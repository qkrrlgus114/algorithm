import sys

input = []
TC = 1
while True:
  input = list(sys.stdin.readline().strip())
  if input[0] == "-": break
  openCnt = 0
  closeCnt = 0
  change = 0
  for i in range(len(input)):
    if input[i] == "{":
      openCnt+=1
    else:
      if openCnt > closeCnt: closeCnt+=1
      else: 
        openCnt+=1
        change+=1
  if openCnt > closeCnt:
    change += (openCnt - closeCnt)//2
  print(str(TC)+". "+str(change))
  TC+=1