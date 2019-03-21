# HTML5

`<!DOCTYPE html>`声明是HTML5文件

`<!--...-->`定义一个注释

## 元数据和脚本

| 标签名   | 作用                                                       |
| -------- | ---------------------------------------------------------- |
| head     | 头部元素的容器，必须包含title，可以包含其他元数据标签      |
| title    | 标题（必需）                                               |
| meta     | 元数据，定义HTML本身的文档信息                             |
| base     | 为页面内的所有相对链接规定默认URL或默认目标                |
| link     | 定义文档与外部资源的关系，如链接css                        |
| style    | 定义CSS样式文件，属性type默认值为text/css。                |
| script   | 定义JavaScript脚本，                                       |
| noscript | 浏览器不支持脚本时显示内部的内容，内部可以包含任何HTML元素 |

###  meta标签

```html
<!-- 规定文档的字符编码。 -->
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<!-- 定义文档自动刷新的时间间隔，单位秒。 -->
<meta http-equiv="refresh" content="300">
<!-- 定义文档关键词，用于搜索引擎。 -->
<meta name="keywords" content="HTML, CSS, XML, XHTML, JavaScript">
<!-- 定义web页面描述。 -->
<meta name="description" content="Free Web tutorials on HTML and CSS">
<!-- 定义页面作者。 -->
<meta name="author" content="Hege Refsnes">
```

### base标签

#### 属性

- **href**：规定页面中所有相对链接的基准 URL。
- **target**：规定所有超链接和表单在何处打开。会被每个链接自身的target覆盖。值为：\_blank，\_parent，\_self，\_top，framename。

### link标签

#### 属性

- href：定义被链接文档的位置。值为URL。
- hreflang：定义被连接文档中文本的语言。
- ref：**必需**。定义当前文档与被连接文档之间的关系。值为stylesheet，icon等

- media：规定链接文档将显示在什么设备上。

### script标签

#### 属性

- src：规定外部脚本的URL。
- type：默认为text/javascript。
- charset：规定脚本中使用的字符编码（仅适用于外部脚本）。
- async：规定异步执行脚本（仅适用于外部脚本）。
- defer：规定当页面已完成解析后，执行脚本（仅适用于外部脚本）。

![284aec5bb7f16b3ef4e7482110c5ddbb_articlex](images/html/284aec5bb7f16b3ef4e7482110c5ddbb_articlex.jpg)

1. 没有 `defer` 或 `async`，**文档的解析将停止，并立即下载并执行脚本**，脚本执行完毕后将继续解析文档。
2. 有 `async`，文档的**解析不会停止**，**其他线程将下载脚本，脚本下载完成后开始执行脚本**，脚本执行的过程中文档将停止解析，直到脚本执行完毕。
3. 有 `defer`，文档的解析不会停止，其他线程将下载脚本，**待到文档解析完成，脚本才会执行**。
4. `async`和`defer`都不能保证脚本按照加载顺序执行。

## 文档章节

| 标签名  | 作用                                 |
| ------- | ------------------------------------ |
| body    | 定义文档主体的部分                   |
| h1~h6   | 定义HTML标题，不同级别标题样式不同。 |
| hgroup  | 被用来对标题元素进行分组。           |
| article | 定义一个文章内容。                   |
| aside   | 定义 `<article> `标签外的内容。      |
| address | 定义文档作者或拥有者的联系信息。     |
| section | 定义了文档的某个区域。               |
| header  | 定义一个文档头部部分。               |
| footer  | 定义一个文档底部。                   |
| nav     | 定义导航链接的部分。                 |

## 文本级别语义

