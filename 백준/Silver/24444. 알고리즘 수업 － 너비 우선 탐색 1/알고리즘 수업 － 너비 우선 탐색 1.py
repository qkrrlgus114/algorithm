import sys
from collections import deque

def bfs():
  global visited, q, idx
  while q:
    cur = q.popleft()
    for next in graph[cur]:
      if not visited[next]:
        q.append(next)
        idx+=1
        visited[next] = idx

N, M, R = map(int, sys.stdin.readline().strip().split())
idx = 1

graph = [[] for _ in range(N+1)]
visited = [0] * (N+1)

for i in range(M):
  a, b = map(int, sys.stdin.readline().strip().split())
  graph[a].append(b)
  graph[b].append(a)
  
for i in range(N+1):
  graph[i].sort()

q = deque([R])
visited[R] = idx
bfs()
for i in range(1, len(visited)):
  print(visited[i])