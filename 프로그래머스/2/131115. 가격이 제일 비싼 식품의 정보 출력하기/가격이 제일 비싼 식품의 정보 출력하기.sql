WITH MaxPrice AS (
    SELECT MAX(PRICE) AS MAX_PRICE
    FROM FOOD_PRODUCT
)
SELECT 
    fp.PRODUCT_ID,
    fp.PRODUCT_NAME,
    fp.PRODUCT_CD,
    fp.CATEGORY,
    fp.PRICE
FROM 
    FOOD_PRODUCT fp, MaxPrice
WHERE 
    fp.PRICE = MaxPrice.MAX_PRICE;