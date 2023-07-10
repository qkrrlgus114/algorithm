import sys
from collections import deque

N = int(sys.stdin.readline())

arr = deque(map(int, sys.stdin.readline().strip().split()))

temp = deque(sorted(arr))

while len(temp) != 1:
    temp_value = temp.popleft()
    temp[len(temp) - 1] += temp_value / 2

if temp[0] % 2 == 0:
    print(int(temp[0]))
else:
    print(temp[0])