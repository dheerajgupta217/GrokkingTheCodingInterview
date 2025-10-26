-- Q1. Find employees who earn more than their manager
-- Tables:
-- Employees(emp_id, name, salary, manager_id)

-- Solution:

SELECT e.name AS employee_name, e.salary, m.name AS manager_name, m.salary AS manager_salary
FROM Employees e
JOIN Employees m ON e.manager_id = m.emp_id
WHERE e.salary > m.salary;

-- Concepts tested: Self-join, comparison within same table, aliasing.
