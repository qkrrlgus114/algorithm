N, M = map(int, input().split())
arr1 = [[0 for i in range(M)] for j in range(N)]
arr2 = [[0 for i in range(M)] for j in range(N)]

for i in range(N):
  arr1[i] = list(map(int,input().split()))

for i in range(N):
  arr2[i] = list(map(int,input().split()))

for i in range(N):
  for j in range(M):
    print(arr1[i][j] + arr2[i][j], end=" ")
  print()