import sys

N = list(map(int,sys.stdin.readline().strip()))
flag = False
count = 0
for i in range(1,len(N)):
  if N[i] != N[i-1] and flag == False:
    if i == len(N)-1:
      count+=1
      break
    flag = True
    N[i] = N[i-1]
  elif flag == True and N[i] == N[i-1]:
    flag = False
    count+=1
  elif flag == True:
    if i == len(N)-1:
      count+=1
      break
    N[i] = N[i-1]
   

print(count)