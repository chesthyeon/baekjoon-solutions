SELECT ROUTE, 
CONCAT(ROUND(SUM(D_BETWEEN_DIST), 1),'km') AS TOTAL_DISTANCE, 
CONCAT(ROUND(AVG(D_BETWEEN_DIST), 2), 'km') AS AVERAGE_DISTANCE
FROM SUBWAY_DISTANCE
GROUP BY ROUTE
ORDER BY ROUND(SUM(D_BETWEEN_DIST), 1) DESC;
# 1. ROUTE로 그룹화
# 2. 총 누계거리 계산해서 소수 둘째자리에서 반올림하고 CONCAT 이용하여 뒤에 km 붙이기
# 평균 역 사이 거리 계산해서 소수 셋째자리에서 반올림하고 CONCAT 이용하여 뒤에 km 붙이기
# 3. 총 누계거리 기준 내림차순 정렬
# => 여기서 아래처럼 썼다가 틀렸는데 찾아보니까 총 누계거리 계산한 후에 CONCAT으로 문자열로 만들었기 때문에 제대로 정렬이 안된다고 한다. 그래서 SELECT문에서 쓴 것 그대로 CONCAT만 제외하고 써줬다.