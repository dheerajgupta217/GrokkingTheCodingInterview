-- Find the second-highest salary without using LIMIT, TOP, or RANK

-- Solution
SELECT MAX(salary) AS second_highest_salary
FROM Employees
WHERE salary < (SELECT MAX(salary) FROM Employees);

-- Concepts tested: Correlated subqueries, aggregate filtering.
