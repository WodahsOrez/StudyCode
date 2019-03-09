package pattern.builder;

/**
 * @Description  奔驰车
 * @author  WodahsOrez
 * @date 2018年6月5日 上午11:40:02 
 *  
 */
public class BenzCar extends AbstractCar {
    /**  
     * @Description  奔驰车启动    
     */
    @Override
    protected void start() {
        System.out.println("奔驰车启动");
    }

    /**  
     * @Description  奔驰车停止
     */
    @Override
    protected void stop() {
        System.out.println("奔驰车停止");
    }

    /**  
     * @Description  奔驰车鸣笛
     */
    @Override
    protected void alarm() {
        System.out.println("奔驰车鸣笛");
    }

    /**  
     * @Description  奔驰车引擎
     */
    @Override
    protected void engineBoom() {
        System.out.println("奔驰车引擎");
    }

}
