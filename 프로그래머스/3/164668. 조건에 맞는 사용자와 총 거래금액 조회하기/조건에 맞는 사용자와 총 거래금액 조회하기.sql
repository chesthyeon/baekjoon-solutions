SELECT 
    ub.writer_id,
    uu.nickname,
    SUM(ub.price) AS total_sales
FROM 
    used_goods_board ub
JOIN 
    used_goods_user uu ON ub.writer_id = uu.user_id
WHERE 
    ub.status = 'DONE'
GROUP BY 
    ub.writer_id, uu.nickname
HAVING 
    SUM(ub.price) >= 700000
ORDER BY 
    total_sales