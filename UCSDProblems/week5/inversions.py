# Uses python3
'''
An inversion of a sequence a 0 , a 1 , . . . , a n−1 is a pair of indices 0 ≤ i < j < n such
that a i > a j . The number of inversions of a sequence in some sense measures how
close the sequence is to being sorted. For example, a sorted (in non-descending
order) sequence contains no inversions at all, while in a sequence sorted in de-
scending order any two elements constitute an inversion (for a total of n(n − 1)/2
inversions).
The goal in this problem is to count the number of inversions of a given sequence.
'''
import sys

def get_number_of_inversions(a, b, left, right):
    number_of_inversions = 0
    if(left >= right):
        return number_of_inversions
    mid = (left + right) // 2
    number_of_inversions += get_number_of_inversions(a, b, left, mid)
    number_of_inversions += get_number_of_inversions(a, b, mid+1, right)
    #write your code here
    number_of_inversions = number_of_inversions + merge(a, b, left, mid, mid+1, right)
    return number_of_inversions

def merge(a, b, leftS, leftE, rightS, rightE):
    leftSideMultiplier = (rightE - rightS) + 1
    inversions = 0
    i = leftE
    j = rightE
    k = rightE
    while( k >= leftS):
        if(a[i] > a[j]):
            b[k] = a[i]
            i = i - 1
            k = k - 1
            inversions = inversions + leftSideMultiplier
        elif(a[i] <= a[j]):
            b[k] = a[j]
            j = j - 1
            k = k - 1
            leftSideMultiplier = leftSideMultiplier - 1
        
        if(i < leftS or j < rightS):
            break
        
    #print("k " + str(k) + " " + "leftS " + str(leftS))
    if( k >= leftS ):
        if(i >= leftS):
            b[leftS:k+1] = a[leftS:i+1]
        elif(j >= rightS):
            b[leftS:k+1] = a[rightS:j+1] 
    
    
    a[leftS:rightE+1] = b[leftS:rightE+1]
    #print(b)
    #print(a)
    return inversions

if __name__ == '__main__':
    input = sys.stdin.read()
    n, *a = list(map(int, input.split()))
    b = n * [0]
    print(get_number_of_inversions(a, b, 0, len(a)-1))

