-- Rank products by revenue contribution percentage

-- Table: Sales(product_id, amount)

SELECT product_id,
       SUM(amount) AS total_sales,
       ROUND(100 * SUM(amount) / SUM(SUM(amount)) OVER (), 2) AS pct_contribution
FROM Sales
GROUP BY product_id
ORDER BY pct_contribution DESC;


-- Concepts tested: Ratio-to-total calculations, analytical percentage.
