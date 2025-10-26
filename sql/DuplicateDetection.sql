-- Find all employees who have the same salary as at least one other employee

SELECT e1.*
FROM Employees e1
WHERE EXISTS (
  SELECT 1
  FROM Employees e2
  WHERE e1.salary = e2.salary
    AND e1.emp_id <> e2.emp_id
);

-- Concepts tested: EXISTS subquery, duplicate detection.
