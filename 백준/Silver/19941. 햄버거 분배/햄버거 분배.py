import sys

N, K = map(int, sys.stdin.readline().strip().split())
arr = list(sys.stdin.readline().strip())

person = 0 # 먹은 사람의 수

for i in range(N):
  if arr[i] == "P": # 만약에 해당 지점이 사람이면
    # 배열의 가능한 가장 왼쪽부터 먹어야 오른쪽 사람이 남은 걸 먹음.
    for j in range(max(0, i-K), min(N, i+K+1)):
      if arr[j] == "H": # H면 먹고
        person += 1 
        arr[j] = "E" # E로 바꿔서 먹었다고 표시
        break
      
print(person)