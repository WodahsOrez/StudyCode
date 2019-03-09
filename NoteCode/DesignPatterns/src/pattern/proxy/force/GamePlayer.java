package pattern.proxy.force;

/**
 * @Description  具体玩家类
 * @author  WodahsOrez
 * @date 2018年6月5日 下午2:45:04 
 *  
 */
public class GamePlayer implements IGamePlayer {
    /** 玩家的角色名 */
    private String name = "";
    
    /** 管理代理类 */
    private IGamePlayer proxy = null;
    
    /**
     * @Description  构造函数
     * @param  name  玩家名称
     */
    public GamePlayer(String name) {
            this.name = name;
    }
    
    /**  
     * @Description  登录方法
     * @param user  用户名
     * @param password  密码
     */
    @Override
    public void login(String user, String password) {
        if (this.proxy != null) {
            System.out.println("账户名为"+user+"的角色"+this.name+"登录成功!");
        } else {
            System.out.println("请使用指定的代理访问");
        }
    }
    
    /**  
     * @Description  击杀boss
     */
    @Override
    public void killBoss() {
        if (this.proxy != null) {
            System.out.println(this.name+"击杀了boss!");
        } else {
            System.out.println("请使用指定的代理访问");
        }
    }

    /**  
     * @Description  升级
     */
    @Override
    public void upgrade() {
        if (this.proxy != null) {
            System.out.println(this.name+"升级了!");
        } else {
            System.out.println("请使用指定的代理访问");
        }
    }

    /**  
     * @Description  获取指定的代理类
     */
    @Override
    public IGamePlayer getProxy() {
        this.proxy = new GamePlayerProxy(this);
        return this.proxy;
    }
}
