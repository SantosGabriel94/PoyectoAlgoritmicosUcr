package TDA.DoubleLinkedList;

public class Node {
    //Atributes
    //1) Store the data/information of the node /almacena la informacion del nodo

    public Object element;
    //2)Pointer to the next nodes/ El puntero del nodo
    public Node next;
    //3)Pointer to back nodes/ Apuntando a los nodos anteriores
    //Constructor
    public Node back;

    public Node(Object element) {
        this.element = element;
        this.next = null;
        back = null;
    }

}//EndClassNode
