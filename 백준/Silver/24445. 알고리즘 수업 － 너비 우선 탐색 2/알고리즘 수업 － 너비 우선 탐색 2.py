import sys
from collections import deque

def bfs():
  global visited, q, count
  while q:
    cur = q.popleft()
    for next in graph[cur]:
      if not visited[next]:
        count+=1
        visited[next] = count
        q.append(next)
        
    

V, E, start = map(int, sys.stdin.readline().strip().split())
graph = [[] for _ in range(V+1)] 
visited = [0] * (V+1) # 방문 순서 확인을 위해서 만듦
q = deque() # bfs 큐
count = 1 # 몇 번째 순서로 들어가는지 

# 인접리스트를 사용하기 때문에 
for i in range(E):
  a,b = map(int, sys.stdin.readline().strip().split())
  graph[a].append(b)
  graph[b].append(a)
# 내림차순으로 방문을 해서 그래프를 내림차순으로 정렬
for i in range(V+1):
  graph[i].sort(reverse=True)

q.append(start) # 큐에 시작 정점을 먼저 넣음
visited[start] = count # 1번째로 방문했으니 체크
bfs()

for i in range(1, len(visited)): # 1번부터 순서를 뽑아냄.
  print(visited[i])