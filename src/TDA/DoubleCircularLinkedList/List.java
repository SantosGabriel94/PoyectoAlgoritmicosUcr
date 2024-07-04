/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TDA.DoubleCircularLinkedList;


/**
 *
 * @author Sharon
 */
public interface List {

    //delete/destroy/undo/reset
    public void cancel();

    //Number of nodes in the list
    public int getSize() throws LinkedListException;

    //True is the list isEmpty
    public boolean isEmpty();

    //Add a new node at the beginning in the list
    public void addHead(Object element);

    //Add a new node at the final in the list
    public void addEnd(Object element);

    //Add a new element of the list while mantaining sord
    public void addSort(Object element);

    //Get the element in the position especify
    public Object getByPosition(int position);

    //Get the position of that element
    public int getByValue(Object element);

    //Delete a element of the list
    public void delete(Object element);

    //Returns true if the element exists int he list
    public boolean exists(Object element);

    //Returns the first element of the list
    //return start.element;
    public Object firstInList();

    //Returns the last element of the list
    public Object lastInList();
}
