# 물고기의 종류 별 물고기 이름, 잡은 수 출력
# 잡은 수 기준 내림차순

SELECT COUNT(*) AS FISH_COUNT, FNI.FISH_NAME
FROM FISH_INFO AS FI
INNER JOIN FISH_NAME_INFO AS FNI
ON FI.FISH_TYPE = FNI.FISH_TYPE
GROUP BY FI.FISH_TYPE, FNI.FISH_NAME
ORDER BY FISH_COUNT DESC