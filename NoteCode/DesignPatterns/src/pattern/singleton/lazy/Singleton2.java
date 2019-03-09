package pattern.singleton.lazy;

/**
 * @Description  懒汉式线程安全,lazy loading,效率低 
 * @author  WodahsOrez
 * @date 2018年6月4日 上午11:23:26 
 *  
 */
public class Singleton2 {
    /** 存放单例实例的属性 */
    private static Singleton2 instance;
    
    /**
     * @Description  私有构造方法实现单例 
     */
    private Singleton2() {};

    /**  
     * @Description  获取单例对象的方法 
     * @return  返回单例对象 
     */
    public static synchronized Singleton2 getInstance() {  
        if (instance == null) {  
            instance = new Singleton2();  
        }  
        return instance;  
    } 
}
