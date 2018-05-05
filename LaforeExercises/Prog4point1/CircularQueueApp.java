package Prog4point1;

/**
 * Created by gaureesh on 7/8/17.
 */
public class CircularQueueApp {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(8);
        int elem = 0;

        queue.insert(11);
        /*queue.insert(20);
        queue.insert(30);
        queue.insert(40); // insert 4 items
        queue.remove();
        queue.remove();
        queue.remove(); // remove 3 items*/
//

       /* queue.insert(50);
        queue.insert(61);
        queue.insert(70);
        queue.insert(80);*/

        queue.display();
       /* while( !queue.isEmpty() ) {
            System.out.println( queue.remove() );
        }*/
    }
}
