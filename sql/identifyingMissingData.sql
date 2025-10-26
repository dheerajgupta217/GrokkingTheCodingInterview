-- Find gaps in order dates for each customer
SELECT customer_id,
       order_date AS current_order,
       LEAD(order_date) OVER (PARTITION BY customer_id ORDER BY order_date) AS next_order,
       LEAD(order_date) OVER (PARTITION BY customer_id ORDER BY order_date) - order_date AS gap_days
FROM Orders;


-- Concepts tested: LEAD(), date difference, identifying missing data.
