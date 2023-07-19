import sys

T = int(sys.stdin.readline())
for _ in range(T):
  candy, box = map(int, sys.stdin.readline().strip().split())
  box_size = []
  for i in range(box):
    a, b = map(int, sys.stdin.readline().strip().split())
    box_size.append(a*b)
  box_size.sort(reverse=True)
  count = 1
  for i in range(box):
    if candy <= box_size[i]:
      print(count)
      break
    else:
      candy -= box_size[i]
      count+=1
  