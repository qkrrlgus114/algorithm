# 10cm 이하는 길이 null, length에 null만 있는 경우 없음.
# 평균 길이가 33cm 이상
# 물고기 종류별로 구분
# 물고기 종류 오름차순
# 10cm이하는 10cm로 취급해서 평균 길이


select count(fish_type) as FISH_COUNT, max(length) as MAX_LENGTH, fish_type
from fish_info
where fish_type in (select fish_type
    from fish_info
    group by fish_type
    having avg(ifnull(length, 10)) >= 33
    )
group by fish_type
order by fish_type asc

