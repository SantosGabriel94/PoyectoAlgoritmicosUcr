
package Logic.ChanelSharon;

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
