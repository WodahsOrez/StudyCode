# Java对象的创建过程

一个Java对象的创建过程分为类初始化和类实例化两个阶段。

## Java对象的创建时机

Java中有以下四种方式可以引起Java对象的创建

### 执行类实例创建表达式（new关键词）

```java
Student stu1 = new Student();
```

### 反射机制

```java
// Constructor类的newInstance
Student stu4 = Student.class.getConstructor().newInstance();
// Class类的newInstance,内部也是调用的Constructor的newInstance，只能调用无参构造
Student stu2 = (Student)Class.forName("Student类的全限定名").newInstance();
Student stu3 = Student.class.newInstance();
```

### clone方法

```java
// Student类实现了Cloneable接口
Student stu5 = (Student)stu4.clone();
```

### 反序列化机制

```java
// Student类实现了Serializable接口，并加上了serialVersionUID
// 写对象,序列化
ObjectOutputStream output = new ObjectOutputStream(
    new FileOutputStream("student.txt"));
output.writeObject(stu5);
output.close();

// 读对象，反序列化
ObjectInputStream input = new ObjectInputStream(new FileInputStream(
    "student.txt"));
Student stu6 = (Student) input.readObject();
```

## Java对象的实例化过程

### 分配内存空间

当一个对象被创建时，虚拟机会为其自己的实例变量和父类继承过来的实例变量分配内存空间，并赋予默认值（零值）。

### 实例变量初始化

给实例变量赋值有两种方式：给实例变量直接赋值和使用实例代码块。

```java
public class InstanceInitializer {
    // 实例变量直接赋值
    private int i = 1;
    // 使用实例代码块
    {
        System.out.println(this.i + " and " + this.j);  // 1 and 0
        this.j = 2;
        System.out.println(this.j);   // 2
    }
    // 直接赋值也可以通过调用方法来执行代码
    private int j = getj();
    
    private int getj(){
        return 3;
    }
}
```

编译器会把以上两种方式对实例变量初始化的操作放到类的构造函数中去，并且在父类构造函数调用之后执行，本身的构造函数代码之前执行。它们两者的执行顺序按照定义的先后执行。

编译器不允许顺序靠前的实例代码块初始化在其后面定义的实例变量，我发现如果是给后面定义的实例变量赋值，编译是可以通过的，传值是无法编译通过的。但是如果加上this，发现都能编译通过了。由于实际上初始化时实例变量都已声明了，所以不管前后顺序都不影响。

```java
public class InstanceInitializer {
    {
        j = 1;                       // 编译通过
        i = 2;                       // 编译通过
        j = i;                       // 编译不通过
        System.out.println(j);       // 编译不通过
        j = this.i;                  // 编译通过
        System.out.println(this.j);  // 编译通过
    }

    private int i = 1;
    private int j;
}
```

### 构造函数初始化

Java要求在实例化类之前，必须先实例化其超类，以保证所创建实例的完整性。所以产生以下约束：

- 除了Object类之外的所有类的构造函数的第一条语句默认为隐式调用父类无参构造
- 若要显示调用则必须为父类构造函数或者本类其他构造函数
- 父类构造函数和本类其他构造函数不能同时出现
- 本类构造函数调用不能出现递归调用，即调用链为死循环





参考：[深入理解Java对象的创建过程：类的初始化与实例化](https://blog.csdn.net/justloveyou_/article/details/72466416)

