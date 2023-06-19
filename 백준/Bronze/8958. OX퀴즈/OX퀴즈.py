import sys

N = int(sys.stdin.readline().strip())
result = []
arr = []
for i in range(N):
  arr.append(sys.stdin.readline().strip())
  
for i in range(N):
  sum = 0
  point = 0
  temp_point = 1
  for j in range(len(arr[i])):
    if arr[i][j]=='O':
      point+=temp_point
      temp_point+=1
    else:
      sum+=point
      point=0
      temp_point=1
    if j == len(arr[i])-1: sum+=point
  result.append(sum)
      
for i in range(N):
  print(result[i])