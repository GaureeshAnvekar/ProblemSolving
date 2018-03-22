package Prog2point4;

/**
 * Created by gaureesh on 24/6/17.
 */
public class OrdArray {
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items
    //-----------------------------------------------------------
    public OrdArray(int max)          // constructor
    {
        a = new long[max];             // create array
        nElems = 0;
    }
    //-----------------------------------------------------------
    public int size()
    { return nElems; }
    //-----------------------------------------------------------
    public int find(long searchKey)
    {
        int lowerBound = 0;
        int upperBound = nElems-1;
        int curIn;

        while(true)
        {
            curIn = (lowerBound + upperBound ) / 2;
            if(a[curIn]==searchKey)
                return curIn;              // found it
            else if(lowerBound > upperBound)
                return nElems;             // can't find it
            else                          // divide range
            {
                if(a[curIn] < searchKey)
                    lowerBound = curIn + 1; // it's in upper half
                else
                    upperBound = curIn - 1; // it's in lower half
            }  // end else divide range
        }  // end while
    }  // end find()
    //-----------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        int lowerBound = 0;
        int upperBound = nElems-1;
        int curIn;

        if( value < a[0]) {
            for( int moveUp = nElems; moveUp >= 1; moveUp-- ) {
                a[moveUp] = a[moveUp-1];
            }
            a[0] = value;
            nElems++;
            return;
        }
        if( upperBound == -1 ) {
            a[0] = value;
            nElems++;
            return;
        }

        if(nElems == 1) {
            if( value > a[0] ) {
                a[1] = value;
            }else {
                a[1] = a[0];
                a[0] = value;
            }
            nElems++;
            return;
        }

        while(true)
        {
            curIn = (lowerBound + upperBound ) / 2;
            if(a[curIn]== value) {
                for( int moveUp = nElems; moveUp >= curIn+1; moveUp--) {
                    a[moveUp] = a[moveUp-1];
                }
                a[curIn+1] = value;
                nElems++;
                return;
            }
                            // found it
            else if(lowerBound > upperBound) {
                for( int moveUp = nElems; moveUp >= lowerBound; moveUp-- ) {
                    a[moveUp] = a[moveUp-1];
                }
                a[lowerBound] = value;
                nElems++;
                return;
            }
                                // can't find it
            else                          // divide range
            {
                if(a[curIn] < value)
                    lowerBound = curIn + 1; // it's in upper half
                else
                    upperBound = curIn - 1; // it's in lower half
            }  // end else divide range
        }  // end while
    }  // end insert()
    //-----------------------------------------------------------
    public boolean delete(long value)
    {
        int j = find(value);
        if(j==nElems)                  // can't find it
            return false;
        else                           // found it
        {
            for(int k=j; k<nElems; k++) // move bigger ones down
                a[k] = a[k+1];
            nElems--;                   // decrement size
            return true;
        }
    }  // end delete()
    //-----------------------------------------------------------
    public void display()             // displays array contents
    {
        for(int j=0; j<nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }
}
