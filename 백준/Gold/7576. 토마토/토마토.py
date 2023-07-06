import sys
from collections import deque

W, H = map(int, sys.stdin.readline().strip().split())

tomato = [[0] * W for _ in range(H)]
visited = [[False] * W for _ in range(H)]

for i in range(H):
    tomato[i] = list(map(int, sys.stdin.readline().strip().split()))

temp = 1

def bfs():
    global visited, q
    # 상 우 하 좌
    dx = [0, 1, 0, -1]
    dy = [-1, 0, 1 ,0]
    while q:
        y, x = q.popleft()
        for i in range(4):
            idx = x + dx[i]
            idy = y + dy[i]
            if idx >= 0 and idy >= 0 and idx < W and idy < H:
                if tomato[idy][idx] == 0 and not visited[idy][idx]:
                    q.append((idy,idx))
                    visited[idy][idx] = True
                    tomato[idy][idx] = tomato[y][x] + 1

q = deque()

for i in range(H):
    for j in range(W):
        if tomato[i][j] == 1:
            q.append((i,j))
            visited[i][j] = True

bfs()
count = 0
for i in range(H):
    for j in range(W):
        if tomato[i][j] == 0:
            count = -1
if count != -1:
    count = max(map(max, tomato)) - 1
print(count)