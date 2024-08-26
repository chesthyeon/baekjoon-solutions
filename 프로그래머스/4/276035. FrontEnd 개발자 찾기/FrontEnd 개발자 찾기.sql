WITH Front_end_skill_codes AS(
    SELECT CODE
    FROM SKILLCODES
    WHERE CATEGORY = 'Front End'
)
SELECT 
    D.ID,
    D.EMAIL,
    D.FIRST_NAME,
    D.LAST_NAME
FROM 
    DEVELOPERS D
JOIN 
    Front_end_skill_codes FNSC ON D.SKILL_CODE & FNSC.CODE
GROUP BY d.id, d.email, d.first_name, d.last_name
ORDER BY 
    D.ID ASC;