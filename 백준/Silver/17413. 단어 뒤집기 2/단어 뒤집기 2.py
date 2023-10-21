import sys

string = list(sys.stdin.readline().strip())
# '<'시작하는지 판단해야함.
# '<'로 시작했으면 '>'까지 temp에 임시 저장
# '>' 만났으면 temp에 있는 거 거꾸로 뒤집에서 결과배열에 추가. 이후 초기화
# '<'를 만났는지 판단하기 위한 check boolean 추가

check = False
temp = []
result = []

for i in string:

    if check == True:
        if i == '>':
            check = False
            for j in temp:
                result.append(j)
            result.append(i)
            temp.clear()
        else:
            temp.append(i)
    else:
        if i == '<':
            if len(temp) != 0:
                temp.reverse()
                for j in temp:
                    result.append(j)
                temp.clear()
            check = True
            result.append(i)
        if check == False and i == ' ':
            temp.reverse()
            for j in temp:
                result.append(j)
            temp.clear()
            result.append(i)
        elif check == False:
            temp.append(i)
    
    
temp.reverse()
for j in temp:
    result.append(j)

for i in result:
    print(i, end="")