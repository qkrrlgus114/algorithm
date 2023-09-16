import sys
from collections import deque

# 10시부터 시계방향
dx = [-2, -1, 1, 2, 2, 1, -1, -2]
dy = [-1, -2, -2, -1, 1, 2, 2, 1]

def bfs(i, j):
    global target_idx, T, I, graph, visited
    q = deque()
    q.append((i, j, 0))
    while q:
        idy, idx, count = q.popleft()
        for i in range(8):
            ndx = idx + dx[i]
            ndy = idy + dy[i]
            if ndx >=0 and ndy >=0 and ndx < I and ndy < I:
                if graph[ndy][ndx] == 5:
                    count += 1
                    return count
                elif visited[ndy][ndx] == 0:
                    visited[ndy][ndx] = 1
                    count += 1
                    q.append((ndy, ndx, count))
                    count -= 1

T = int(sys.stdin.readline())

for i in range(T):
    I = int(sys.stdin.readline())
    cur_idx = list(map(int, sys.stdin.readline().split()))
    target_idx = list(map(int, sys.stdin.readline().split()))

    # 전체 맵
    graph = [[0 for _ in range(I)] for _ in range(I)]
    graph[target_idx[0]][target_idx[1]] = 5
    # 방문체크
    visited = [[0 for _ in range(I)] for _ in range(I)]

    if target_idx[0] == cur_idx[0] and target_idx[1] == cur_idx[1]:
        print(0)
    else:
        count = bfs(cur_idx[0], cur_idx[1])
        print(count)