/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Logic.DoubleLinkedList2;

/**
 *
 * @author User
 */
public interface List {
    public int getSize();
    
    
   //delte all the list
    public void reset();
    //if list 
    public boolean isEmpty();
    
    
    //add a ner value in the list
    
    public void insert(Object element);
    //remoove one of the elemnts in th elist
    
    
    public void deleteByElement(Object element);
    
    public void deleteByPosition(int position);
    
    
    //return the position of the element im the list
 public Object getByPosition(int position);
 
    //return ture if one elment exist in the list
    public boolean exists(Object element); 
    
    public Object firstInList();
    
    //return the last elemento of the list
    public Object lastInList();
    
    
    
}
