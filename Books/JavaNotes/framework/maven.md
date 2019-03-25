# Maven

## 基本概念

Apache Maven是一个基于项目对象模型（POM）的概念，可以通过一小段描述信息来管理项目的构建，报告和文档的项目管理工具软件。通过中心仓库来管理依赖。

1. 仓库类型：local本地仓库，remote私服(局域网)，central中央仓库(互联网)
2. 生命周期

    - 清洁生命周期：pre-clean，clean，post-clean。
    - 默认生命周期：compile，test，package，install，deploy。（当后面的命令执行时，会按顺序先把它之前的命令执行）
    - 网站的生命周期：pre-site，site，post-site，site-deploy。
3. 打包类型：pom(聚合工程)，jar(java工程)，war(web工程)
4. group Id：即域名。如：org.apache。artifact Id：即项目名。如maven
5. version：snapshot测试版本，release正式版本。

### 安装配置

1. [官网下载](http://maven.apache.org)，解压。
2. 配置path环境变量指向maven的bin文奸夹。

3. 配置conf/settings文件
   - `<localRepository>`配置本地仓库的路径。
   - `<mirror> `配置镜像服务器。属性有id，name，url，mirrorof（被镜像服务器替代的原始服务器的id）。

#### 阿里的镜像服务器配置

```xml
<mirror>
    <id>alimaven</id>
    <mirrorOf>central</mirrorOf>
    <name>aliyun maven</name>
    <url>http://maven.aliyun.com/nexus/content/repositories/central/</url>
</mirror>
```
#### eclipse配置

1. 配置本地maven：Eclipse→Maven→Installation和User Setting

2. 创建索引，加快检索效率：Show View→Maven→右键rebuild index


### 目录结构

```
src                         源码目录
|---main                    项目主体目录
|---|---java                项目主体源代码目录
|---|---resources           项目主体配置文件目录
|---test                    项目测试目录
|---|---java                项目测试源代码目录
|---|---|---resources       项目测试配置文件目录
pom.xml                     Maven工程核心配置文件
```

## 命令

mvn tomcat:run  部署项目

mvn -v  版本信息

mvn clean  清理（删除target目录下编译内容）

mvn compile  编译源代码，一般编译模块下的src/main/java目录

mvn package  项目打包工具,会在模块下的target目录生成jar或war等文件

mvn test  测试命令,执行src/test/java/下所有XxxxTest.java的测试用例.

mvn install  将打包的jar/war文件复制到你的本地仓库中,供其他模块使用

## 创建项目

maven module：子模块

maven project：普通maven项目或父工程。







## 插件

插件配置在`<build>`的`<plugins>`或者`<pluginManagement>的<plugins>`下

编译环境

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.0</version>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
                <encoding>UTF-8</encoding>
            </configuration>
        </plugin>
    </plugins>
</build>
```

tomcat配置

```
<plugin>
	<!-- 配置插件 -->
	<groupId>org.apache.tomcat.maven</groupId>
	<artifactId>tomcat7-maven-plugin</artifactId>
	<configuration>
		<port>8080</port>
		<path>/</path>
	</configuration>
</plugin>
```



## 依赖

插件配置在`<project>`的`<dependencies>`或者`<dependencyManagement>`下

参考：[maven依赖查询](https://mvnrepository.com)

#### dependencies和dependencyManagement的区别

- dependencies：即使子项目不写该依赖项，仍会从父项目中继承该依赖（完全继承）。
- dependencyManagement：里只是声明依赖，并不实现引入，因此子项目需要显示的声明需要用的依赖。
  - 在子项目中**不声明依赖**，不会从父项目中继承依赖下来；
  - 在子项目中**声明该依赖项，并且没有指定具体版本**，才会从父项目中继承该项，并且version和scope都读取自父pom;
  - 在子项目中**声明并指定了版本号**，那么会使用子项目中指定的jar版本。

### 依赖范围

即`<dependency>`内的`<scope>`。

| 依赖范围        | 编译时使用该依赖 | 测试时使用该依赖 | 运行时使用该依赖 |
| --------------- | ---------------- | ---------------- | ---------------- |
| compile（默认） | Y                | Y                | Y                |
| test            | -                | Y                | -                |
| provided        | Y                | Y                | -                |
| runtime         | -                | Y                | Y                |
| system          | Y                | Y                | -                |

当一个项目继承了多个传递依赖的范围变化

**JSTL**

```xml
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
    <version>1.2</version>
</dependency>
```

