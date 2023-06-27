import sys
from collections import deque

def bfs(y, x):
    global visited, map, dx, dy
    q = deque() # 우선 큐를 생성
    q.append((y,x)) # 큐에 좌표를 집어넣음.
    visited[y][x] = True # 해당 좌표는 들렸으니 True로 바꿔주고
    count = 1 # 단지내의 집의 수를 세기 위한 카운트
    while q:
        y, x = q.popleft() # 우선 두 개의 좌표를 꺼내고
        for i in range(4): # 사방탐색을 위해 새로운 값 생성
            idx = x + dx[i]
            idy = y + dy[i]
            if idx >= 0 and idx < V and idy >= 0 and idy < V: # 맵의 크기를 초과하지 않고
                if not visited[idy][idx] and map[idy][idx] == "1": # 해당 좌표가 1이면서 아직 False면
                    count+=1 # 단지의 개수 하나 더해주고
                    q.append((idy,idx)) # 해당 좌표 큐에 추가해줌
                    visited[idy][idx] = True # 그리고 방문표시 해줌
    return count # 마지막에 단지내의 집의 수 리턴
    

V = int(sys.stdin.readline()) # 맵의 크기를 받음
map = [[] for _ in range(V)] # 맵을 생성해서
# 맵을 집어넣음
for i in range(V):
    map[i] = list(sys.stdin.readline().strip())

# 2차 방문체크 visited 생성(전부 False)
visited = [[False] * V for _ in range(V)]

# 상우하좌 순서로 탐색 배열 생성
dx = [0, 1, 0, -1]
dy = [-1, 0, 1 ,0]

result = [] # 정답을 넣을 배열

for i in range(V):
    for j in range(V):
        if map[i][j] == "1" and not visited[i][j]: # 해당 좌표가 1이면서 아직 미방문이면
            result.append(bfs(i,j)) # result에 bfs값의 결과를 넣는다.(그러면 단지내의 집의 수가 들어감)

result.sort()
print(len(result))
for i in range(len(result)):
    print(result[i])