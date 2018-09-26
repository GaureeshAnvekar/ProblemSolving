# Uses python3
'''
Fractional knapsack has the property of optimal substructure. So naive recursion
is used here. Even if we memoize the subproblems, the solution will be wrong as the optimal
solution for a subproblem will not remain the same at some other node of the tree because the values and weights
are constantly changing. Also note that we need not go through different subproblems of different
sizes. Instead any random 2 subproblems will suffice. Here we are just dividing capacity by 2.
'''
import sys

def get_optimal_value(capacity, weights, values):
    value = 0
    # write your code here
    bestVal = -1;
    bestValInd = -1;
    
    if capacity == 0:
        return 0;
    if capacity == 1:
        for i in range(len(weights)):
            if weights[i] != 0:
                if float(values[i])/weights[i] > bestVal:
                    bestVal = float(values[i])/weights[i];
                    bestValInd = i;
        
        if bestVal != -1:
            value = bestVal;
            weights[bestValInd] = weights[bestValInd] - 1;
            values[bestValInd] = abs(values[bestValInd] - bestVal);
        return value;
    
                
    part1 = int(capacity / 2)
    part2 = abs(capacity - part1);
    value = get_optimal_value(part1, weights, values) + get_optimal_value(part2, weights, values)
    return value


if __name__ == "__main__":
    data = list(map(int, sys.stdin.read().split()))
    #data = [1,10,500,30]
    n, capacity = data[0:2]
    values = data[2:(2 * n + 2):2]
    weights = data[3:(2 * n + 2):2]
    opt_value = get_optimal_value(capacity, weights, values)
    print("{:.10f}".format(opt_value))
