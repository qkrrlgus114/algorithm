import sys

N = int(sys.stdin.readline())
arr1 = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())
arr2 = list(map(int, sys.stdin.readline().split()))
dict = {}

arr1.sort()

for i in range(len(arr1)):
    if arr1[i] in dict:
        temp = dict.get(arr1[i]) + 1
        dict[arr1[i]] = temp
    else:
        dict[arr1[i]] = 1

for i in range(len(arr2)):
    if arr2[i] in dict:
        print(dict.get(arr2[i]), end=" ")
    else:
        print(0, end=" ")