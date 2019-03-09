# 图片上传预览功能的实现与坑

## 实现方法

### FileReader

**原理**：把file对象转换成一段data:base64的字符串，在src插入该字符串。

```html
<!doctype html>
<html>
<head>
  <meta charset="UTF-8">
  <title>上传图片预览</title>
</head>
<body>
<input type="file" id="file"><br>
<img  height="200" id="img">
<script>
document.getElementById('file').onchange = function(){ 
	var file =  this.files[0];
	var reader = new FileReader();
	// 监听reader对象的的onload事件，当图片加载完成时，把base64编码賦值给预览图片
	reader.onload = function(event){
		document.getElementById('img').src = event.target.result;
        }
	// 调用reader.readAsDataURL()方法，把图片转成base64
	reader.readAsDataURL(file);
}
</script>
</body>
</html>
```



### URL.createObjectURL

原理：创建一个 File 对象或 Blob 对象的内存URL。该URL 的生命周期和创建它的窗口中的 document 绑定。

```javascript
document.getElementById('file').onchange = function(){ 
	var file =  this.files[0];
	document.getElementById('img').src = URL.createObjectURL(file);
}
```

以上两种方法也都适用于视频，区别在于需要传值到`<video>`标签的src。



### IE8兼容

但是！但是！但是！以上方法IE8都不支持，所以只能用ajax把图片上传到服务器，然后返回图片在服务器上的地址，把地址塞到src里去。然而接下来还有如下的这些坑：

1. 由于ie8不支持label的for属性，考虑使用js触发input[file]控件。
2. 但是IE下 input[file]表单控件，不能用js控制打开文件选择器，必须要手动点击才可以，否则提交表单时会报 “拒绝访问”。无奈考虑把input[file]变透明，遮住设计好的按钮。
3. ie8不支持opacity属性，用滤镜实现

```css
filter:progid:DXImageTransform.Microsoft.Alpha(opacity=0);
```



## 应用实例

<a href="previewImgDemo.html" target="_blank">身份证图片上传预览</a>

```html
<!doctype html>
<html>
<head>
  <meta charset="UTF-8">
  <title>上传图片预览</title>
</head>
<style>
.imglabel{
	width: 200px;
	height: 120px;
	line-height: 120px;
	text-align: center;
	border: 1px solid #ddd;
	border-radius: 3px;
	background-color: #f8f8f8; 
	cursor: pointer;
	display: block;
	margin: 8px;
}

.imgdiv{
	position: relative;
	width: 200px;
	height: 120px;
	border: 1px solid #ddd;
	border-radius: 3px;
	display: none;
	margin: 8px;
}

.imgdiv img{
	width: 100%;
	height: 100%;
}

.imgdiv span{
	position: absolute;
	left: 0;
	bottom: 0;
	width: 100%;
	color: #fff;
	background-color: #000;
	opacity: 0.5;
}

.imgdiv label{
	display: inline-block;
	width: 48%;
	text-align: center;
	cursor: pointer;
}
</style>
<body>
	
	<label class="imglabel" id="imglabel1" for="file1">+ 添加正面（人像面）</label>
	<div class="imgdiv" id="imgdiv1">
		<img class="img" id="img1">
		<span>
		<label  for="file1">重新选择</label>
		<label onclick="cancel('file1')">删除</label>
		</span>
	</div>
	<input type="file" id="file1" style="display:none;">

	<label class="imglabel" id="imglabel2" for="file2">+ 添加反面（非人像面）</label>
	<div class="imgdiv" id="imgdiv2">
		<img class="img" id="img2">
		<span>
		<label  for="file2">重新选择</label>
		<label onclick="cancel('file2')">删除</label>
		</span>
	</div>
	<input type="file" id="file2" style="display:none;">

</body>

<script>
// 删除方法，清空并触发onchange
function cancel(id) {
	document.getElementById(id).value = "";
	document.getElementById(id).onchange();
}

// 切换隐藏方法
function triggerImg(index){
	if(document.getElementById('file'+index).value == ""){
		document.getElementById('imgdiv'+index).style="display:none;"
		document.getElementById('imglabel'+index).style="display:block;"
	} else {
		document.getElementById('imgdiv'+index).style="display:block;"
		document.getElementById('imglabel'+index).style="display:none;"
	}
}

//URL.createObjectURL方式实现
document.getElementById('file1').onchange = function(){ 
	triggerImg("1");
	if(this.value != ""){
		var file =  this.files[0];
		document.getElementById('img1').src = URL.createObjectURL(file);
	}
}

// FileReader方式实现
document.getElementById('file2').onchange = function(){ 
	triggerImg("2");
	if(this.value != ""){
		var file =  this.files[0];
		var reader = new FileReader();
		// 监听reader对象的的onload事件，当图片加载完成时，把base64编码賦值给预览图片
		reader.onload = function(event){
			document.getElementById('img2').src = event.target.result;
			}
		// 调用reader.readAsDataURL()方法，把图片转成base64
		reader.readAsDataURL(file);
	}
}
</script>
</html>
```

