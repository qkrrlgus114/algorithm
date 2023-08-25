# 동전의 개수, 총합을 입력 받음.
# 동전을 배열에 넣은 뒤 가장 큰 동전부터 차례대로 계산하면 최적의 값을 찾을 수 있음.
import sys

N, K = map(int, sys.stdin.readline().split())
coin = []
for _ in range(N):
  coin.append(int(sys.stdin.readline()))

# 가장 큰 값 부터 뽑아내기 위해서  
coin.sort(reverse=True)

# 총 동전의 개수
count = 0

for i in range(N):
  if K >= coin[i]:
    temp = K // coin[i]
    count += temp
    K %= coin[i]
    
print(count)