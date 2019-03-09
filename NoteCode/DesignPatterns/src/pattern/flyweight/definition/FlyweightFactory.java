package pattern.flyweight.definition;

import java.util.HashMap;

/**
 * @Description  享元工厂
 * @author  WodahsOrez
 * @date 2018年7月10日 上午10:46:06 
 *  
 */
public class FlyweightFactory {
    /** 池容器 */
    private static HashMap<String,AbstractFlyweight> pool = new HashMap<String,AbstractFlyweight>();
    
    /**  
     * @Description  工厂方法
     * @param EXTRINSIC  外部状态
     * @return  
     */
    public static AbstractFlyweight getFlyweight(String EXTRINSIC) {
        AbstractFlyweight flyweight = null;
        if (pool.containsKey(EXTRINSIC)) {
            flyweight = pool.get(EXTRINSIC);
        } else {
            flyweight = new ConcreteFlyweight1(EXTRINSIC);
            pool.put(EXTRINSIC, flyweight);
        }
        return flyweight;
    }
}
