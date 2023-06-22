import sys
from collections import deque

N, M = map(int, sys.stdin.readline().strip().split())
price = deque()
for i in range (M):
  price.append(deque(map(int,sys.stdin.readline().strip().split())))
  
set = N//6 # 6개짜리 세트 몇 개 구입하는지
na = N%6 # 6개씩 묶고 남은 나머지
min_set = 10000000
min_na = 10000000
for i in range(len(price)):
  if set==0:
    temp1 = min(price[i][0], price[i][1]*na)
    if temp1 < min_na: min_na = temp1
  else:
    temp1 = min(price[i][0]*set, price[i][1]*6*set)
    if temp1 < min_set: min_set = temp1
    temp2 = min(price[i][0], price[i][1]*na)
    if temp2 < min_na: min_na = temp2
if(min_set==10000000): min_set=0
elif(min_na==10000000): min_na=0
print(min_set+min_na)