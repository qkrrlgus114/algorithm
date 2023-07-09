import sys
from collections import deque

T = int(sys.stdin.readline())

for i in range(T):
  N = int(sys.stdin.readline())
  card = deque(sys.stdin.readline().strip().split())
  result = deque(card.popleft())
  while len(card) > 0:
    temp = card.popleft()
    if result[0] >= temp:
      result.appendleft(temp)
    else:
      result.append(temp)
      
  for i in range(len(result)):
    print(result[i], end="")
  print()