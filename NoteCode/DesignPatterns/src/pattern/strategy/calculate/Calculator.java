package pattern.strategy.calculate;

/**
 * @Description  抽象策略角色
 * @author  WodahsOrez
 * @date 2018年6月6日 下午3:09:59 
 *  
 */
public interface Calculator {

    /**  
     * @Description  运算方法
     */
    public int exec(int a, int b);
}
