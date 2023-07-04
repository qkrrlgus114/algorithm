import sys

arr = []
for i in range(9):
  arr.append(int(sys.stdin.readline()))

max_value = max(arr)
max_idx = arr.index(max_value)
print(max_value)
print(max_idx+1)