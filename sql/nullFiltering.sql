-- Find employees who never made a sale

-- Tables:

-- Employees(emp_id, name)

-- Sales(sale_id, emp_id, amount)

SELECT e.emp_id, e.name
FROM Employees e
LEFT JOIN Sales s ON e.emp_id = s.emp_id
WHERE s.emp_id IS NULL;


-- Concepts tested: LEFT JOIN + null filtering (anti-join pattern).
