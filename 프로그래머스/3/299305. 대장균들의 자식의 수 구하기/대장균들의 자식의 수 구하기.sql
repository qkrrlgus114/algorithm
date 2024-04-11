# ID, 자식의 수 출력
# 자식이 없다면 0으로 출력
# ID 오름차순

select A.ID, count(B.ID) AS CHILD_COUNT
from ECOLI_DATA A
left join ECOLI_DATA B
on A.ID = B.PARENT_ID
group by A.ID
order by A.ID;