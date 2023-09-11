# 운동기구 최대 두 개 선택 가능
# 근손실 정도가 M을 넘으면 안 됨
import sys

N = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
arr.sort()

max_value = 0

if N == 1:
    max_value = arr[0]
elif N == 2:
    max_value = arr[0] + arr[1]
elif N % 2 == 1: # 홀수면
    for i in range(0, N//2):
        if max_value < arr[i] + arr[N - i - 2]:
            max_value = arr[i] + arr[N - i - 2]
else:
    for i in range(0, (N//2) - 1):
        if max_value < arr[i] + arr[N - i - 1]:
            max_value = arr[i] + arr[N - i - 1]

print(max_value)