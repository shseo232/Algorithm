-- 코드를 입력하세요
SELECT
    ANIMAL_ID,NAME,
    (CASE
     WHEN SEX_UPON_INTAKE like 'Intact%' then 'X'
     ELSE 'O'
     END )
FROM
    ANIMAL_INS 