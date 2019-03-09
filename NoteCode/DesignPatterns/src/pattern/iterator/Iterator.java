package pattern.iterator;

/**
 * @Description  迭代器抽象
 * @author  WodahsOrez
 * @date 2018年6月7日 上午11:40:53 
 *  
 */
public interface Iterator {
    /**  
     * @Description  获取下一个元素
     */
    Object next();
    
    /**  
     * @Description  是否到达尾部
     */
    boolean hasNext();
    
    /**  
     * @Description  删除上一个获取的元素
     */
    boolean remove();
}
