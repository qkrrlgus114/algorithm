import sys

N = list(map(int,sys.stdin.readline().strip()))

N.sort(reverse=True)
temp = ""
for i in range(len(N)):
  temp+=str(N[i])
result = int(temp)
if result%30 == 0:
  print(result)
else:
  print(-1)