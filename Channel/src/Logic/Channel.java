/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

/**
 *
 * @author Sharon
 */
public class Channel implements List {

    private ChannelNode head;
    private ChannelNode tail;
    private ChannelNode current;
    private int size;

    public Channel() {
        this.head = null;
        this.tail = null;
        this.current = null;
        this.size = 0;
    }

    @Override
    public void addChannel(Object element) {
        ChannelNode newNode = new ChannelNode(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void nextChannel() {
        if (current != null && current.next != null) {
            current = current.next;
        } else if (current != null && current.next == null) {
            //If the current chanel is the last channel, go back to channel 1
            current = head;
        }
    }

    @Override
    public void previousChannel() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else if (current != null && current.prev == null) {
            //If the current channel is the first, go back last to channel(Channel 7)
            current = tail;
        }
    }

    @Override
    public String selectChannel(int channelNumber) throws ListException {
        try {
            if (channelNumber < 1 || channelNumber > size) {
                throw new ListException("Error, the channel number doesn't exist");
            }
            ChannelNode node = head;
            int count = 1;
            while (count < channelNumber && node != null) {
                node = node.next;
                count++;
            }
            if (node != null) {
                current = node;
                return "Channel: " + current.element;
            } else {
                throw new ListException("Error, the channel number doesn't exist");
            }
        } catch (ListException e) {
            return e.getMessage(); // Return the message of the exception
        }
    }

    @Override
    public void printChannels() {
        ChannelNode node = head;
        while (node != null) {
            System.out.println(node.element);
            node = node.next;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String currentChannel() {
        if (current != null) {
            return "Current Channel: " + current.element;
        } else {
            return "No current channel selected";
        }
    }
}
