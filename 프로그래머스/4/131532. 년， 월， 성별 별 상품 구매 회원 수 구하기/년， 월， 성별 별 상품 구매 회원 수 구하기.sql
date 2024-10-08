-- 코드를 입력하세요
# SELECT
# YEAR(a.SALES_DATE) as YEAR, MONTH(a.SALES_DATE) as MONTH , b.GENDER ,COUNT(b.USER_ID) as USERS
# FROM
# ONLINE_SALE a
# JOIN
# USER_INFO  b
# ON
# a.USER_ID = b.USER_ID
# WHERE GENDER is not null
# GROUP BY YEAR,MONTH,b.GENDER
# ORDER BY YEAR,MONTH,b.GENDER

# SELECT 
# YEAR(a.SALES_DATE) as YEAR,MONTH(a.SALES_DATE) as MONTH,
# b.GENDER
# FROM 
# ONLINE_SALE a
# JOIN USER_INFO b
# ON a.USER_ID = b.USER_ID
# WHERE GENDER is not null
# GROUP BY YEAR,MONTH
# ORDER BY YEAR,MONTH

SELECT YEAR(a.SALES_DATE) as YEAR,MONTH(a.SALES_DATE) as MONTH,b.GENDER,COUNT(DISTINCT a.USER_ID) as USERS
FROM 
ONLINE_SALE a
JOIN USER_INFO b
ON a.USER_ID = b.USER_ID
WHERE b.GENDER is not null
GROUP BY 
b.GENDER,MONTH,YEAR
ORDER BY
YEAR,MONTH,b.GENDER