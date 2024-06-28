package TDA.DynamicStack;

public class StaticStack implements Stack {

    private Object S[];
    private int top;//last value saved
//constructor
    public StaticStack(int n) {
        if (n <= 0) {
            System.exit(0);
        }
        S = new Object[n];
        top = -1;
    }
//return the size of stack
    @Override
    public int getSize() {
        return top + 1;
    }
 //return true is empty
    @Override
    public boolean isEmpty() {
        return top < 0;
    }
 //return the top element
    @Override
    public Object top() throws StackException {
        if (isEmpty()) {
            throw new StackException("The stack is empty");
        }
        return S[top];

    }
//insert element
    @Override
    public void push(Object element) throws StackException {
        if (getSize() == S.length) {
            throw new StackException("The stack is full");
        } else {
            S[++top] = element;
        }
    }
    //delete the top elements and return
    @Override
    public Object pop() throws StackException {
        if (isEmpty()) {
            throw new StackException("The stack is empty");
        }
        return S[top--];

    }
    
 
    public String toString(){
        String stackData="";
        for (int i = top; i >= 0; i--) {
            stackData+="Value :" + S[i]+"\n";
        }
        return stackData;
    }
        
}
