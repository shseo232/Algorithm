-- 코드를 입력하세요
SELECT
    CAR_TYPE ,COUNT(*) as CARS
FROM
    CAR_RENTAL_COMPANY_CAR 
WHERE
    OPTIONS like '%열선시트%' || OPTIONS like '%가죽시트%' || OPTIONS like '%통풍시트%' 
GROUP BY
    CAR_TYPE
ORDER BY
    CAR_TYPE