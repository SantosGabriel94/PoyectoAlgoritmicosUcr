/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic.DoubleLinkedList;

/**
 *
 * @author User
 */
public class Node {
     public Object element;  // save  the nodo
    public Node next;       // Reference of next nodo
    public Node prev;       // Reference to the nodo last

    public Node(Object element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }
    
}
