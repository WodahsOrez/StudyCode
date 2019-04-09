# Java对象的创建过程

一个Java对象的创建过程分为**类初始化**和**类实例化**两个阶段。而类初始化有两个问题分别是**类加载和初始化时机**和**类加载过程**。类实例化则分为**实例对象创建时机**和**对象实例化过程**。

## 类加载和初始化时机

在规范中类加载时机没有严格约束，由虚拟机的具体实现自己控制。但规范指明**有且只有**五种情况必须立即对类进行初始化。

1. 使用new关键词实例化对象的时候，读取设置静态字段，调用静态方法时。
2. 反射包的方法对类进行反射调用的时候，如果类没有进行过初始化，则需要先触发其初始化。
3. 当初始化一个类的时候，如果发现其父类还没有进行过初始化，则需要先触发其父类的初始化。
4. 当虚拟机启动时，用户需要指定一个要执行的主类（包含main()方法的那个类），虚拟机会先初始化这个主类。
5. 当使用jdk1.7动态语言支持时，如果一个java.lang.invoke.MethodHandle实例最后的解析结果REF_getstatic,REF_putstatic,REF_invokeStatic的方法句柄，并且这个方法句柄所对应的类没有进行初始化，则需要先出触发其初始化。



以上五种行为称为对一个类的**主动引用**。除此之外除此之外，所有引用类的方式，都不会触发初始化，称为 **被动引用**。

**被动引用的场景**：

- 子类引用父类静态字段，不会导致子类初始化
- 通过数组定义来引用类，不会触发此类的初始化
- 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化

## 类加载过程

一个类的生命周期包括加载（Loading）、验证（Verification）、准备(Preparation)、解析(Resolution)、初始化(Initialization)、使用(Using) 和 卸载(Unloading)七个阶段。

准备阶段是正式为类变量(static 成员变量)分配内存并设置类变量初始值（零值）的阶段，这些变量所使用的内存都将在方法区中进行分配。如果类变量是final，准备阶段就会把类变量赋值为指定的值。

而在初始化阶段，则根据程序猿通过程序制定的主观计划去初始化类变量和其他资源，或者更直接地说：初始化阶段是执行类构造器<clinit>()方法的过程。<clinit>()方法是由编译器自动收集类中的所有类变量的赋值动作和静态语句块static{}中的语句合并产生的，编译器收集的顺序是由语句在源文件中出现的顺序所决定的，静态语句块只能访问到定义在静态语句块之前的变量，定义在它之后的变量，在前面的静态语句块可以赋值，但是不能访问。

 在同一个类加载器下，一个类型只会被初始化一次。

父类的类构造器<clinit>() -> 子类的类构造器<clinit>() -> 父类的成员变量和实例代码块 -> 父类的构造函数 -> 子类的成员变量和实例代码块 -> 子类的构造函数。

实际上是把实例初始化嵌入到了静态初始化流程中

## 实例对象的创建时机

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

## 对象的实例化过程

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





参考：

[JVM类生命周期概述：加载时机与加载过程](https://blog.csdn.net/justloveyou_/article/details/72466105)

[深入理解Java对象的创建过程：类的初始化与实例化](https://blog.csdn.net/justloveyou_/article/details/72466416)

