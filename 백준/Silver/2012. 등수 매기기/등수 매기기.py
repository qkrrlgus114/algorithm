import sys

N = int(sys.stdin.readline())
arr = []
for i in range(N):
    arr.append(int(sys.stdin.readline()))

arr.sort()
sum = 0
for i in range(N):
    sum += abs(arr[i] - (i + 1))

print(sum)