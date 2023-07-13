import sys

T = int(sys.stdin.readline())

for _ in range(T):
  N = int(sys.stdin.readline())
  arr = list(map(int, sys.stdin.readline().strip().split()))
  arr.reverse() # 거꾸로 
  sum = 0 # 합계
  temp = arr[0]
  for i in range(1, len(arr)):
    if temp >= arr[i]:
      sum += temp - arr[i]
    else:
      temp = arr[i]
  
  print(sum)