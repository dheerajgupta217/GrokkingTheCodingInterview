-- Pivot sales by month

-- Table: Sales(product, month, amount)
-- Output: Each row = product, columns = Jan, Feb, Mar, etc.

-- Answer (standard SQL CASE method):

SELECT product,
       SUM(CASE WHEN month = 'Jan' THEN amount END) AS Jan,
       SUM(CASE WHEN month = 'Feb' THEN amount END) AS Feb,
       SUM(CASE WHEN month = 'Mar' THEN amount END) AS Mar
FROM Sales
GROUP BY product;
