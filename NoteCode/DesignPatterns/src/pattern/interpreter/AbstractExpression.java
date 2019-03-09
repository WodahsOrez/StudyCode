package pattern.interpreter;

import java.util.HashMap;

/**
 * @Description  抽象解释器 
 * @author  WodahsOrez
 * @date 2018年7月9日 下午4:22:39 
 *  
 */
public abstract class AbstractExpression {
    /**  
     * @Description  解析方法
     * @param var 环境对象
     * @return   
     */
    public abstract int interpret(HashMap<String,Integer> var);
}
