# 음식 종류별
# 즐겨찾기 많은 식당
# 음식 종류, id, 식당이름, 즐겨찾기 수 조회
# 음식 종류 내림차순



select r1.food_type, r1.rest_id, r1.rest_name, r1.favorites
from rest_info as r1
inner join (select food_type, max(favorites) as favorites
    from rest_info
    group by food_type) as r2
on r1.food_type = r2.food_type and r1.favorites = r2.favorites
order by r1.food_type desc