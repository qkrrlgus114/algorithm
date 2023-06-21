import sys

N = int(sys.stdin.readline().strip())

def fibo(N):
  if N == 0:
    return 0
  elif N == 1:
    return 1
  return fibo(N-2) + fibo(N-1)

print(fibo(N))