# Uses python3
'''
You are given a set of points on a line and a set of segments on a line. The goal is to compute, for
each point, the number of segments that contain this point.
'''
import sys

def fast_count_segments(starts, ends, points):
    cnt = [0] * len(points)
    #write your code here
    starts.sort()
    ends.sort()
    i = 0
    totalSegments = len(starts)
    
    for x in points:
        leftStartCnt = BinarySearch(starts, x, "left")
        rightEndCnt = BinarySearch(ends, x, "right")
        cnt[i] = (leftStartCnt + rightEndCnt) - totalSegments   # A intersection B = A + B - (AUB)
        i = i + 1

    return cnt

def BinarySearch(lst, x, leftOrRight):
    cnt = 0
    S = 0
    E = len(lst) - 1
    mid = (S + E) // 2
    
    while(S <= E):
        mid = (S + E) // 2
        if (leftOrRight == "left"):
            if (lst[mid] <= x):
                cnt = cnt + (mid -S) + 1
                S = mid + 1
            else:
                E = mid - 1
        else: #right points
            if (lst[mid] >= x):
                cnt = cnt + (E - mid) + 1
                E = mid - 1
            else:
                S = mid + 1

    return cnt

def naive_count_segments(starts, ends, points):
    cnt = [0] * len(points)
    for i in range(len(points)):
        for j in range(len(starts)):
            if starts[j] <= points[i] <= ends[j]:
                cnt[i] += 1
    return cnt

if __name__ == '__main__':
    input = sys.stdin.read()
    data = list(map(int, input.split()))
    #data = [3, 2, 0, 5, -3, 2, 7, 10, 1, 6]
    n = data[0]
    m = data[1]
    starts = data[2:2 * n + 2:2]
    ends   = data[3:2 * n + 2:2]
    points = data[2 * n + 2:]
    #use fast_count_segments
    cnt = fast_count_segments(starts, ends, points)
    for x in cnt:
        print(x, end=' ')
