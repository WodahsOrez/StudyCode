# vue-i18n（国际化）

## 安装与配置

### 安装

```sh
npm install vue-i18n  ## npm安装
yarn add vue-i18n  ## yarn安装
```

### 配置

#### 基础配置(main.ts)

```tsx
import Vue from 'vue';
import VueI18n from 'vue-i18n'
Vue.use(VueI18n )
new Vue({
    el： ’#app',
    i18n,
    router,
    components: {App},
    template: '<App/>'
    .....
})
```

#### 自定义配置(@/locale/index.ts)

```tsx
import Vue from 'vue'
import VueI18n from 'vue-i18n'
const vueApp: any = Vue;
vueApp.use(VueI18n);

//引入语言文件
import zhCn from './lang/zh-CN';
import iviewZhCnLocale from 'view-design/dist/locale/zh-CN';
import elementZhLocale from 'element-ui/lib/locale/lang/zh-CN';
const messages = {
    'zh-CN': Object.assign(iviewZhCnLocale, elementZhLocale, zhCn),
};


// 自动根据浏览器系统语言设置语言
const navLang = localStorage.getItem('local') || navigator.language;
const localLang = (navLang === 'zh-CN' || (navLang === 'en-US' && messages.hasOwnProperty('en-US'))) ? navLang : false;
let lang: string = localLang || 'zh-CN';

vueApp.config.lang = lang

// // vue-i18n 6.x+写法
vueApp.locale = () => { };

// messages为语言映射对象，key为语言标识，value为语言文件
const i18n = new VueI18n({
    locale: lang,
    messages
});

export default i18n;
```

#### 组件国际化(main.ts)

```tsx
import ElementUi from 'element-ui';
import ViewUI from 'view-design';
import i18n from '@/locale'
Vue.use(ElementUi, {
  i18n: (key: any, value: any) => i18n.t(key, value)
});
Vue.use(ViewUI, {
  i18n: (key: any, value: any) => i18n.t(key, value)
});
```

## 使用

```tsx
// vue文本输出
{{ $t('login.name') }}
// vue属性绑定
:title="$t('login.caption')"
// ts语句中
placeholder=this.$t('login.password.placeholder')
// 改变语言
this.$i18n.locale = 'en'
```

## 自定义语言文件

```
.
├── locale                       // 语言文件夹
|   ├── lang                     // 汇总语言文件
│   │    ├── en-US.ts            // 英文汇总语言文件
│   │    └── zh-CN.ts            // 中文汇总语言文件
│   ├── lanres                   // 实体语言文件
│   │    └── 实体名
│   │        ├── 实体名_en-US.ts  // 体英文语言文件
│   │        └── 实体名_zh-CN.ts  // 体中文语言文件
│   └── index.ts                 // i18n配置文件
```

