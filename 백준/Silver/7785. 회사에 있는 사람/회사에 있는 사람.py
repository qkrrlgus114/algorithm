import sys

N = int(sys.stdin.readline().strip())
names = set()
for i in range(N):
  name, check = sys.stdin.readline().split()
  if name in names:
    names.remove(name)
  else:
    names.add(name)
    
name_list = list(names)
name_list.sort(reverse=True)
for i in name_list:
  print(i)