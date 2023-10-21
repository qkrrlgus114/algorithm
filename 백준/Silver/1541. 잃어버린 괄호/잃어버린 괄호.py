import sys

string = sys.stdin.readline().strip()
temp = list(string.split('-'))

result = []
for i in range(len(temp)):
    temp_str = list(temp[i].split('+'))
    sum_result = 0
    if len(temp_str) != 1:
        for j in range(len(temp_str)):
            sum_result += int(temp_str[j])
    else:
        sum_result = int(temp_str[0])
    temp[i] = sum_result

final = 0
for i in range(len(temp)):
    if i == 0:
        final += temp[i]
    else:
        final -= temp[i]
print(final)