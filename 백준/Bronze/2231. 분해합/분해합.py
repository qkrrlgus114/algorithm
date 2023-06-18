N = int(input())
result = 0
for i in range(N//3,N+1):
  temp = i
  sum = 0
  while i>=1:
    sum+=i%10
    i=i//10
  if sum+temp == N:
    result = temp
    break
if result!=0:
  print(result)
else:
  print(0)