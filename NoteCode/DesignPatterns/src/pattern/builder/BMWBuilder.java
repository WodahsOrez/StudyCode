package pattern.builder;

import java.util.ArrayList;

/**
 * @Description  宝马车建造者
 * @author  WodahsOrez
 * @date 2018年6月5日 上午11:46:28 
 *  
 */
public class BMWBuilder extends AbstractCarBuilder {
    /** 宝马车实例对象 */
    private BMWCar bmw= new BMWCar();

    /**  
     * @Description  设定宝马车对象的组件顺序
     * @param sequence    传入的组件顺序集合
     */
    @Override
    public void setSequence(ArrayList<String> sequence) {
        bmw.setSequence(sequence);
    }

    /**  
     * @Description  获取设置好的宝马车实例
     */
    @Override
    public AbstractCar getCar() {
        return this.bmw;
    }

}
