import sys

A, B = map(int, sys.stdin.readline().strip().split())
N = int(sys.stdin.readline())
arr = []
for i in range(N):
  arr.append(int(sys.stdin.readline()))

temp = abs(A - B)

flag = True
for i in range(N):
  if temp > abs(arr[i] - B):
    flag = False
    temp = abs(arr[i] - B)

if not flag:
  print(temp+1)
else:
  print(temp)