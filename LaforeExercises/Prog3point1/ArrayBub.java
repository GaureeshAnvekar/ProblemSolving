package Prog3point1;

/**
 * Created by gaureesh on 12/7/17.
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
        int out, in, outLeft, evenOdd;

        for(out=nElems-1,outLeft = 0; out >= outLeft;) {  // outer loop (backward)
                for (in = outLeft; in < out; in++) {       // inner loop (forward)
                    if (a[in] > a[in + 1])       // out of order?
                        swap(in, in + 1);
                }
                out--;
                for (in = out; in > outLeft; in--) {
                    if (a[in] < a[in - 1]) {
                        swap(in, in - 1);
                    }
                }
                outLeft++;

        }// swap them
    }  // end bubbleSort()
    //--------------------------------------------------------------
    private void swap(int one, int two)
    {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}
