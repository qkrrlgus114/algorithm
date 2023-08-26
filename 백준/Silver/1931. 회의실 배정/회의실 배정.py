import sys

N = int(sys.stdin.readline())
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

# 회의를 종료 시간 기준으로 오름차순 정렬. 종료 시간이 같으면 시작 시간으로 정렬
arr.sort(key=lambda x: (x[1], x[0]))

count = 0
current_end_time = 0

for i in range(N):
    # 현재 회의의 시작 시간이 이전에 선택한 회의의 종료 시간보다 크거나 같다면
    if arr[i][0] >= current_end_time:
        count += 1  # 회의를 선택
        current_end_time = arr[i][1]  # 선택한 회의의 종료 시간을 기록

print(count)