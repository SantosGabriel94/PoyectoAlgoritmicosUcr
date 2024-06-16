package Logic.graphUser;

import Logic.Profile;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphUser implements Graph {

    //Atributes
    private Vertex[] vertex;
    private Object[][] edgeMatrix;
    private int cont;
    private int n;

    public GraphUser(int n) {
        if (n < 0) {
            System.exit(0);
        }
        this.n = n;
        this.cont = 0;
        this.vertex = new Vertex[n];
        this.edgeMatrix = new Object[n][n];
        startEdgeMatrix();

    }

    public void startEdgeMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                edgeMatrix[i][j] = 0;
            }
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < cont; i++) {
            vertex[i] = null;
        }
        cont = 0;
        startEdgeMatrix();
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
        if (isEmpty()) {
            throw new GraphException("Graph is empty");
        }

        for (int i = 0; i < cont; i++) {
            if (vertex[i].element.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existsEdge(Object v1, Object v2) {
        if (isEmpty()) {
            System.out.println("No data in the graph");
        }
        return edgeMatrix[getPosition(v1)][getPosition(v2)] != (Object) 0;
    }

    @Override
    public void addVertex(Object element) {
        if (cont >= n) {
            throw new GraphException("Grap is full");
        }
        vertex[cont++] = new Vertex(element);
    }

    @Override
    public void addEdge(Object v1, Object v2) {
        if (!existsVertex(v1) || !existsVertex(v2)) {
            throw new GraphException("One or both edges doesnt exists");
        }
        edgeMatrix[getPosition(v1)][getPosition(v2)] = 1;
        edgeMatrix[getPosition(v1)][getPosition(v2)] = 1;
    }

    @Override
    public void addWeight(Object v1, Object v2, Object weight) {
        if (!existsVertex(v1) || !existsVertex(v2)) {
            throw new GraphException("One or both vertices don't exist");
        }
        edgeMatrix[getPosition(v1)][getPosition(v2)] = weight;
        edgeMatrix[getPosition(v2)][getPosition(v1)] = weight;
    }

    @Override
    public int getPosition(Object element) {
        for (int i = 0; i < cont; i++) {
            if (vertex[i].element.equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void bfs(Object startVertex) throws GraphException {
        if (!existsVertex(startVertex)) {
            throw new GraphException("The vertex doesn't exist");
        }
        Queue<Integer> line = new LinkedList<>();
        boolean[] b1 = new boolean[cont];
        int startIndex = getPosition(startVertex);
        line.add(startIndex);
        b1[startIndex] = true;
        while (!line.isEmpty()) {
            int vertexIndex = line.poll();
            System.out.print(vertex[vertexIndex].element + " ");
            for (int i = 0; i < cont; i++) {
                if (edgeMatrix[vertexIndex][i] != (Object) 0 && !b1[i]) {
                    line.add(i);
                    b1[i] = true;
                }
            }
        }
        System.out.println();
    }

    @Override
    public void dfs(Object startVertex) throws GraphException {
        if (!existsVertex(startVertex)) {
            throw new GraphException("The start vertex doesn't exist");
        }
        Stack<Integer> row = new Stack<>();
        boolean[] b1 = new boolean[cont];
        int startIndex = getPosition(startVertex);
        row.push(startIndex);
        b1[startIndex] = true;
        while (!row.isEmpty()) {
            int vertexIndex = row.pop();
            System.out.print(vertex[vertexIndex].element + " ");
            for (int i = 0; i < cont; i++) {
                if (edgeMatrix[vertexIndex][i] != (Object) 0 && !b1[i]) {
                    row.push(i);
                    b1[i] = true;
                }
            }
        }
        System.out.println();

    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Graph information:\n");
        result.append("----------------------------------\n");
        for (int i = 0; i < cont; i++) {
            if (vertex[i].element instanceof Profile) {
                Profile profile = (Profile) vertex[i].element;
                result.append("Vertex ").append(i).append(": Profile [Name: ").append(profile.getNameProfile()).append(", Age: ").append(profile.getAge()).append("]\n");
            }
        }
        result.append("\nEdges of the graph:\n");
        for (int i = 0; i < cont; i++) {
            for (int j = 0; j < cont; j++) {
                if (edgeMatrix[i][j] != (Object) 0) {
                    result.append(vertex[i].element).append(" -------> ").append(vertex[j].element).append("\n");
                }
            }
        }
        return result.toString();
    }

}
