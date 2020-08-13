import qs from 'qs';
import {Environment} from '@/environments/environment'

/**
 * Fetch net 对象
 * 调用 getInstance() 获取实例
 *
 * @class Fetch
 */
export class Fetch {

    /**
     * 获取 Fetch 单例对象
     *
     * @static
     * @returns {Fetch}
     * @memberof Fetch
     */
    public static getInstance(): Fetch {
        if (!Fetch.Fetch) {
            Fetch.Fetch = new Fetch();
        }
        return this.Fetch;
    }

    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {Fetch}
     * @memberof Fetch
     */
    private static Fetch: Fetch;

    /**
     * Creates an instance of Fetch.
     * 私有构造，拒绝通过 new 创建对象
     * 
     * @memberof Fetch
     */
    private constructor() { }

    /**
     * post请求
     *
     * @param {string} url
     * @param {*} [params={}]
     * @returns {Promise<any>}
     * @memberof Fetch
     */
    public post(url: string, params: any = {}): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            fetch(Environment.proxyAddress+url,{
                method: 'post',
                body: JSON.stringify(params),
                headers: { 
                    'Content-Type': 'application/json;charset=UTF-8', 
                },
            }).then((response: any) => {
                resolve(response)
            }).catch((error: any) => {
                reject(error);
            });
        });
    }

    
    /**
     * 获取
     *
     * @param {string} url
     * @param {*} [params={}]
     * @returns {Promise<any>}
     * @memberof Http
     */
    public get(url: string,params: any = {}): Promise<any> {
        return new Promise((resolve: any, reject: any) => {
            url += `?${qs.stringify(params)}`;
            fetch(Environment.proxyAddress+url,{
                method: 'get',
                headers: { 
                    'Content-Type': 'application/json;charset=UTF-8', 
                },
            }).then((response: any) => {
                resolve(response)
            }).catch((error: any) => {
                reject(error);
            });
        });
    }

}