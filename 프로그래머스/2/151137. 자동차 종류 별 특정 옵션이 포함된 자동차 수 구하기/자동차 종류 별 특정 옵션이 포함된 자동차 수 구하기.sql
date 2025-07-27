
-- 해답: 자동차 종류 별 특정 옵션이 포함된 자동차 수 구하기
SELECT 
    CAR_TYPE,
    COUNT(*) AS CARS
FROM 
    CAR_RENTAL_COMPANY_CAR
WHERE 
    OPTIONS LIKE '%통풍시트%' 
    OR OPTIONS LIKE '%열선시트%' 
    OR OPTIONS LIKE '%가죽시트%'
GROUP BY 
    CAR_TYPE
ORDER BY 
    CAR_TYPE;

-- 방법 2: REGEXP 사용 (MySQL)
SELECT 
    CAR_TYPE,
    COUNT(*) AS CARS
FROM 
    CAR_RENTAL_COMPANY_CAR
WHERE 
    OPTIONS REGEXP '통풍시트|열선시트|가죽시트'
GROUP BY 
    CAR_TYPE
ORDER BY 
    CAR_TYPE;

-- 방법 3: FIND_IN_SET 사용 (콤마로 구분된 경우)
SELECT 
    CAR_TYPE,
    COUNT(*) AS CARS
FROM 
    CAR_RENTAL_COMPANY_CAR
WHERE 
    FIND_IN_SET('통풍시트', REPLACE(OPTIONS, ', ', ',')) > 0
    OR FIND_IN_SET('열선시트', REPLACE(OPTIONS, ', ', ',')) > 0
    OR FIND_IN_SET('가죽시트', REPLACE(OPTIONS, ', ', ',')) > 0
GROUP BY 
    CAR_TYPE
ORDER BY 
    CAR_TYPE;