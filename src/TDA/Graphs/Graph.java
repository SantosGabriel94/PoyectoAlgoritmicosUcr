/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TDA.Graphs;

/**
 *
 * @author Sharon
 */
public interface Graph {

    public void clear();

    public boolean isEmpty();

    public int getSize();

    public boolean existsVertex(Object element);

    public void addVertex(Object element);

    public boolean existsEdge(Object v1, Object v2);

    public void addEdge(Object v1, Object v2) throws GraphException;

    public void addWeight(Object v1, Object v2, Object weight);

    public Object getByPosition(int position) throws GraphException;

    // Breadth-First Search
    public void bfs(Object startVertex) throws GraphException;

    // Depth-First Search
    public void dfs(Object startVertex) throws GraphException;
}
