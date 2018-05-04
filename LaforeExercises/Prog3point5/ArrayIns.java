package Prog3point5;

/**
 * Created by gaureesh on 13/7/17.
 */
public class ArrayIns {
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items
    //--------------------------------------------------------------
    public ArrayIns(int max)          // constructor
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
    public void insertionSort()
    {
        int in, out, comp = 0, copy = 0;

        for(out=1; out<nElems; out++)     // out is dividing line
        {
            long temp = a[out];            // remove marked item
            copy++;
            in = out;                      // start shifts at out
            while(in>0 && a[in-1] >= temp) // until one is smaller,
            {
                a[in] = a[in-1];            // shift item to right
                copy++;
                --in;                       // go left one position
                comp++;
            }
            if(in > 0 ) {
                comp++;
            }
            a[in] = temp;                  // insert marked item
            copy++;
        }  // end for
      System.out.println("Copies " + copy);
      System.out.println("Comp " + comp);

    }  // end insertionSort()

    public void insertionSort2()
    {
        int in, out;
        int copies = 0, comparisons = 0;
        for(out = 1; out < nElems; out++)
        {
            long temp = a[out];
            copies++;
            in = out;
            while(in > 0 && a[in-1] >= temp)
            {
                a[in] = a[in-1];
                copies++;
                if(in == 1) comparisons++;
                comparisons++;
                in--;
            }
            a[in] = temp;
            copies++;
        }
        System.out.println("Copies: " + copies);
        System.out.println("Comparisons: " + comparisons);
    }
}
