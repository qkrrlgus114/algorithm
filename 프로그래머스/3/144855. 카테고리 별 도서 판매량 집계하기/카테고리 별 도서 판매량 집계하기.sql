# 2022년 1월 카테고리별 도서 판매량 합산
# 카테고리명 기준 오름차순

select b.category, sum(bs.sales) as TOTAL_SALES
from book as b
inner join book_sales as bs
on b.book_id = bs.book_id
where bs.sales_date like '2022-01%'
group by b.category
order by b.category asc