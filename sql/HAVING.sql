-- Find departments where average salary is higher than company’s overall average salary

-- Solution

SELECT dept_id
FROM Employees
GROUP BY dept_id
HAVING AVG(salary) > (SELECT AVG(salary) FROM Employees);

-- Concepts tested: Subquery in HAVING, aggregate comparison.
