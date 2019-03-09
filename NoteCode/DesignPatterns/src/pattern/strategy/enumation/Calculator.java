package pattern.strategy.enumation;

/**
 * @Description  策略枚举
 * @author  WodahsOrez
 * @date 2018年6月6日 下午4:46:36 
 *  
 */
public enum Calculator{
    ADD("+"){
        public int exec(int a,int b){
            return a + b;
        }
    },
    SUB("-"){
        public int exec(int a,int b){
            return a - b;
        }
    };
    
    /** 存放符号标志 */
    String value = "";
    
    private Calculator(String value){
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
    
    /**  
     * @Description  抽象算法
     */
    public abstract int exec(int a,int b);
}

