arr = list(map(int, input().split()))
check = [1,1,2,2,2,8]
result = []
for i in range(len(arr)):
  print(check[i] - arr[i], end=' ')