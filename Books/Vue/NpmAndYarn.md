# Npm和Yarn

## Npm



### 命令

```sh
## 安装，-g全局，@版本号安装指定版本
npm install 模块名@版本号 -g 
## 删除
npm uninstall 模块名
## 更新
npm update 模块名
# 安装所有依赖
npm install
```

### 依赖

```sh
--save || -S #发布后需要的依赖，会写入package.json的dependencies里
--save-dev || -D #仅开发需要的依赖，发布后不会带，会写入package.json的devDependencies里
```

## Yarn

### 命令

```sh
## 安装，默认带--save，global全局安装
npm global add 模块名@版本号 
## 删除
npm remove 模块名
## 更新
npm upgrade 模块名
# 安装所有依赖
yarn install
```

### 依赖

```sh
--dev || -D ##仅开发需要的依赖，发布后不会带，会写入package.json的devDependencies里
```

