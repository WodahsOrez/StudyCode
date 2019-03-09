package pattern.adpater;

/**
 * @Description  对象适配器,通过类关联的方式,关联源角色
 * @author  WodahsOrez
 * @date 2018年6月7日 上午9:12:49 
 *  
 */
public class Adapter2 implements Target {
    /** 存放源角色1 */
    private Adaptee1 adaptee1 = null;
   
    /** 存放源角色2 */
    private Adaptee2 adaptee2 = null;
    
    /**
     * @Description  通过构造函数设置源角色
     * @param adaptee1  源角色1
     * @param adaptee2  源角色2
     */
    public Adapter2(Adaptee1 adaptee1, Adaptee2 adaptee2) {
        this.adaptee1 = adaptee1;
        this.adaptee2 = adaptee2;
    }

    /**  
     * @Description  实现Target的方法,调用源角色的方法
     */
    @Override
    public void request() {
        this.adaptee1.doSomething();
        this.adaptee2.doSomething();
    }
}
