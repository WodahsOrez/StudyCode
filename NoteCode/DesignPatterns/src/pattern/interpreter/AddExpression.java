package pattern.interpreter;

import java.util.HashMap;

/**
 * @Description  加法解析器
 * @author  WodahsOrez
 * @date 2018年7月9日 下午4:26:12 
 *  
 */
public class AddExpression extends AbstractSymbolExpression {
    /**
     * @Description  定义加法解析器
     * @param left  左表达式
     * @param right  右表达式
     */
    public AddExpression(AbstractExpression left,AbstractExpression right) {
        super(left,right);
    }

    /**  
     * @Description  解析方法
     * @param var  环境对象
     * @return    
     */
    @Override
    public int interpret(HashMap<String, Integer> var) {
        return super.left.interpret(var) + super.right.interpret(var);
    }
    
    
}
