/*  Basic use of Array data structure.
 *  Reversing an array with integers
 */
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine().trim());

        int[] arr = new int[n];

        String[] arrItems = scan.nextLine().split(" ");

        for (int arrItr = 0; arrItr < n; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
            arr[arrItr] = arrItem;
        }
        
        //Reverse
        for (int arrItr = arr.length - 1; arrItr >= 0; arrItr-- ) {
            System.out.print(arr[arrItr]);
            System.out.print(" ");
        }
    }
}
