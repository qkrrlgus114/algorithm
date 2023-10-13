import sys

N = list(sys.stdin.readline().strip())

temp = []

for i in range(len(N)):
    temp.append(int(N[i]))

temp.sort(reverse=True)
for i in range(len(temp)):
    print(temp[i], end="")