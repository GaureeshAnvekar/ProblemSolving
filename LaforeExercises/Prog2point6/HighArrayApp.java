package Prog2point6;

/**
 * This removes duplicates by inserting -1 and then using delete
 * Created by gaureesh on 4/7/17.
 */
public class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100;            // array size
        HighArray arr;                // reference to array
        arr = new HighArray(maxSize); // create the array

        arr.insert(77);               // insert 10 items
        arr.insert(77);
        arr.insert(44);
        arr.insert(55);
        arr.insert(55);
        arr.insert(55);
        arr.insert(11);
        arr.insert(00);
        arr.insert(00);
        arr.insert(00);

        arr.noDups();

   /*     arr.display();                // display items

        int searchKey = 35;           // search for item
        if (arr.find(searchKey))
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        arr.delete(00);               // delete 3 items
        arr.delete(55);
        arr.delete(99);*/

        arr.display();                // display ite
    }
}
