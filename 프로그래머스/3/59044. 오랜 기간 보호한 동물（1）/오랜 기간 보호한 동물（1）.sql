# 입양을 못 간 동물
# 가장 보호소에 오래 있었던 동물 3마리
# 이름, 보호 시작일
# 보호 시작일 오름차순

select ai.name, ai.datetime
from animal_ins as ai
left join animal_outs as ao
on ai.animal_id = ao.animal_id
where ao.datetime is null
order by ai.datetime asc limit 3