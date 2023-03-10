# Write your MySQL query statement below
SELECT CASE
    WHEN s.id = ( SELECT COUNT(*) FROM Seat ) AND MOD(s.id,2) = 1 THEN s.id
    WHEN MOD(s.id,2) = 0 THEN s.id - 1
    ELSE s.id + 1
    END AS id,
    s.student
FROM Seat AS s
ORDER BY id
