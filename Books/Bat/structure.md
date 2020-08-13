# 语法结构

## IF条件

### 数字比较

```cmd
IF [NOT] ERRORLEVEL number command
```

number的数字范围是0~255，当ERRORLEVEL的值大于等于number的值时，条件成立

EQU - 等于
NEQ - 不等于
LSS - 小于
LEQ - 小于或等于
GTR - 大于
GEQ - 大于或等于

### 字符串比较

```cmd
 IF [NOT] string1==string2 command
```

区分大小写，当两个字符串完全一致时，条件成立。

如果字符串中有空格，可以使用下方的的写法

```cmd
if [NOT] {string1}=={string2} command
if [NOT] [string1]==[string2] command
if [NOT] "string1"=="string2" command
```

不区分大小写可以用下面的写法

```cmd
IF [/I] string1 compare-op string2 command
```

### 文件或目录存在

```cmd
 IF [NOT] EXIST filename command
```

### ELSE语句

用小括号组成if-else结构

```cmd
IF EXIST filename (
  del filename
) ELSE (
  echo filename missing
)
```

