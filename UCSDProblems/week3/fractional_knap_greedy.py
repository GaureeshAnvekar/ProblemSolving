# Uses python3
'''
Fractional knapsack has the property of optimal substructure. Instead of naive recursion or DP, we see that 
intuitively we should look for the item with best per unit weight value and select it and move with remaining subproblem.
This is also a "Safe Move" (Greedy) as we can prove that any optimal solution will have an item with best per unit weight value.
'''
import sys

def get_optimal_value(capacity, weights, values):
    value = 0
    if capacity == 0:
        return 0;
    
    bestPerUnitWt = -1;
    bestPerUnitWtInd = -1;
    
    for i in range(len(values)):
        if weights[i] != 0:
            if ( float(values[i])/weights[i] > bestPerUnitWt ):
                bestPerUnitWt = float(values[i])/weights[i];
                bestPerUnitWtInd = i;
    
    if bestPerUnitWt == -1:
        return 0;
    #Now the max of weight with highest per unit weight value and reduce capacity and value and weights
    maxWtFit = (weights[bestPerUnitWtInd] if (capacity >= weights[bestPerUnitWtInd]) else capacity);
    maxValue = maxWtFit * bestPerUnitWt;
    weights[bestPerUnitWtInd] = weights[bestPerUnitWtInd] - maxWtFit;
    values[bestPerUnitWtInd] = values[bestPerUnitWtInd] - maxValue;
    remCapacity = capacity - maxWtFit;
    return maxValue + get_optimal_value(remCapacity, weights, values);


if __name__ == "__main__":
    data = list(map(int, sys.stdin.read().split()))
    #data = [3,50,60,20,100,50,120,30]
    n, capacity = data[0:2]
    values = data[2:(2 * n + 2):2]
    weights = data[3:(2 * n + 2):2]
    opt_value = get_optimal_value(capacity, weights, values)
    print("{:.10f}".format(opt_value))
