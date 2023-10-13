import sys
import copy

N = int(sys.stdin.readline())
graph = [[] * 2 for _ in range(N)]

rank = []
result = []

for i in range(N):
    graph[i] = list(map(int, sys.stdin.readline().split()))
    
for i in range(N):
    count = 0
    kg = graph[i][0]
    cm = graph[i][1]
    for j in range(N):
        if kg < graph[j][0] and cm < graph[j][1]:
            count += 1
    rank.append(count+1)
    
for i in range(N):
    print(rank[i], end=" ")