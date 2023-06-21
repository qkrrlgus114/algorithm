import sys

N = int(sys.stdin.readline().strip())

def facto(N):
  if N == 1 or N == 0:
    return 1
  return N * facto(N-1)
  
print(facto(N))