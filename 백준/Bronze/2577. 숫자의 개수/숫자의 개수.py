import sys

a = int(sys.stdin.readline())
b = int(sys.stdin.readline())
c = int(sys.stdin.readline())
result = [0,0,0,0,0,0,0,0,0,0]
num = list(str(a*b*c))
for i in range(len(num)):
  result[int(num[i])]+=1
  
for i in range(len(result)):
  print(result[i])