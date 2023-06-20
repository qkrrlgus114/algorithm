import sys
from collections import deque

card = deque()

N = int(sys.stdin.readline().strip())
for i in range(1, N+1):
  card.append(i)

while len(card)>1:
  card.popleft()
  temp = card.popleft()
  card.append(temp)
  
print(card[0])