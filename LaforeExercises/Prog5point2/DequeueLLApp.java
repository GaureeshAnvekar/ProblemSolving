package Prog5point2;

/**
 * Created by gaureesh on 13/10/17.
 */
public class DequeueLLApp {
    public static void main(String[] args) {
        Dequeue deq = new Dequeue();

        deq.insertFirst(1);
        deq.insertFirst(2);

        deq.insertLast(5);
        deq.insertLast(4);
        deq.insertLast(3);

        deq.display();

        deq.deleteFirst();
        deq.deleteLast();

        deq.display();
    }
}
