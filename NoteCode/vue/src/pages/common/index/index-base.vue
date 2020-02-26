<template>
<div class="index_view index">
    <layout :class="themeClasses" :style="themeStyle">
        <header class="index_header">
            <div class="page-logo">
                    <img src="../../../assets/img/logo2.png" height="22" />
                <span style="display: inline-block;margin-left: 10px;font-size: 22px;">首页</span>
            </div>
            <div class="header-right" style="display: flex;align-items: center;justify-content: space-between;">
                <div>
                    <icon type="md-notifications-outline" style="font-size: 25px;margin: 0 10px;" />
                </div>
                <div>
                    <icon type="ios-mail-open-outline" style="font-size: 25px;margin: 0 10px;" />
                </div>
                <app-lang style='font-size: 15px;padding: 0 10px;'></app-lang>
                    <app-user></app-user>
                <app-theme style="width:45px;display: flex;justify-content: center;"></app-theme>
            </div>
        </header>
        <layout>
            <sider :width="collapseChange ? 64 : 200" hide-trigger v-model="collapseChange">
                <div class="sider-top">
                    <i class="ivu-icon ivu-icon-md-menu" @click="handleClick"></i>
                </div>
                <view_appmenu 
    :viewState="viewState"  
    :viewParam="viewParam"  
    :showBusyIndicator="true"  
    v-model="collapseChange"  
    :mode="mode"  
    :selectTheme="selectTheme"  
    :isDefaultPage="isDefaultPage"  
    :defPSAppView="defPSAppView" 
    name="appmenu"  
    ref='appmenu' 
    @closeview="closeView($event)">
</view_appmenu>
            </sider>
            <content class="index_content" :style="{'width':this.collapseChange ? 'calc(100vw - 64px)' : 'calc(100vw - 200px)' }">
                <tab-page-exp></tab-page-exp>
                <app-keep-alive :routerList="getRouterList">
                    <router-view :key="getRouterViewKey"></router-view>
                </app-keep-alive>
            </content>
        </layout>
    </layout>
</div>

</template>

