/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDA.Graphs;


/**
 *
 * @author Sharon
 */
public class TestGraph {

    public static void main(String[] args) {
        GraphListAdjacency g = new GraphListAdjacency(10);
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addEdge("A", "B");
        g.addEdge("A", "C");

        System.out.println("Is the graph empty: " + g.isEmpty());
        System.out.println("getSize: " + g.getSize());
        System.out.println("ExistsVertex: " + g.existsVertex("B"));
        System.out.println("ExistsEdge: " + g.existsEdge("A", "B"));
        System.out.println("getByPosition: " + g.getByPosition(0));

        g.addWeight("A", "B", 2);

        System.out.println("\ntoString \n" + g.toString());

        try {
            System.out.println("BFS starting from vertex A:");
            g.bfs("A");
            System.out.println("DFS starting from vertex A:");
            g.dfs("A");
        } catch (GraphException e) {
            System.out.println(e.getMessage());
        }

        g.clear();
        System.out.println("\ntoString " + g.toString());
    }
}
