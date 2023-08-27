# 1. 현재 위치 이후보다 저렴한 곳이 있으면 거기까지 기름을 구매.
# 2. 기름 가격중에서 가장 저렴한 곳을 잡아놓고 현재 위치가 거기에 오면 남은 기름 전부 구매


import sys

N = int(sys.stdin.readline())
dis = list(map(int, sys.stdin.readline().split()))
oil_price = list(map(int,sys.stdin.readline().split()))

result = 0
cur_oil_price = oil_price[0]

for i in range(N - 1):
    if cur_oil_price > oil_price[i]:
        cur_oil_price = oil_price[i]
    result += dis[i] * cur_oil_price

print(result)