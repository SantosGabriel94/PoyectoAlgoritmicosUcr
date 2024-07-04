/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TDA.DynamicQueue;

/**
 *
 * @author Sharon
 */
public interface Queue {

    public int getSize();

    public boolean isEmpty();

    public void cancel() throws QueueException ;
    
    public boolean exists(Object element);
    
    public void insert(Object element);
    
    public Object delete();
    
    public Object firstElement() throws QueueException;
}
