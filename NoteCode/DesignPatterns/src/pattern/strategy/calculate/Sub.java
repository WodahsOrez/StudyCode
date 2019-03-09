package pattern.strategy.calculate;

/**
 * @Description  减法策略
 * @author  WodahsOrez
 * @date 2018年6月6日 下午3:13:13 
 *  
 */
public class Sub implements Calculator {

    /**  
     * @Description  减法运算
     */
    @Override
    public int exec(int a, int b) {
        return a - b;
    }

}
