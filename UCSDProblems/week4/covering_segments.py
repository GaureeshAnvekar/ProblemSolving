# Uses python3
"""
You are responsible for collecting signatures from all tenants of a certain build-
ing. For each tenant, you know a period of time when he or she is at home.
You would like to collect all signatures by visiting the building as few times as
possible.
The mathematical model for this problem is the following. You are given a set
of segments on a line and your goal is to mark as few points on a line as possible
so that each segment contains at least one marked point.
"""
import sys
from collections import namedtuple

Segment = namedtuple('Segment', 'start end')

def optimal_points(segments):
    points = []
    #write your code here
    #First sort the segments in ascending order of end-points
    segments.sort(key = lambda tupl: tupl[1] );
    i = 0;
    while i < len(segments):
        points.append(segments[i][1]);
        segToCmp = segments[i];
        i = i + 1;
        if( i < len(segments)):
            while(segments[i][0] <= segToCmp[1] and segments[i][1] >= segToCmp[1]):
                i = i+1;
                if (i >= len(segments)):
                    break;
        
    return points

if __name__ == '__main__':
    input = sys.stdin.read()
    n, *data = map(int, input.split())
    segments = list(map(lambda x: Segment(x[0], x[1]), zip(data[::2], data[1::2])))
    points = optimal_points(segments)
    print(len(points))
    for p in points:
        print(p, end=' ')
