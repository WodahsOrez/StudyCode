# 常用命令

## 注释命令：REM和::

### REM注释

REM是正规的注释命令，改命令后的内容不会被执行，但能回显。

### ::注释

`::`也可以起到注释作用，原理是任何`:`开头的字符行，在批处理中都被视为标号，而直接忽略其后的所有内容。

#### 标号

- 有效标号：冒号后紧跟一个以字母数字开头的字符串，goto语句可以识别。
- 无效标号：冒号后紧跟一个非字母数字的一个特殊符号，goto无法识别的标号，可以起到注释作用，所以 :: 常被用作注释符号，其实 :+ 也可起注释作用。

### 注意

与rem 不同的是， ::后的字符行在执行时不会回显,，无论是否用echo on打开命令行回显状态， 因为命令解释器不认为他是一个有效的命令行,，就此点来看,，rem 在某些场合下将比 :: 更为适用。另外， rem 可以用于 config.sys 文件中。

### 行内注释

行内注释格式：%注释内容% （不常用，慎用）

## 回显命令：ECHO和@

### @命令

@字符放在命令前将关闭该命令回显，无论此时echo是否为打开状态。



### echo命令的作用

1. 控制回显功能的开关（echo [{on|off}]）
2. 显示当前echo的状态（echo）
3. 输出提示信息，不受echo off影响（echo 信息内容）
4. echo在dos提示符中使用可以关闭dos信息
5. 输出空行（echo.）可以用，：；”／[\]＋等任一符号替代
   - 跟管道组合可以把echo输出的内容作为输入传给其他命令，如echo.|time

## 暂停命令：PAUSE

pause暂停执行命令，并显示"请按任意键继续. . ."

显示其他提示信息，可以这样用：`echo 其他提示语 & pause > nul`

## 跳转：GOTO和:

在批处理中允许以“:XXX”来构建一个标号，然后用GOTO XXX跳转到标号:XXX处，然后执行标号后的命令。

例：

```cmd
@echo off
:start
set /a var+=1
echo %var%
if %var% leq 3 GOTO start
pause
```

## 搜索：find

在文件中搜索字符串。

```
FIND [/V] [/C] [/N] [/I] [/OFF[LINE]] "string" [[drive:][path]filename[ ...]]
  /V    显示所有未包含指定字符串的行。
  /C    仅显示包含字符串的行数。
  /N    显示行号。
  /I    搜索字符串时忽略大小写。
  /OFF[LINE] 不要跳过具有脱机属性集的文件。
  "string"  指定要搜索的文字串，
  [drive:][path]filename
     指定要搜索的文件。
如果没有指定路径，FIND 将搜索键入的或者由另一命令产生的文字。
Find常和type命令结合使用
Type [drive:][path]filename | find "string" [>tmpfile] #挑选包含string的行
Type [drive:][path]filename | find /v "string" #剔除文件中包含string的行
Type [drive:][path]filename | find /c #显示文件行数
以上用法将去除find命令自带的提示语（文件名提示）
```

例1：

```cmd
@echo off
echo 111 >test.txt
echo 222 >>test.txt
find "111" test.txt
del test.txt
pause
```

运行显示如下：
```
---------- TEST.TXT
111
请按任意键继续. . .
```
例2：
```cmd
@echo off
echo 111 >test.txt
echo 222 >>test.txt
type test.txt|find "111"
del test.txt
pause
```
运行显示如下：
```
111
请按任意键继续. . .
```

## 调用批处理命令：CALL

CALL命令可以在批处理执行过程中调用另一个批处理，当另一个批处理执行完后，再继续执行原来的批处理

```
CALL command
```

调用一条批处理命令，和直接执行命令效果一样，特殊情况下很有用，比如变量的多级嵌套，见教程后面。在批处理编程中，可以根据一定条件生成命令字符串，用call可以执行该字符串，见例子。

```
CALL [drive:][path]filename [batch-parameters]
```

