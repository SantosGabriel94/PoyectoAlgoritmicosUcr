/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDA.DynamicQueue;

/**
 *
 * @author Sharon
 */
public class DynamicQueue implements Queue {

    private NodeQueue front;
    private NodeQueue end;
    private int size;

    public DynamicQueue() {
        front = null;
        end = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void cancel() throws QueueException {
        front = null;
        end = null;
        size = 0;
    }

    @Override
    public boolean exists(Object element) {
        NodeQueue current = front;
        while (current != null) {
            if (current.element.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public void insert(Object element) {
        NodeQueue newNode = new NodeQueue(element);
        if (isEmpty()) {
            front = newNode;
            end = newNode;
        } else {
            end.next = newNode;
            end = newNode;
        }
        size++;
    }

    @Override
    public Object delete() {
        if (isEmpty()) {
            throw new QueueException("Error");
        }
        Object element = front.element;
        front = front.next;
        if (front == null) {
            end = null;
        }
        size--;
        return element;
    }

    @Override
    public Object firstElement() throws QueueException {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.element;
    }
}
