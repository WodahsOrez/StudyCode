package pattern.strategy.calculate;

/**
 * @Description  上下文类
 * @author  WodahsOrez
 * @date 2018年6月6日 下午3:16:22 
 *  
 */
public class Context {
    /** 策略类 */
    private Calculator cal = null;
    
    /**
     * @Description  构造函数传入具体策略
     */
    public Context(Calculator cal) {
        this.cal = cal;
    }
    
    /**  
     * @Description  委托策略执行
     */
    public int exec(int a, int b) {
        return this.cal.exec(a, b);
    }
}
