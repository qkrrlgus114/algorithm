import sys

# 카드의 개수와 반복 횟수 입력
n, m = map(int, sys.stdin.readline().strip().split())

# 카드 입력 받음
card = list(map(int, sys.stdin.readline().strip().split()))

# m이 0이 될 때까지 반복
while m!=0:
    card.sort() # 오름차순으로 정렬
    temp = card[0] + card[1] # 두 개의 합을 구하고
    card[0] = card[1] = temp # 그 합으로 갱신
    m-=1
    
print(sum(card))