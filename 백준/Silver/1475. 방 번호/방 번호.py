import sys

N = list(sys.stdin.readline().strip())

count = [0] * 10

for i in N:
    if i == '6' or i == '9':
        if count[6] < count[9]:
            count[6] += 1
        else:
            count[9] += 1
    else:
        count[int(i)] += 1

print(max(count))