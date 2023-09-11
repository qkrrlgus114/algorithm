import sys

N, K = map(int, sys.stdin.readline().split())

arr = list(map(int, sys.stdin.readline().split()))

arr.sort(reverse=True)

sum = 0

for i in range(K):
    sum += arr[i] - i
    
print(sum)