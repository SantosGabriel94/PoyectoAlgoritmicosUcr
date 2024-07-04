package Logic.BST;

/**
 *
 * @author Marvin
 */
public class ArbolBinarioBusqueda implements Arbol {

    NodoBinario raiz;

    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }

    @Override
    public void anular() {
        raiz = null;
    }

    @Override
    public boolean isEmpty() {
        return raiz == null;
    }

    @Override
    public int getSize() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("El Arbol esta vacio, tiene 0 elementos");
        }
        return getSize(raiz);
    }

    @Override
    public boolean exist(Object element) throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("El Arbol esta vacio");
        }
        return exist(raiz, element);
    }

    @Override
    public void insertar(Object element) throws RuntimeException {
        if (!(element instanceof VisitRecord)) {
            throw new IllegalArgumentException("El elemento debe ser de tipo VisitRecord");
        }
        raiz = insertar(raiz, element);
    }

    @Override
    public void elimanar(Object element) throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("El Arbol esta vacio");
        }
        raiz = eliminar(raiz, element);
    }

    @Override
    public int alturaNodo(Object element) throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("El Arbol esta vacio");
        }
        return alturaNodo(raiz, element, 0);
    }

    @Override
    public int alturaArbol() {
        return alturaArbol(raiz);

    }

    public Object getMin() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("El Arbol esta vacio");
        }
        return getMin(raiz).element;
    }

    public Object getMax() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("El Arbol esta vacio");
        }
        return getMax(raiz).element;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrden(raiz, sb);
        return sb.toString();
    }

    //-------------------------------------------------------
    //Metodos internos privado recursivos:
    //-------------------------------------------------------
    private int getSize(NodoBinario nodo) {

        if (nodo == null) {
            return 0;
        } else {
            return 1 + getSize(nodo.izq) + getSize(nodo.der);
        }
    }

    private boolean exist(NodoBinario nodo, Object element) {
        if (nodo == null) {
            return false;
        }
        if (comparar(element, nodo.element) == 0) {
            return true;
        } else if (comparar(element, nodo.element) < 0) {
            return exist(nodo.izq, element);
        } else {
            return exist(nodo.der, element);
        }
    }

    private NodoBinario insertar(NodoBinario nodo, Object element) {

        if (nodo == null) {
            nodo = new NodoBinario(element);
        } else if (comparar(element, nodo.element) <= 0) {
            nodo.izq = insertar(nodo.izq, element);

        } else if (comparar(element, nodo.element) >= 0) {
            nodo.der = insertar(nodo.der, element);

        }
        return nodo;
    }

    private NodoBinario eliminar(NodoBinario nodo, Object element) {
        if (nodo == null) {
            return null;
        }
        if (comparar(element, nodo.element) < 0) {
            nodo.izq = eliminar(nodo.izq, element);
        } else if (comparar(element, nodo.element) > 0) {
            nodo.der = eliminar(nodo.der, element);
        } else {
            // Nodo con un hijo o sin hijos
            if (nodo.izq == null) {
                return nodo.der;
            } else if (nodo.der == null) {
                return nodo.izq;
            }
            // Nodo con dos hijos: obtener el sucesor en inorden (el más pequeño en el subárbol derecho)
            nodo.element = encontrarMin(nodo.der).element;
            nodo.der = eliminar(nodo.der, nodo.element);
        }
        return nodo;
    }

    private NodoBinario encontrarMin(NodoBinario nodo) {
        while (nodo.izq != null) {
            nodo = nodo.izq;
        }
        return nodo;
    }

    private NodoBinario getMin(NodoBinario nodo) {
        if (nodo == null) {
            return null;
        } else if (nodo.izq == null) {
            return nodo;
        } else {
            return getMin(nodo.izq);
        }
    }

    private NodoBinario getMax(NodoBinario nodo) {
        if (nodo == null) {
            return null;
        } else if (nodo.der == null) {
            return nodo;
        } else {
            return getMax(nodo.der);
        }
    }

    private int alturaNodo(NodoBinario nodo, Object element, int altura) {
        if (nodo == null) {
            return -1; // Elemento no encontrado
        }
        if (comparar(element, nodo.element) == 0) {
            return altura;
        } else if (comparar(element, nodo.element) < 0) {
            return alturaNodo(nodo.izq, element, altura + 1);
        } else {
            return alturaNodo(nodo.der, element, altura + 1);
        }
    }

    private int alturaArbol(NodoBinario nodo) {
        if (nodo == null) {
            return 0;
        } else {
            int alturaIzq = alturaArbol(nodo.izq);
            int alturaDer = alturaArbol(nodo.der);
            return Math.max(alturaIzq, alturaDer) + 1;
        }
    }

    private void preOrden(NodoBinario nodo, StringBuilder sb) {
        if (nodo != null) {
            sb.append(nodo.element).append("\n");
            preOrden(nodo.izq, sb);
            preOrden(nodo.der, sb);
        }
    }

//    private String preOrden(NodoBinario nodo) {
//        if (nodo == null) {
//            return "";
//        }
//        return nodo.element + " " + preOrden(nodo.izq) + preOrden(nodo.der);
//    }
//    private String inOrden(NodoBinario nodo) {
//        if (nodo == null) {
//            return "";
//        }
//        return inOrden(nodo.izq) + nodo.element + " " + inOrden(nodo.der);
//    }
//    private String postOrden(NodoBinario nodo) {
//        if (nodo == null) {
//            return "";
//        }
//        return postOrden(nodo.izq) + postOrden(nodo.der) + nodo.element + " ";
//    }
    //-------------------------------------------------------
    //Metodos auxiliar
    //-------------------------------------------------------
    private int comparar(Object element1, Object element2) {

        if (element1 instanceof VisitRecord && element2 instanceof VisitRecord) {
            VisitRecord record1 = (VisitRecord) element1;
            VisitRecord record2 = (VisitRecord) element2;
            return record1.compareTo(record2);
        }

        if (element1 instanceof Integer && element2 instanceof Integer) {
            return ((Integer) element1).compareTo((Integer) element2);
        }

        if (element1 != null && element2 != null) {
            return element1.toString().compareToIgnoreCase(element2.toString());
        }

        return 0;
    }

    public static class VisitRecord implements Comparable<VisitRecord> {

        private int channelNumber;

        public VisitRecord(int channelNumber) {
            this.channelNumber = channelNumber;
        }

        @Override
        public int compareTo(VisitRecord other) {
            return Integer.compare(this.channelNumber, other.channelNumber);
        }

        @Override
        public String toString() {
            return "Channel " + channelNumber;
        }
    }
}
