import sys

N = int(sys.stdin.readline())
sum = 0
if N == 1 or N == 2:
  print(1)
elif N == 3:
  print(2)
else:
  for i in range(1,N):
    sum+=i
    if sum>N:
      print(i-1)
      break