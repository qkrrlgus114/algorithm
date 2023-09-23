# N개의 달걀, M명의 고객

import sys

N, M = map(int, sys.stdin.readline().split())
egg_price = []
for i in range(M):
    egg_price.append(int(sys.stdin.readline()))

max_result = 0
max_price = 0
for i in range(M):
    count = 0
    egg_count = N
    for j in range(M):
        if egg_price[i] <= egg_price[j] and egg_count != 0:
            egg_count -= 1
            count += 1

    if max_result < count * egg_price[i]:
        max_price = egg_price[i]
        max_result = count * egg_price[i]

print(max_price, max_result, end=" ")