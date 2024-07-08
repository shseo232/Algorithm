-- 코드를 입력하세요
SELECT
    BOARD_ID,WRITER_ID,TITLE,PRICE,
    (
        CASE
        WHEN STATUS = 'DONE' then '거래완료'
        WHEN STATUS = 'RESERVED' then '예약중'
        ELSE '판매중'
        END
    ) as STATUS
FROM
    USED_GOODS_BOARD 
WHERE
    CREATED_DATE like '2022-10-05'
ORDER BY BOARD_ID DESC