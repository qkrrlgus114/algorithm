# 카드 합성할 때마다 두 카드 레벨의 합만큼 골드를 받는다.
# 최대한 많은 골드를 벌어야 한다.
# 가장 큰 놈들끼리 합쳐야 한다

import sys

N = int(sys.stdin.readline())

# 카드 입력 받음
card = list(map(int, sys.stdin.readline().split()))

card.sort(reverse=True)

# 전체의 합
sum = 0

for i in range(0, N-1):
    sum += card[0] + card[i+1]

print(sum)