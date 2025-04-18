# 조회수가 가장 높은 게시글 첨부파일
# FILD ID 내림차순
# /home/grep/src/{BOARD_ID}/FILE_ID + FILE_NAME + FILE_EXT

SELECT CONCAT('/home/grep/src/', BOARD_ID, '/', FILE_ID, FILE_NAME, FILE_EXT) AS FILE_PATH
FROM USED_GOODS_FILE 
WHERE BOARD_ID = (
    SELECT BOARD_ID
    FROM USED_GOODS_BOARD 
    ORDER BY VIEWS DESC
    LIMIT 1)
ORDER BY FILE_ID DESC
