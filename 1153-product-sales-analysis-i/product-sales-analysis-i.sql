# Write your MySQL query statement below
Select b.product_name,a.year, a.price from Sales as a Left Join Product as b on a.product_id = b.product_id;