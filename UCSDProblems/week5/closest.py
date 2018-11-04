#Uses python3
'''
Given n points on a plane, find the smallest distance between a √︀
pair of two (different) points. Recall
that the distance between points (x 1 , y 1 ) and (x 2 , y 2 ) is equal to (x 1 − x 2 ) 2 + (y 1 − y 2 ) 2 .
'''
import sys
import math

def minimum_distance(x_new, x_y_arr, start, end):
    #write your code here
    closest = math.inf
    
    #base condition
    mypoint = None
    if ( start >= end ):
        for i in range( len( x_y_arr ) ):
            if ( x_y_arr[i][0] == x_new[start] ):
                if ( mypoint == None ):
                    mypoint = x_y_arr[i]
                else:
                    closest = abs(mypoint[1] - x_y_arr[i][1])
                    mypoint = x_y_arr[i]
        return closest
    ##
    mid = (start + end) // 2
    n = (end - start) + 1
    close1 = minimum_distance(x_new, x_y_arr, start, mid)
    close2 = minimum_distance(x_new, x_y_arr, mid+1, end)
    
    best = min(close1, close2)
    leftMostPt = x_new[mid]
    rightMostPt = x_new[mid + 1]
    mean = (rightMostPt + leftMostPt) / 2 
    close3 = MidStripe(mean, x_y_arr, rightMostPt, leftMostPt, best)
    
    closest = min(close3, best)
    return closest

def MidStripe(mean, x_y_arr, rightMostPt, leftMostPt, best):
    rightBoundary = rightMostPt   #default when best is inf
    leftBoundary = leftMostPt     #default when best is inf
    dist = best
    #when best is not -1
    if (best != math.inf):
        rightBoundary = mean + best
        leftBoundary = mean - best
        
    middleStripY = []
    
    for i in range(len(x_y_arr)):
        if(x_y_arr[i][0] <= rightBoundary and x_y_arr[i][0] >= leftBoundary):
            middleStripY.append(x_y_arr[i])
            
    #traverse the Y strip vertically from bottom to find best. only check upto 8 points.
    for i in range(len(middleStripY)):
        for j in range(i+1, i + 9):
            if ( j < len(middleStripY)):
                dist = math.sqrt(((middleStripY[i][0] - middleStripY[j][0])**2 + (middleStripY[i][1] - middleStripY[j][1])**2))
                if (dist < best):
                    best = dist
            

    ##
     
    '''if ( best == math.inf ):
        return dist
    elif( dist < best ):
        best = dist
    '''
    return best

if __name__ == '__main__':
    input = sys.stdin.read()
    data = list(map(int, input.split()))
    #data = [3,1,3,4,5,6,8]
    n = data[0]
    x = data[1::2]
    y = data[2::2]
    x_new = []
    x_y_arr = []
    
    for i in range(len(x)):
        x_y_arr.append([x[i], y[i]])
        
        if( i == 0 ):
            x_new.append( x[i] )
        else:
            if((x[i] in x_new) == False):
                x_new.append(x[i])
    
    x_y_arr.sort( key = lambda x_y_cord: x_y_cord[1] )
    x_new.sort()
    
    """for i in range(1,10000):
        x_new.append(5)
        x_y_arr.append([5,i])
    """
    closest = minimum_distance(x_new, x_y_arr, 0, len(x_new) - 1)
    if( closest == math.inf):
        print("{0:.9f}".format(0))
    else:
        print("{0:.9f}".format(closest))
