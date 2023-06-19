import sys

N = int(sys.stdin.readline().strip())
my_list = list(map(int, sys.stdin.readline().strip().split()))
my_card = {i: 1 for i in my_list}
M = int(sys.stdin.readline().strip())
check_list = list(map(int, sys.stdin.readline().strip().split()))
for i in check_list:
  if my_card.get(i) == 1:
    print(1,end=" ")
  else:
    print(0,end=" ")