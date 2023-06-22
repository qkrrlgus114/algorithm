import sys
from collections import deque

N = int(sys.stdin.readline().strip())
A = deque(list(map(int, sys.stdin.readline().strip().split())))
B = deque(list(map(int, sys.stdin.readline().strip().split())))

A = sorted(A,reverse=True)
result = 0

for i in A:
  min_B = min(B)
  result += min_B * i
  for temp in B:
    if temp == min_B:
      B.remove(temp)
      break

print(result)