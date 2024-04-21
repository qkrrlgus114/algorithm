# 공간을 둘 이상 등록한 사람
# 공간의 정보를 아이디 순으로

select *
from places
where host_id in (select host_id
    from places
    group by host_id 
    having count(host_id) >= 2)
order by id asc

