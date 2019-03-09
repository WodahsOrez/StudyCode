package pattern.iterator;

import java.util.Vector;

/**
 * @Description  具体容器
 * @author  WodahsOrez
 * @date 2018年6月7日 上午11:52:15 
 *  
 */
public class ConcreteAggregate implements Aggregate {
    /** 容器 */
    private Vector vector = new Vector();
    
    /**  
     * @Description  添加元素
     */
    @Override
    public void add(Object object) {
        this.vector.add(object);
    }

    /**  
     * @Description  删除元素
     */
    @Override
    public void remove(Object object) {
        this.vector.remove(object);
    }

    /**  
     * @Description  获取迭代器
     */
    @Override
    public Iterator iterator() {
        return new ConcreteIterator(this.vector);
    }

}
