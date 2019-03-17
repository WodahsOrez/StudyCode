package pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description  Handler类
 * @author  OrezWodahs
 * @date 2019年3月17日 下午4:50:54 
 *  
 */
public class GamePlayerHandler implements InvocationHandler {
    /** 存放被代理的玩家实例 */
    private IGamePlayer gamePlayer = null;
    
    /**
     * @Description  通过玩家类创建代理类
     * @param gamePlayer   被代理的玩家类
     */
    public GamePlayerHandler(IGamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }
    
    
    /**  
     * @Description  动态代理方法
     * @param proxy  动态生成的代理类的实例
     * @param method  被代理的玩家类调用的方法的Method对象
     * @param args  方法的参数
     * @return
     * @throws Throwable  
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before 动态代理...");
        System.out.println(proxy.getClass().getName());
        System.out.println(this.gamePlayer.getClass().getName());
        switch (method.getName()) {
        case "login":
            System.out.println("代练开始登录");
            method.invoke(this.gamePlayer, args);
            break;
        case "killBoss":
            System.out.println("代练开始练级");
            method.invoke(this.gamePlayer, args);
            break;
        case "upgrade":
            System.out.println("在代练的努力下");
            method.invoke(this.gamePlayer, args);
            break;
        }
        return proxy;

    }


}
