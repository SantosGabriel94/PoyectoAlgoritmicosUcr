
package Logic.ChanelSharon;

/**
 *
 * @author Sharon
 */
public interface List {
    
    public void addChannel(Object element);
    
    public void nextChannel();
    
    public void previousChannel();
    
    public String selectChannel(int channelNumber) throws ListException;
    
    public void printChannels();
    
    public String currentChannel();
    
    public boolean isEmpty();   
}
