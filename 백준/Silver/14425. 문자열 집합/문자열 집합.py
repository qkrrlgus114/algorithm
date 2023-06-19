import sys

count = 0
N,M = map(int, sys.stdin.readline().strip().split())
word = {}
for i in range(N):
  word[sys.stdin.readline().strip()] = 1
  
check_list = []
for i in range(M):
  check_list.append(sys.stdin.readline().strip())
  
for i in range(M):
  if word.get(check_list[i])==1: count+=1
print(count)