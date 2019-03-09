package pattern.interpreter;

import java.util.Stack;
import java.util.HashMap;

/**
 * @Description  解析器封装类
 * @author  WodahsOrez
 * @date 2018年7月9日 下午4:30:52 
 *  
 */
public class Calculator {
    /** 定义表达式 */
    private AbstractExpression expression;
    
    /**
     * @Description  构造传参并解析
     * @param expStr  表达式
     */
    public Calculator(String expStr) {
        Stack<AbstractExpression> stack = new Stack<AbstractExpression>();
        char[] charArray = expStr.toCharArray();
        AbstractExpression left = null;
        AbstractExpression right = null;
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
            case '+':
                left = stack.pop();
                right = new VarExpression(String.valueOf(charArray[++i]));
                stack.push(new AddExpression(left, right));
                break;
            case '-':
                left = stack.pop();
                right = new VarExpression(String.valueOf(charArray[++i]));
                stack.push(new SubExpression(left, right));
                break;
            default:
                stack.push(new VarExpression(String.valueOf(charArray[i])));
            }
        }
        this.expression = stack.pop();
    }
    
    /**  
     * @Description  开始运算
     * @param var 环境对象
     * @return   
     */
    public int run(HashMap<String,Integer> var) {
        return this.expression.interpret(var);
    }
}
