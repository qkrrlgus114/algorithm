import sys

N = int(sys.stdin.readline())
arr1 = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())
arr2 = list(map(int, sys.stdin.readline().split()))

arr1.sort()

def binary_search(target, arr1):
    start = 0
    end = len(arr1) - 1
    
    while start <= end:
        mid = (start + end) // 2
        
        if arr1[mid] == target:
            return 1
        elif arr1[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return 0

for i in range(len(arr2)):
    value = binary_search(arr2[i], arr1)
    print(value)