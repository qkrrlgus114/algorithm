import sys
from collections import deque

N = int(sys.stdin.readline())
ground = [] # 땅

# 땅을 입력 받고
for i in range(N):
  ground.append(list(map(int, sys.stdin.readline().strip().split())))

# 2차원 배열에서 최댓값을 찾는 방법
max_value = max(map(max, ground))

# 안전한 땅의 개수
safe_zone = 0

def bfs(y, x):
  global result, visited
  # 상 우 하 좌
  dx = [0, 1, 0, -1]
  dy = [-1, 0, 1, 0]
  q = deque()
  q.append((y,x))
  while q:
    y,x = q.popleft()
    visited[y][x] = True
    result[y][x] = 0 # 해당 땅을 0으로 만들어버림
    for i in range(4):
      idy = y + dy[i]
      idx = x + dx[i]
      # 범위 안에 있으면서
      if idy >= 0 and idx >= 0 and idy < N and idx < N:
        # 방문 아직 안 했고, 1이면
        if result[idy][idx] == 1 and not visited[idy][idx]:
          visited[idy][idx] = True # 방문 표시 하고
          result[y][x] = 0 # 0으로 만들고
          q.append((idy,idx)) # 큐에 집어넣음

while max_value != -1: # 맥스값부터 1씩 깎으면서 모든 경우 확인
  result = [[0] * N for _ in range(N)] # 결과를 넣을 2차 배열
  count = 0 # 현재 안전한 땅의 개수
  visited = [[False] * N for _ in range(N)] # 방문 체크
  for i in range(N):
    for j in range(N):
      if ground[i][j] <= max_value: # 해당 땅보다 낮으면
        result[i][j] = 0 # 0으로 만듦(안전X)
      else:
        result[i][j] = 1 # 아니면 1로 만듦(안전O)
  for i in range(N):
    for j in range(N):
      if result[i][j] == 1: # 안전한 땅이면 bfs
        bfs(i,j)
        count += 1 # 안전한 땅의 개수 +1
  if safe_zone < count: safe_zone = count # 최대 안전한 땅을 구함
  max_value -= 1

print(safe_zone)