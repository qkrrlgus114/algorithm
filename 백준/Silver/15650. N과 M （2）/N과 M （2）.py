import sys

def back(start):
    global result
    #종료
    if len(result) == M:
        for i in range(len(result)):
            print(result[i], end=" ")
        print()
        return
    
    #재귀
    for i in range(start, N+1):
        if i not in result:
            result.append(i)
            back(i+1)
            result.pop()

N, M = map(int, sys.stdin.readline().strip().split())

result = []
back(1)