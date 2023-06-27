import sys
from collections import deque

def bfs():
  global visited, q, count
  while q:
    cur = q.popleft()
    for next in graph[cur]:
      if not visited[next]:
        visited[next] = True
        q.append(next)
        count+=1

V = int(sys.stdin.readline())
E = int(sys.stdin.readline())
start = 1
count = 0 # 몇 대의 컴퓨터가 감염됐는지
q = deque() # 사용할 큐
graph = [[] for _ in range(V+1)]
visited = [False] * (V+1)

# 입력 받기
for i in range(E):
  a, b = map(int, sys.stdin.readline().strip().split())
  
  # 양방향 입력이니깐
  graph[a].append(b)
  graph[b].append(a)

visited[1] = True
q.append(start)
bfs()
print(count)