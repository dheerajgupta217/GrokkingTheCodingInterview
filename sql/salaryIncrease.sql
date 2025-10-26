-- Find employees whose salary increased compared to the previous year

-- Table: SalaryHistory(emp_id, year, salary)

-- Answer:

SELECT emp_id, year, salary,
       LAG(salary) OVER(PARTITION BY emp_id ORDER BY year) AS prev_salary
FROM SalaryHistory
WHERE salary > LAG(salary) OVER(PARTITION BY emp_id ORDER BY year);
