import sys

N, M = map(int, sys.stdin.readline().strip().split())

arr = list(map(int, sys.stdin.readline().strip().split()))
arr.sort()
visited = [False] * N

result = []
# 1 7 9 9
def back():
  # 종료
  if len(result) == M:
    for i in range(len(result)):
      print(result[i],end=" ")
    print()
    return
  
  # 재귀
  for i in range(N):
    if i > 0 and arr[i-1] == arr[i]: continue
    result.append(arr[i])
    back()
    result.pop()

back()