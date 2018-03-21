package Prog2point1;

/**
 * Contains 2.1, 2.2, 2.3
 * Created by gaureesh on 23/6/17.
 */
public class HighArrayApp {
        public static void main(String[] args)
        {
            int maxSize = 100;            // array size
            HighArray arr;                // reference to array
            arr = new HighArray(maxSize); // create the array

            arr.insert(77);               // insert 10 items
            arr.insert(99);
            arr.insert(44);
            arr.insert(55);
            arr.insert(22);
            arr.insert(88);
            arr.insert(11);
            arr.insert(00);
            arr.insert(66);
            arr.insert(33);

            arr.display();                // display items

            int searchKey = 35;           // search for item
            if( arr.find(searchKey) )
                System.out.println("Found " + searchKey);
            else
                System.out.println("Can't find " + searchKey);

            arr.delete(00);               // delete 3 items
            arr.delete(55);
            arr.delete(99);

            arr.display();                // display items again

            HighArray arr2 = new HighArray(0);

            System.out.println("The max element in array is " + arr2.getMax());

            //Remove max
            arr.removeMax();
            arr.display();

            //Try sort
            HighArray sortedArr = new HighArray(maxSize);

            while(true) {
                long temp = arr.getMax();

                if(temp == -1) {
                    break;
                } else {
                    sortedArr.insert(temp);
                    arr.removeMax();
                }
            }
            sortedArr.display();
        }  // end main()
    }  // end class HighArrayApp

