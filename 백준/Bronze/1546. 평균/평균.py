num = int(input())
arr = list(map(int, input().split()))
pointMax = max(arr)
for i in range(0, len(arr)):
  arr[i] = arr[i]/pointMax*100

pointSum = sum(arr)
print(pointSum/num)