package Prog5point1;

/**
 * Created by gaureesh on 10/10/17.
 */
public class PriorityQueue {
    private LinkedList container;

    PriorityQueue() {
        container = new LinkedList();
    }

    public void insert(int d) {
        container.insert(d);
    }

    public int remove() {
        return container.delete();
    }

    public boolean isEmpty() {
        return container.isEmpty();
    }
}
