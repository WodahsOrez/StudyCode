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

