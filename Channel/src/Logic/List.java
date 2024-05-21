/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Logic;

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
