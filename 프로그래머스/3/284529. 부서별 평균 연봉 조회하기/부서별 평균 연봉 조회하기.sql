SELECT
    a.DEPT_ID,a.DEPT_NAME_EN,ROUND(AVG(b.SAL)) as AVG_SAL
FROM
    HR_DEPARTMENT a
JOIN
    HR_EMPLOYEES b 
ON    
    a.DEPT_ID = b.DEPT_ID
GROUP BY
      a.DEPT_ID,a.DEPT_NAME_EN
ORDER BY
    AVG_SAL DESC