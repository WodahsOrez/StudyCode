import { notification } from 'antd'

export class Notification {

    /**
     * 弹出错误通知
     *
     * @static
     * @param {string} message
     * @param {string} [title="错误"]
     * @memberof Notification
     */
    public static error(message: string, title: string = "错误") {
        notification.error({ message: title, description: message })
    }

    /**
     * 弹出成功通知
     *
     * @static
     * @param {string} message
     * @param {string} [title="错误"]
     * @memberof Notification
     */
    public static success(message: string, title: string = "成功") {
        notification.success({ message: title, description: message })
    }

}