package pattern.composite.transparent;

import java.util.ArrayList;


/**
 * @Description  抽象构件
 * @author  WodahsOrez
 * @date 2018年6月8日 上午11:30:48 
 *  
 */
public abstract class AbstractComponent {
    /** 父节点 */
    private AbstractComponent parent = null;
    
    /**  
     * @Description  个体和整体都具有的共享
     */
    public void doSomething() {
        // 编写业务逻辑
    }
    
    /**  
     * @Description  增加一个构件
     */
    public abstract void add(AbstractComponent component);

    /**  
     * @Description  删除一个构件
     */
    public abstract void remove(AbstractComponent component);
    
    /**  
     * @Description  获取分支下的所有构件
     */  
    public abstract ArrayList<AbstractComponent> getChildren(); 
    
    public AbstractComponent getParent() {
        return parent;
    }

    public void setParent(AbstractComponent parent) {
        this.parent = parent;
    }
}
