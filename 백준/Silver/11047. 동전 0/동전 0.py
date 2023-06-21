import sys
from collections import deque

N, K = map(int,sys.stdin.readline().strip().split())

coin = deque()

for i in range(N):
  coin.append(int(sys.stdin.readline()))
  
sum = 0
coin.reverse()

for i in range(N):
  sum = sum + K//coin[i]
  K = K%coin[i]
print(sum)