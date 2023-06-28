import sys

N = int(sys.stdin.readline())
line = [] # 손님들
for i in range(N):
    line.append(int(sys.stdin.readline()))
result = 0 # 최종 받을 팁

line.sort(reverse=True) # 가장 많은 팁부터 받기 위해 내림차순 정렬

for i in range(N):
    if line[i] - i >= 0:
        result += line[i] - i
print(result)