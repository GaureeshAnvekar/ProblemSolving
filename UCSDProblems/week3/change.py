# Uses python3
'''
The money change problem has the property of optimal substructure i.e. least no.of
coins required for an input 'm' can be the sum of least coins for subproblem of 'm' + 
least coins for another subproblem of 'm'.
The following uses it and is done using naive recursion without memoization.
'''
import sys

def get_change(m):
    #base cases
    if m == 0:
        return 0;
    if m == 1 or m == 5 or m == 10:
        return 1;
    if m < 0:
        return float("inf"); #to represent infinity as 'm' is negative so that case shouldn't be considered.
    
    change = min(get_change(m-1)+1, get_change(m-5)+1, get_change(m-10)+1); #This is because if we take coin 1, then remainder will be m-1, if coin 5 then m-5.
    return change;

if __name__ == '__main__':
    m = int(sys.stdin.read())
    print(get_change(m))
