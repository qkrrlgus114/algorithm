# 종류 = 세단
# 10월 대여 시작 기록
# ID 중복 없음

SELECT DISTINCT(CRCC.CAR_ID)
FROM CAR_RENTAL_COMPANY_CAR CRCC
INNER JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY CRCRH
ON CRCC.CAR_ID = CRCRH.CAR_ID
WHERE CRCC.CAR_TYPE = '세단'
AND CRCRH.START_DATE >= '2022-10-01'
ORDER BY CAR_ID DESC
