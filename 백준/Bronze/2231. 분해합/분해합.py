N = int(input())
result = 0
for i in range(1,N+1):
  N_sum = sum(map(int, str(i)))
  if N_sum+i == N:
    result = i
    break
if result != 0:
  print(result)
else:
  print(0)