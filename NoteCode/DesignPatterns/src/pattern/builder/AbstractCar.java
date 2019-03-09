package pattern.builder;

import java.util.ArrayList;

/**
 * @Description  抽象汽车类
 * @author  WodahsOrez
 * @date 2018年6月5日 上午11:37:00 
 *  
 */
public abstract class AbstractCar {
    /** 存放组件组合顺序的集合 */
    private ArrayList<String> sequence = new ArrayList<String>();
    
    /**  
     * @Description  启动
     */
    protected abstract void start();  
    
    /**  
     * @Description  停车
     */
    protected abstract void stop();   
    
    /**  
     * @Description  喇叭
     */
    protected abstract void alarm();  
    
    /**  
     * @Description  引擎
     */
    protected abstract void engineBoom(); 
    
    /**  
     * @Description  模板方法
     */
    final public void run(){
        for(String tag:sequence){
            switch(tag.toLowerCase()){
                case "start" :
                    this.start();
                    break;
                case "stop" :
                    this.stop();
                    break;
                case "alarm" :
                    this.alarm();
                    break;
                case "engineboom" :
                    this.engineBoom();
                    break;
            }
        }
    }
    
    /**  
     * @Description  设置组件顺序的方法
     * @param sequence   传入代表各个组件顺序的集合
     */
    final public void setSequence(ArrayList<String> sequence){
        this.sequence = sequence;
    }

}
