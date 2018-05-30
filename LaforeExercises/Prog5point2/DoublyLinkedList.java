package Prog5point2;

/**
 * Created by gaureesh on 11/10/17.
 */
public class DoublyLinkedList {
    private Link first;
    private Link last;

    DoublyLinkedList() {
        first = null;
        last = null;
    }

    public void insertFirst( int data ) {
        Link newOne = new Link(data);

        if( first == null ) {
            last = newOne;
        }

        newOne.next = first;
        newOne.prev = null;
        first = newOne;
    }

    public int deleteFirst() {
        int result = first.getData();

        first = first.next;

        if( first != null ) {
            first.prev = null;
        } else {
            last = null;
        }

        return result;
    }

    public void insertLast( int data ) {
        Link newOne = new Link(data);

        if( first == null ) {
            newOne.next = first;
            newOne.prev = null;
            first = newOne;
            last = newOne;
        } else {
            newOne.next = null;
            newOne.prev = last;
            last.next = newOne;
            last = newOne;
        }
    }

    public int deleteLast() {
        int result = last.getData();

        if( first == last ) {
            first = null;
            last = null;
        } else {
            last = last.prev;
        }

        return result;
    }

    public void displayList() {
        Link current = first;
        System.out.println("The elements are:");
        while (current != last) {
            System.out.println(current.getData());
            current = current.next;
        }

        System.out.print(current.getData());
    }
}
