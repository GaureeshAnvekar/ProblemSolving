package Prog5point2;

/**
 * Created by gaureesh on 11/10/17.
 */
public class Link {
    public Link next;
    public Link prev;
    private int data;

    Link(int d) {
        data = d;
    }

    public int getData() {
        return data;
    }
}
