package pattern.interpreter;

import java.util.HashMap;

/**
 * @Description  抽象运算符号解析器 
 * @author  WodahsOrez
 * @date 2018年7月9日 下午4:25:04 
 *  
 */
public abstract class AbstractSymbolExpression extends AbstractExpression {
    /** 左表达式 */
    protected AbstractExpression left;
    /** 右表达式 */
    protected AbstractExpression right;
    
    /**
     * @Description  解析方法
     * @param left  左表达式
     * @param right  右表达式
     */
    public AbstractSymbolExpression(AbstractExpression left,AbstractExpression right) {
        this.left = left;
        this.right = right;
    }
    
    
}
