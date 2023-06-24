import sys
from collections import deque

N, M = map(int, sys.stdin.readline().strip().split())

A= []
B= []

for i in range(N):
  A.append(deque(map(int, sys.stdin.readline().strip())))
for i in range(N):
  B.append(deque(map(int, sys.stdin.readline().strip())))
count = 0

def rotate(n, m):
  for i in range(n,n+3):
    for j in range(m,m+3):
      if A[i][j] == 0:
        A[i][j] = 1
      else:
        A[i][j] = 0


if (N < 3 or M < 3) and A != B:
  count = -1
else:
  for i in range(N-2):
    for j in range(M-2):
      if A[i][j] != B[i][j]:
        count+=1
        rotate(i,j)

if A!=B:
  count = -1
print(count)