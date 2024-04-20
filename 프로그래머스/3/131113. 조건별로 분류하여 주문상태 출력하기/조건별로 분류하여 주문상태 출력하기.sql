# 5월 1일 기준
# 주문id, 제품id, 출고일자, 출고여부 조회
# 출고여부 5월 1일까지는 '출고완료', 이후는 '출고 대기',, 미정은 '출고미정'
# 주문 id 기준 오름차순

select order_id, product_id, date_format(out_date, '%Y-%m-%d') as out_date, case when out_date <= '2022-05-01' then '출고완료' when out_date > '2022-05-01' then '출고대기' else '출고미정' end as '출고여부'
from food_order
order by order_id asc