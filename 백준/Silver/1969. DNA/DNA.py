import sys
from collections import deque

N, M = map(int,sys.stdin.readline().strip().split())

dna = deque()
result = ""
dna_a = deque([0, 0, 0, 0])
distance = 0
max = 0
index = 0

for i in range(N):
  dna.append(list(sys.stdin.readline().strip()))



for i in range(M):
  for j in range(N):
    if dna[j][i] == "A": dna_a[0]+=1
    elif dna[j][i] == "C": dna_a[1]+=1
    elif dna[j][i] == "G": dna_a[2]+=1
    elif dna[j][i] == "T": dna_a[3]+=1
  for i in range(4):
    if max < dna_a[i]:
      max = dna_a[i]
      index = i
  distance += N-max
  if index==0: result += "A"
  elif index==1: result += "C"
  elif index==2: result += "G"
  elif index==3: result += "T"
  dna_a = deque([0, 0, 0, 0])
  max = 0
  
print(result)
print(distance)