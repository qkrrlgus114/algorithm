import sys

input = [] # 입력 배열
TC = 1 # 테케
while True: # 우선 무한으로 돌린 다음에
  input = list(sys.stdin.readline().strip()) # 입력을 하나 받고
  if input[0] == "-": break # 첫 번째가 "-"로 시작하면 끝
  openCnt = 0 # 열린 괄호 개수
  closeCnt = 0 # 닫힌 괄호 개수
  change = 0 # 바뀐 횟수
  for i in range(len(input)): 
    if input[i] == "{": # 만약에 열렸으면 +1
      openCnt+=1
    else: # 닫혔으면
      if openCnt > closeCnt: closeCnt+=1 # 열린 괄호가 많으면 닫힌 괄호 +1
      else: # 열린 괄호 <= 닫힌 괄호 상태면 무조건 열려야 다음이 이어지니
        openCnt+=1 # 열린 괄호 +1
        change+=1 # 바뀐 횟수 +1(즉 바뀌었다고 표시)
  if openCnt > closeCnt: # 다 끝나고 열린 괄호가 많으면
    change += (openCnt - closeCnt)//2 # 계산해서
  print(str(TC)+". "+str(change)) # 출력
  TC+=1