# Typora的使用

[TOC]

## 1.文本修饰

`Ctrl+1 ~ 6` ：一级~六级标题。（`#-#######`）

`Ctrl+=`：提升标题级别。

`Ctrl+-`：降低标题级别。###￥#

`Ctrl+0`：普通文本。

`Ctrl+I`：斜体，*效果演示*。（`一对*`）

`Ctrl+B`：粗体，**效果演示**。（`一对**`）

`Ctrl+U`：下划线，<u>效果演示</u>。（`<u></u>`）

`Shift+Alt+5`：删除线，~~效果演示~~。（`一对~~`）

`Highlight`：高亮，==效果演示==。（`一对==`）

`Ctrl+Shift+Q`：引用。（`前面加上>,个数随层级增加`）

## 2.表格

`Ctrl+T`：插入表格。（`用|分隔单元格，用---分隔表头，用:表示对齐方式`）

```
|左对齐|居中  |右对齐|
|:--- |:---:|---: |
|     |     |     |
```

## 3.列表

`Ctrl+Shift+[`：有序列表。（`数字接英文句号，如1.`）

`Ctrl+Shift+]`：无序列表。（`*或+或-`）

`Ctrl+[`：减少列表缩进。

`Ctrl+]`：增加列表缩进。

## 4.代码块

``Ctrl+Shift+` `` ：行内代码块。（``用一个或两个`包起来 ``）

`Ctrl+Shift+K`：代码区块。（``用三个`包起来 ``）

**图表**（代码区块写入相应的语言即可）

- [流程图](https://segmentfault.com/a/1190000006247465)（flow）
- [时序图](https://bramp.github.io/js-sequence-diagrams/)（sequence）
- [甘特图](https://mermaidjs.github.io/)（mermaid）

## 5.图片、超链接、脚注

`Ctrl+Shift+I`：插入图片。（`![图片名称](图片地址，本地或网络 "悬浮名称")`）

`Ctrl+K`：超链接，[效果演示](https://www.baidu.com "baidu")。（`Ctrl+左击`可以跳转到该超链接）

```
[链接文本名称](带https://的URL地址 “链接悬浮名称”)
[链接文本名称](#锚点id “链接悬浮名称”)
//可以再标题后面加上锚点
## 标题2{#title2}
//另一种写法（图片也有类似的写法）
[百度][2]
[2]http://www.baidu.com "baidu"
[百度][]
[百度]http://www.baidu.com "baidu"
```

`Footnotes`：脚注，效果演示。[^1] 

[^1]: 脚注内容

```
[^标识]
[^标识]：脚注内容
```

## 6.其他

`Superscript`：上标，效果演示X^2^。（`一对^`）

`Subscript`：下标，效果演示H~2~O。（`一对~`）

`Ctrl+Shift+M`：行间数学区块，内填LaTeX[^参考]。（`一对$$`）

`Inline Math`：行内数学公式，内填LaTeX[^参考]。（`一对$`）

[^参考]: https://blog.csdn.net/jyfu2_12/article/details/79207643

`Todo List`：复选框，只能放在行首，不能省略空格。（`- [ ]或者- [X]`）

- [ ] 效果演示
  - [x] 效果演示

`Horizontal Line`：分割线。（`---或者***`）

`emoji`：表情图标，如 :happy:（`:emoji名称:`）

`Table of  Contents`：生成内容目录。（`[toc]`）

## 7.软件操作快捷键

`Ctrl+Shift+V`：纯文本粘贴。

`Ctrl+L`：选中当前行。

`Ctrl+D`：选中当前词。

`Ctrl+/`：源代码模式。

`Ctrl+Shift+L`：显示/隐藏侧边栏。

`Ctrl+Shift+1`：大纲视图。

`Ctrl+Shift+3`：文件树视图。

`F8`：专注模式，除当前行都变暗。

`F9`：打字机模式，当前行始终处于屏幕中央。