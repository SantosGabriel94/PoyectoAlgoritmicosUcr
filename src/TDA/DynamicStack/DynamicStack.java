package TDA.DynamicStack;

public class DynamicStack implements Stack {

    private Node top;
    private int cont;
    
    //Constructor method 
    public DynamicStack() {
        top = null;
        cont = 0;
    }

    //return the size of stack
    @Override
    public int getSize() {
        return cont;
    }
    
    //return true if is empty
    @Override
    public boolean isEmpty() {
        return cont == 0;
    }
    
    //return the top element
    @Override
    public Object top() throws StackException {
        if (isEmpty()) {
            throw new StackException("The stack is empty");
        }
        return top.element;
    }
    
    //insert element
    @Override
    public void push(Object element) throws StackException {
        Node newNode = new Node(element);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        cont++;
    }

    //delete the top elements and return
    @Override
    public Object pop() throws StackException {
        if (isEmpty()) {
            throw new StackException("The stack is empty");
        }
        Object element = top.element;
        top = top.next;
        cont--;
        return element;
    }

    @Override
    public String toString() {
        String salida = "";
        Node aux = top;
        while (aux != null) {
            salida += "[" + aux.element + "]"+"\n";
            aux = aux.next;

        }
        return salida;
    }

}
