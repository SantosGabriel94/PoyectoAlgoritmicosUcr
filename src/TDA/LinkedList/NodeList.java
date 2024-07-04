/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDA.LinkedList;


/**
 *
 * @author Sharon
 */
public class NodeList {

    //Atributes
    //1) Store the data/information of the node
    public Object element;
    //2) Pointer to next nodes
    public NodeList next, before;

    public NodeList(Object element) {
        this.element = element;
        this.next = this.before = null;
    }//Constructor

}
