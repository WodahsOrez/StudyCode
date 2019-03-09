package pattern.factory.method;

/**
 * @Description  具体方法工厂类 
 * @author  WodahsOrez
 * @date 2018年6月4日 下午2:24:30 
 *  
 */
public class ConcreteCreator extends Creator {
    /**  
     * @Description  实现了根据传入的Class方法创建实例方法
     * @param  c  具体产品类的Class类
     * @return    
     * @throws 
     */
    @Override
    public <T extends Product> T createProduct(Class<T> c) {
        Product product = null;
        try {
            product = c.newInstance();
        } catch (Exception e) {
            // 异常处理
        }
        return (T) product;
    }

}
