/*
The goal is to find the min no.of coins needed to change the input value(int) into coins
with values 1, 5 and 10.
As this looks like an optimization problem, this can be solved with dynamic programming. We go through
each possible sub-problem, and find the optimum combination. With memoization we don't repeat calculate the same sub problem.
Also this can be made much easier by directly using Greedy Approach done in next program.
 */

import java.util.Scanner;
import java.lang.Math;

public class MoneyChangeMemoiz {
    //Takes in input as the Number to calculate denominations for. saveDenom array for memoization. spaces just prints
    //appropriate spaces for tree branch
    public static int minDenom( int input, int[] saveDenoms, int spaces ) {
        if( input == 1 || input == 5 || input == 10 ) {
            return 1;
        } else {
            System.out.println(String.format("%" + String.valueOf(spaces) + "s", "") + "This is for input " + input);
            int[] coins = new int[3];   //Put 1,5 and 10 in array
            coins[0] = 1;
            coins[1] = 5;
            coins[2] = 10;
            int min = -1;
            int noOfCoins = 0;
            //Loop 3 times for all the sub problems
            for( int i = 0; i < 3; i++ ) {
                if( ( input >= coins[i] ) && saveDenoms[input - coins[i]] != -1 ) {
                    noOfCoins = 1 + saveDenoms[input - coins[i]];
                    if (min == -1) {
                        min = 1 + saveDenoms[input - coins[i]];
                    } else {
                        min = Math.min(min, 1 + saveDenoms[input - coins[i]]);
                    }
                } else if ( input >= coins[i] ) {
                    noOfCoins = 1 + minDenom( input - coins[i], saveDenoms, spaces + 2 ); //Here 1 represents single coin which can be 1 or 5 or 10
                    if ( min == -1 ) {
                        min = noOfCoins;
                    } else {
                        min = Math.min(min, noOfCoins );
                    }
                }

                System.out.println(String.format("%" + spaces + "s", "") + "The no.of coins when " + coins[i] + " is used first " + noOfCoins);
        }
        saveDenoms[input] = min;
        System.out.println(String.format("%" + spaces + "s", "") + "The min no.of coins for " + input + " is " + min );
        return min;
    }
    }

    public static void main( String[] args ) {
        System.out.println("Enter the input(int)");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        int[] saveDenoms = new int[input+1];

        for( int i = 0; i < input; i++ ) {
            saveDenoms[i] = -1;
        }

        System.out.println("The min no.of denominations is:  " + minDenom(input,saveDenoms, 1));
    }
}
