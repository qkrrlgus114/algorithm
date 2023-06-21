import sys
from collections import deque

N = int(sys.stdin.readline().strip())
dis = deque(list(map(int, sys.stdin.readline().strip().split())))
city = deque(list(map(int, sys.stdin.readline().strip().split())))
target = city[0]
oil = 0
i=0
while i!=len(city)-1:
  flag = True
  for j in range(i+1,N-1):
    if target > city[j]: 
      target = city[j]
      flag = False
      break
  if flag == True:
    for j in range(i,N-1):
      oil += city[i]*dis[j]
    break
  elif flag == False:
    oil += city[i]*dis[i]
    i+=1
    
print(oil)