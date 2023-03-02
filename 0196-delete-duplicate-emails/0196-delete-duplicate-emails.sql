# Please write a DELETE statement and DO NOT write a SELECT statement.
# Write your MySQL query statement below
DELETE FROM Person
WHERE Id NOT IN (SELECT id FROM (SELECT Email, MIN(Id) AS id FROM Person GROUP BY Email) t)
