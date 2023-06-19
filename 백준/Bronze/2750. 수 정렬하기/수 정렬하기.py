def change(i, j, arr):
  temp = arr[i]
  arr[i] = arr[j]
  arr[j] = temp

N = int(input())
arr = []
for i in range(N):
  arr.append(int(input()))
  
for i in range(N-1):
  for j in range(i+1,N):
    if arr[i] > arr[j]:
      change(i,j,arr)

for i in range(N):
  print(arr[i])