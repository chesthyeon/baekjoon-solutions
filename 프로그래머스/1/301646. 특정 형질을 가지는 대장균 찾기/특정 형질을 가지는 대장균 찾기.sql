SELECT COUNT(*) AS COUNT
FROM ECOLI_DATA
WHERE (GENOTYPE & 2) = 0  -- 2번 형질(2^1)을 보유하지 않음
  AND (GENOTYPE & 5) > 0; -- 1번(2^0) 또는 3번(2^2) 형질을 보유함