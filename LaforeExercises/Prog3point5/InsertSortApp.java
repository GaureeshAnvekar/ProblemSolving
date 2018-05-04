package Prog3point5;

/**
 * Created by gaureesh on 13/7/17.
 */
public class InsertSortApp {
    public static void main(String[] args)
    {
        int maxSize = 100;            // array size
        ArrayIns arr;                 // reference to array
        arr = new ArrayIns(maxSize);  // create the array

        arr.insert(5);               // insert 10 items
        arr.insert(7);
        arr.insert(4);
        arr.insert(6);
        /*arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);*/

        arr.display();                // display items

        arr.insertionSort();          // insertion-sort them
        //arr.insertionSort2();
        arr.display();                // display them again
    }  // end main()
}
