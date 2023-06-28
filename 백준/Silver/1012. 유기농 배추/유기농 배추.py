import sys
from collections import deque

def bfs(y, x):
    global ground, visited
    q = deque() # 먼저 큐를 만들고
    q.append((y,x)) # 큐에 좌표를 넣는다.
    visited[y][x] = True # 해당 큐 방문했으니 체크로 만들어주고
    ground[y][x] = 2 # 땅도 2로 바꿔서 다시 탐색 못하게 바꾼다
    while q: # 큐가 없을 때까지
        y, x = q.popleft() # 큐에서 빼내고
        for i in range(4): # 사방탐색을 돌린다.
            idx = x + dx[i]
            idy = y + dy[i]
            if idx>=0 and idx < W and idy>=0 and idy<H: # 범위 내에 있고
                if ground[idy][idx] == 1 and not visited[idy][idx]: # 아직 1이면서 방문하지 않았으면
                    visited[idy][idx] = True # 방문표시 하고
                    ground[idy][idx] = 2 # 재방문 못하게 2로 바꾸고
                    q.append((idy,idx)) # 큐에 추가해준다
                    

T = int(sys.stdin.readline()) # 테스트케이스
# 사방탐색 (상,우,하,좌)
dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

for _ in range(T):
    # 가로, 세로, 배추개수 입력
    W, H, item = map(int, sys.stdin.readline().strip().split())
    # 땅 0으로 초기화
    ground = [[0] * (W) for _ in range(H)]
    # 방문체크 배열 False로 초기화
    visited = [[False] * (W) for _ in range(H)]
    # 총 필요한 지렁이의 개수
    count = 0
    # 배추 있는 땅 1로 입력받기
    for i in range(item):
        a, b = map(int, sys.stdin.readline().strip().split())
        ground[b][a] = 1
    for i in range(H):
        for j in range(W):
            if ground[i][j] == 1: # 해당 땅이 1이면
                bfs(i, j) # bfs 돌고
                count+=1 # 지렁이 +1 해줌
    print(count)