<script lang='ts'>
import { Vue, Component, Prop, Provide, Emit, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';


import view_appmenu from '@widgets/app/index-appmenu/index-appmenu.vue';

@Component({
    components: {
        view_appmenu, 
    },
})
export default class IndexBase extends Vue {

    /**
     * 数据变化
     *
     * @param {*} val
     * @returns {*}
     * @memberof IndexBase
     */
    @Emit() 
    public viewDatasChange(val: any):any {
        return val;
    }

    /**
     * 数据视图
     *
     * @type {string}
     * @memberof IndexBase
     */
    @Prop() public viewdata!: string;

    /**
     * 视图默认使用
     *
     * @type {boolean}
     * @memberof IndexBase
     */
    @Prop({ default: true }) public viewDefaultUsage!: boolean;

	/**
	 * 视图标识
	 *
	 * @type {string}
	 * @memberof IndexBase
	 */
	public viewtag: string = '942C420B-3FD8-4526-9FE1-C5EA1494FA6B';

    /**
     * 父数据对象
     *
     * @protected
     * @type {*}
     * @memberof IndexBase
     */
    protected srfparentdata: any = {};

    /**
     * 视图模型数据
     *
     * @type {*}
     * @memberof IndexBase
     */
    public model: any = {
        srfTitle: '应用首页视图',
        srfCaption: 'app.views.index.caption',
        srfSubCaption: '',
        dataInfo: ''
    }

    /**
     * 处理值变化
     *
     * @param {*} newVal
     * @param {*} oldVal
     * @memberof IndexBase
     */
    @Watch('viewdata')
    onViewData(newVal: any, oldVal: any) {
        const _this: any = this;
        if (!Object.is(newVal, oldVal) && _this.engine) {
            _this.parseViewParam();
            _this.engine.load();
        }
    }

    /**
     * 容器模型
     *
     * @type {*}
     * @memberof IndexBase
     */
    public containerModel: any = {
        view_appmenu: { name: 'appmenu', type: 'APPMENU' },
    };

    /**
     * 视图状态订阅对象
     *
     * @private
     * @type {Subject<{action: string, data: any}>}
     * @memberof IndexBase
     */
    public viewState: Subject<ViewState> = new Subject();




    /**
     * 引擎初始化
     *
     * @private
     * @memberof IndexBase
     */
    private engineInit(): void {
    }

    /**
     * 视图参数
     *
     * @type {*}
     * @memberof IndexBase
     */
    public viewParam: any = {};

    /**
     * 解析视图参数
     *
     * @private
     * @memberof IndexBase
     */
    private parseViewParam(): void {
        if (!this.viewDefaultUsage && this.viewdata && !Object.is(this.viewdata, '')) {
            Object.assign(this.viewParam, JSON.parse(this.viewdata));
            return;
        }
        const path = (this.$route.matched[this.$route.matched.length - 1]).path;
        const keys: Array<any> = [];
        const curReg = this.$pathToRegExp.pathToRegexp(path, keys);
        const matchArray = curReg.exec(this.$route.path);
        let tempValue: Object = {};
        keys.forEach((item: any, index: number) => {
            Object.defineProperty(tempValue, item.name, {
                enumerable: true,
                value: matchArray[index + 1]
            });
        });
        const _data = this.$viewTool.formatRouteParams(tempValue);
        Object.assign(this.viewParam, _data);
    }

    /**
     * Vue声明周期
     *
     * @memberof IndexBase
     */
    public created() {
        const secondtag = this.$util.createUUID();
        this.$store.commit('viewaction/createdView', { viewtag: this.viewtag, secondtag: secondtag });
        this.viewtag = secondtag;
        this.parseViewParam();
        
    }

    /**
     * 销毁之前
     *
     * @memberof IndexBase
     */
    public beforeDestroy() {
        this.$store.commit('viewaction/removeView', this.viewtag);
    }

    /**
     * Vue声明周期(组件初始化完毕)
     *
     * @memberof IndexBase
     */
    public mounted() {
        const _this: any = this;
        _this.engineInit();
        if (_this.loadModel && _this.loadModel instanceof Function) {
            _this.loadModel();
        }
                this.viewState.next({ tag: 'appmenu', action: 'load', data: {} });
        this.$viewTool.setIndexParameters([{ pathName: 'index', parameterName: 'index' }]);
        this.$viewTool.setIndexViewParam(this.viewParam);

    }




    /**
     * 关闭视图
     *
     * @param {any[]} args
     * @memberof IndexBase
     */
    public closeView(args: any[]): void {
        let _view: any = this;
        if (_view.viewdata) {
            _view.$emit('viewdataschange', args);
            _view.$emit('close');
        } else if (_view.$tabPageExp) {
            _view.$tabPageExp.onClose(_view.$route.fullPath);
        }
    }
     

    /**
     * 菜单位置
     *
     * @private
     * @type {string}
     * @memberof IndexBase
     */
    private mode: string ='vertical';

    /**
     * 当前主题
     *
     * @readonly
     * @memberof IndexBase
     */
    get selectTheme() {
        if (this.$router.app.$store.state.selectTheme) {
            return this.$router.app.$store.state.selectTheme;
        } else if (localStorage.getItem('theme-class')) {
            return localStorage.getItem('theme-class');
        } else {
            return 'app-default-theme';
        }
    }

    /**
     * 当前字体
     *
     * @readonly
     * @memberof IndexBase
     */
    get selectFont() {
        if (this.$router.app.$store.state.selectFont) {
            return this.$router.app.$store.state.selectFont;
        } else if (localStorage.getItem('font-family')) {
            return localStorage.getItem('font-family');
        } else {
            return 'Microsoft YaHei';
        }
    }

    /**
     * 菜单收缩变化
     *
     * @type {boolean}
     * @memberof IndexBase
     */
    public collapseChange: boolean = false;

    /**
     * 菜单收缩点击
     *
     * @memberof IndexBase
     */
    public handleClick(): void {
        this.collapseChange = !this.collapseChange;
    }

    /**
     * 默认打开的视图
     *
     * @type {*}
     * @memberof IndexBase
     */
    public defPSAppView: any = {
    };

    /**
     * 应用起始页面
     *
     * @type {boolean}
     * @memberof IndexBase
     */
    public isDefaultPage: boolean = true;

    /**
     * 获取样式
     *
     * @readonly
     * @type {string[]}
     * @memberof IndexBase
     */
    get themeClasses(): string[] {
        return [
            Object.is(this.selectTheme, 'app_theme_blue') ? 'app_theme_blue' : '',
            Object.is(this.selectTheme, 'app-default-theme') ? 'app-default-theme' : '',
            Object.is(this.selectTheme, 'app_theme_darkblue') ? 'app_theme_darkblue' : '',
        ];
    }

    /**
     * 主题字体
     *
     * @readonly
     * @type {*}
     * @memberof IndexBase
     */
    get themeStyle(): any {
        return {
            'height': '100vh',
            'font-family': this.selectFont,
        }
    }

    /**
     * 获取路由列表
     *
     * @readonly
     * @type {any[]}
     * @memberof IndexBase
     */
    get getRouterList(): any[] {
        return this.$store.state.historyPathList;
    }

    /**
     * 获取路由键值
     *
     * @readonly
     * @type {string}
     * @memberof IndexBase
     */
    get getRouterViewKey(): string {
        return this.$route.fullPath;
    }

}
</script>

<style scoped lang='less'>
@import './index.less';
</style>