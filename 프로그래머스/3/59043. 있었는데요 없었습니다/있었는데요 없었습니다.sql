# 보호 시작일 > 입양일
# 아이디, 이름 조회
# 보호 시작일 오름차순

SELECT AI.ANIMAL_ID, AI.NAME
FROM ANIMAL_INS AS AI
INNER JOIN ANIMAL_OUTS AS AO
ON AI.ANIMAL_ID = AO.ANIMAL_ID
WHERE AI.DATETIME > AO.DATETIME
ORDER BY AI.DATETIME ASC