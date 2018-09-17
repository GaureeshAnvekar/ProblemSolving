# Uses python3
import sys

def pisano(n,m):
    if n <= 1:
        return n;
    
    #previous = 0
    #current = 1
    pisano = [];
    pisano.insert(0,0);
    pisano.insert(1,1);
    i = 2;
    while i <= n:
        #previous, current = current, (previous%m + current%m);
        pisano.insert(i,(pisano[i-1] + pisano[i-2])%m);
        if pisano[i] == 1 and pisano[i-1] == 0:
            pisanoLen = i-1;
            rem = (n+1) % pisanoLen;
            pisano.pop();
            pisano.pop();
            return pisano[rem-1];
        i = i + 1;
    return pisano[n];
        
if __name__ == '__main__':
    input = sys.stdin.read();
    n, m = map(int, input.split())
    print(pisano(500, 10))
