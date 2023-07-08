import sys

N, K = map(int, sys.stdin.readline().strip().split())
arr = list(map(int, sys.stdin.readline().strip().split()))

len_arr = []

for i in range(0, N-1):
  len_arr.append(abs(arr[i] - arr[i + 1]))

len_arr.sort(reverse=True)

sum = sum(len_arr[K - 1 : ])
print(sum)