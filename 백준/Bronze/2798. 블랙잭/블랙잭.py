N, M = map(int,input().split())
arr = list(map(int, input().split()))
arr.sort()
a,b,c = 0, 0, 0
flag = True
sum = 0
for i in range(len(arr)-2):
  for j in range(i+1,len(arr)-1):
    for k in range(j+1, len(arr)):
      if arr[i]+arr[j]+arr[k] == M:
        sum = M
        flag = False
        break
      elif arr[i]+arr[j]+arr[k] > M:
        break
      if sum < arr[i]+arr[j]+arr[k]:
        sum = arr[i]+arr[j]+arr[k]
    if flag==False:
      break
  if flag==False:
    break

print(sum)