use startersql;
ALTER TABLE users
ADD COLUMN referred_by_id INT;
UPDATE users SET referred_by_id = 1 WHERE id IN (2, 3,12,6,8,9,11,15,13,17);
UPDATE users SET referred_by_id = 2 WHERE id in (18,19,21,23,24,4);
SELECT 
  a.id,
  a.name AS user_name,
  b.name AS referred_by
FROM users a
INNER JOIN users b ON a.referred_by_id = b.id;