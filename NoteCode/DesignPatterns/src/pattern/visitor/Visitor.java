package pattern.visitor;

/**
 * @Description  抽象访问者
 * @author  WodahsOrez
 * @date 2018年7月6日 上午7:58:01 
 *  
 */
public interface Visitor {
    /**  
     * @Description  访问对象方法
     * @param element1   可以访问哪些对象
     */
    void visit(ConcreteElement1 element1);
    
    /**  
     * @Description  访问对象方法
     * @param element2   可以访问哪些对象
     */
    void visit(ConcreteElement2 element2); 
}
