package pattern.proxy.force;

/**
 * @Description  代理类
 * @author  WodahsOrez
 * @date 2018年6月5日 下午3:25:59 
 *  
 */
public class GamePlayerProxy implements IGamePlayer {
    /** 存放被代理的玩家实例 */
    private IGamePlayer gamePlayer = null;
    
    /**
     * @Description  通过代理类的构造函数创建对应的玩家类
     * @param name   玩家姓名
     */
    public GamePlayerProxy(IGamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }
    
    /**  
     * @Description  登录方法
     * @param user  用户名
     * @param password  密码
     */
    @Override
    public void login(String user, String password) {
        System.out.println("代练开始登录");
        this.gamePlayer.login(user, password);
    }

    /**  
     * @Description  击杀boss
     */
    @Override
    public void killBoss() {
        System.out.println("代练开始练级");
        this.gamePlayer.killBoss();
    }

    /**  
     * @Description  升级
     */
    @Override
    public void upgrade() {
        System.out.println("在代练的努力下");
        this.gamePlayer.upgrade();
    }

    /**  
     * @Description  返回自己
     */
    @Override
    public IGamePlayer getProxy() {
        return this;
    }

}
