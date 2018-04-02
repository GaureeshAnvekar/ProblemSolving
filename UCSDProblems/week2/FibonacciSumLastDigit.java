/*
To find the last of sum of first n fibonacci.
Here instead of using a loop to find the sum and then mod 10,
we should use the Pisano period technique where for any mod "m", there
will be a pattern of some length, which then keeps repeating,
Eg:    i:         0   1   2   3   4   5   6   7
     fib(i):      0   1   1   2   3   5   8   13
  fib(i) mod 2:   0   1   1   0   1   1   0   1      --As we can see there is this "011" pattern when "m" is 2.
                                                     --so we can leverage this fact and thus divide i by 3 as length
                                                     --of pattern is 3 and then get use the remainder.
                                                     --Also a period for any "m" also starts with "01" and hence same pattern always
                                                     --starts beginning with "01"
 So we can directly use 10 as "m" and find the last digit for each fib(i) only till it covers one pattern, by fib(i) mod 10.
 The just multiply the no.of patterns with the last digit of one pattern. Also if any remainder, then again calculate fib(i) mod 10
 till it covers the remainder.
 For complete details about question refer question 6 from "week2_algorithmic_questions" under "UCSDProblems/week2"
 */
import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % 10;
            //sum = (sum + current) % 10;
        }

        return sum % 10;
    }
    public static long getFibonacciSumFast(long n) {
        long noOfF1sN_2 = 0;
        long noOfF0sN_2 = 1;
        long noOfF1sN_1 = 1;
        long noOfF0sN_1 = 1;
        long currNoOfF1s = 0;
        long currNoOfF0s = 0;

        if( n == 0 ) {
            return 0;
        } else if ( n == 1 ) {
            return 1;
        } else {
            for( int i = 2; i <= n; i++ ) {
                /*currNoOfF0s = noOfF0sN_1 + noOfF0sN_2;
                currNoOfF1s = (noOfF1sN_1 + noOfF1sN_2) % 10;

                //Now update previous ones
                noOfF0sN_2 = noOfF0sN_1;
                noOfF0sN_1 = currNoOfF0s;

                noOfF1sN_2 = noOfF1sN_1;
                noOfF1sN_1 = currNoOfF1s;*/
            }

            return (currNoOfF1s ) % 10;
        }


    }
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
    public static double findLastDigit( long patternLength, long n ) {
        double noOfFits = Math.floor( (n+1) / patternLength );
        double remainder = (n+1) % patternLength;
        double lastDigitSinglePattern = 0;
        double lastDigitOfSum = 0;
        long fibN_2 = 0;
        long fibN_1 = 1;
        long fibNew;
        long sumSinglePattern = 1;  // As fib0 + fib1 = 1 for mod 10 or in fact any mod
        //Loop to caculate the mods for each fib(i) only till the patternLength
        for( int i = 2; i < patternLength; i++ ) {
            fibNew = fibN_1 + fibN_2;
            sumSinglePattern = (sumSinglePattern + fibNew) % 10;
            fibN_2 = fibN_1;
            fibN_1 = fibNew;
        }
        lastDigitSinglePattern = (sumSinglePattern % 10);

        //Loop to calculate the mods for each fib(i) for the remainder part
        fibN_2 = -1;
        fibN_1 = 1;
        fibNew = 0;
        long sumRemainderPattern = 0;
        for( int i = 0; i < remainder; i++ ) {
            fibNew = fibN_1 + fibN_2;
            sumRemainderPattern = (sumRemainderPattern + fibNew) % 10;
            fibN_2 = fibN_1;
            fibN_1 = fibNew;
        }

        lastDigitOfSum = (((noOfFits * lastDigitSinglePattern) % 10) + sumRemainderPattern ) % 10;

        return lastDigitOfSum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long patternLength = findPatternLength(n,10);
        long lastDigit = (long)findLastDigit(patternLength,n);

        System.out.println(lastDigit);
    }
}

