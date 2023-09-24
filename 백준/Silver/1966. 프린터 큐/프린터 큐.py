import sys
from collections import deque

T = int(sys.stdin.readline())
for _ in range(T):
    N, target_idx = map(int, sys.stdin.readline().split())

    paper = deque(list(map(int, sys.stdin.readline().split())))
    paper_idx = deque(list(range(N)))
    cnt = 0

    while paper:
        if paper[0] == max(paper):
            cnt += 1
            paper.popleft()
            temp = paper_idx.popleft()
            if temp == target_idx:
                print(cnt)
                break
        else:
            paper.append(paper.popleft())
            paper_idx.append(paper_idx.popleft())