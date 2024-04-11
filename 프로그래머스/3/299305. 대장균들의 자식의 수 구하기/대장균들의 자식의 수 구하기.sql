# ID, 자식의 수 출력
# 자식이 없다면 0으로 출력

select A.ID, count(B.PARENT_ID) AS CHILD_COUNT
from ECOLI_DATA A
left join ECOLI_DATA B
on A.ID = B.PARENT_ID
group by A.ID
order by A.ID;