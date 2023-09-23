import sys
from collections import deque

# 3가지 이동 방법이 있음
# x-1, x+1, x*2

def bfs():
    global N, K, visited
    q = deque()
    q.append((N, 0))
    while q:
        temp, count = q.popleft()
        for i in range(3):
            next_temp = temp
            if i == 0 and temp < 100000 :
                next_temp += 1
            elif i == 1 and temp >= 1:
                next_temp -= 1
            elif i == 2 and temp <= 50000:
                next_temp *= 2
            else:
                continue
                
            if visited[next_temp] == 0:
                visited[next_temp] = count + 1
                q.append((next_temp, count + 1))

                if next_temp == K:
                    break



N, K = map(int, sys.stdin.readline().split())
visited = [0 for _ in range(100001)]

visited[N] = 1

if N == K:
    print(0)
else:
    bfs()
    print(visited[K])