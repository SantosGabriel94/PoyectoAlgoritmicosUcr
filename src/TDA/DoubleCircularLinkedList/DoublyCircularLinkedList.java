/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDA.DoubleCircularLinkedList;

/**
 *
 * @author Sharon
 */
public class DoublyCircularLinkedList implements List {

    //Atributes
    private NodeList head;
    private NodeList tail;
    private int size;//Keeps track of the number of nodes in the list

    public DoublyCircularLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void cancel() {
        head = null;//Cancel of nodes
        tail = null;
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
    public void addHead(Object element) {
        NodeList newNode = new NodeList(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            head.next = tail;
            head.before = tail;
            tail.next = head;
            tail.before = head;
        } else {
            newNode.next = head;
            newNode.before = tail;
            head.before = newNode;
            tail.next = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addEnd(Object element) {
        NodeList newNode = new NodeList(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            head.next = newNode;
            head.before = newNode;
            tail.next = newNode;
            tail.before = newNode;
        } else {
            newNode.next = head;
            newNode.before = tail;
            tail.next = newNode;
            head.before = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void addSort(Object element) {
        NodeList newNode = new NodeList(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            head.next = head;
            head.before = tail;
            tail.next = head;
            tail.before = head;
        } else {
            NodeList aux = head;
            while (((Comparable) aux.element).compareTo(element) < 0 && aux.next != head) {
                aux = aux.next;
            }
            if (((Comparable) aux.element).compareTo(element) >= 0) {
                newNode.before = aux.before;
                newNode.next = aux;
                aux.before.next = newNode;
                aux.before = newNode;
                if (aux == head) {
                    head = newNode;
                }
            } else {
                newNode.next = aux;
                newNode.before = aux.before;
                aux.before.next = newNode;
                aux.before = newNode;
                if (aux == tail) {
                    tail = newNode;
                }
            }
        }
        size++;
    }

    @Override
    public Object getByPosition(int position) {
        if (isEmpty()) {
            return null;
        }
        NodeList aux = head;
        for (int i = 0; i < position; i++) {
            aux = aux.next;
        }
        return aux.element;
    }

    @Override
    public int getByValue(Object element) {
        NodeList current = head;
        int index = 0;
        while (current != null) {
            if (current.element.equals(element)) {
                return index;
            }
            current = current.next;
            index++;
            if (current == head) {
                break;
            }
        }
        return -1;//if the element not found
    }

    @Override
    public void delete(Object element) {
        if (isEmpty()) {
            return;
        }
        NodeList prev = null;
        NodeList curr = head;
        while (curr != null && !curr.element.equals(element)) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) {
            return;
        }
        if (prev == null) {
            head = curr.next;
        } else {
            prev.next = curr.next;
        }
        size--;
    }

    @Override
    public boolean exists(Object element) {
        NodeList aux = head;
        while (aux != null) {
            if (aux.element.equals(element)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    @Override
    public Object firstInList() {
        if (isEmpty()) {
            return null;
        }
        return head.element;
    }

    @Override
    public Object lastInList() {
        if (isEmpty()) {
            return null;
        }
        return tail.element;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]"; // lista vacía
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        NodeList current = head;

        do {
            sb.append(current.element);
            if (current != tail) {
                sb.append(", ");
            }
            current = current.next;
        } while (current != head);

        sb.append("]");
        return sb.toString();
    }
}
