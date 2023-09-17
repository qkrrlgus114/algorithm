import sys
from collections import deque

N, K = map(int, sys.stdin.readline().split())

q = deque()

for i in range(N):
    q.append(i+1)
print("<", end="")
while q:
    for i in range(K - 1):
        temp = q.popleft()
        q.append(temp)
    if len(q) == 1:
        print(q.popleft(), end=">")
    else:
        print(q.popleft(), end=", ")