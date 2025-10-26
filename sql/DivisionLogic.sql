-- Find customers who ordered all products

-- Tables:

-- Orders(customer_id, product_id)

-- Products(product_id)

SELECT customer_id
FROM Orders
GROUP BY customer_id
HAVING COUNT(DISTINCT product_id) = (SELECT COUNT(*) FROM Products);


-- Concepts tested: Division logic, set completeness.
