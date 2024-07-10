SELECT
    a.AUTHOR_ID, b.AUTHOR_NAME, a.CATEGORY,SUM((c.SALES * a.PRICE)) as TOTAL_SALES
FROM
    BOOK a
JOIN
    AUTHOR b
ON
    a.AUTHOR_ID = b.AUTHOR_ID
JOIN
    BOOK_SALES  c
ON
    a.BOOK_ID = c.BOOK_ID 
WHERE
    c.SALES_DATE like '2022-01%'
GROUP BY   
    b.AUTHOR_ID, b.AUTHOR_NAME, a.CATEGORY
ORDER BY
    b.AUTHOR_ID,a.CATEGORY DESC