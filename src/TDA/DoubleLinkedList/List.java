package TDA.DoubleLinkedList;

public interface List {

    //Amount of nodes of the list/cantidad de nodos de la lista
    public int getSize() throws ListException;
    //Delete all the list/Borra todo

    public void cancel();
    //True if the list is empty/ Devuelve verdadero si la lista esta vacia

    public boolean isEmpty();
    //Add a new value in the list/ Agrega un nuevo valor en la lista

    public void insert(Object element);
    //Remove one of the element in the list/ borra un elemento especifico de la lista

    public void delete(Object element);
    //Return the position of one element in the list/Devuelve la posicion del elemento 

    public int getPosition(Object element);
    //Return true if one element exists in the list/ Devuelve verdadero si un elemento existe

    public boolean exist(Object element);
    //Return last in the list

    public Object lastInList();
    //Return first in the list

    public Object firstInList();
    //Return the element by position

    public Object getByPosition(int position);
    //Add in head of the list

    public void addHead(Object element);
    //Add in end of the list

    public void addEnd(Object element);
    //Return the object specified by parameter

    public Object getByValue(Object Element);

}
