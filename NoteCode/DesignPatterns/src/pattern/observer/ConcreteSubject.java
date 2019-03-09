package pattern.observer;

/**
 * @Description  具体被观察者类
 * @author  WodahsOrez
 * @date 2018年6月19日 下午2:04:56 
 *  
 */
public class ConcreteSubject extends Observable {
    /**  
     * @Description  具体业务方法
     */
    public void doSomething() {
        //业务逻辑
        super.notifyObservers();
    }
}
