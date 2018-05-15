package Prog4point4;

/**
 * Created by gaureesh on 23/8/17.
 */
class PriorityQ
{
    // array in sorted order, from max at 0 to min at size-1
    private int maxSize;
    private long[] queArray;
    private int nItems;
    //-------------------------------------------------------------
    public PriorityQ(int s)          // constructor
    {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }
    //-------------------------------------------------------------
    public void insert(long item)    // insert item
    {
        queArray[nItems++] = item;
    }  // end insert()
    //-------------------------------------------------------------
    public long remove()             // remove minimum item
    {
        int priorityGoesTo = nItems - 1;
        int priorityElem = (int)queArray[nItems-1];


        for( int j = nItems - 2; j >= 0; j-- ) {
            if( priorityElem > queArray[j] ) {
                priorityGoesTo = j;
                priorityElem = (int)queArray[j];
            }
        }

        for( int k = priorityGoesTo; k < nItems-1; k++ ) {
            queArray[k] = queArray[k+1];
        }

        nItems--;
        return priorityElem;
    }
    //-------------------------------------------------------------
    public long peekMin()            // peek at minimum item
    { return queArray[nItems-1]; }
    //-------------------------------------------------------------
    public boolean isEmpty()         // true if queue is empty
    { return (nItems==0); }
    //-------------------------------------------------------------
    public boolean isFull()          // true if queue is full
    { return (nItems == maxSize); }
//-------------------------------------------------------------
}  // end class PriorityQ