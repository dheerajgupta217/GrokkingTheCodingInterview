-- Find employees whose salary is in the top 10% of all salaries

-- Solution
SELECT emp_id, name, salary
FROM (
  SELECT emp_id, name, salary,
         NTILE(10) OVER (ORDER BY salary DESC) AS decile
  FROM Employees
) t
WHERE decile = 1;

-- Concepts tested: Percentile logic with NTILE(), window partitioning.
