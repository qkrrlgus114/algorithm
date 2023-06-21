import sys
from collections import deque

N = int(sys.stdin.readline())
arr = deque(list(map(int, sys.stdin.readline().strip().split())))

narr = sorted(arr)
sum = 0
result = 0
for i in range(N):
  sum+=narr[i]
  result += sum
print(result)