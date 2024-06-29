package TDA.DoubleLinkedList;

public class DoubleLinkedList implements List {

    //Atributes
    public Node start;
    private int increase;

    public DoubleLinkedList() {
        this.start = null;//Represents the starts of the linkedList
        increase = 0;
    }

    //Amount of nodes of the list/cantidad de nodos de la lista
    public int getSize() {
        return increase;
    }

    //Delete all the list/Borra todo
    public void cancel() {
        increase = 0;
        start = null;
    }

    //True if the list is empty/ Devuelve verdadero si la lista esta vacia
    public boolean isEmpty() {
        return start == null;
    }

    //Add a new value in the list/ Agrega un nuevo valor en la lista
    public void insert(Object element) {
        Node newNode = new Node(element);//The next node

        Node aux = start;//Contain the first node
        Node backAux = null;

        if (isEmpty()) {
            start = newNode; //When list is empty, start is the newNode
        } else {
            while (aux.next != null) {
                aux.next.back = aux;//Add back in the next node
                aux = aux.next;

            }
            aux.next = newNode;
            aux.next.back = aux; //Add back in the next node

        }
        increase++;
    }

    //Remove one of the element in the list/ borra un elemento especifico de la lista
    public void delete(Object element) {
        Node aux = start;
        Node auxTemp = null;

        if (isEmpty()) {
            throw new ListException("the list is empty");
        }
//      1st case: when the element i have to delete is in 1st position of the list
        if (aux.element.equals(element)) {
            start = aux.next;
            increase--;
        }
//      2nd case: 
        while (aux.next != null && !aux.element.equals(element)) {
            auxTemp = aux;
            aux = aux.next;
        }
        if (aux.element.equals(element)) {
            auxTemp.next = aux.next;
            auxTemp.next.back = auxTemp;
            increase--;
        }

    }

    //Return the position of one element in the list/Devuelve la posicion del elemento 
    public int getPosition(Object element) {
        int cont = 0;
        Node aux = start;

        if (isEmpty()) {
            throw new ListException("the list is empty");
        }

        while (aux != null) {
            if (element == aux.element) {
                break;
            }
            cont++;
            aux = aux.next;
        }
        return cont;
    }

    //Add element in the first position
    public void addHead(Object element) {
        Node aux = start;
        Node newNode = new Node(element);
        start = newNode;
        start.next = aux;
    }

    //Add element in the last position
    public void addEnd(Object element) {
        Node aux = start;
        Node newNode = new Node(element);

        while (aux.next != null) {
            aux = aux.next;
        }

        aux.next = newNode;
        aux.next.back = aux;
    }

    //Return true if one element exists in the list/ Devuelve verdadero si un elemento existe 
    public boolean exist(Object element) {
        boolean isExist = false;
        Node aux = start;
        if (isEmpty()) {
            throw new ListException("the list is empty");
        }
        while (aux != null) {
            if (aux.element == element) {
                isExist = true;
            }
            aux = aux.next;

        }
        return isExist;
    }

    //return the element by position
    public Object getByPosition(int position) {
        Node aux = start;
        Object elementTemp = null;

        while (aux != null) {
            if (position == getPosition(aux.element)) {
                elementTemp = aux.element;
                break;
            }
            aux = aux.next;
        }
        return elementTemp;
    }

    //Return last in the list
    public Object lastInList() {
        Node aux = start;
        Object elementTemp = null;
        while (aux != null) {
            if (aux.next == null) {
                elementTemp = aux.element;
            }
            aux = aux.next;
        }
        return elementTemp;
    }

    //Return first in the list
    public Object firstInList() {
        return start.element.toString();
    }

    public Object getByValue(Object element) {
        Node aux = start;
        Node auxTemp = new Node("");

        if (isEmpty()) {
            throw new ListException("the list is empty");
        } else {
            if (exist(element) == true) {
                while (aux.next != null && aux.element.equals(element) != true) {
                    aux = aux.next;
                }
                auxTemp = aux;
            }
        }
        return auxTemp.element;
    }

    public String toString() {
        if (isEmpty()) {
            return "DoubleLinkedList{ [] }"; // Lista vacía
        }

        String result = "DoubleLinkedList{ [";
        Node current = start;
        while (current != null) {
            result += current.element;
            if (current.next != null) {
                result += ", ";
            }
            current = current.next;
        }
        result += "] }";
        return result;
    }
}
