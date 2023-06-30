import sys

N = int(sys.stdin.readline())
arr = list(map(int,sys.stdin.readline().strip()))

sum = 0
for i in range(N):
  sum += arr[i]
print(sum)