import sys

N = int(sys.stdin.readline())

temp = 1
sum = 0
while True:
    
    sum += temp
    if sum > N:
        print(temp - 1)
        break
    temp += 1