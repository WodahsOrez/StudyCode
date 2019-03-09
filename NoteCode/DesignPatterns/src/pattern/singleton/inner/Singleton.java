package pattern.singleton.inner;

/**
 * @Description  登记式/静态内部类,线程安全,lazy loading
 * @author  WodahsOrez
 * @date 2018年6月4日 下午1:18:37 
 *  
 */
public class Singleton {
    /**
     * @Description  静态内部类,为单例的主体 
     * @author  WodahsOrez
     * @date 2018年6月4日 下午1:18:40 
     *  
     */
    private static class SingletonHolder {
        /** 内部静态常量,值为单例实例 */
        private static final Singleton INSTANCE = new Singleton();
    }

    /**
     * @Description  私有构造实现单例 
     */
    private Singleton() {}

    /**  
     * @Description  调用该方法时加载内部类
     * @return  返回内部类静态常量
     */
    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
