import sys
from collections import deque

result = -1

def bfs(i):
    global graph, visited, x, y, result
    
    q = deque([(i, 0)])
    
    while q:
        cur, count = q.popleft()
        
        if cur == y:
            result = count
            return
        for temp in graph[cur]:
            if visited[temp] == 0:
                visited[temp] = cur
                q.append((temp, count+1))

N = int(sys.stdin.readline())

x, y = map(int, sys.stdin.readline().split())

m = int(sys.stdin.readline())

graph = [[] for _ in range(N+1)]
visited = [0] * (N+1)

for i in range(m):
    start, end = map(int, sys.stdin.readline().split())
    
    graph[start].append(end)
    graph[end].append(start)

bfs(x)

print(result)