def solution(s):
    max_value = -1000000000
    min_value = 1000000000
    temp_idx = 0
    value = 0
    for i in range(len(s)):
        if i == len(s) - 1:
            value = int(s[temp_idx : i + 1])
            if max_value < value:
                max_value = value
            if min_value > value:
                min_value = value
        elif s[i] == " ":
            value = int(s[temp_idx : i])
            temp_idx = i + 1
            if max_value < value:
                max_value = value
            if min_value > value:
                min_value = value
    
    arr = str(min_value)+" "+str(max_value)
    return arr
        