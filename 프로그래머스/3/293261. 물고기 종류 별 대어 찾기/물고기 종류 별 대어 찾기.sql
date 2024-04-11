# 물고기 종류 별 구분
# 가장 큰 물고기 ID, 이름, 길이 출력
# ID 오름차순

select fi.id, fni.fish_name, fi.length
from fish_info fi
inner join fish_name_info fni
on fi.fish_type = fni.fish_type
where (fi.fish_type, fi.length) in(
    select fish_type, max(length)
    from fish_info
    group by fish_type
)

