package Prog4point5;

/**
 * Created by gaureesh on 26/8/17.
 */
public class Queue {
    private Customer[] container;
    private int front = 0;
    private int rear = -1;
    private int nElems = 0;
    private int max;
    private int queueId;

    Queue(int size, int id) {
        container = new Customer[size];
        max = size;
        queueId = id;
    }

    public void insert(Customer c) {
        rear = (rear + 1) % max;
        container[rear] = c;
        nElems++;
    }

    public Customer remove() {
        nElems--;
        Customer done = container[front];
        front = (front + 1) % max;
        return done;
    }

    public boolean isFull() {
        return (nElems == max);
    }

    public boolean isEmpty() {
        return (nElems == 0);
    }

    public int noOfCustomers() {
        return nElems;
    }

    public Customer peek() {
        if( nElems > 0 ) {
            return container[front];
        }
        return null;
    }

    public void display() {
        System.out.println("Customers in " + queueId + ":");
        for( int start = front; start <= rear; start++ ) {
            System.out.println(container[start].getId() + " " + container[start].getProcessingTime());
        }

    }

}
