-- 코드를 입력하세요
SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE
FROM BOOK
WHERE PUBLISHED_DATE >= '20210101' 
AND PUBLISHED_DATE < '20220101'
AND CATEGORY = '인문'
ORDER BY PUBLISHED_DATE ASC