package pattern.factory.method;

/**
 * @Description  抽象提取的产品抽象类 
 * @author  WodahsOrez
 * @date 2018年6月4日 下午1:58:41 
 *  
 */
public abstract class Product {
    /**  
     * @Description  产品共性的方法
     */
    public void method1() {
        // 业务逻辑代码
    }
    
    /**  
     * @Description  产品各自个性的方法
     */
    public abstract void method2();
}
