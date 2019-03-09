package pattern.singleton.enumation;

/**
 * @Description  枚举单例,线程安全,非lazy loading,支持序列化 
 * @author  WodahsOrez
 * @date 2018年6月4日 下午1:30:24 
 *  
 */
public enum Singleton {  
    /** 单例实例 */
    INSTANCE;  
    
    /**  
     * @Description  单例的具体方法
     */
    public void whateverMethod() {}  
}  