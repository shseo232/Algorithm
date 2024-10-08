-- 코드를 작성해주세요
with ECOLI_DATAs as (
        SELECT
         YEAR(DIFFERENTIATION_DATE) as YEAR,MAX(SIZE_OF_COLONY) as MAXDEV
         FROM
         ECOLI_DATA 
         GROUP BY YEAR
    )

SELECT 
    YEAR(a.DIFFERENTIATION_DATE) as YEAR, (b.MAXDEV - a.SIZE_OF_COLONY) as YEAR_DEV,a.ID
FROM
    ECOLI_DATA a
    JOIN 
    ECOLI_DATAs b
    WHERE
    YEAR(a.DIFFERENTIATION_DATE) = b.YEAR
ORDER BY
    YEAR,YEAR_DEV