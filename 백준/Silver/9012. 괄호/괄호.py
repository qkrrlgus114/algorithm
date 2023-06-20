import sys

N = int(sys.stdin.readline().strip())

for i in range(N):
  stack = []
  flag = True
  temp_str = sys.stdin.readline().strip()
  for j in range(len(temp_str)):
    if temp_str[j] =='(': 
      stack.append('(')
    elif temp_str[j] == ')':
      if len(stack) == 0:
        flag = False
        break
      else:
        stack.pop(-1)
  
  if len(stack)!=0: flag=False    
  if flag==False:
    print("NO")
  else:
    print("YES")