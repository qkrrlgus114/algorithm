N, M = map(int, input().split())
arr = [[0 for i in range(M)] for j in range(N)]
result = []
for i in range(N):
  arr[i] = list(input())
for i in range(0,N-7):
  for j in range(0,M-7):
    count = 0
    start = ""
    start_b_count = 0
    start_w_count = 0
    for k in range(i,8+i):
      for l in range(j, 8+j):
        if (k+l)%2 == 0:
          if arr[k][l] != "B":
            start_b_count+=1
          elif arr[k][l] != "W":
            start_w_count+=1
        else:
          if arr[k][l] != "B":
            start_w_count+=1
          elif arr[k][l] != "W":
            start_b_count+=1
    result.append(min(start_b_count, start_w_count))
print(min(result))