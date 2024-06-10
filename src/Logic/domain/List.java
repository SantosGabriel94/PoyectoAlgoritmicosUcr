package Logic.domain;

/**
 *
 * @author Marvin
 */
public interface List {

    public int getSize() throws ListException;

    public void cancel();

    public boolean isEmpty();

    public void insert(Object element);

    public int getPosition(Object element);

    public void delete(Object element);

    public void delete(int position);

    public boolean exits(Object element);

    public Object firstInList();

    public Object lastInList();

    public Object getElementAt(int position);

}
