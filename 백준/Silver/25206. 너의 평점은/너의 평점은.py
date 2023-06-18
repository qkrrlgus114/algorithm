grade = [4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0]
rating = ["A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"]
grade_sum = 0
sub_sum = 0

for _ in range(20):
  sub = list(input().split())
  if sub[2] == 'P': continue
  grade_sum += float(sub[1])
  sub_idx = rating.index(sub[2])
  sub_sum += grade[sub_idx] * float(sub[1])

print('%.6f'%(sub_sum / grade_sum))