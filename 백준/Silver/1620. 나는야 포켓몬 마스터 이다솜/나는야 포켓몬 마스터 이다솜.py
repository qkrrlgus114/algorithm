import sys

N, M =map(int,sys.stdin.readline().strip().split())
arr = dict()
temp = 1
for i in range(N):
  a = sys.stdin.readline().strip()
  arr[a] = temp
  arr[temp] = a
  temp+=1
for i in range(M):
  b = sys.stdin.readline().strip()
  if b.isdigit():
    print(arr[int(b)])
  else:
    print(arr[b])