arr = [[0 for i in range(101)] for j in range(101)]
N = int(input())
for _ in range(N):  
  x, y = map(int, input().split())
  for i in range(y, y+10):
    for j in range(x, x+10):
      arr[i][j] = 1
  result = 0
  for i in range(101):
    for j in range(101):
      if arr[i][j] == 1: result+=1

print(result)