package pattern.memento;

import java.util.HashMap;

/**
 * @Description  发起人
 * @author  WodahsOrez
 * @date 2018年6月20日 下午4:05:20 
 *  
 */
public class Originator {
    /** javaBean属性 */
    private String state1 = "";
    private String state2 = "";
    private String state3 = "";
    public String getState1() {
        return state1;
    }
    public void setState1(String state1) {
        this.state1 = state1;
    }
    public String getState2() {
        return state2;
    }
    public void setState2(String state2) {
        this.state2 = state2;
    }
    public String getState3() {
        return state3;
    }
    public void setState3(String state3) {
        this.state3 = state3;
    }
    
    /**  
     * @Description  创建备忘录对象
     */
    public Memento createMemento() {
        return new ConcreteMemento(BeanUtils.backupProp(this));
    }
    
    /**  
     * @Description  更新备忘录对象
     */
    public  void restoreMemento(Memento memento) {
        BeanUtils.restoreProp(this,((ConcreteMemento)memento).getStateMap());
    }
    
    /**  
     * @Description  转换成字符串输出
     */
    public String toString() {
        return "state1 = " + this.state1 + "\nstate2 = " + this.state2 + "\nstate3 = " + this.state3;
    }
    
    /**
     * @Description  备忘录内部类
     * @author  WodahsOrez
     * @date 2018年6月20日 下午4:08:20 
     *  
     */
    private class ConcreteMemento implements Memento {
        /** bean属性容器 */
        private HashMap<String,Object> stateMap;
        
        /**
         * @Description  通过构造,保存bean的属性至map
         */
        private ConcreteMemento(HashMap<String,Object> map) {
            this.stateMap = map;
        }

        private HashMap<String, Object> getStateMap() {
            return this.stateMap;
        }

        private void setStateMap(HashMap<String,Object> stateMap) {
            this.stateMap = stateMap;
        }
    }
    
}
