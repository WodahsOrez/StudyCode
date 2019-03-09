package pattern.iterator;

import java.util.Vector;

/**
 * @Description  具体迭代器类
 * @author  WodahsOrez
 * @date 2018年6月7日 上午11:49:41 
 *  
 */
public class ConcreteIterator implements Iterator {
    /** 容器 */
    private Vector vector = new Vector();
    
    /** 游标 */
    private int cursor = 0;
    
    /**
     * @Description  通过构造函数传递一个Vector
     * @param vector   
     */
    @SuppressWarnings("unchecked")
    public ConcreteIterator(Vector vector) {
        this.vector = vector;
    }
    
    @Override
    public Object next() {
        Object result = null;
        if (this.hasNext()) {
            result = this.vector.get(this.cursor++);
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        if (this.cursor == this.vector.size()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean remove() {
        this.vector.remove(--this.cursor);
        return true;
    }

}
