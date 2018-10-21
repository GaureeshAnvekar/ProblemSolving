# Uses python3
"""
The goal in this problem is to redesign a given implementation of the random-
ized quick sort algorithm so that it works fast even on sequences containing
many equal elements. This can be done by using 3-way partition and avoiding 
the part which has equal elements.
"""
import sys
import random

def partition3(a, l, r):
    #write your code here
    j = l
    k = l
    for i in range(l+1,r+1):
        if a[i] == a[l]:
            k = k + 1
            temp = a[k]
            a[k] = a[i]
            a[i] = temp
        elif a[i] < a[l]:
            k = k + 1
            temp1 = a[k]
            a[k] = a[i]
            a[i] = temp1
            j = j + 1
            temp2 = a[j]
            a[j] = a[k]
            a[k] = temp2
    
    return j,k


def partition2(a, l, r):
    j = 0
    for i in range(1,r+1):
        if a[i] <= a[l]:
            j = j + 1
            temp = a[j]
            a[j] = a[i]
            a[i] = temp
    return j


def randomized_quick_sort(a, l, r):
    #base
    if l >= r:
        return
    #select random pivot by selecting rand index
    pivotPos = random.randint(l,r)
    #swap the pivot element with leftmost element
    temp = a[l]
    a[l] = a[pivotPos]
    a[pivotPos] = temp
    #partition to get exact position of sorted pivot
    index1, index2 = partition3(a, l, r)
    #swap pivot with the returned index
    temp = a[l]
    a[l] = a[index1]
    a[index1] = temp
    #recursion on below pivot and above pivot elements
    randomized_quick_sort(a, l, index1 -1)
    randomized_quick_sort(a, index2+1, r)

if __name__ == '__main__':
    input = sys.stdin.read()
    n, *a = list(map(int, input.split()))
    randomized_quick_sort(a, 0, n - 1)
    for x in a:
        print(x, end=' ')
