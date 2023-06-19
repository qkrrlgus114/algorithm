N = int(input())

arr = []
while N>0:
  arr.append(N%10)
  N = N//10
  
arr.sort(reverse=True)
for i in range(len(arr)):
  print(arr[i], end="")