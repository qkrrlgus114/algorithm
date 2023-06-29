import sys
from collections import deque

# 사방탐색을 위해서 상우하좌 순서
dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

def bfs(y, x):
    global visited, miro, result
    q = deque() # 큐 생성
    q.append((y,x)) # 큐에 해당 좌표 넣고
    result[y][x] = 1 # 결과 배열에 1추가.
    while q: # 큐가 있으면
      y, x = q.popleft() # y, x 좌표 꺼내서
      for i in range(4): # 4방탐색 돌림
        idx = x + dx[i]
        idy = y + dy[i]  
        if idx >= 0 and idx < W and idy >= 0 and idy < H: # 범위 안에 있으면서
            if not visited[idy][idx] and miro[idy][idx] == 1: # 아직 방문 안 했고, 미로가 1이면
              visited[idy][idx] = True # 방문표시 하고
              q.append((idy,idx)) # 큐에 넣고
              result[idy][idx] = result[y][x] + 1 # 결과배열에 이전 위치+1로 넣어줌(거리)
                

H, W = map(int, sys.stdin.readline().strip().split())

miro = [] # 입력받을 미로
result = [] # 거리를 출력할 배열
result = [[0] * W for _ in range(H)]
visited = [[False] * W for _ in range(H)]
# 미로 입력
for i in range(H):
    miro.append(list(map(int, sys.stdin.readline().strip())))


bfs(0,0)
print(result[H-1][W-1])