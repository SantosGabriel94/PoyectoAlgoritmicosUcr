/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic.Cola;

/**
 *
 * @author User
 */
public class Node {
     int value;
    int priority;
    Node next;

    public Node(int value, int priority) {
        this.value = value;
        this.priority = priority;
        this.next = null;
    }
        
}
