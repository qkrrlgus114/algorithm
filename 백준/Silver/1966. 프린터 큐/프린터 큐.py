import sys
from collections import deque

T = int(sys.stdin.readline().strip())

for _ in range(T):
  N, M = map(int,sys.stdin.readline().strip().split())

  q = deque(list(map(int,sys.stdin.readline().strip().split())))
  count = 1
  while len(q)>0:
    max_value = max(q)
    temp = q.popleft()
    if M==0:
      if temp >= max_value:
        print(count)
        break
      elif temp < max_value:
        q.append(temp)
        M = len(q)-1
    else:
      if temp >= max_value: # 뽑아낸 값이 크면
        M-=1
        count += 1
      elif temp < max_value: # 뽑아낸 값이 작으면 뒤로
        q.append(temp)
        M-=1