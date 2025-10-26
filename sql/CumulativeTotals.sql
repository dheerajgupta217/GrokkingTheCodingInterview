-- Q8. Calculate running total of sales per region ordered by date

-- Table:

-- Sales(sale_id, region, sale_date, amount)

SELECT region, sale_date, amount,
       SUM(amount) OVER (PARTITION BY region ORDER BY sale_date) AS running_total
FROM Sales
ORDER BY region, sale_date;


-- Concepts tested: Window aggregation, cumulative totals.
