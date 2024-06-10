package Logic.domain;

/**
 *
 * @author Marvin
 */
public class AdminLinkedList implements List {

    Nodo start;
    int cont;

    public AdminLinkedList() {
        start = null;
        this.cont = 0;
    }

    @Override
    public int getSize() {
        //GetSize optimo
        return cont;

    }

    @Override
    public void cancel() {
        start = null;
        cont = 0;
    }

    @Override
    public boolean isEmpty() {
        return start == null;
    }

    @Override
    public void insert(Object element) {

        Nodo aux = start;
        Nodo newNode = new Nodo(element);

        if (isEmpty()) {
            start = newNode;
        } else {
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = newNode;
        }
        cont++;
    }

    @Override
    public int getPosition(Object element) {

        Nodo aux = start;
        int pos = 0;

        while (aux != null && !aux.element.equals(element)) {
            aux = aux.next;
            pos++;
        }

        if (aux == null) {
            return -1;
        } else {
            return pos;
        }
    }

    @Override
    public void delete(Object element) {
        if (isEmpty()) {
            throw new ListException("Empty List");
        }
        Nodo aux = start;
        Nodo auxTemp = null;

        if (aux.element.equals(element)) {
            start = aux.next;
        } else {
            while (!aux.element.equals(element) && aux.next != null) {
                aux = aux.next;
                auxTemp = aux;

            }
            if (aux.element.equals(element)) {
                auxTemp.next = aux.next;
            }
        }

    }

    @Override
    public void delete(int position) {

        if (isEmpty()) {
            throw new ListException("Empty List");
        }

        if (position < 0 || position >= cont) {
            throw new ListException("Invalid position");
        }

        if (position == 0) {
            start = start.next;
        } else {
            Nodo aux = start;
            for (int i = 0; i < position - 1; i++) {
                aux = aux.next;
            }
            aux.next = aux.next.next;
        }

        cont--;
    }

    @Override
    public boolean exits(Object element) {

        Nodo aux = start;

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
            throw new ListException("Empty List");
        }
        return start.element;

    }

    @Override
    public Object lastInList() {

        if (isEmpty()) {
            throw new ListException("Empty List");
        }

        Nodo aux = start;
        while (aux.next != null) {
            aux = aux.next;
        }

        return aux.element;

    }

    @Override
    public Object getElementAt(int position) {
        if (position < 0 || position >= cont) {
            throw new ListException("Invalid position");
        }

        Nodo aux = start;
        for (int i = 0; i < position; i++) {
            aux = aux.next;
        }

        return aux.element;

    }

}
