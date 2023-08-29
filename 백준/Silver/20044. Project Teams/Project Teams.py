# 10000개의 정수가 주어지는데 최소를 결국 찾아야함
# 끝과 끝을 더해서 가장 최소를 찾아야함

import sys

N = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))

arr.sort()

# 최솟값
min_value = 200000

for i in range(2 * N):
    if i == (2 * N) - 1:
        break

    if min_value > arr[i] + arr[(2 * N) - i - 1]:
        min_value = arr[i] + arr[(2 * N) - i - 1]

print(min_value)