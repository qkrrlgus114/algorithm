# 보호 시작일 > 입양일
# 아이디, 이름
# 보호 시작일 빠른 순

SELECT AI.ANIMAL_ID, AI.NAME
FROM ANIMAL_INS AI
INNER JOIN ANIMAL_OUTS AO ON AI.ANIMAL_ID = AO.ANIMAL_ID
WHERE AI.DATETIME > AO.DATETIME
ORDER BY AI.DATETIME
