# 보호 시작일 > 입양일 
# id, 이름 조회
# 보호시작일이 빠른 순

select ai.animal_id, ai.name
from animal_ins as ai
inner join animal_outs as ao
on ai.animal_id = ao.animal_id
where ai.datetime > ao.datetime
order by ai.datetime