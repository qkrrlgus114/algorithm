import sys
from collections import deque

def bfs(start):
    global graph, visited
    q = deque([start])

    while q:
        now = q.popleft()
        for i in graph[now]:
            if visited[start][i] == 0:
                visited[start][i] = 1
                q.append(i)

    print(*visited[start])

N = int(sys.stdin.readline())
graph = [[] for _ in range(N)]
visited = [[0] * N for _ in range(N)]

for i in range(N):
    arr = list(map(int, sys.stdin.readline().split()))
    for j in range(N):
        if arr[j] == 1:
            graph[i].append(j)

for i in range(N):
    bfs(i)