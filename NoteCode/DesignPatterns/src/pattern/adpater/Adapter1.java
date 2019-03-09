package pattern.adpater;

/**
 * @Description  类适配器,继承Adaptee实现Target
 * @author  WodahsOrez
 * @date 2018年6月7日 上午9:07:10 
 *  
 */
public class Adapter1 extends Adaptee1 implements Target {

    /**  
     * @Description  实现Target方法,通过调用Adaptee的方法
     */
    @Override
    public void request() {
        super.doSomething();
    }
}
