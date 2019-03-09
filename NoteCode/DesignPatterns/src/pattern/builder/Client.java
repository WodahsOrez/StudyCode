package pattern.builder;

public class Client {
    public static void main(String[] args) {
        Director director = new Director();
        director.getABenzCar().run();
        System.out.println("----------分割线----------");
        director.getBBenzCar().run();
        System.out.println("----------分割线----------");
        director.getCBMWCar().run();
        System.out.println("----------分割线----------");
        director.getDBMWCar().run();
    }
}
