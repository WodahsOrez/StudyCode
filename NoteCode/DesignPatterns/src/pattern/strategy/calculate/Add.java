package pattern.strategy.calculate;

/**
 * @Description  加法策略
 * @author  WodahsOrez
 * @date 2018年6月6日 下午3:13:13 
 *  
 */
public class Add implements Calculator {

    /**  
     * @Description  加法运算
     */
    @Override
    public int exec(int a, int b) {
        return a + b;
    }

}
