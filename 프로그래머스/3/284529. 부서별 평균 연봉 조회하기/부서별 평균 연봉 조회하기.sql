# 부서별로 부서 id, 영문 부서명, 평균 연봉 조회
# 평균 연봉은 소수점 첫째 자리에서 반올림
# 평균 연봉 내림차순

select hd.dept_id, hd.dept_name_en, round(avg(he.sal), 0) as AVG_SAL
from HR_DEPARTMENT as hd
inner join HR_EMPLOYEES as he
on hd.dept_id = he.dept_id
group by hd.dept_id, hd.dept_name_en
order by AVG_SAL desc