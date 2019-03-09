package pattern.builder;

import java.util.ArrayList;

/**
 * @Description  汽车建造者抽象类
 * @author  WodahsOrez
 * @date 2018年6月5日 上午11:42:44 
 *  
 */
public abstract class AbstractCarBuilder {
    /**  
     * @Description  设置组件组合顺序
     * @param sequence   组件顺序的集合
     */
    public abstract void setSequence(ArrayList<String> sequence);
    /**  
     * @Description  获取汽车实例
     * @return   返回对应的汽车实例
     */
    public abstract AbstractCar getCar();

}
