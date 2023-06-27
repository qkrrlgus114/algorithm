import sys

N = int(sys.stdin.readline())
dasom = int(sys.stdin.readline()) # 다솜이
candidate = [] # 후보자들 

for _ in range(N-1):
  candidate.append(int(sys.stdin.readline()))
  
count = 0 # 다솜이가 추가로 얻은 표

candidate.sort(reverse=True) # 가장 큰 표가 앞으로
if N == 1:
  print(count)
else:
  while candidate[0] >= dasom:
    candidate[0] -= 1
    dasom += 1
    count += 1
    candidate.sort(reverse=True) # 다시 역정렬
  print(count)