import sys
from collections import deque

N, E = map(int, sys.stdin.readline().strip().split())

def bfs(temp):
  global arr, visited
  q = deque(arr[temp])

  while q:
    temp = q.popleft()
    if not visited[temp]:
      visited[temp] = True
      for i in range(len(arr[temp])):
        q.append(arr[temp][i])
      

arr = [[] for _ in range(N + 1)]
visited = [False] * (N + 1)
count = 0

for i in range(E):
  a, b = map(int, sys.stdin.readline().strip().split())
  
  # 무방향이라
  
  arr[a].append(b)
  arr[b].append(a)
  
for i in range(1, N):
  if not visited[i]:
    visited[i] = True
    bfs(i)
    count += 1
  
visited_cnt = 0  
for i in range(1, len(visited)):
  if not visited[i]: visited_cnt += 1
print(count + visited_cnt)
