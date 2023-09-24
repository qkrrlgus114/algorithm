import sys
from collections import deque

def bfs(i, j):
    global graph, dx, dy, N, M
    q = deque()
    q.append((i, j))
    graph[i][j] = 1
    count = 1

    while q:
        y, x = q.popleft()
        for i in range(4):
            idx = x + dx[i]
            idy = y + dy[i]
            if 0 <= idx < N and 0 <= idy < M:
                if graph[idy][idx] == 0:
                    graph[idy][idx] = 1
                    q.append((idy, idx))
                    count += 1
    return count

                    

M, N, K = map(int, sys.stdin.readline().split())

graph = [[0] * N for _ in range(M)]

#상 우 하 좌 순서
dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

# 영역의 개수
count = 0
# 영역의 크기
result = []

for _ in range(K):
    x1, y1, x2, y2 = map(int, sys.stdin.readline().split())
    for i in range(x1, x2):
        for j in range(M - y1 - 1, M - y2 - 1, -1):
            graph[j][i] = 1

for i in range(M):
    for j in range(N):
        if graph[i][j] == 0:
            x = bfs(i,j)
            count += 1
            result.append(x)

result.sort()

print(count)
for i in range(len(result)):
    print(result[i], end=" ")