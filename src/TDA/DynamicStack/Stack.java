package TDA.DynamicStack;

public interface Stack {

    public int getSize();

    public boolean isEmpty();

    public Object top() throws StackException;

    public void push(Object element) throws StackException;

    public Object pop() throws StackException;

}
