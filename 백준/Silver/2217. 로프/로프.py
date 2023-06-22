import sys

N = int(sys.stdin.readline().strip())
arr = []
for i in range(N):
  arr.append(int(sys.stdin.readline().strip()))
  
arr.sort(reverse=True)
result = []
for i in range(N):
  result.append(arr[i] * (i+1))

print(max(result))