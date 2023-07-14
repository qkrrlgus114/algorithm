import sys

N = int(sys.stdin.readline())
A, B = map(int, sys.stdin.readline().strip().split())
dough = int(sys.stdin.readline())
topping = []
for _ in range(N):
  topping.append(int(sys.stdin.readline()))

topping.sort(reverse=True) # 역정렬
price = A
cal = dough
result = cal / price

for i in range(len(topping)):
  if result < (cal + topping[i]) / (price + B):
    cal += topping[i]
    price += B
    result = cal / price
  else:
    break
  
print(int(result))
