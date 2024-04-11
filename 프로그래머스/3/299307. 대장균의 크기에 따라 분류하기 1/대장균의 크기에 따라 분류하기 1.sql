# 아 하기 싫다
# 크기 100 이하 'LOW', 100 초과 1000 이하 'MEDIUM', 1000 초과 'HIGH'
# 개체 ID, SIZE 출력
# 개체 ID 오름차순

select ID, case when SIZE_OF_COLONY <= 100 then 'LOW' when SIZE_OF_COLONY > 100 and SIZE_OF_COLONY <= 1000 then 
'MEDIUM' else 'HIGH' end as SIZE 
from ECOLI_DATA
order by ID;