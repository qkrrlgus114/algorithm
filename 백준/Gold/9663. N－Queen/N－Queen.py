import sys

N = int(sys.stdin.readline()) # 체스판

result = 0

# 위 확인 배열
upper = [0] * N
# 왼쪽 대각선 위
left_upper = [0] * (2 * N - 1)
# 오른쪽 대각선 위
right_upper = [0] * (2 * N - 1)
def back(queen):
  global result, q_map
  # 종료
  # 1. 퀸을 다 썼으면 종료
  if queen == N:
    result += 1
    return
  

  # 재귀
  for j in range(N):
    if check(queen, j):
      upper[j] = 1
      left_upper[queen + j] = 1
      right_upper[queen - j + (N - 1)] = 1
      back(queen+1)
      upper[j] = 0
      left_upper[queen + j] = 0
      right_upper[queen - j + (N - 1)] = 0
      
def check(y, x):
  # 위 확인
  if upper[x] == 1:
    return False
  
  # 왼쪽 대각선
  if left_upper[y + x] == 1:
    return False
  
  # 오른쪽 대각선
  if right_upper[y - x + (N - 1)] == 1: 
    return False
  
  return True


back(0)
print(result)