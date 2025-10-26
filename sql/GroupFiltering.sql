-- Find duplicate rows based on all columns

-- Table: Users(id, name, email, created_at)

SELECT name, email, created_at, COUNT(*)
FROM Users
GROUP BY name, email, created_at
HAVING COUNT(*) > 1;


-- Concepts tested: Duplicate detection, group filtering.
