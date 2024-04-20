# 입양 간 기록은 있는데
# 보호소에 들어온 기록이 없는 
# 동물 id, 이름 id

select ao.animal_id, ao.name
from ANIMAL_OUTS as ao
left join ANIMAL_INS as ai
on ao.animal_id = ai.animal_id
where ai.datetime is null