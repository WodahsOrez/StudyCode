package pattern.observer;

import java.util.Vector;

/**
 * @Description  被观察者类
 * @author  WodahsOrez
 * @date 2018年6月19日 下午1:26:10 
 *  
 */
public class Observable {
    /** Vector利用同步方法来线程安全，线程安全在多线程情况下不会造成数据混乱 */
    private Vector<Observer> obs = new Vector();;       

    /**  
     * @Description  新增一个观察者
     * @param o   
     */
    public synchronized void addObserver(Observer o) {
        if (o == null)
            throw new NullPointerException();
        if (!obs.contains(o)) {
            obs.addElement(o);
        }
    }

    /**  
     * @Description 删除观察者
     * @param o   
     */
    public synchronized void deleteObserver(Observer o) {
        obs.removeElement(o);
    }

    /**  
     * @Description  通知观察者 
     */
    public void notifyObservers() {
        for(Observer o :this.obs) {
            o.update();
        }
    }
}
