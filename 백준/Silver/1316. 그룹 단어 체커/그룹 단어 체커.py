T = int(input())
total = 0
for i in range(T):
  word = input()
  count = 0
  for idx in range(0, len(word)-1):
    if word[idx] != word[idx+1]:
      new_word = word[idx+1:]
      if new_word.count(word[idx]) > 0:
        count+=1
  if count==0:
    total+=1

print(total)