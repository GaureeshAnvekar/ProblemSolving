package Prog4point3;

/**
 * Created by gaureesh on 7/8/17.
 */
public class Dequeue {
    private int front = -1;
    private int back;
    private int nElems;
    private int[] queueContainer;
    private int max;

    Dequeue(int size ) {
        queueContainer = new int[size];
        max = size;
        nElems = 0;
        back = size;
    }

    public void insertTop( int n ) {
        back = (back - 1) % max;
        queueContainer[back] = n;
        nElems++;
    }

    public int removeTop() {
        nElems--;
        if( back == max ) {
            back = 0;
            return queueContainer[back];
        }

        back = (back + 1) % max;
        return queueContainer[back];
    }

    public void insertBottom( int n ) {
        front = (front + 1) % max;
        queueContainer[front] = n;
        nElems++;
    }

    public int peek() {
        return queueContainer[back];
    }

    public int removeBottom() {
        nElems--;
        if( front == -1 ) {
            front = max - 1;
            return queueContainer[front--];
        }
        return queueContainer[front--];
    }

    public boolean isEmpty() {
        return (nElems == 0);
    }

    public boolean isFull() {
        return (nElems == max);
    }
}
