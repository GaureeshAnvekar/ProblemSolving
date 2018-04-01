/*
Here we calculate the (Fib(n) mod m), where n and m can be any integers.
The key here is to avoid calculating the fib(n) using a loop.
Instead there is a periodic pattern for each "m" which should be used.
Eg:    i:         0   1   2   3   4   5   6   7
     fib(i):      0   1   1   2   3   5   8   13
  fib(i) mod 2:   0   1   1   0   1   1   0   1      --As we can see there is this "011" pattern when "m" is 2.
                                                     --so we can leverage this fact and thus divide i by 3 as length
                                                     --of pattern is 3 and then get use the remainder.
                                                     --Also a period for any "m" also starts with "01" and hence same pattern always
                                                     --starts beginning with "01"
 */

import java.util.*;
public class FibonacciMod {
    public static long findPatternLength(long fibN, long mod) {
        long patternLength = 2; //length to be 3 for mod 2
        if (mod == 2) {
            return 3; // this is "011" for 2
        }

        long fibN_1 = 0;   // fib0 = 0
        long fibN_2 = 1;   // fib1 = 1
        long fibNewN;
        while (true) {
            fibNewN = (fibN_1 + fibN_2) % mod;
            if ((fibNewN % mod) == 0) {
                //Now immediately check the next fib % m to see if it's 1
                if (((fibNewN + fibN_1) % mod) == 1) {
                    return --patternLength;  // this will be patternLength
                }
            }
            fibN_2 = fibN_1;
            fibN_1 = fibNewN;
            patternLength++;
        }

    }

    public static long calculateFibNModM(long fibN, long mod, long patternLength) {
        long remainder = fibN % patternLength;
        //System.out.println(remainder);
        long fibN_1 = 0;
        long fibN_2 = 1;
        long fibNewN = 1;
        if (remainder == 0) {
            for( int i = 2; i < patternLength ; i++ ) {
                fibNewN = (fibN_1 + fibN_2) % mod;
                fibN_2 = fibN_1;
                fibN_1 = fibNewN;
            }

            return (fibNewN) % mod;
        } else {
            for (int i = 2; i < remainder + 2; i++) {
                fibNewN = (fibN_1 + fibN_2) % mod; // This mode is to avoid creation of large fibonacci and just limit
                                                   // to whatever length mod is.
                fibN_2 = fibN_1;
                fibN_1 = fibNewN;
            }
            return (fibNewN) % mod;
        }


     }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] arr = input.trim().split("\\s+");

        long fibN = Long.parseLong(arr[0]);
        long mod = Long.parseLong(arr[1]);

        //System.out.println(findPatternLength(fibN,mod));
        long patternLength = findPatternLength(fibN,mod);

        System.out.println(patternLength);
        System.out.println(calculateFibNModM(fibN,mod,patternLength));
    }
}
