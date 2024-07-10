-- 코드를 입력하세요
SELECT
    CATEGORY,PRICE as MAX_PRICE,PRODUCT_NAME
FROM
    FOOD_PRODUCT 
WHERE
    (PRICE,CATEGORY) in (SELECT 
                    MAX(PRICE),CATEGORY
                   FROM
                   FOOD_PRODUCT 
                   WHERE
                    CATEGORY like '과자' OR
                    CATEGORY like '국' OR
                    CATEGORY like '김치' OR
                    CATEGORY like '식용유' 
                    GROUP BY
                        CATEGORY
                  )
GROUP BY
    CATEGORY
ORDER BY
    MAX_PRICE DESC