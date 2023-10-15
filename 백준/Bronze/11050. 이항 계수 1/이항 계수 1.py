import sys
from itertools import combinations

N, K = map(int, sys.stdin.readline().split())

nums = []
for i in range(1, N+1):
    nums.append(i)


combi = list(combinations(nums, K))
print(len(combi))