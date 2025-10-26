-- Calculate retention: users who logged in in consecutive months

-- Table: Logins(user_id, login_date)

-- Answer:
WITH month_data AS (
    SELECT user_id,
           EXTRACT(YEAR FROM login_date) AS yr,
           EXTRACT(MONTH FROM login_date) AS mn
    FROM Logins
    GROUP BY user_id, EXTRACT(YEAR FROM login_date), EXTRACT(MONTH FROM login_date)
)
SELECT DISTINCT l1.user_id
FROM month_data l1
JOIN month_data l2
  ON l1.user_id = l2.user_id
 AND (l1.yr * 12 + l1.mn + 1) = (l2.yr * 12 + l2.mn);
