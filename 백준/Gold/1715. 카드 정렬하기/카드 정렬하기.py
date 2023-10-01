import sys
import heapq

N = int(sys.stdin.readline())

arr = []
result = 0

for _ in range(N):
    heapq.heappush(arr, int(sys.stdin.readline()))

while len(arr) > 1:
    temp1 = heapq.heappop(arr)
    temp2 = heapq.heappop(arr)
    result += temp1 + temp2
    heapq.heappush(arr, temp1 + temp2)
    
print(result)
    