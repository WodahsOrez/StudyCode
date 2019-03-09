package pattern.template.sample2;

/**
 * @Description  具体型号的汽车类
 * @author  WodahsOrez
 * @date 2018年6月5日 上午10:06:33 
 *  
 */
public class HummerH1Model extends AbstractHummer {
    private boolean alarmFlag = true;
    
    /**  
     * @Description  汽车启动
     */
    @Override
    protected void start() {
        System.out.println("悍马H1启动");
    }

    /**  
     * @Description  汽车制动
     */
    @Override
    protected void stop() {
        System.out.println("悍马H1停车");
    }

    /**  
     * @Description  汽车鸣笛
     */
    @Override
    protected void alarm() {
        System.out.println("悍马H1鸣笛");
    }

    /**  
     * @Description  汽车引擎
     */
    @Override
    protected void engineBoom() {
        System.out.println("悍马H1引擎声");
    }
    
    /**  
     * @Description  重写钩子方法,由alarmFlag决定是否会响喇叭
     * @return    
     */
    @Override
    protected boolean isAlarm() {
        return this.alarmFlag;
    }
    
    /**  
     * @Description  设置alarmFlag
     * @param alarmFlag   传入的boolean值,true为喇叭响
     */
    public void setAlarm(boolean alarmFlag) {
        this.alarmFlag = alarmFlag;
    }
    

}
