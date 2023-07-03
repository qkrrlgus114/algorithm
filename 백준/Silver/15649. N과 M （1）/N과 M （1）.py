from itertools import permutations
import sys

N, M = map(int, sys.stdin.readline().strip().split())

result = list(permutations(range(1, N+1),M))
for i in result:
    for j in i:
        print(j, end=" ")
    print()