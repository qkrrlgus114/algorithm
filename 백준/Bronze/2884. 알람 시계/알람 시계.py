hour, min = map(int, input().split())
if min < 45:
  min = 60 + min - 45
  if hour==0:
    hour = 23
  else:
    hour -= 1
else:
  min -= 45

print(hour, min)