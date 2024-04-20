# 완료 된 거래
# 총 금액 70만원 이상
# 회원 id, 닉네임, 총거래금액
# 총거래금액 기준 오름차순

select b.writer_id, u.nickname, sum(b.price) as TOTAL_SALES
from USED_GOODS_BOARD as b
inner join USED_GOODS_USER as u
on b.writer_id = u.user_id
where b.status = 'DONE'
group by b.writer_id, u.nickname
having sum(b.price) >= 700000
order by TOTAL_SALES asc