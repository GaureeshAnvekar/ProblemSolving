package Prog5point1;

/**
 * Created by gaureesh on 10/10/17.
 */
public class MainApp {

    public static void main(String[] args) {
        PriorityQueue newQueue = new PriorityQueue();

        newQueue.insert(10);
        newQueue.insert(9);
        newQueue.insert(8);
        newQueue.insert(7);

        while( !newQueue.isEmpty() ) {
            System.out.println(newQueue.remove());
        }

    }
}
