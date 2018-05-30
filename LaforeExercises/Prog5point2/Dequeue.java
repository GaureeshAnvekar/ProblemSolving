package Prog5point2;

/**
 * Created by gaureesh on 12/10/17.
 */
public class Dequeue {
    private DoublyLinkedList container;

    Dequeue() {
        container = new DoublyLinkedList();
    }

    public void insertFirst( int data ) {
        container.insertFirst(data);
    }

    public int deleteFirst() {
        return container.deleteFirst();
    }

    public void insertLast( int data ) {
        container.insertLast(data);
    }

    public int deleteLast() {
        return container.deleteLast();
    }

    public void display() {
        container.displayList();
    }
}
