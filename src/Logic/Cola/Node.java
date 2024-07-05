/*
 * Universidad de Costa Rica | Algoritmos y Estructura de Datos
 * Proyecto Final | Grupo #6 Algoritmicos
 */
package Logic.Cola;

/**
 *
 * @author Algoritmicos
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
