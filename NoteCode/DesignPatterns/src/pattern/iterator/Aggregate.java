package pattern.iterator;

/**
 * @Description  抽象容器
 * @author  WodahsOrez
 * @date 2018年6月7日 上午11:50:15 
 *  
 */
public interface Aggregate {
    /**  
     * @Description  添加元素
     */
    void add(Object object);
    
    /**  
     * @Description  删除元素
     */
    void remove(Object object);
    
    /**  
     * @Description  获取迭代器
     */
    Iterator iterator();
}
