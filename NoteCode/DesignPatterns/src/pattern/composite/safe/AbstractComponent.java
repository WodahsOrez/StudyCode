package pattern.composite.safe;

/**
 * @Description  抽象构件
 * @author  WodahsOrez
 * @date 2018年6月8日 上午10:17:00 
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

    public AbstractComponent getParent() {
        return parent;
    }

    public void setParent(AbstractComponent parent) {
        this.parent = parent;
    }
}
