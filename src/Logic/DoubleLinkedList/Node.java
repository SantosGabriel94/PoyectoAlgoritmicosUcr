/*
 * Universidad de Costa Rica | Algoritmos y Estructura de Datos
 * Proyecto Final | Grupo #6 Algoritmicos
 */
package Logic.DoubleLinkedList;

/**
 *
 * @author Algoritmicos
 */
public class Node {

    public Object element;  // save the nodo
    public Node next;       // Reference of next nodo
    public Node prev;       // Reference to the nodo last

    public Node(Object element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }

}
