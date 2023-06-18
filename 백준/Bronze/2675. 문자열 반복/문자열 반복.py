T = int(input())
for i in range(T):
  num, word = input().split()
  for x in word:
    print(int(num) * x, end="")
  print()