调用的其它批处理程序。filename 参数必须具有 .bat 或 .cmd 扩展名。

```
CALL :label arguments
```

调用本文件内命令段，相当于子程序。被调用的命令段以标签:label开头
以命令goto :eof结尾。

另外，批脚本文本参数参照(%0、%1、等等)已如下改变:
   批脚本里的 %* 指出所有的参数(如 %1 %2 %3 %4 %5 ...)
   批参数(%n)的替代已被增强。您可以使用以下语法:（看不明白的直接运行后面的例子）
      %~1      - 删除引号(")，扩充 %1
      %~f1     - 将 %1 扩充到一个完全合格的路径名
      %~d1     - 仅将 %1 扩充到一个驱动器号
      %~p1     - 仅将 %1 扩充到一个路径
      %~n1     - 仅将 %1 扩充到一个文件名
      %~x1     - 仅将 %1 扩充到一个文件扩展名
      %~s1     - 扩充的路径指含有短名
      %~a1     - 将 %1 扩充到文件属性
      %~t1     - 将 %1 扩充到文件的日期/时间
      %~z1     - 将 %1 扩充到文件的大小
      %~PATH:1−查找列在PATH环境变量的目录，并将PATH:1−查找列在PATH环境变量的目录，并将PATH:1 - 在列在 PATH 环境变量中的目录里查找 %1，
               并扩展到找到的第一个文件的驱动器号和路径。
     %~ftza1   - 将 %1 扩展到类似 DIR 的输出行。
  在上面的例子中，%1 和 PATH 可以被其他有效数值替换。
%~ 语法被一个有效参数号码终止。%~ 修定符不能跟 %*使用
注意：参数扩充时不理会参数所代表的文件是否真实存在，均以当前目录进行扩展
要理解上面的知识，下面的例子很关键。

例：

```
@echo off
Echo 产生一个临时文件 > tmp.txt
Rem 下行先保存当前目录，再将c:\windows设为当前目录
pushd c:\windows
Call :sub tmp.txt
Rem 下行恢复前次的当前目录
Popd
Call :sub tmp.txt
pause
Del tmp.txt
exit
:sub
Echo 删除引号： %~1
Echo 扩充到路径： %~f1
Echo 扩充到一个驱动器号： %~d1
Echo 扩充到一个路径： %~p1
Echo 扩充到一个文件名： %~n1
Echo 扩充到一个文件扩展名： %~x1
Echo 扩充的路径指含有短名： %~s1
Echo 扩充到文件属性： %~a1
Echo 扩充到文件的日期/时间： %~t1
Echo 扩充到文件的大小： %~z1
Echo 扩展到驱动器号和路径：%~dp1
Echo 扩展到文件名和扩展名：%~nx1
Echo 扩展到类似 DIR 的输出行：%~ftza1
Echo.
Goto :eof
```

例：

```
set aa=123456
set cmdstr=echo %aa%
call %cmdstr%
pause
```

本例中如果不用call，而直接运行%cmdstr%，将显示结果%aa%，而不是123456

## 调用外部程序：start

批处理中调用外部程序的命令

1. 用start调用的外部程序在新窗口中运行，批处理程序继续往下执行，不理会外部程序的运行状况
2. 批处理中直接运行外部程序则必须等外部程序完成后才继续执行剩下的指令

例：start explorer d:\  

调用图形界面打开D盘

## 文件关联：assoc和ftype

文件关联
```cmd
assoc 设置'文件扩展名'关联，关联到'文件类型'
ftype 设置'文件类型'关联，关联到'执行程序和参数'
当你双击一个.txt文件时，windows并不是根据.txt直接判断用 notepad.exe 打开
而是先判断.txt属于 txtfile '文件类型'
再调用 txtfile 关联的命令行 txtfile=%SystemRoot%\system32\NOTEPAD.EXE %1
可以在"文件夹选项"→"文件类型"里修改这2种关联
assoc       #显示所有'文件扩展名'关联
assoc .txt    #显示.txt代表的'文件类型'，结果显示 .txt=txtfile
assoc .doc    #显示.doc代表的'文件类型'，结果显示 .doc=Word.Document.8
assoc .exe    #显示.exe代表的'文件类型'，结果显示 .exe=exefile
ftype       #显示所有'文件类型'关联
ftype exefile  #显示exefile类型关联的命令行，结果显示 exefile="%1" %*
assoc .txt=Word.Document.8
设置.txt为word类型的文档，可以看到.txt文件的图标都变了
assoc .txt=txtfile
恢复.txt的正确关联

ftype exefile="%1" %*
恢复 exefile 的正确关联
如果该关联已经被破坏，可以运行 command.com ，再输入这条命令
```

## 切换目录：pushd和popd

切换当前目录

```cmd
@echo off
c: & cd\ & md mp3    #在 C:\ 建立 mp3 文件夹
md d:\mp4          #在 D:\ 建立 mp4 文件夹
cd /d d:\mp4        #更改当前目录为 d:\mp4
pushd c:\mp3        #保存当前目录，并切换当前目录为 c:\mp3
popd             #恢复当前目录为刚才保存的 d:\mp4
一般用处不大，在当前目录名不确定时，会有点帮助。（dos编程中很有用）
```

## 参数位移：shift

更改批处理文件中可替换参数的位置。
SHIFT [/n]
如果命令扩展名被启用，SHIFT 命令支持/n 命令行开关；该命令行开关告诉
命令从第 n 个参数开始移位；n 介于零和八之间。例如:
  SHIFT /2
会将 %3 移位到 %2，将 %4 移位到 %3，即从%2开始，把后一个参数值赋值给前一个参数；并且不影响 %0 和 %1。

## 程序返回码：errorlevel

每个命令运行结束，可以用这个命令行格式查看返回码

用于判断刚才的命令是否执行成功

默认值为0，一般命令执行出错会设 errorlevel 为1

echo %errorlevel%

## 标题：title

设置cmd窗口的标题

```cmd
title 标题名 
```

## 颜色：COLOR

设置默认的控制台前景和背景颜色。

```cmd
COLOR [attr]
 attr     指定控制台输出的颜色属性
颜色属性由两个十六进制数字指定 -- 第一个为背景，第二个则为
前景。每个数字可以为以下任何值之一:
  0 = 黑色    8 = 灰色
  1 = 蓝色    9 = 淡蓝色
  2 = 绿色    A = 淡绿色
  3 = 湖蓝色   B = 淡浅绿色
  4 = 红色    C = 淡红色
  5 = 紫色    D = 淡紫色
  6 = 黄色    E = 淡黄色
  7 = 白色    F = 亮白色
```

1. 如果没有给定任何参数，该命令会将颜色还原到 CMD.EXE 启动时的颜色。这个值来自当前控制台窗口、/T 开关或DefaultColor 注册表值。
2. 如果用相同的前景和背景颜色来执行 COLOR 命令，COLOR 命令会将 ERRORLEVEL 设置为 1。
3. 例如: "COLOR fc" 在亮白色上产生亮红色

## 配置系统：mode

配置系统设备。
串行口:　    MODE COMm[:] [BAUD=b] [PARITY=p] [DATA=d] [STOP=s]
                     [to=on|off] [xon=on|off] [odsr=on|off]
                     [octs=on|off] [dtr=on|off|hs]
                     [rts=on|off|hs|tg] [idsr=on|off]
设备状态:        MODE [device] [/STATUS]
打印重定向:　　 MODE LPTn[:]=COMm[:]
选定代码页:　　 MODE CON[:] CP SELECT=yyy
代码页状态:　　 MODE CON[:] CP [/STATUS]
显示模式:　　   MODE CON[:] [COLS=c] [LINES=n]
击键率:　        MODE CON[:] [RATE=r DELAY=d]

例：

```
mode con cols=113 lines=15 & color 9f
```

此命令设置DOS窗口大小：15行，113列

