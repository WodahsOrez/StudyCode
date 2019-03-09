package pattern.composite.transparent;

import java.util.ArrayList;

/**
 * @Description  树叶构件
 * @author  WodahsOrez
 * @date 2018年6月8日 上午10:23:57 
 *  
 */
public class Leaf extends AbstractComponent {

    @Deprecated
    @Override
    public void add(AbstractComponent component) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public void remove(AbstractComponent component) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public ArrayList<AbstractComponent> getChildren() {
        throw new UnsupportedOperationException();
    }
    
}
