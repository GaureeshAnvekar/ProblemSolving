# Uses python3
"""
You are organizing a funny competition for children. As a prize fund you have n
candies. You would like to use these candies for top k places in a competition
with a natural restriction that a higher place gets a larger number of candies.
To make as many children happy as possible, you are going to find the largest
value of k for which it is possible.
"""
import sys

def optimal_summands(n):
    summands = []
    #write your code here
    if(n == 0):
        return 0;
    
    if(n == 1):
        summands.append(1);
        return summands;
    
    i = 1;
    while(i <= n):
        if( (n - i) > i or (n - i) == 0):
            summands.append(i);
            n = n - i;
        i = i + 1;

    return summands;
if __name__ == '__main__':
    input = sys.stdin.read()
    n = int(input)
    summands = optimal_summands(n)
    print(len(summands))
    for x in summands:
        print(x, end=' ')
