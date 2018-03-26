package Prog3point4;

/**
 * Created by gaureesh on 13/7/17.
 */
public class ArrayBub {
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items
    //--------------------------------------------------------------
    public ArrayBub(int max)          // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }
    //--------------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }
    //--------------------------------------------------------------
    public void display()             // displays array contents
    {
        for(int j=0; j<nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }
    //--------------------------------------------------------------
    public void bubbleSort()
    {
        int out, in;

        for(out=nElems-1; out>1; out--)   // outer loop (backward)
            for(in=0; in<out; in++)        // inner loop (forward)
                if( a[in] > a[in+1] )       // out of order?
                    swap(in, in+1);          // swap them
    }  // end bubbleSort()
    //--------------------------------------------------------------
    private void swap(int one, int two)
    {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    // odd even sort
    public void oddEvenSort() {
        for( int outer = 1; outer <= this.nElems; outer++ ) {
            for( int odd = 1; (odd-1) < this.nElems - 1; odd = odd + 2 ) {
                if( a[odd - 1] > a[odd] ) {
                    swap(odd - 1, odd);
                }
            }
            for( int even = 2; (even-1) < this.nElems - 1; even = even + 2 ) {
                if( a[even - 1] > a[even ] ) {
                    swap(even-1, even);
                }
            }
        }
    }
}
