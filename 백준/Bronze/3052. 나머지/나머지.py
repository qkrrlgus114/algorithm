arr = []
for i in range(0,10):
  arr.append(int(input())%42)

temp = set(arr)
print(len(temp))