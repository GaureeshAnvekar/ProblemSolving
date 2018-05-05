package Prog4point1;

/**
 * Created by gaureesh on 7/8/17.
 */
public class CircularQueue {
    private int front = 0;
    private int rear = -1;
    private int nElems;
    private int[] queueContainer;
    private int max;

    CircularQueue(int size ) {
        queueContainer = new int[size];
        max = size;
        nElems = 0;
    }

    public void insert( int n ) {
        rear = rear + 1;
        int rem = rear % max;
        queueContainer[rem] = n;
        nElems++;
    }

    public int remove() {
        int elem = queueContainer[front];
        front = (front + 1) % max;
        nElems--;
        return elem;
    }

    public boolean isEmpty() {
        return (nElems == 0);
    }

    public boolean isFull() {
        return (nElems == max);
    }

    public void display() {
        int noOfElems = this.nElems;
        int start = this.front;
        int end = this.rear;

        for( int i = noOfElems; i > 0; i-- ) {
            System.out.println(this.queueContainer[start % this.max]);
            start++;
        }
    }
}
