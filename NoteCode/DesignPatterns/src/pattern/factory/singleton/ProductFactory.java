package pattern.factory.singleton;

import java.util.HashMap;
import java.util.Map;

import pattern.factory.method.ConcreteProduct1;
import pattern.factory.method.ConcreteProduct2;
import pattern.factory.method.Product;

/**
 * @Description  通过工厂模式来实现单例 
 * @author  WodahsOrez
 * @date 2018年6月4日 下午2:32:55 
 *  
 */
public class ProductFactory{
    /** 产品单例实例的存放区 */
    private static final Map<Class,Product> prMap = new HashMap();
    
    /**  
     * @Description  获取单例实例的方法,
     * @param  type 具体产品类的Class对象
     * @return  返回产品实例
     * @throws  Exception   
     */
    public static synchronized Product createProduct(Class<? extends Product> type) throws Exception{
        Product product = null;
        if(prMap.containsKey(type)){
            product = prMap.get(type);
        }else{
            product = type.newInstance();
            prMap.put(type,product);
        }
        return product;
    }
}
