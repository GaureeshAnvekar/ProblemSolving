/*
Finding the Least Common Multiple in an efficient way.
For this use the technique i.e. LCM(a,b) = (a*b) / GCD(a,b)
So calculate GCD using the Euclid's algorithm.
 */
import java.util.*;

public class LCM {
    //This lcm_fast method should be avoided as we are calculating GCD and then LCM directly
    private static long lcm_fast(int a, int b) {
        int big;
        if( a == 1 ) {
            return b;
        } else if( b == 1 ) {
            return a;
        }
        if ( a < b ) {
            big = b;
        } else {
            big = a;
        }
        long multiple = 1;
        while(true) {
            if( (((a * multiple) % b) == 0 || (multiple == big)  )) {
                return ( a * multiple );
            } else {
                multiple++;
            }
        }

    }

    private static long euclids_gcd(long a, long b) {
        if( a == 0 ) {
            return b;
        } else if ( b == 0 ) {
            return a;
        } else if ( a == b ) {
            return  a;
        } else {
            if( a > b ) {
                a = a % b;
                //return euclids_gcd(a,b);
            } else if ( b > a ) {
                b = b % a;
                //return euclids_gcd(a,b);
            }
            return euclids_gcd(a,b);
        }


    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextInt();
        long b = scanner.nextInt();

        System.out.println((a*b)/euclids_gcd(a,b));
        //System.out.println((a*b)/euclids_gcd(a,b));
    }
}
