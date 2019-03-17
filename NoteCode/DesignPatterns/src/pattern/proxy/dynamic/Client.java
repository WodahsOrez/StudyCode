package pattern.proxy.dynamic;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        IGamePlayer gameplayer = new GamePlayer("卢瑟");
        IGamePlayer proxy = (IGamePlayer)Proxy.newProxyInstance(gameplayer.getClass().getClassLoader(), 
                gameplayer.getClass().getInterfaces(), new GamePlayerHandler(gameplayer));
        proxy.login("zhangsan", "123");
        proxy.killBoss();
        proxy.upgrade();
    }
}


