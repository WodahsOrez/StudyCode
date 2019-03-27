# Spring注解

## IoC注解

### bean注解

**@Component**: 标注bean类，("id名")，默认id名为首字母小写的类名，下面三个衍生注解

**@Repository**：用于标注持久层类，("id名")，默认id名为首字母小写的类名

**@Service**：用于标注业务层类，("id名")，默认id名为首字母小写的类名

**@Controller**：用于标注WEB层类，("id名")，默认id名为首字母小写的类名

**@RestController** ：Spring4之后新加入的注解，原来返回json需要@ResponseBody和@Controller配合。即@RestController是@ResponseBody和@Controller的组合注解。

**@Scope**("protetype")配置bean的scope属性

**@Order**(value=1)加载优先级,越小越高(Spring4.0加入)

**@Lazy** 延迟到调用此属性时才注入,需同时加注在属性和bean上(Spring4.0加入)



### 属性注入

#### @Autowired  根据类型进行注入

required属性，默认true

-  @Autowired(required = false)  找不到时注入一个null
-  @Autowired(required = true)   找不到匹配的bean就报NoSuchBeanDefinitionException

##### 修饰成员变量(此时可以不用写set/get方法)

```java
@Autowired
@Qualifier("user")    //按名称注入
private User user
```

##### 修饰方法/构造方法(多入参的每个都注入)

```java
@Autowired  
public Boss(@Qualifier("car")Car car , @Qualifier("office")Office office){ 
}
```

##### 修饰集合

```java
@Autowired(required=false)
private List<Plugin> plugins;  //将所有类型为Plugin的bean都注入进List集合

@Autowired
private Map<String,Plugin> pluginMaps;  //4.0新特性,key为Bean的名字,value为所有实现了Plugin的Bean
```

 

#### @Resource

（这个注解属于J2EE的），默认安照名称进行装配，名称可以通过name属性进行指定， 如果没有指定name属性，当注解写在字段上时，默认取字段名进行按照名称查找，如果注解写在setter方法上默认取属性名进行装配。 当找不到与名称匹配的bean时才按照类型进行装配。但是需要注意的是，如果name属性一旦指定，就只会按照名称进行装配。

##### 修饰成员变量

```java
@Resource(name="baseDao")     
private BaseDao baseDao;    
```

##### 修饰方法/构造方法

```java
@Resource
public void setDataSource(DataSource dataSource) {
this.dataSource = dataSource;
}
```

##### 修饰实体类时

@Resource用在类上的时候，Spring会把当前类作为资源放入Spring容器



### 参数绑定，转换注解

#### @RequestBody

注解用于读取http请求的内容(字符串)，通过springmvc提供的HttpMessageConverter接口将读到的内容转换为json、xml等格式的数据并绑定到controller方法的参数上。

```java
public @ResponseBody Items editItemSubmit_RequestJson(@RequestBody Items items) throws Exception {
    System.out.println(items);
    return items;
}
```



#### @ResponseBody

该注解用于将Controller的方法返回的对象，通过HttpMessageConverter接口转换为指定格式的数据如：json,xml等，通过Response响应给客户端

注解的作用是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，通常用来返回JSON数据或者是XML数据，需要注意的呢，在使用此注解之后不会再走视图处理器，而是直接将数据写入到输入流中，他的效果等同于通过response对象输出指定格式的数据。

```java
@RequestMapping("/login")
@ResponseBody
public User login(User user){
	return user;
}
```

效果等同于如下代码：

```java
@RequestMapping("/login")
public void login(User user, HttpServletResponse response){
	response.getWriter.write(JSONObject.fromObject(user).toString());
}
```



#### @RequestMapping

@RequestMapping(value="/item")或@RequestMapping("/item）作用于类和方法,标识映射URL,带/为绝对路径(推荐)

- value的值是数组，可以将多个url映射到同一个方法或类,
- method的值为RequestMethod.GET/POST,多值用{,}
- @RequestMapping(value="/ itemsView/{id}")：{×××}占位符，请求的URL可以是“/viewItems/1”或“/viewItems/2”，通过在方法中使用@PathVariable获取{×××}中的×××变量。



#### @PathVariable

用于将请求URL中的模板变量映射到功能处理方法的参数上。支持REST,用于匹配RequestMapping中的{xxx}占位符参数

如果RequestMapping中表示为"/ itemsView /{id}"，id和形参名称一致，@PathVariable不用指定名称。



#### @RequestParam(value,required) 

- value是匹配传递的参数名，等效于Request.getParamrter()
- required默认为true，表示必须包含对应的参数



#### @ModelAttribute(value) 

作用于方法或形参，把返回值或参数对象存到request中，key为指定的value，本质是使用Model的addAttribute方法