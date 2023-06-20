import sys
from collections import deque

N = int(sys.stdin.readline().strip())
q = deque()

for i in range(N):
  temp_str = list(sys.stdin.readline().strip().split())
  if temp_str[0] == "push":
    q.append(temp_str[1])
  elif temp_str[0] == "pop":
    if len(q)>0:
      print(q.popleft())
    else:
      print(-1)
  elif temp_str[0] == "size":
    print(len(q))
  elif temp_str[0] == "empty":
    if len(q)>0:
      print(0)
    else:
      print(1)
  elif temp_str[0] == "front":
    if len(q)>0:
      print(q[0])
    else:
      print(-1)
  elif temp_str[0] == "back":
    if len(q)>0:
      print(q[-1])
    else:
      print(-1)