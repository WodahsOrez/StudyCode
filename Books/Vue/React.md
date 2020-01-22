# React

## 项目搭建

```sh
#安装官方脚手架
npm install -g create-react-app
#搭建一个TypeScript的项目
npx create-react-app demo-ts --typescript
```

### 集成less

#### 安装依赖

```sh
#安装less-loader
yarn add less less-loader -D
#将配置文件暴露出来
yarn eject
```

#### 修改配置

修改config文件夹下的webpack.config.js配置

1.  ##### 搜索 style files regexes ，找到后添加两行代码

```js
// style files regexes
const cssRegex = /\.css$/;
const cssModuleRegex = /\.module\.css$/;
const sassRegex = /\.(scss|sass)$/;
const sassModuleRegex = /\.module\.(scss|sass)$/;
// 此处加入这两行
const lessRegex = /\.less$/;
const lessModuleRegex = /\.module\.less$/;
```

2.  ##### 修改 getStyleLoaders 函数，添加代码

```js
// common function to get style loaders
  const getStyleLoaders = (cssOptions, preProcessor) => {
    const loaders = [
      isEnvDevelopment && require.resolve('style-loader'),
      isEnvProduction && {
        loader: MiniCssExtractPlugin.loader,
        options: shouldUseRelativeAssetPaths ? { publicPath: '../../' } : {},
      },
      {
        loader: require.resolve('css-loader'),
        options: cssOptions,
      },
      // 加入下面代码
      {
        loader: require.resolve('less-loader'),
        options: cssOptions,
      },
```

3. ##### 搜索 cssRegex ，在 css 配置下添加 less 配置


```json
{
    test: cssRegex,
    exclude: cssModuleRegex,
    use: getStyleLoaders({
        importLoaders: 1,
        sourceMap: isEnvProduction && shouldUseSourceMap,
    }),
    // Don't consider CSS imports dead code even if the
    // containing package claims to have no side effects.
    // Remove this when webpack adds a warning or an error for this.
    // See https://github.com/webpack/webpack/issues/6571
    sideEffects: true,
},
// Adds support for CSS Modules (https://github.com/css-modules/css-modules)
// using the extension .module.css
{
    test: cssModuleRegex,
    use: getStyleLoaders({
        importLoaders: 1,
        sourceMap: isEnvProduction && shouldUseSourceMap,
        modules: true,
        getLocalIdent: getCSSModuleLocalIdent,
    }),
},
// 此处加入less的配置
{
    test: lessRegex,
    exclude: lessModuleRegex,
    use: getStyleLoaders(
        {
            importLoaders: 1,
            sourceMap: isEnvProduction
            ? shouldUseSourceMap
            : isEnvDevelopment,
        },
        'less-loader'
    ),
    sideEffects: true,
},
{
    test: lessModuleRegex,
    use: getStyleLoaders(
        {
            importLoaders: 1,
            sourceMap: isEnvProduction
            ? shouldUseSourceMap
            : isEnvDevelopment,
            modules: true,
            getLocalIdent: getCSSModuleLocalIdent,
        },
        'less-loader'
    ),
},
```

