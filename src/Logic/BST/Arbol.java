
package Logic.BST;

/**
 *
 * @author Marvin
 */
public interface Arbol {
    
    //Eliminar el arbol
    public void anular();
    
    //true si el arbol esta vacio
    public boolean isEmpty();
    
    //true si el elemento indicado existe dentro el arbol
    //metodo interno privado:
    //private int getSize(NodoBinario)
    public int getSize() throws RuntimeException;
    
    //true si el elemento indicado existe dentro del Arbol
    //metodo interno privado:
    //private boolean exist(NodoBinario, Object element)
    public boolean exist(Object element) throws RuntimeException;
    
    //inserta un elemento dentro del arbol
    //metodo interno privado:
    //private NodoBinario insertar(NodoBinario, Object element)
    public void insertar(Object element) throws RuntimeException;
    
    //Elimina un elemento indicado dentro del arbol.3 casos
    //1. El nodo a eliminar no tiene hijos
    //2. El nodo a eliminar solo tiene un hijo
    //3. El nodo a eliminar tiene 2 hijos
    //metodo interno privado:
    //private NodoBinario elimanr(NodoBinario, Object element)
    public void elimanar(Object element) throws RuntimeException;
    
    //Devuelve el numero de ancestros para un nodo dado
    //profundidad de un nodo
    //metodo interno privado:
    //private int alturaNodo(NodoBinario, Object element)
    public int alturaNodo(Object element) throws RuntimeException;
    
    //Devuelve la altura maxima(profundidad maxima) desde la raiz
    //metodo interno privado:
    //private int alturaArbol(NodoBinario)
    public int alturaArbol();
    
    
    //Devuelve el maximo de un arbol
    //Devuelve el minimo de un arbol
    //toString:
    //1.PreOrden: nodo-izq-der
    //2.InOrden: izq-nodo-der
    //3.PostOrden: izq-der-nodo
    
    
}
