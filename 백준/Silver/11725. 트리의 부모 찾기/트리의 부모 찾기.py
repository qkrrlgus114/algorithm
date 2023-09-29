import sys
from collections import deque

def bfs():
    global N, graph, visited
    
    q = deque()
    q.append(1)
    while q:
        now = q.popleft()
        for i in graph[now]:
            if visited[i] == 0:
                visited[i] = now
                q.append(i)
                
N = int(sys.stdin.readline())

graph = [[] for _ in range(N+1)]
visited = [0] * (N+1)

for i in range(N - 1):
    start, end = map(int, sys.stdin.readline().split())
    
    graph[start].append(end)
    graph[end].append(start)
    
bfs()

for i in range(2, N+1):
    print(visited[i])