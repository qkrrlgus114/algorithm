# N개의 줄에 사탕의 색상이 주어진다
# 빨간색 C, 파란색 P, 초록색 Z, 노란색 Y

import sys

result = 0

def check_graph(graph):
    
    global result
    
    temp = graph[0][0]
    count = 0
    
    for i in range(N):
        count = 0
        temp = graph[i][0]
        for j in range(N):
            if graph[i][j] == temp:
                count += 1
            else:
                temp = graph[i][j]
                count = 1
            result = max(result, count)
                
        count = 0
        temp = graph[0][i]
        for j in range(N):
            if graph[j][i] == temp:
                count += 1
            else:
                temp = graph[j][i]
                count = 1
            result = max(result, count)

N = int(sys.stdin.readline())

graph = []
for i in range(N):
    graph.append(list(sys.stdin.readline().strip()))

# 우 하
dx = [1, 0]
dy = [0, 1]

for i in range(N):
    for j in range(N):
        for k in range(2):
            ndx = dx[k] + j
            ndy = dy[k] + i
            if 0 <= ndx < N and 0 <= ndy < N:
                temp = graph[ndy][ndx]
                graph[ndy][ndx] = graph[i][j]
                graph[i][j] = temp
                check_graph(graph)
                temp = graph[ndy][ndx]
                graph[ndy][ndx] = graph[i][j]
                graph[i][j] = temp
                
                
print(result)