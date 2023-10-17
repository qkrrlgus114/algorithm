import sys
import math

T = int(sys.stdin.readline())

for _ in range(T):
    left, right = map(int, sys.stdin.readline().split())

    print(math.comb(right, left))