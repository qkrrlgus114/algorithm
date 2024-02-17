-- 코드를 입력하세요
SELECT B.PRODUCT_ID, A.PRODUCT_NAME, SUM(A.PRICE * B.AMOUNT) AS TOTAL_SALES
FROM FOOD_PRODUCT AS A
INNER JOIN FOOD_ORDER AS B
ON A.PRODUCT_ID = B.PRODUCT_ID
WHERE B.PRODUCE_DATE LIKE ('2022-05%')
GROUP BY B.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, B.PRODUCT_ID ASC