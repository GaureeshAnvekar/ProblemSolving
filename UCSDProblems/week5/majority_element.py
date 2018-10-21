# Uses python3
"""
Given a sequence of elements a 1 , a 2 , . . . , a n , you would like to check whether
it contains an element that appears more than n/2 times. Naive method
would be O(n2) going through all pairs. Using divide-n-conquer it is 
O(nlogn)
"""
import sys

def get_majority_element(a, left, right):
    if left == right:
        return a[left]

    #write your code here
    noOfElem = (right+1) - left
    mid = (int(noOfElem / 2) - 1) + left
    left_major_elem = get_majority_element(a, left, mid)
    right_major_elem = get_majority_element(a, mid+1, right)
    
    if( left_major_elem == right_major_elem ):
        return left_major_elem
    else:
        count_left = 0
        count_right = 0
        nby2 = int(noOfElem / 2)
        for i in range(left,right+1):
            if a[i] == left_major_elem:
                count_left += 1
            elif a[i] == right_major_elem:
                count_right += 1
                
            if count_left > nby2:
                return left_major_elem
            elif count_right > nby2:
                return right_major_elem
    
    return None

if __name__ == '__main__':
    input = sys.stdin.read()
    n, *a = list(map(int, input.split()))
    check = get_majority_element(a, 0, n-1)
    if check == None:
        print(0)
    else:
        print(1)
