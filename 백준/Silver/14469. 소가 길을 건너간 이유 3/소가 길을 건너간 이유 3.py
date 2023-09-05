import sys

N = int(sys.stdin.readline())
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

arr.sort()

sum = arr[0][0] + arr[0][1]

for i in range(N):
    if i == 0:
        continue
    if arr[i][0] <= sum:
        sum += arr[i][1]
    else:
        sum = arr[i][0] + arr[i][1]
        
print(sum)