package pattern.singleton.dcl;

/**
 * @Description  双锁机制，安全且在多线程情况下能保持高性能,lazy loading
 * @author  WodahsOrez
 * @date 2018年6月4日 上午11:51:38 
 *  
 */
public class Singleton {
    /** 存放单例实例的属性 */
    private static volatile Singleton instance;
    
    /**
     * @Description  私有构造方法实现单例  
     */
    private Singleton() {}
    
    /**  
     * @Description  获取单例对象的方法,加了同步锁 
     * @return  返回单例对象
     */
    public static  Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
