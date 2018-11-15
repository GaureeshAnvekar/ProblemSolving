# Uses python3
'''
As we already know, a natural greedy strategy for the change problem does not work correctly for any set of
denominations. For example, if the available denominations are 1, 3, and 4, the greedy algorithm will change
6 cents using three coins (4 + 1 + 1) while it can be changed using just two coins (3 + 3). Your goal now is
to apply dynamic programming for solving the Money Change Problem for denominations 1, 3, and 4.
Used DP approach
'''
import sys
import math

def get_change(m):
    #write your code here
    denominations = []
    denominations.append(0)   #no coins for money 0
    coins = [1, 3, 4]
    best = math.inf
    
    for money in range(1, m+1):
        denominations.append(0) #this is to create extra index for new money and assign 0 to it
        best = math.inf         # resetting best to max value
        for coin in coins:
            if(money >= coin):
                check = denominations[money-coin] + 1
                if(check < best):
                    best = check
                    denominations[money] = best
        
    return denominations[m]

if __name__ == '__main__':
    m = int(sys.stdin.read())
    print(get_change(m))