| 标签名 | 作用                                                         |
| ------ | ------------------------------------------------------------ |
| span   | 定义文档中的行内元素。前后不会换行。没有结构上的意义。       |
| a      | 定义超链接。                                                 |
| ruby   | 定义 ruby 注释（中文注音或字符）。                           |
| rt     | 在 ruby 中使用，定义字符（中文注音或字符）的解释或发音。     |
| rp     | 在 ruby 中使用，以定义不支持 ruby 元素的浏览器所显示的内容。 |
| em     | 呈现为被强调的文本。效果是类似斜体。                         |
| strong | 定义重要的文本。效果是类似加粗。                             |
| dfn    | 定义一个定义项目。                                           |
| code   | 定义计算机代码文本。                                         |
| samp   | 定义样本文本。                                               |
| kbd    | 定义键盘文本。它表示文本是从键盘上键入的。它经常用在与计算机相关的文档或手册中。 |
| var    | 定义变量。您可以将此标签与 `<pre> `及 `<code> `标签配合使用。 |
| abbr   | 定义一个缩写。                                               |
| q      | 定义短的引用。属性cite：规定引用的源URL。                    |
| cite   | 定义作品（比如书籍、歌曲、电影、电视节目、绘画、雕塑等等）的标题。 |
| time   | 定义一个日期/时间。也可以用属性datetime规定日期/时间。       |
| i      | 定义斜体文本。                                               |
| b      | 定义粗体文本。                                               |
| sub    | 定义下标文本。                                               |
| sup    | 定义上标文本。                                               |
| small  | 定义小号文本。                                               |
| mark   | 定义带有记号的文本。背景高亮的文本。                         |
| ins    | 定义被插入文本。即更新修正后的文本，体现为下划线。属性：cite和datetime。 |
| del    | 定义已删除的文本。即有删除线的文本。属性：cite和datetime。   |
| s      | 对那些不正确、不准确或者没有用的文本进行标识。也有删除线，但替换和删除的文本用del标签。 |
| bdi    | 允许您设置一段文本，使其脱离其父元素的文本方向设置。         |
| bdo    | 定义文本的方向。属性dir设置文本方向：ltr从左向右和rtl从右向左。 |
| wbr    | 规定在文本中的何处适合添加换行符。如单词换行时机。           |

###  a标签

#### 属性

- href：规定连接的目标URL。
- hreflang：规定被连接文档的语言。
- ref：规定当前文档和目标URL的关系。
- target：规定在何处打开目标 URL。值有：_blank，\_parent，\_self，\_top，framename。
- type：规定目标文档的 MIME 类型。
- download：定义下载链接的地址或者是下载文件的名称（不用写后缀会自动加上）。
- media：规定目标 URL 的媒介类型。默认值：all。仅在 href 属性存在时使用。

## 组合内容

| 标签名     | 作用                                                         |
| ---------- | ------------------------------------------------------------ |
| br         | 插入一个简单的换行符。                                       |
| hr         | 定义水平线。                                                 |
| div        | 定义一个块级元素。前后会自动换行。                           |
| p          | 定义一个段落                                                 |
| ol         | 定义一个有序列表                                             |
| ul         | 定义一个无序列表                                             |
| li         | 定义一个列表项                                               |
| dl         | 定义一个描述列表。                                           |
| dt         | 定义一个描述列表的项目/名字。                                |
| dd         | 用来描述一个描述列表的项目/名字。                            |
| figure     | 规定独立的流内容（图像、图表、照片、代码等等）。             |
| figcaption | 为figure标签定义一个标签。一般位于figure标签的第一个或最后一个元素。 |
| pre        | 定义预格式文本。通常会保留空格和换行符。而文本也会呈现为等宽字体。 |
| blockquote | 定义摘自另一个源的块引用。                                   |

## 表单

|          | 作用                                                         |
| -------- | ------------------------------------------------------------ |
| fieldset | 定义围绕表单中元素的边框。属性：disabled，form，name。       |
| legend   | 定义 fieldset 元素的标题。                                   |
| meter    | 定义度量衡。仅用于已知最大和最小值的度量。                   |
| label    | 定义 input 元素的标注。点击该元素会自动触发for属性里id指向的input元素的焦点。 |
| textarea | 定义多行的文本输入控件。                                     |
| form     | 定义一个 HTML 表单，用于用户输入。                           |
| select   | 定义选择列表（下拉列表）。                                   |
| optgroup | 定义选择列表中相关选项的组合。                               |
| option   | 定义选择列表中的选项。                                       |
| input    | 定义一个输入控件                                             |
| output   | 定义一个计算的结果                                           |
| button   | 定义按钮。                                                   |
| progress | 定义运行中的任务进度（进程）。                               |
| datalist | 规定了 input 元素可能的选项列表。配合input的list属性指定datalist的id。 |
| keygen   | 规定用于表单的密钥对生成器字段。                             |

 

## 表格数据

|          | 作用 |
| -------- | ---- |
| col      |      |
| colgroup |      |
| caption  |      |
| table    |      |
| tr       |      |
| td       |      |
| th       |      |
| tbody    |      |
| thead    |      |
| tfoot    |      |

 

## 嵌入式内容

|        | 作用 |
| ------ | ---- |
| img    |      |
| area   |      |
| map    |      |
| embed  |      |
| object |      |
| param  |      |
| source |      |
| iframe |      |
| canvas |      |
| track  |      |
| audio  |      |
| video  |      |

 

## 交互元素

|         | 作用 |
| ------- | ---- |
| menu    |      |
| command |      |
| summary |      |
| details |      |