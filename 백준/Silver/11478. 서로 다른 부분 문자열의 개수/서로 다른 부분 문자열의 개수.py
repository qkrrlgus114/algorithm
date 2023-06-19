import sys

S = sys.stdin.readline().strip()
temp = 1
result = set()

while temp<=len(S):
  for i in range(len(S)-temp+1):
    result.add(S[i:temp+i])
  temp+=1
  
print(len(result))