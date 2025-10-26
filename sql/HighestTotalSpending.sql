-- Find the 3 customers with the highest total spending in the past 6 months

-- Table: Sales(cust_id, sale_date, amount)

-- Answer:

SELECT cust_id, SUM(amount) AS total_spent
FROM Sales
WHERE sale_date >= CURRENT_DATE - INTERVAL '6 MONTH'
GROUP BY cust_id
ORDER BY total_spent DESC
LIMIT 3;
