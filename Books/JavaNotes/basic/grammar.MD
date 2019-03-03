# 主标题

## 标识符

由大小写字母，数字，_$组成的自定义名称，其中不能以数字开头，且不能和关键词重名。

**正则表达式**：`^[A-Za-z_$][A-Za-z0-9_$]*$`

## 数据类型

![1550393917847](images/grammar/1550393917847.png)

| 类型    | 范围                    | 备注    |
| ------- | ----------------------- | ------- |
| byte    | 8位(-2^7^~ 2^7^-1)      |         |
| short   | 16位(-2^15^~2^15^-1)    |         |
| int     | 32位(-2^31^~2^31^-1)    |         |
| long    | 64位(-2^63^~2^63^-1)    | 末尾加L |
| float   | 32位(1符号8指数23尾数)  | 末尾加f |
| double  | 64位(1符号11指数52尾数) |         |
| char    | 16位(0~2^16^-1)         |         |
| boolean | true/false              |         |

## 注释

注释不会被编译到class文件内

```Java
// 单行注释
/* 
多行注释
*/
/**
 *文档注释,可以使用javadoc命令导出API帮助文档
 */
```

| **标签**      | **描述**                                                 | **示例**                                                     |
| ------------- | -------------------------------------------------------- | ------------------------------------------------------------ |
| @author       | 标识一个类的作者                                         | @author name                                                 |
| @deprecated   | 指名一个过期的类或成员                                   | @deprecated   description                                    |
| @param        | 说明一个方法的参数                                       | @param   parameter-name explanation                          |
| @return       | 说明返回值类型                                           | @return   explanation                                        |
| @see          | 指定一个到另一个主题的链接                               | @see   anchor                                                |
| @serial       | 说明一个序列化属性                                       | @serial   description                                        |
| @serialData   | 说明通过writeObject(   ) 和 writeExternal( )方法写的数据 | @serialData   description                                    |
| @serialField  | 说明一个ObjectStreamField组件                            | @serialField   name type description                         |
| @since        | 标记当引入一个特定的变化时                               | @since   release                                             |
| @exception    | 标志一个类抛出的异常                                     | @exception   exception-name explanation                      |
| @throws       | 和   @exception标签一样.                                 | The   @throws tag has the same meaning as the @exception tag. |
| @version      | 指定类的版本                                             | @version   1.2                                               |
| {@docRoot}    | 指明当前文档根目录的路径                                 | Directory   Path                                             |
| {@inheritDoc} | 从直接父类继承的注释                                     | Inherits   a comment from the immediate surperclass.         |
| {@link}       | 插入一个到另一个主题的链接                               | {@link   name text}                                          |
| {@linkplain}  | 插入一个到另一个主题的链接，但是该链接显示纯文本字体     | Inserts   an in-line link to another topic.                  |
| {@value}      | 显示常量的值，该常量必须是static属性。                   | Displays   the value of a constant, which must be a static field. |