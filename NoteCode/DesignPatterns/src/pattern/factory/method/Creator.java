package pattern.factory.method;

/**
 * @Description  抽象工厂类 
 * @author  WodahsOrez
 * @date 2018年6月4日 下午2:06:52 
 *  
 */
public abstract class Creator {
    /**  
     * @Description  根据入参生成对应类型的产品实例
     * @param  c 传入的具体产品类的Class类
     * @return  
     */
    public abstract <T extends Product> T createProduct(Class<T> c);
}
