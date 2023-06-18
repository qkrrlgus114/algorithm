arr = [[0 for i in range(9)] for j in range(9)]
for i in range(9):
  arr[i] = list(map(int, input().split()))

max = 0
i_idx = 0
j_idx = 0
for i in range(9):
  for j in range(9):
    if max < arr[i][j]:
      max = arr[i][j]
      i_idx = i
      j_idx = j

print(max)
print(i_idx+1, j_idx+1)