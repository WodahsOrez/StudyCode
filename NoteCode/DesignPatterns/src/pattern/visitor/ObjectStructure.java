package pattern.visitor;

import java.util.Random;

/**
 * @Description  结构对象
 * @author  WodahsOrez
 * @date 2018年7月6日 上午8:22:08 
 *  
 */
public class ObjectStructure {
    /**  
     * @Description  对象生成器,通过一个工厂方法模式模拟
     * @return   
     */
    public static AbstractElement createElement() {
        Random rand = new Random();
        if (rand.nextInt(100) > 50) {
            return new ConcreteElement1();
        } else {
            return new ConcreteElement2();
        }
    }
}
