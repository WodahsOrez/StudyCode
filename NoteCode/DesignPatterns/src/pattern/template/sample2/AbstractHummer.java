package pattern.template.sample2;

/**
 * @Description  汽车模板抽象类
 * @author  WodahsOrez
 * @date 2018年6月5日 上午9:26:25 
 *  
 */
public abstract class AbstractHummer {
    /**  
     * @Description  汽车启动
     */
    protected abstract void start();
   
    /**  
     * @Description  汽车制动
     */
    protected abstract void stop();
   
    /**  
     * @Description  汽车鸣笛
     */
    protected abstract void alarm();
  
    /**  
     * @Description  汽车引擎
     */
    protected abstract void engineBoom();
    
    /**  
     * @Description  模板方法,设定汽车跑起来的逻辑流程
     */
    public void run() {
        this.start();
        this.stop();
        if(this.isAlarm()) {
            this.alarm();
        }
        this.engineBoom();
    }
    
    /**  
     * @Description  钩子方法,默认喇叭会响
     * @return   
     */
    protected boolean isAlarm() {
        return true;
    }
}
