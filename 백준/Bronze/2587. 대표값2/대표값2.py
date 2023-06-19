arr = []
sum = 0
for i in range(5):
  arr.append(int(input()))
  sum += arr[i]

avg = sum // 5
arr.sort()
print(avg)
print(arr[2])