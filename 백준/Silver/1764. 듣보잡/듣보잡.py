import sys

N, M = map(int, sys.stdin.readline().strip().split())
human = dict()
result = []
for i in range(N):
  human[sys.stdin.readline().strip()] = 1

for i in range(M):
  name = sys.stdin.readline().strip()
  temp = human.get(name)
  if temp == None:
    human[temp] = 1
  elif temp == 1:
    result.append(name)
    
result.sort()
print(len(result))
for i in range(len(result)):
  print(result[i])