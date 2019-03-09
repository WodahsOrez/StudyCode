package pattern.memento;

import java.util.HashMap;

/**
 * @Description  备忘录管理者
 * @author  WodahsOrez
 * @date 2018年6月20日 下午4:02:46 
 *  
 */
public class Caretaker {
    /** 备忘录容器 */
    private HashMap<String,Memento> memMap = new HashMap<String,Memento>();
    
    /**  
     * @Description  获取一个备忘录
     * @param idx  备忘录标识
     * @return   对应备忘录
     */
    public Memento getMemento(String idx) {
        return this.memMap.get(idx);
    }
    
    /**  
     * @Description  存储一个备忘录
     * @param idx  备忘录标识
     * @param memento   备忘录
     */
    public void setMemento(String idx,Memento memento) {
        this.memMap.put(idx, memento);
    }
}
