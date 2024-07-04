/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDA.Graphs;

import TDA.LinkedList.DoublyCircularLinkedList;

/**
 *
 * @author Sharon
 */
public class Vertex {

    Object element;
    boolean visited;
    boolean destiny;
    DoublyCircularLinkedList listEdges, listWeight;

    public Vertex(Object element) {
        this.element = element;
        this.visited = false;
        this.destiny = false;

        listEdges = new DoublyCircularLinkedList();
        listWeight = new DoublyCircularLinkedList();
    }
}
