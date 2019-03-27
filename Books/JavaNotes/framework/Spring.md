# Spring

Spring是一个轻量级控制反转(IoC)和面向切面(AOP)的容器框架。

## IoC理论

控制反转（Inversion of Control）是将组件对象的控制权从代码本身转移到外部容器的一种设计思想，主要作用是用来降低耦合度。其主要实现方式就是依赖注入（Dependency Injection，简称DI）。所谓依赖注入，就是由IOC容器在运行期间，动态地将某种依赖关系注入到对象之中。

### IoC底层原理

- dom4j(导入并解析xml文件，获取类名)
- 反射机制（通过类名创建对象实例）
- 工厂模式（动态的注入对象依赖）


### IoC属性注入方式

- 属性注入(Setter方法注入)：灵活性好，但setter方法数量较多，时效性差，通过无参构造实例化
- 构造函数注入：灵活性差，重载限制太多，时效性好，通过匹配的构造方法实例化
- 工厂方法注入：不推荐使用，需要额外的类和代码

### Spring的bean管理

#### xml配置bean创建

使用无参构造创建bean对象

```xml
<bean id="bean1" class="me.wodahsorez.bean.Bean1"></bean>
```

使用工厂的静态方法创建bean对象

```xml
<!-- getBean1为静态方法，返回Bean1的实例对象 -->
<bean id="bean2" class="me.wodahsorez.bean.Bean2Factory" factory-method=“getBean2” ></bean>
```

使用工厂的实例方法创建bean对象

```xml
<!-- 先创建工厂类的实例 -->
<bean id="bean3Factory" class="me.wodahsorez.bean.Bean3Factory"></bean>
<!-- factory-bean写工厂类的实例的id，factory-method写工厂类的实例方法 -->
<bean id="bean3" factory-bean="bean3Factory" factory-method=“getBean3”></bean>
```

#### Spring的属性注入

构造注入

```xml
<bean id="User" class="me.wodahsorez.bean.User">
	<!-- 通过匹配构造方法的参数名匹配 -->
    <constructor-arg name="name" value="张三" ></constructor-arg>
    <!-- 通过index索引匹配参数 -->
    <constructor-arg index="2" value="23" ></constructor-arg>
    <!-- ref注入对象类型的属性，值为对象实例的id，type为属性的类型全路径 -->
    <constructor-arg type="me.wodahsorez.bean.Role" ref="role1"></constructor-arg>
</bean>
```

因为一个bean代表一个对象，所以只需配一个构造方法，其他构造方法需要另配一个bean。

setter方法注入（常用）

```xml
<bean id="User" class="me.wodahsorez.bean.User">
	<property name="name" value="张三"></property>
    <!-- ref注入对象类型的属性，值为对象实例的id -->
    <property name="role" ref="role1"></property>
    <!-- name值可以通过.来选择对象属性内部的属性 -->
    <property name="role.name" value="rolename"></property>
</bean>
```











## Spring容器的启动配置

在web.xml里配置Listener，代码如下：  

```xml
<listener>   
	<listener-class> org.springframework.web.context.ContextLoaderListener <listener-class >   
</listener>
```

如果在web.xml里给该Listener指定要加载的xml，如：

```xml
<context-param>
    <param-name>contextConfigLocation</param-name> 
    <param-value>classpath:applicationContext.xml</param-value>
</context-param>
```

则会去加载相应的xml，而不会去加载/WEB-INF/下的applicationContext.xml。

但是，如果没有指定的话，默认会去/WEB-INF/下加载applicationContext.xml。

注意：这里的contextConfigLocation内是对整个Spring有感知的，但是@controller会无法被MVC识别，而MVC的contextConfigLocation内只对MVC有用二者范围有区别.

### 路径写法

```
/WEB-INF/*-context.xml 
com/mycompany/**/applicationContext.xml  
file:C:/some/path/*-context.xml
classpath:com/mycompany/**/applicationContext.xml  
```

1. 会查找到WEB-INF目录下的以"-context.xml"结尾的文件  在WEB-INF下的 a-context.xml b-context.xml都会被找到

2. com/mycompany/目录下所有的applicationContext.xml都会被找到

3. file 表示会根据文件系统的路径查找 这个条会找到 c盘下的/some/path目录以"-context.xml"的文件都会被找到

4. 查找classpath下的com/mycompany/包中所有子包的applicationContext.xml文件

5. classpath：只会到你的class路径中查找找文件; 

6. classpath*：不仅包含class路径，还包括jar文件中(class路径)进行查找.

有时候会用模糊匹配的方式配置多配置文件。但是如果配置文件是在jar包里，模糊匹配就找不到了。可以用**逗号或空格**隔开的方式配置多个配置文件。或者配置文件在jar文件根目录除外的其他任何地方，然后根据路径名称模糊匹配即可找到。

没有资源前缀默认路径相对于WEB的部署根路径，Ant风格的匹配符：?匹配一个字符,*匹配任意字符,**匹配多层路径

参考：[spring配置文件路径你知多少](http://name327.iteye.com/blog/1628884)