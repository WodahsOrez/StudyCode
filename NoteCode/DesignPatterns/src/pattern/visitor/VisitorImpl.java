package pattern.visitor;

/**
 * @Description  具体访问者
 * @author  WodahsOrez
 * @date 2018年7月6日 上午8:14:42 
 *  
 */
public class VisitorImpl implements Visitor {

    /**  
     * @Description  访问对象方法
     * @param element1   可以访问哪些对象
     */
    @Override
    public void visit(ConcreteElement1 element1) {
        element1.doSomething();
    }

    /**  
     * @Description  访问对象方法
     * @param element2  可以访问哪些对象
     */
    @Override
    public void visit(ConcreteElement2 element2) {
        element2.doSomething();
    }
}
