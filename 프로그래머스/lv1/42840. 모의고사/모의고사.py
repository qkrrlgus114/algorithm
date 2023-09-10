def solution(answers):
    student1 = [1,2,3,4,5]
    student2 = [2,1,2,3,2,4,2,5]
    student3 = [3,3,1,1,2,2,4,4,5,5]
    
    idx1 = 0
    idx2 = 0
    idx3 = 0
    
    result = [0 ,0 ,0]
    for i in range(len(answers)):
        if i >= 5:
            idx1 = i % 5
            if i >= 8:
                idx2 = i % 8
                if i>= 10:
                    idx3 = i % 10
        if answers[i] == student1[idx1]:
            result[0] += 1
        if answers[i] == student2[idx2]:
            result[1] += 1
        if answers[i] == student3[idx3]:
            result[2] += 1
        idx1 += 1
        idx2 += 1
        idx3 += 1
            
    max_value = -1
    sum = []
    for i in range(len(result)):
        if result[i] != 0 and max_value < result[i]:
            max_value = result[i]
            sum = []
            sum.append(i + 1)
        elif result[i] != 0 and max_value == result[i]:
            sum.append(i + 1)
    
    return sum
            
            