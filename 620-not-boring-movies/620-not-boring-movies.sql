# Write your MySQL query statement below
select id, movie, description, rating from Cinema
WHERE mod(id,2) = 1
and
description not LIKE '%boring%'
order by rating DESC;
