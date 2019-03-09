package pattern.proxy.force;

/**
 * @Description  玩家接口
 * @author  WodahsOrez
 * @date 2018年6月5日 下午2:36:06 
 *  
 */
public interface IGamePlayer {
    /**  
     * @Description  登录方法
     * @param user  用户名
     * @param password  密码
     */
    void login(String user, String password);
    
    /**  
     * @Description  击杀boss
     */
    void killBoss();
    
    /**  
     * @Description  升级
     */
    void upgrade();
    
    /**  
     * @Description  获取指定的代理类
     */
    IGamePlayer getProxy();
}
