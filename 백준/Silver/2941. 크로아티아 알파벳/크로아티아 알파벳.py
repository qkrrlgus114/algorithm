word = ["c=","c-","dz=","d-","lj","nj","s=","z="]
check_word = input()
for i in word:
  check_word = check_word.replace(i,'.')

print(len(check_word))