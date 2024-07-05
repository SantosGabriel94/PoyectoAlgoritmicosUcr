/*
 * Universidad de Costa Rica | Algoritmos y Estructura de Datos
 * Proyecto Final | Grupo #6 Algoritmicos
 */
package Logic.domain;

/**
 *
 * @author Algoritmicos
 */
public class Nodo {

    public Object element;
    public Nodo next;

    public Nodo(Object element) {
        this.element = element;
        this.next = null;
    }

}
