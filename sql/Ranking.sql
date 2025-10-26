-- Retrieve top 3 highest-paid employees in each department
-- Tables:
-- Employees(emp_id, name, salary, dept_id)
-- Departments(dept_id, dept_name)

-- Query (Window Function):
SELECT name, salary, dept_id
FROM (
  SELECT name, salary, dept_id,
         DENSE_RANK() OVER (PARTITION BY dept_id ORDER BY salary DESC) AS rnk
  FROM Employees
) ranked
WHERE rnk <= 3;

-- Concepts tested: Window functions, ranking per group.
