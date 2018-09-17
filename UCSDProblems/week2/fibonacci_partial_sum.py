# Uses python3
import sys
import math

def fibonacci_partial_sum_naive(from_, to):
    if from_ <= 1 and to <= 1:
        return (from_ + to);

    previous = 0
    current  = 1
    lastDigitOfSum = [];
    lastDigitOfSum.insert(0,0);
    lastDigitOfSum.insert(1,1);
    
    for i in range(2,60):
        previous, current = current, (previous + current)
        lastDigitOfSum.insert(i,(lastDigitOfSum[i-1] + current) );
    
        
    #This is for 'to' ie to calculate last digit of sum of fib(to)
    q1 = math.floor((to)/60);
    rem1 = (to) % 60;
    lastDigitOfSumTo = (lastDigitOfSum[rem1] + (q1 * lastDigitOfSum[59]));

    #This is for 'from_' ie to calculate last digit of sum of fib(from_)
    q2 = math.floor((from_-1)/60);
    rem2 = (from_-1) % 60;
    lastDigitOfSumFrom = (lastDigitOfSum[rem2] + (q2 * lastDigitOfSum[59]));
        
    #Now to calculate last digit of sum from fib(from_) to fib(to), subtract
    #fib(from_) from fib(to)
    return abs(((lastDigitOfSumTo) - (lastDigitOfSumFrom))%10);

if __name__ == '__main__':
    input = sys.stdin.read();
    from_, to = map(int, input.split())
    print(fibonacci_partial_sum_naive(from_,to))