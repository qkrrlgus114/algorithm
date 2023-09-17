import sys
from collections import deque

# 정상인의 bfs
def bfs1(y, x, color):
    global N, graph, visited1, dx, dy
    q = deque()
    q.append((y, x))
    visited1[y][x] = 1

    while q:
        ny, nx = q.popleft()
        for i in range(4):
            idx = nx + dx[i]
            idy = ny + dy[i]
            if 0 <= idy < N and 0 <= idx < N and not visited1[idy][idx] and graph[idy][idx] == color:
                q.append((idy, idx))
                visited1[idy][idx] = 1

# 적록색약의 bfs
def bfs2(y, x, color):
    global N, graph, visited2, dx, dy
    q = deque()
    q.append((y, x))
    visited2[y][x] = 1

    while q:
        ny, nx = q.popleft()
        for i in range(4):
            idx = nx + dx[i]
            idy = ny + dy[i]
            if idy >= 0 and idx >= 0 and idy < N and idx < N:
                if visited2[idy][idx] == 0:
                    if color == 'B':
                        if graph[idy][idx] == 'B':
                            q.append((idy, idx))
                            visited2[idy][idx] = 1
                    else:
                        if graph[idy][idx] == 'R' or graph[idy][idx] == 'G':
                            q.append((idy, idx))
                            visited2[idy][idx] = 1



N = int(sys.stdin.readline())
graph = [list(sys.stdin.readline().strip()) for _ in range(N)]
visited1 = [[0 for _ in range(N)] for _ in range(N)]
visited2 = [[0 for _ in range(N)] for _ in range(N)]
human = 0
bhuman = 0

# 상우하좌 순서
dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

for i in range(N):
    for j in range(N):
        if visited1[i][j] == 0:
            bfs1(i, j, graph[i][j])
            human += 1

for i in range(N):
    for j in range(N):
        if visited2[i][j] == 0:
            bfs2(i, j, graph[i][j])
            bhuman += 1

print(human, bhuman)