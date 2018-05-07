package Prog4point3;

/**
 * Created by gaureesh on 22/8/17.
 */
public class StackX
{
    private Dequeue queue;
    //--------------------------------------------------------------
    public StackX(int s)         // constructor
    {
        queue = new Dequeue(s);
    }
    //--------------------------------------------------------------
    public void push(int j)    // put item on top of stack
    {
        queue.insertBottom(j);     // increment top, insert item
    }
    //--------------------------------------------------------------
    public int pop()           // take item from top of stack
    {
        return queue.removeBottom();  // access item, decrement top
    }
    //--------------------------------------------------------------
    public int peek()          // peek at top of stack
    {
        return queue.peek();
    }
    //--------------------------------------------------------------
    public boolean isEmpty()    // true if stack is empty
    {
        return queue.isEmpty();
    }
    //--------------------------------------------------------------
    public boolean isFull()     // true if stack is full
    {
        return queue.isFull();
    }
//--------------------------------------------------------------
}  // end class StackX
