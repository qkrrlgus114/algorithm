import sys

N = int(sys.stdin.readline())

A = list(map(int, sys.stdin.readline().split()))
B = list(map(int, sys.stdin.readline().split()))

A.sort()

sum = 0


for i in range(len(A)):
    temp = 0
    idx = 0
    for j in range(len(B)):
        if temp < B[j]:
            temp = B[j]
            idx = j
    sum += temp * A[i]
    B[idx] = -1

print(sum)