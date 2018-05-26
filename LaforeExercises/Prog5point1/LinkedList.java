package Prog5point1;

/**
 * Created by gaureesh on 10/10/17.
 */
public class LinkedList {
    private Link first;

    LinkedList() {
        first = null;
    }

    public void insert( int data ) {
        Link newOne = new Link(data);
        Link current = first;
        Link previous = null;

        if( current == null ) {
            first = newOne;
            newOne.next = null;
            return;
        } else {
            while( current != null ) {
                if( newOne.getData() <= current.getData() ) {
                   if( previous == null ) {
                       newOne.next = first;
                       first = newOne;
                       return;
                   } else {
                       newOne.next = current;
                       previous.next = newOne;
                       return;
                   }
                } else {
                    previous = current;
                    current = current.next;
                }
            }
            previous.next = newOne;
        }
    }

    public int delete() {
        int result = first.getData();

        first = first.next;
        return result;
    }

    public boolean isEmpty() {
        return (first == null);
    }


}
