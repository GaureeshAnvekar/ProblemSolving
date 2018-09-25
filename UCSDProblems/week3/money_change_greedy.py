# Uses python3
'''
The money change problem has the property of optimal substructure i.e. least no.of
coins required for an input 'm' can be the sum of least coins for subproblem of 'm' + 
least coins for another subproblem of 'm'.
The following uses greedy directly without using DP, because the optimal solution
satisfies the criteria in which the intuition of having coins with highest value always
works.
'''
import sys
import math
def get_change(m):
    #base cases
    if m == 0:
        return 0;
    if int(m/10) != 0:
        best = int(m/10);
        return best + get_change(m - (best * 10));
    if int(m/5) != 0:
        best = int(m/5);
        return best + get_change(m - (best * 5));
    else:
        return m;

if __name__ == '__main__':
    m = int(sys.stdin.read())
    print(get_change(m))
