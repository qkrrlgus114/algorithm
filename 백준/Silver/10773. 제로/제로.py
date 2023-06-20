import sys

result = []

N = int(sys.stdin.readline().strip())

for i in range(N):
  temp = int(sys.stdin.readline().strip())
  if temp == 0:
    result.pop(-1)
  else:
    result.append(temp)
    
sum = 0
for i in range(len(result)):
  sum+=result[i]
  
print(sum)