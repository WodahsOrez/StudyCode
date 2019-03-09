package pattern.builder;

/**
 * @Description  宝马车
 * @author  WodahsOrez
 * @date 2018年6月5日 上午11:40:02 
 *  
 */
public class BMWCar extends AbstractCar {
    /**  
     * @Description  宝马车启动    
     */
    @Override
    protected void start() {
        System.out.println("宝马车启动");
    }

    /**  
     * @Description  宝马车停止
     */
    @Override
    protected void stop() {
        System.out.println("宝马车停止");
    }

    /**  
     * @Description  宝马车鸣笛
     */
    @Override
    protected void alarm() {
        System.out.println("宝马车鸣笛");
    }

    /**  
     * @Description  宝马车引擎
     */
    @Override
    protected void engineBoom() {
        System.out.println("宝马车引擎");
    }

}
