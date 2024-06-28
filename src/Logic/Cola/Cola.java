/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic.Cola;

/**
 *
 * @author User
 */
public class Cola {
     private Node first;
    private Node last;

    public Cola() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(int value, int priority) {
        Node newNode = new Node(value, priority);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            if (newNode.priority < first.priority) {
                newNode.next = first;
                first = newNode;
            } else {
                Node current = first;
                while (current.next != null && current.next.priority <= newNode.priority) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
                if (current.next == null) {
                    last = newNode;
                }
            }
        }
    }

    public int remove() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("The queue is empty");
        }
        int removedValue = first.value;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return removedValue;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("The queue is empty");
        }
        return first.value;
    }

    public void viewQueue() {
        if (isEmpty()) {
            System.out.println("The queue is empty");
            return;
        }
        Node current = first;
        System.out.print("Queue: ");
        while (current != null) {
            System.out.print(current.value + " (" + current.priority + ") ");
            current = current.next;
        }
        System.out.println();
    }

    public boolean removeByValue(int value) {
        if (isEmpty()) {
            return false;
        }

        if (first.value == value) {
            first = first.next;
            if (first == null) {
                last = null;
            }
            return true;
        }

        Node current = first;
        while (current.next != null && current.next.value != value) {
            current = current.next;
        }

        if (current.next == null) {
            return false;
        }

        current.next = current.next.next;
        if (current.next == null) {
            last = current;
        }
        return true;
    }

    public void removeAll() {
        first = null;
        last = null;
    }
    public static void main(String[] args) {
        Cola queue = new Cola();

        // Prueba agregar elementos
        queue.add(5, 1);
        queue.add(6, 0);
        queue.add(7, 3);
        System.out.print("Estado de la cola despues de agregar: ");
        queue.viewQueue(); 

        // Prueba eliminar elemento
        System.out.println("Elemento eliminado: " + queue.remove()); 
        System.out.print("Estado de la cola despues de eliminar: ");
        queue.viewQueue(); // Esperado: 5 7

        // Prueba consultar el primer elemento
        System.out.println("Primer elemento: " + queue.peek()); // Esperado: 

        // Prueba comprobar si está vacía
        System.out.println("¿Esta vacia la cola? " + queue.isEmpty()); 

        // Prueba eliminar por valor
        queue.add(10, 2);
        System.out.println("Eliminar elemento con valor 5: " + queue.removeByValue(5));//true
        System.out.print("Estado de la cola despues de eliminar el valor 5: ");
        queue.viewQueue(); 

        // Prueba eliminar todos los elementos
        queue.removeAll();
        System.out.println("¿Esta vacia la cola despues de eliminar todo? " + queue.isEmpty()); // true
    }
   
}
