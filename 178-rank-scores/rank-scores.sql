# Write your MySQL query statement below

select S1.score , (select count(distinct score) from Scores S2 WHERE S1.score <= S2.score) as "Rank"
from Scores S1 
ORDER BY S1.score DESC;