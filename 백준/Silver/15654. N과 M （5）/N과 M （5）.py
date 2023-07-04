import sys

N, M = map(int, sys.stdin.readline().strip().split())
temp = list(map(int, sys.stdin.readline().strip().split()))
temp.sort()
result = []

def back():
  # 종료
  if len(result) == M:
    for i in range(len(result)):
      print(result[i], end=" ")
    print()
    return
  
  # 재귀
  for i in range(0, N):
    if temp[i] not in result:
      result.append(temp[i])
      back()
      result.pop()
    
back()