import sys

N = int(sys.stdin.readline())

for i in range(N):
  check = list(sys.stdin.readline().strip())
  sum = 0
  temp = 1
  temp_sum = 0
  for i in range(len(check)):
    if check[i] == 'O':
      temp_sum += temp
      temp += 1
    else:
      sum += temp_sum
      temp = 1
      temp_sum = 0
  if temp_sum != 0: sum+=temp_sum
  print(sum)