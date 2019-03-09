package pattern.singleton.lazy;

/**
 * @Description 懒汉式非线程安全,lazy loading,
 * @author  WodahsOrez
 * @date 2018年6月4日 上午9:27:08
 * 
 */
public class Singleton1 {
    
    /** 存放单例实例的属性 */
    private static Singleton1 instance;
    
    /**
     * @Description  私有构造方法实现单例
     */
    private Singleton1 (){}  
    
    /** 
     * @Description  获取单例对象的方法 
     * @return  返回单例对象
     */
    public static Singleton1 getInstance() {  
        if (instance == null) {  
            instance = new Singleton1();  
        }  
        return instance;  
    }  

}
