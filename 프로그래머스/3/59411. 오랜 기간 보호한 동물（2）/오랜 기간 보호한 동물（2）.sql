# 입양을 간 동물 
# 보호 기간이 가장 길었던 두 마리
# 아이디, 이름 조회
# 보호 기간이 긴 순으로

select ai.animal_id, ai.name
from animal_ins as ai
inner join animal_outs as ao
on ai.animal_id = ao.animal_id
order by ao.datetime - ai.datetime desc limit 2