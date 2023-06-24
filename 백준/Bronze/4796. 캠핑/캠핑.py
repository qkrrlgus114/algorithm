import sys
cnt = 1
while True:
  L, P, V = map(int,sys.stdin.readline().strip().split())
  if L == 0 and P == 0 and V == 0:
    break
  count = 0
  while True:
    if V - L < 0:
      count+=V
      break
    else:
      V -= L
      count+=L
      if V - (P - L) < 0:
        break
      else:
        V -= P - L
  result = "Case "+str(cnt)+": "+str(count)
  print(result)
  cnt+=1