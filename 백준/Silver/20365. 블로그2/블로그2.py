import sys

N = int(sys.stdin.readline())
arr = list(sys.stdin.readline().strip())

paint = [0, 0] # R, B 순서
if arr[0] == 'R':
  paint[0] = 1
else:
  paint[1] = 1

for i in range(1, N):
  if arr[i] != arr[i-1]: # 두 개가 다르면
    if arr[i] == 'R':
      paint[0] += 1
    else:
      paint[1] += 1
      

print(min(paint) + 1)
  