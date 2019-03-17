package pattern.proxy.dynamic;


/**
 * @Description  玩家类
 * @author  OrezWodahs
 * @date 2019年3月17日 下午4:49:56 
 *  
 */
public class GamePlayer implements IGamePlayer {
    /** 玩家的角色名 */
    private String name = "";
    
    /**
     * @Description  构造函数
     * @param  gamePlayer  只有传入代理对象才能创建
     * @param  name  玩家名称
     * @throws Exception 
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
        System.out.println("账户名为"+user+"的角色"+this.name+"登录成功!");
    }
    
    /**  
     * @Description  击杀boss
     */
    @Override
    public void killBoss() {
        System.out.println(this.name+"击杀了boss!");
    }

    /**  
     * @Description  升级
     */
    @Override
    public void upgrade() {
        System.out.println(this.name+"升级了!");
    }
    

}
