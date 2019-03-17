package pattern.proxy.dynamic;


/**
 * @Description  玩家接口
 * @author  OrezWodahs
 * @date 2019年3月17日 下午4:50:12 
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
}
