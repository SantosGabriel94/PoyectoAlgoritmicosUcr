/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

/**
 *
 * @author Sharon
 */
public class ChannelNode {
    
    public Object element; // Information of the node
    public ChannelNode next; // Next node
    public ChannelNode prev; // before node

    // Constructor
    public ChannelNode(Object element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }
}
