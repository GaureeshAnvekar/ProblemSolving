# Uses python3
import sys
import math
def fibonacci_sum_naive(n):
    if n <= 1:
        return n

    previous = 0
    current  = 1
    sum      = 1
    lastDigitOfSum = [];
    lastDigitOfSum.insert(0,0);
    lastDigitOfSum.insert(1,1);
    for i in range(2,61):
        previous, current = current, (previous + current)%10
        sum += current
        lastDigitOfSum.insert(i,sum%10);
    
        
    q = math.floor(n/60);
    rem = n % 60;
    return (lastDigitOfSum[rem] + (q * lastDigitOfSum[60]))%10;
    


if __name__ == '__main__':
    input = sys.stdin.read()
    n = int(input)
    print(fibonacci_sum_naive(7))
