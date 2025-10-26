-- Get customers who placed consecutive orders on consecutive days

-- Table: Orders(customer_id, order_date)

SELECT DISTINCT o1.customer_id
FROM Orders o1
JOIN Orders o2
  ON o1.customer_id = o2.customer_id
 AND o2.order_date = o1.order_date + INTERVAL '1 day';


-- Concepts tested: Self-join with date arithmetic, time-series analysis.
