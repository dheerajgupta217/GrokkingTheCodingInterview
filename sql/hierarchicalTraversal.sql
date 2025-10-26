-- Q7. Display an employee hierarchy (manager → subordinate chain)

WITH RECURSIVE EmpHierarchy AS (
  SELECT emp_id, name, manager_id, 1 AS level
  FROM Employees
  WHERE manager_id IS NULL  -- top-level managers
  
  UNION ALL
  
  SELECT e.emp_id, e.name, e.manager_id, eh.level + 1
  FROM Employees e
  JOIN EmpHierarchy eh ON e.manager_id = eh.emp_id
)
SELECT * FROM EmpHierarchy
ORDER BY level, manager_id;

-- Concepts tested: Recursive CTEs, hierarchical traversal.
