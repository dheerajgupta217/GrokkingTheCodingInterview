-- Find overlapping project periods

-- Table: Projects(proj_id, emp_id, start_date, end_date)

-- Answer:

SELECT p1.proj_id AS proj1, p2.proj_id AS proj2, p1.emp_id
FROM Projects p1
JOIN Projects p2
  ON p1.emp_id = p2.emp_id
 AND p1.proj_id <> p2.proj_id
 AND p1.start_date <= p2.end_date
 AND p2.start_date <= p1.end_date;


-- Explanation:
-- Two ranges overlap if each starts before the other ends.
