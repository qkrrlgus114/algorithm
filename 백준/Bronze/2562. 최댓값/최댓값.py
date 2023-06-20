import sys

arr = []
for i in range(9):
  arr.append(int(sys.stdin.readline().strip()))

max_value = 0
idx = 0
for i in range(9):
  if max_value < arr[i]:
    max_value = arr[i]
    idx = i+1
    
print(max_value)
print(idx)