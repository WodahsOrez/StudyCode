# Spring-xml配置

## Beans命名空间

### 导入约束

```xml
<beans xmlns="http://www.springframework.org/schema/beans" 
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">
```



### `<bean>`标签

#### 属性

- **id**：Spring容器管理的bean实例的名称标识。不能包含特殊符号。
- **name**：作用和id相同，但能包含特殊符号。（一般推荐用id）。
- **class**：创建的实例的所属类的全路径。
- **scope**：bean的作用范围。(后三个仅适用WebApplicationContext环境)
  - **singleton**(**默认值**)：在Spring容器中仅存在一个共享的Bean实例,**容器启动时实例化**
  - **prototype**：每次从容器中都获取一个新的实例,**被调用时才实例化**
  - **request**：每次HTTP请求都会创建一个新的Bean实例
  - **session**：同一个HTTP请求共享一个Bean实例
  - **global session**：同一个全局Session共享一个Bean实例
- **init-method**：初始化方法。紧随对象创建后执行。
- **destroy-method**：摧毁方法。在实例被摧毁前执行。
- **lazy-init**：当值为true时，不在随容器启动而提前实例化，但当被其他需要提前实例化的bean引用时，依然会提前实例化。



### 属性注入标签

#### `<property>`标签

有属性name，value，ref。通过setter方法注入，其内可以有以下子标签

- `<value>`基本类型和字符串值，根据bean属性自动判断类型，注意字符实体
- `<null />`和空字符串`<value></value>`
- `<ref bean="userDaoImpl" />` bean可以换成parent即父容器中的bean
- `<bean class="cn.bdqn.biz.dao.impl.UserDao" />`  内部bean，不能被外部引用，不写id



##### 集合类型的标签，都是property的子标签

`<list>`，`<set>`：其内可容纳的标签和property一样

`<map>`内部由`<entry>`对组成

```xml
<entry key="键名" key-ref="引用型键" value="基础类型值" value-ref="引用类型值" />
<entry key="0">
	<value>值</value>
<entry>
```

`<props>`键值都必须是String类型，其内部子标签是若干`<prop key="键">值</prop>`

**集合合并**：通过在集合标签内加入merge="true"属性，来使子bean继承父bean的同名属性集合元素。



## context命名空间

### 导入约束

```xml
<beans xmlns="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context" xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd">
```

### 开启注解扫描

```xml
<!-- 开启注解扫描，扫描指定package内的类，属性，方法上的注解 -->
<context:component-scan base-package="me.wodahsorez">
	<!-- 加入需要扫描的注解 -->
    <context:include-filter type="annotation" expression="org.springframework.stereotype.Component"/> 
    <!-- 排除不需要扫描的类 -->
    <context:exclude-filter type="regex" expression=".service.*"/> 
</context:component-scan>
<!-- 启用已经被注册的bean的属性上的注解，component-scan也包含该功能 -->
<context:annotation-config></context:annotation-config>
```

#### component-scan的属性：

- base-package：扫描的包路径。

- annotation-config：默认为true。即开启属性注解，等效于annotation-config。

- resource-pattern：对资源进行筛选的正则表达式。具体细分在include-filter与exclude-filter中进行。

- use-default-filters：默认为true。即会对@Component，@Controller，@Service，@Reposity等注解扫描。若值为false，则这些注解都不被扫描，需要配合include-filter指定需要的注解。即作用相当于全选和反选。

- 先排除黑名单,再加入白名单

#### include-filter与exclude-filter的type属性：

- annotation：注解类型
- assignable_type：annotation：指定的类型
- aspectj：按照Aspectj的表达式，基本上不会用到
- regex：按照正则表达式
- custom：自定义规则


## p命名空间

### 导入约束

```xml
<beans xmlns="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:p="http://www.springframework.org/schema/p" xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd http://www.springframework.org/schema/p http://www.springframework.org/schema/p/spring-p.xsd">
```

### 使用

- 特点是使用属性的形式而不是子元素配置Bean的属性
- 对于直接量(基本数据类型、字符串)属性：p:属性名="属性值"
- 对于引用Bean的属性：p:属性名-ref="Bean的id"，如：

```xml
<bean id="userDaoImpl" class="cn.bdqn.biz.dao.impl.UserDaoImpl" p:dao="123" p:dao-ref="userDao"/>
```

