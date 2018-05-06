package Prog4point2;

/**
 * Created by gaureesh on 7/8/17.
 */
public class CircularQueueApp {
    public static void main(String[] args) {
        Dequeue queue = new Dequeue(5);
        int elem = 0;

        queue.insertBottom(10);
        queue.insertBottom(20);
        queue.insertBottom(30);
        queue.insertBottom(40); // insert 4 items
        queue.insertBottom(50);

        while( !queue.isEmpty() ) {
            System.out.println( queue.removeTop() );
        }
    }
}
