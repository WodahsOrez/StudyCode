import { PureComponent, ReactNode } from "react";
import Layout from '@/components/layout';
import '@/styles/default.less';
import AppMenu from '@/widgets/app/web-site-appmenu';

/**
 * 输入参数
 *
 * @interface DefaultProps
 */
interface DefaultProps {
    /**
     * 视图抬头
     *
     * @type {string}
     * @memberof DefaultProps
     */
    title?: string;
    
    /**
     * 是否显示菜单栏
     *
     * @type {boolean}
     * @memberof DefaultProps
     */
    isShowMenu?: boolean;
}

/**
 * 应用布局
 *
 * @export
 * @class
 * @extends {PureComponent}
 */
export default class extends PureComponent<DefaultProps> {

    /**
     * 输入参数默认值
     *
     * @static
     */
    static defaultProps = {
        isShowMenu: true
    }

    /**
     * 绘制内容
     *
     * @returns {ReactNode}
     */
    public render(): ReactNode {
        let menu = this.props.isShowMenu ? <AppMenu name="appmenu"/> : null;
        return <Layout title={this.props.title} menu={menu}>{this.props.children}</Layout>;
    }
}