import sys

N = int(sys.stdin.readline())

arr = list(map(int, sys.stdin.readline().split()))

result1 = 0
result2 = 0
p = 0
for i in range(N):
    if arr[i] % 2 == 1:
        p += 1
    else:
        result1 += p

arr.reverse()

p = 0

for i in range(N):
    if arr[i] % 2 == 1:
        p += 1
    else:
        result2 += p
        
print(min(result1, result2))