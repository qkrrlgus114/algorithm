import sys

N, M = map(int, sys.stdin.readline().strip().split())

if N == 1 or M == 1:
    print(1)
elif N == 2:
    if M >= 7:
        print(4)
    else:
        print((M-1)//2+1)
elif M <= 6:
    print(min(4, M))
else:
    print(M-2)