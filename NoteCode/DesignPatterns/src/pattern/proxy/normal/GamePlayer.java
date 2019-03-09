package pattern.proxy.normal;

/**
 * @Description  具体玩家类
 * @author  WodahsOrez
 * @date 2018年6月5日 下午2:45:04 
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
    public GamePlayer(IGamePlayer gamePlayer,String name) throws Exception {
        if (gamePlayer.getClass().getSimpleName().equals("GamePlayerProxy")) {
            this.name = name;
        } else {
            throw new Exception("不能创建角色");
        }
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
