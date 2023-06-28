import sys

N = int(sys.stdin.readline())
price = [] # 가격을 넣을 배열
# 가격 입력받음
for i in range(N):
    price.append(int(sys.stdin.readline()))

price.sort(reverse=True) # 제일 높은 가격을 무료로 받기 위해서 내림차순 정렬
count = 1 # 현재 몇 개를 카운트했는지(3이 되면 1로 초기화)
sum = price[0] # 처음에 0번째 가격 더해놓음
for i in range(1, N): # 0번째 더했으니 1번부터 시작
    count += 1 # 카운트 +1 해서 
    if count == 3: # 3이 되면 무료니깐 0으로 초기화 함.
        count = 0
    else: # 아니면 가격 더해줌
        sum += price[i]
print(sum)