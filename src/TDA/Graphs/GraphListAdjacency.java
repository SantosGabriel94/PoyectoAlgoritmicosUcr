/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDA.Graphs;

import TDA.LinkedList.DoublyCircularLinkedList;
import TDA.DynamicQueue.DynamicQueue;
import TDA.DynamicStack.DynamicStack;

/**
 *
 * @author Sharon
 */
public class GraphListAdjacency implements Graph {

    //Atributes
    private Vertex[] vertex;
    private int cont;
    private int n;

    public GraphListAdjacency(int n) {
        if (n <= 0) {
            System.exit(0);
        }
        this.n = n;
        vertex = new Vertex[n];
        this.cont = 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < cont; i++) {
            vertex[i] = null;
        }
        cont = 0;
    }

    @Override
    public boolean isEmpty() {
        return cont == 0;
    }

    @Override
    public int getSize() {
        return cont;
    }

    @Override
    public boolean existsVertex(Object element) {
        for (int i = 0; i < cont; i++) {
            if (vertex[i].element.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addVertex(Object element) {
        if (cont >= vertex.length) {
            throw new GraphException("Grafo esta lleno");
        }
        vertex[cont++] = new Vertex(element);
    }

    @Override
    public boolean existsEdge(Object v1, Object v2) {
        int pos1 = getPosition(v1);
        int pos2 = getPosition(v2);

        if (pos1 == -1 || pos2 == -1) {
            return false;
        }

        return vertex[pos1].listEdges.exists(v2);
    }

    @Override
    public void addEdge(Object v1, Object v2) throws GraphException {

        vertex[getPosition(v1)].listEdges.addEnd(v2);
        vertex[getPosition(v2)].listEdges.addEnd(v1);
    }

    @Override
    public void addWeight(Object v1, Object v2, Object weight) {
        int pos1 = getPosition(v1);
        int pos2 = getPosition(v2);

        if (pos1 == -1 || pos2 == -1) {
            throw new GraphException("Some of the vertices do not exist");
        }

        vertex[pos1].listWeight.addEnd(weight);
        vertex[pos2].listWeight.addEnd(weight);
    }

    @Override
    public Object getByPosition(int position) throws GraphException {
        if (position < 0 || position >= cont) {
            throw new GraphException("Invalid position");
        }
        return vertex[position].element;
    }

    @Override
    public void bfs(Object startVertex) throws GraphException {
        int start = getPosition(startVertex);
        if (start == -1) {
            throw new GraphException("Vertex not found");
        }

        for (int i = 0; i < cont; i++) {
            vertex[i].visited = false;
        }

        DynamicQueue queue = new DynamicQueue();

        vertex[start].visited = true;
        queue.insert(startVertex);

        while (!queue.isEmpty()) {
            Object currentVertex = queue.delete();
            System.out.print(currentVertex + " ");

            DoublyCircularLinkedList edges = vertex[getPosition(currentVertex)].listEdges;
            for (int i = 0; i < edges.getSize(); i++) {
                Object adjVertex = edges.getByPosition(i);
                int adjIndex = getPosition(adjVertex);
                if (!vertex[adjIndex].visited) {
                    vertex[adjIndex].visited = true;
                    queue.insert(adjVertex);
                }
            }
        }
        System.out.println();
    }

    @Override
    public void dfs(Object startVertex) throws GraphException {
        int start = getPosition(startVertex);
        if (start == -1) {
            throw new GraphException("Vertex not found");
        }

        for (int i = 0; i < cont; i++) {
            vertex[i].visited = false;
        }

        DynamicStack stack = new DynamicStack();

        vertex[start].visited = true;
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            Object currentVertex = stack.pop();
            System.out.print(currentVertex + " ");

            DoublyCircularLinkedList edges = vertex[getPosition(currentVertex)].listEdges;
            for (int i = 0; i < edges.getSize(); i++) {
                Object adjVertex = edges.getByPosition(i);
                int adjIndex = getPosition(adjVertex);
                if (!vertex[adjIndex].visited) {
                    vertex[adjIndex].visited = true;
                    stack.push(adjVertex);
                }
            }
        }
        System.out.println();
    }

    //Auxiliary private methods
    public int getPosition(Object element) {
        for (int i = 0; i < cont; i++) {
            if (vertex[i].element.equals(element)) {
                return i;
            }
        }
        return -1; // flag, the vertex was never found, the flag goes to -1
    }

    public String toString() {
        if (isEmpty()) {
            return "Graph is empty";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cont; i++) {
            sb.append(vertex[i].element).append(" -> ");

            DoublyCircularLinkedList edges = vertex[i].listEdges;
            DoublyCircularLinkedList weights = vertex[i].listWeight;

            for (int j = 0; j < edges.getSize(); j++) {
                Object adjVertex = edges.getByPosition(j);
                sb.append(adjVertex);

                if (weights.getSize() > j) {
                    sb.append(" (weight: ").append(weights.getByPosition(j)).append(")");
                }

                if (j < edges.getSize() - 1) {
                    sb.append(", ");
                }
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}
