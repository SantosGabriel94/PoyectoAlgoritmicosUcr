package Logic.graphUser;

public class Vertex {

    //Atributes
    Object element;
    boolean visited;
    boolean destiny;
    boolean origin;

    public Vertex(Object element) {
        this.element = element;
        this.visited = false;
        this.destiny = false;
        this.origin = false;
    }

}
