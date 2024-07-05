/*
 * Universidad de Costa Rica | Algoritmos y Estructura de Datos
 * Proyecto Final | Grupo #6 Algoritmicos
 */
package Logic.DoubleLinkedList;

import java.util.Stack;

/**
 *
 * @author Algoritmicos
 */
public class LinkedList implements List {

    public Node start;             // Reference to the beginning of the list
    private Node end;              // Reference at the end of the list
    private Stack<Node> history;   // Stack to maintain change history

    public LinkedList() {
        start = null;
        end = null;
        history = new Stack<>();
    }

    @Override
    public int getSize() {
        int size = 0;
        Node aux = start;

        while (aux != null) {
            size++;
            aux = aux.next;
        }

        return size;
    }

    @Override
    public void reset() {
        start = null;
        end = null;
    }

    @Override
    public boolean isEmpty() {
        return start == null;
    }

    @Override
    public void insert(Object element) {
        if (element == null) {
            throw new IllegalArgumentException("Cannot insert a null element into the list.");
        }

        Node newNode = new Node(element);

        if (isEmpty()) {
            start = newNode;
            end = newNode;
        } else {
            newNode.prev = end;
            end.next = newNode;
            end = newNode;
        }
    }

    @Override
    public void deleteByElement(Object element) {
        if (isEmpty()) {
            throw new RuntimeException("Cannot remove from an empty list.");
        }

        Node aux = start;

        while (aux != null && (aux.element == null || !aux.element.equals(element))) {
            aux = aux.next;
        }

        if (aux != null) {
            if (aux == start) {
                start = aux.next;
                if (start != null) {
                    start.prev = null;
                }
            } else if (aux == end) {
                end = aux.prev;
                end.next = null;
            } else {
                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;
            }
            history.push(start); // Save current state to stack
        }
    }

    // Remaining methods implemented according to the List interface
    @Override
    public int getByPosition(Object element) {
        if (isEmpty()) {
            throw new RuntimeException("Empty list.");
        }

        Node aux = start;
        int position = 1;

        while (aux != null) {
            if (aux.element.equals(element)) {
                return position;
            }
            aux = aux.next;
            position++;
        }

        return -1;
    }

    @Override
    public boolean exists(Object element) {
        if (isEmpty()) {
            throw new RuntimeException("Empty list.");
        }

        Node aux = start;

        while (aux != null) {
            if (aux.element != null && aux.element.equals(element)) {
                return true;
            }
            aux = aux.next;
        }

        return false;
    }

    @Override
    public void deleteByPosition(int position) {
        if (isEmpty()) {
            throw new RuntimeException("Empty list.");
        }

        if (position < 1 || position > getSize()) {
            throw new RuntimeException("Invalid position.");
        }

        Node toDelete = start;
        int currentPosition = 1;

        while (currentPosition < position) {
            toDelete = toDelete.next;
            currentPosition++;
        }

        if (toDelete == start) {
            start = toDelete.next;
            if (start != null) {
                start.prev = null;
            }
        } else if (toDelete == end) {
            end = toDelete.prev;
            end.next = null;
        } else {
            toDelete.prev.next = toDelete.next;
            toDelete.next.prev = toDelete.prev;
        }
    }

    @Override
    public Object firstInList() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list.");
        }

        return start.element;
    }

    @Override
    public Object lastInList() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list.");
        }

        return end.element;
    }

}
