# Vue CLI（3.0）

## 安装

```sh
## 安装
npm install -g @vue/cli
# OR
yarn global add @vue/cli
## 查看版本
vue --version
## 创建项目
vue create 项目名
## 可视化界面创建项目
vue ui
```

### 项目配置

- babel：用于ES6转化成ES5，兼容ES5用
- TypeScript：JavaScript的超集，面向对象。
- [Progressive Web App](https://pwa.baidu.com/pwa/README)：改善网页应用体验，让其接近app
- Router：
- Vuex：
- css pre-processor：
- Linter/Formatter：语法校验配置
- Unit Testing：单元测试，程序员角度
- E2E Testing：端对端测试，用户角度

#### 在选择功能后，会询问更细节的配置

TypeScript：

1. 是否使用class风格的组件语法：Use class-style component syntax?
2. 是否使用babel做转义：Use Babel alongside TypeScript for auto-detected polyfills?

Router：

1. 路由使用历史模式（一般实际项目要使用history）：Use history mode for router? (Requires proper server setup for index fallback in production) 

CSS Pre-processors：

1. 选择CSS 预处理类型：Pick a CSS pre-processor

Linter / Formatter

1. 选择Linter / Formatter规范类型：Pick a linter / formatter config
   - TSLint
   - ESLint with error prevention only   仅错误预防
   - ESLint + Airbnb config   Airbnb配置
   - ESLint + Standard config  标准配置
   - ESLint + Prettier   Prettier配置（常用）
2. 选择lint方式，保存时检查/提交时检查：Pick additional lint features
   - Lint on save 保存时检查
   - Lint and fix on commit 提交时检查

Testing

1. 选择Unit测试方式：Pick a unit testing solution
   - Mocha + Chai
   - Jest
2. 选择E2E测试方式：Pick a E2E testing solution
   - Cypress (Chrome only) 
   - Nightwatch (Selenium-based)

其他选项

1. 选择 Babel，PostCSS， ESLint 等自定义配置的存放位置：Where do you prefer placing config for Babel, PostCSS, ESLint, etc.?
   - In dedicated config files 在单独的配置文件中
   - In package.json  在package.json里配置
3. 将此作为将来项目的预置吗？是的，下次可以直接用：Save this as a preset for future projects?
4. 项目配置名称，设置配置名称为：Save preset as

## 参考文档

[配置详解](https://www.cnblogs.com/zjhr/p/9472648.html)

