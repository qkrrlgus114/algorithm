import sys

N = int(sys.stdin.readline())

arr = list(map(int, sys.stdin.readline().strip().split()))

curr = arr[0]
count = 0
max_value = 0
for i in range(1,N):
    if curr > arr[i]: count+=1
    else:
        if max_value < count: 
            max_value = count
        count = 0
        curr = arr[i]
        
if max_value < count:
    max_value = count
print(max_value)