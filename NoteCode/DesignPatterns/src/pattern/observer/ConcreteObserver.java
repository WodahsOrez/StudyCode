package pattern.observer;

/**
 * @Description  具体观察者
 * @author  WodahsOrez
 * @date 2018年6月19日 下午2:01:14 
 *  
 */
public class ConcreteObserver implements Observer{
    /**  
     * @Description  实现更新方法
     */
    @Override
    public void update() {
        System.out.println("接收到信息,并进行处理!");
    }
    
}
