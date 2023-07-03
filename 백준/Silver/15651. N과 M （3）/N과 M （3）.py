import sys

def back():
    global result
    #종료
    if len(result) == M:
        for i in range(len(result)):
            print(result[i], end=" ")
        print()
        return
    
    #재귀
    for i in range(1, N+1):
            result.append(i)
            back()
            result.pop()

N, M = map(int, sys.stdin.readline().strip().split())

result = []
back()