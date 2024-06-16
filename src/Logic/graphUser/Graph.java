package Logic.graphUser;

public interface Graph {

    //Delete the whole graph
    public void clear();

    //Return true or false if the graph is empty or not
    public boolean isEmpty();

    //Returns the size of the graph based on the vertex amount
    public int getSize();

    //True if vertex exist, false if not
    public boolean existsVertex(Object element);

    //True if the edge exists, false if not
    public boolean existsEdge(Object v1, Object v2);

    //Insert a new vertex into the TDA
    public void addVertex(Object element) throws GraphException;

    //Add a new edge between two of the vertex
    public void addEdge(Object v1, Object v2);

    //Add weight to an edge
    public void addWeight(Object v1, Object v2, Object weight);

    //Return the position of the vertex
    public int getPosition(Object element);

    //Breadth-first search
    public void bfs(Object startVertex) throws GraphException;

    //Depth-first search
    public void dfs(Object startVertex) throws GraphException;

}
