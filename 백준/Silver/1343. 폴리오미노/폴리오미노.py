import sys

check = list(sys.stdin.readline().strip())
result = ""
count = 0
flag = True
def func(result, count):
    if count == 2:
      result += "BB"
    elif count >= 4 and count % 4 == 0:
      result += "AAAA" * (count//4)
    elif count >= 4 and count % 4 == 2:
      result += "AAAA" * (count//4)
      result += "BB"
    return result

for i in range(len(check)):
  if check[i] == ".":
    if count % 2 == 1: 
        flag = False 
    if count != 0:
      result = func(result, count)
      count = 0
      result += "."
    else:
      result += "."
  else: count+=1
if count == 1: flag = False
if count % 2 == 1: 
        flag = False
if flag == False:
  print(-1)
else:
  result = func(result, count)
  print(result)