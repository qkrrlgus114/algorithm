# 자동차 종류 '세단'
# 10월 대여 시작 기록
# 자동차 id 리스트는 중복 없음, id 내림차순

select distinct(c.car_id)
from CAR_RENTAL_COMPANY_CAR as c
inner join CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
on c.car_id = h.car_id
where c.car_type = '세단' and h.start_date like '2022-10%'
order by c.car_id desc
