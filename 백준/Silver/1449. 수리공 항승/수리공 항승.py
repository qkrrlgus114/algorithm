import sys
from collections import deque

N, L = map(int,sys.stdin.readline().strip().split())

water = deque(list(map(int, sys.stdin.readline().strip().split())))
water = sorted(water)
count = 0
check = water[0]
for i in range(N):
  if water[i] > check:
    check = water[i]+L
    count+=1
  elif water[i] == check:
    check += L
    count+=1
  else:
    continue
  
print(count)