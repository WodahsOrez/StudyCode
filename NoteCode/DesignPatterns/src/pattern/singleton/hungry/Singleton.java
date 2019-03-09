package pattern.singleton.hungry;

/**
 * @Description  饿汉式 ,线程安全效率高,浪费内存,非lazy loading
 * @author  WodahsOrez
 * @date 2018年6月4日 上午11:30:02 
 *  
 */
public class Singleton {
    /** 存放单例实例的属性 */
    private static Singleton instance = new Singleton();  
    
    /**
     * @Description  私有构造方法实现单例 
     */
    private Singleton (){}  
    
    /**  
     * @Description  获取单例对象的方法
     * @return  返回单例对象
     */
    public static Singleton getInstance() {  
        return instance;  
    }  
}
