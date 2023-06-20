import sys
from collections import deque

N, cycle = map(int,sys.stdin.readline().strip().split())

arr = deque()

for i in range(1,N+1):
  arr.append(i)

result = "<"
for i in range(N):
  temp = 1
  while temp!=cycle:
    temp_value = arr.popleft()
    arr.append(temp_value)
    temp+=1
  if i == N-1:
    result = result + str(arr.popleft()) + ">"
  else:
    result = result + str(arr.popleft()) + ", "
    
print(result)