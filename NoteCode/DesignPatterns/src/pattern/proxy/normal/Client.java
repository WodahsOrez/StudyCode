package pattern.proxy.normal;

public class Client {
    public static void main(String[] args) {
        IGamePlayer gameplayer = new GamePlayerProxy("卢瑟");
        gameplayer.login("zhangsan", "123");
        gameplayer.killBoss();
        gameplayer.upgrade();
    }
}


