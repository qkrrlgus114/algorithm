import sys
from collections import deque

def dfs(idx):
  global visited
  visited[idx] = True # 방문했다고 표시
  print(idx, end=" ")
  for next in range(1, N+1):
    if not visited[next] and graph[idx][next]:
      dfs(next)
      
def bfs(idx):
  global q, visited
  while q: # 큐가 있을 때까지 돌림
    cur = q.popleft()
    print(cur, end=" ")
    for next in range(1, N+1):
      if not visited[next] and graph[cur][next]:
        q.append(next)
        visited[next] = True
  
N, M, V = map(int, sys.stdin.readline().strip().split())

graph = [[False] * (N+1) for _ in range(N+1)]
visited = [False] * (N+1)

# 그래프 입력
for i in range(M):
  a, b = map(int, sys.stdin.readline().strip().split())
  graph[a][b] = True
  graph[b][a] = True


# dfs
dfs(V)
print()

# bfs
visited = [False] * (N+1)
visited[V] = True
q = deque([V])
bfs(V)