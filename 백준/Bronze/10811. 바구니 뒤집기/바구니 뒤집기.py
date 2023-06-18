N, M = map(int,input().split())
arr = []
for i in range(1,N+1):
  arr.append(i)
for i in range(0, M):
  start, end = map(int,input().split())
  temp = arr[start-1:end]
  temp.reverse()
  arr[start-1:end] = temp

for i in arr:
  print(i, end=' ')