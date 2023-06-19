import sys

N, M = map(int, sys.stdin.readline().strip().split())
N_set = set(map(int, sys.stdin.readline().strip().split()))
M_set = set(map(int, sys.stdin.readline().strip().split()))

N_ch = N_set.difference(M_set)
M_ch = M_set.difference(N_set)
print(len(N_ch)+len(M_ch))