WITH RECURSIVE HourRange AS (
    -- 초기 시간 설정 (9시)
    SELECT 9 AS HOUR
    UNION ALL
    -- 재귀적으로 1씩 증가시켜 19시까지 시간 범위를 생성
    SELECT HOUR + 1
    FROM HourRange
    WHERE HOUR < 19
)
SELECT 
    HR.HOUR, 
    COALESCE(COUNT(A.DATETIME), 0) AS COUNT
FROM 
    HourRange HR
LEFT JOIN 
    ANIMAL_OUTS A 
    ON HR.HOUR = HOUR(A.DATETIME)
GROUP BY 
    HR.HOUR
ORDER BY 
    HR.HOUR;
