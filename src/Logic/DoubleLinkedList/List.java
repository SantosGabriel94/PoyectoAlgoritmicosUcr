/*
 * Universidad de Costa Rica | Algoritmos y Estructura de Datos
 * Proyecto Final | Grupo #6 Algoritmicos
 */
package Logic.DoubleLinkedList;

/**
 *
 * @author Algoritmicos
 */
public interface List {

    public int getSize();

    //delte all the list
    public void reset();

    //if list 
    public boolean isEmpty();

    //add a ner value in the list
    public void insert(Object element);
    //remoove one of the elemnts in th elist

    public void deleteByElement(Object element);

    public void deleteByPosition(int position);

    //return the position of the element im the list
    public int getByPosition(Object element);

    //return ture if one elment exist in the list
    public boolean exists(Object element);

    public Object firstInList();

    //return the last elemento of the list
    public Object lastInList();

}
