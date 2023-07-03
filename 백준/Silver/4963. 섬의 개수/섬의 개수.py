import sys
from collections import deque

def bfs(y, x):
  global ground, visited
  q = deque()
  q.append((y,x))
  # 상 우상 우 우하 하 좌하 좌 좌상 
  dx = [0, 1, 1, 1, 0, -1, -1, -1]
  dy = [-1, -1, 0, 1, 1, 1, 0, -1]
  while q:
    y, x = q.popleft()
    for i in range(8):
      idy = y + dy[i]
      idx = x + dx[i]
      if idx < W and idx >= 0 and idy < H and idy >= 0: # 범위 안에 있고
        if not visited[idy][idx] and ground[idy][idx] == 1: # 방문하지 않았고 1이면
          q.append((idy,idx))
          visited[idy][idx] = True
    
    

while True:
  W, H = map(int, sys.stdin.readline().strip().split())
  if W == 0 and H == 0:
    break
  ground = [] # 섬과 바다
  visited = [[False] * W for _ in range(H)] # 방문체크
  # 입력 받기
  for i in range(H):
    ground.append(list(map(int, sys.stdin.readline().strip().split())))
  
  count = 0 # 섬의 개수
  for i in range(H):
    for j in range(W):
      if ground[i][j] == 1 and not visited[i][j]: # 해당 위치가 방문하지 않았고 1이면
        visited[i][j] = True
        bfs(i,j)
        count+=1 # 섬의 개수 +1해줌
  print(count)