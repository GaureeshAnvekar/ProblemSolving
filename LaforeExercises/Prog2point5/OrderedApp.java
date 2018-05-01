package Prog2point5;

/**
 * This takes 2 arrays and sorts while inserting itself using linear search.
 * Then 2 sorted arrays are merged using merge method
 * Created by gaureesh on 4/7/17.
 */
public class OrderedApp {
    public static void main(String[] args)
    {
        int maxSize = 100;             // array size
        OrdArray arr;                  // reference to array
        arr = new OrdArray(maxSize);   // create the array

        arr.insert(77);                // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        OrdArray arr2 = new OrdArray(50);
        arr2.insert(1);
        arr2.insert(2);
        arr2.insert(3);

        OrdArray mergedArray = arr.merge(arr2);

        /*int searchKey = 55;            // search for item
        if( arr.find(searchKey) != arr.size() )
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        arr.display();                 // display items

        arr.delete(00);                // delete 3 items
        arr.delete(55);
        arr.delete(99);*/

        mergedArray.display();                 // display items again
    }  // end main()
}
