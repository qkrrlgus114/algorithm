# 1. 오름차순 기준으로 정렬

import sys

N = int(sys.stdin.readline())
arr = list(map(int ,sys.stdin.readline().split()))

# 정렬
arr.sort()

count = 0
result = 0

for i in range(N):
    count += arr[i]
    result += count
print(result)