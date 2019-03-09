package pattern.interpreter;

import java.util.HashMap;

/**
 * @Description  变量解析器
 * @author  WodahsOrez
 * @date 2018年7月9日 下午4:23:43 
 *  
 */
public class VarExpression extends AbstractExpression {
    /** 变量名 */
    private String key;
    
    /**
     * @Description  定义变量解析器
     * @param key   变量名
     */
    public VarExpression(String key) {
        this.key = key;
    }
    
    /**  
     * @Description  解析方法
     * @param var 环境对象
     * @return    
     */
    @Override
    public int interpret(HashMap<String, Integer> var) {
        return var.get(this.key);
    }
    
}
