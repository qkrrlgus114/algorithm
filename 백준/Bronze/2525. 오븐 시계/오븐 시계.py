hour, min = map(int, input().split())
time = int(input())
temp = 0
if min+time < 60:
  min = min+time
else:
  temp = (min+time)//60
  min = (min+time)%60

hour+=temp
if hour > 23:
  hour-=24
print(hour, min)