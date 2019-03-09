package pattern.visitor;

/**
 * @Description  抽象元素
 * @author  WodahsOrez
 * @date 2018年7月6日 上午7:55:08 
 *  
 */
public abstract class AbstractElement {
    /**  
     * @Description  业务逻辑方法
     */
    public abstract void doSomething();
    
    /**  
     * @Description  访问者访问方法
     * @param visitor   允许哪个访问者
     */
    public abstract void accept(Visitor Visitor);
}
