-- Detect employees who manage themselves (circular reference)

-- Table: Employee(emp_id, manager_id)

-- Answer:

SELECT emp_id
FROM Employee
WHERE emp_id = manager_id;


-- Or deeper recursion detection:
-- Use a recursive CTE to find circular reporting loops (real-world tough one):

WITH RECURSIVE hierarchy AS (
  SELECT emp_id, manager_id, emp_id AS root
  FROM Employee
  UNION ALL
  SELECT e.emp_id, e.manager_id, h.root
  FROM Employee e
  JOIN hierarchy h ON e.manager_id = h.emp_id
)
SELECT DISTINCT h1.root AS circular_root
FROM hierarchy h1
JOIN hierarchy h2 ON h1.root = h2.emp_id
WHERE h2.manager_id = h1.root;
