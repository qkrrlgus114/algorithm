def solution(strings, n):
    # 해당 인덱스 기준으로 정렬을 해야함
    # 근데 동일한 문자가 있을 경우 사전순으로 정렬.
    arr = []
    strings.sort()
    
    new_word = []
    for string in strings:
        new_word.append(string[n])
    
    new_word.sort()
    
    for i in new_word:
        for string in strings:
            if i == string[n] and string not in arr:
                arr.append(string)
                
    return arr
    
    