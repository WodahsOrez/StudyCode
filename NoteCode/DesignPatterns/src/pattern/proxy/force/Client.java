package pattern.proxy.force;

public class Client {
    public static void main(String[] args) {
        IGamePlayer gameplayer = new GamePlayer("卢瑟");
        IGamePlayer proxy = gameplayer.getProxy();
        proxy.login("limin", "1234");
        proxy.killBoss();
        proxy.upgrade();
        
    }
}


