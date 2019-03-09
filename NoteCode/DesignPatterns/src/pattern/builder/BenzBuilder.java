package pattern.builder;

import java.util.ArrayList;

/**
 * @Description  奔驰车建造者
 * @author  WodahsOrez
 * @date 2018年6月5日 上午11:46:28 
 *  
 */
public class BenzBuilder extends AbstractCarBuilder {
    /** 奔驰车实例对象 */
    private BenzCar benz= new BenzCar();

    /**  
     * @Description  设定奔驰车对象的组件顺序
     * @param sequence    传入的组件顺序集合
     */
    @Override
    public void setSequence(ArrayList<String> sequence) {
        benz.setSequence(sequence);
    }

    /**  
     * @Description  获取设置好的奔驰车实例
     */
    @Override
    public AbstractCar getCar() {
        return this.benz;
    }

}
