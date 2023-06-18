T = int(input())
for i in range(0,T):
  count = 0
  point = list(map(int, input().split()))
  avg = sum(point[1:])/point[0]
  for x in point[1:]:
    if avg < x: count+=1
  per = (count/point[0]*100)
  print('%.3f'%per+'%')