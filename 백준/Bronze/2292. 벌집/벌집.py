num = int(input())
base = 6
count = 0
sum = 1
if num == 1:
  print(1)
else:
  while True:
    if num <= sum:
      break
    sum += base
    base += 6
    count += 1
  print(count+1)