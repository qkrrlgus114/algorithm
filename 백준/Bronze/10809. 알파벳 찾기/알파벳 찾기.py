import sys

word = list(sys.stdin.readline().strip())

temp = 0

count = [-1] * 27
for i in word:
    if count[ord(i) - 97] == -1:
        count[ord(i) - 97] = temp
    temp += 1

for i in range(26):
    print(count[i], end=" ")