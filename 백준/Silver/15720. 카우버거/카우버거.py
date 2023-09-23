import sys

B, S, D = map(int, sys.stdin.readline().split())

bu = list(map(int, sys.stdin.readline().split()))
si = list(map(int, sys.stdin.readline().split()))
dr = list(map(int, sys.stdin.readline().split()))

min_size = min(len(bu), len(si), len(dr))
before = 0
after = 0

bu.sort(reverse=True)
si.sort(reverse=True)
dr.sort(reverse=True)

for i in range(len(bu)):
    before += bu[i]
for i in range(len(si)):
    before += si[i]
for i in range(len(dr)):
    before += dr[i]

for j in range(min_size):
    bu[j] *= 0.9
    si[j] *= 0.9
    dr[j] *= 0.9

for i in range(len(bu)):
    after += bu[i]
for i in range(len(si)):
    after += si[i]
for i in range(len(dr)):
    after += dr[i]

print(before)
print(round(after))