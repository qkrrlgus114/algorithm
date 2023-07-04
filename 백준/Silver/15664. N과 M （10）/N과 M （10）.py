import sys

N, M = map(int, sys.stdin.readline().strip().split())

arr = list(map(int, sys.stdin.readline().strip().split()))
arr.sort()
visited = [False] * N

result = []
# 1 7 9 9
def back(start):
  # 종료
  if len(result) == M:
    for i in range(len(result)):
      print(result[i],end=" ")
    print()
  
  # 재귀
  for i in range(start,N):
    if i > 0 and arr[i] == arr[i-1] and visited[i-1] == False: continue
    if visited[i] == False:
      visited[i] = True
      result.append(arr[i])
      back(i+1)
      result.pop()
      visited[i] = False

back(0)