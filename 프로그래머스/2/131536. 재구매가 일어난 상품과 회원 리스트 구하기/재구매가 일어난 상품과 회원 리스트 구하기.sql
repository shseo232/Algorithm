-- 코드를 입력하세요
SELECT
USER_ID ,PRODUCT_ID 
FROM 
ONLINE_SALE 
GROUP BY 
PRODUCT_ID,USER_ID
HAVING
COUNT(PRODUCT_ID)>1
ORDER BY USER_ID,PRODUCT_ID desc