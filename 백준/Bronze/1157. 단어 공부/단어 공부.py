word = input().upper()
word_list = list(set(word))
result = []
for i in word_list:
  result.append(word.count(i))

max_count = result.count(max(result))
if max_count >=2: print('?')
else: print(word_list[result.index(max(result))])