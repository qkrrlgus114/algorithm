# 게시물 3건 이상 등록한
# 사용자 id, 닉네임, 전체주소, 전화번호 조회
# 회원 id 내림차순

select distinct(u.user_id), u.nickname, concat(u.city," ", u.street_address1, " ", u.street_address2) as '전체주소', 
concat(substring(u.tlno, 1, 3), "-", substring(u.tlno, 4, 4), "-", substring(u.tlno, 8, 4)) as '전화번호'
from USED_GOODS_BOARD as b
inner join USED_GOODS_USER as u
on b.writer_id = u.user_id
where b.writer_id in (select writer_id
    from USED_GOODS_BOARD 
    group by writer_id 
    having count(writer_id) >= 3)
order by u.user_id desc
