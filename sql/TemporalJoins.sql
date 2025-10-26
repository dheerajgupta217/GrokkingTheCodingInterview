-- Detect overlapping date ranges

-- Table: Bookings(booking_id, room_id, start_date, end_date)

SELECT b1.booking_id AS booking1, b2.booking_id AS booking2
FROM Bookings b1
JOIN Bookings b2 
  ON b1.room_id = b2.room_id
 AND b1.booking_id <> b2.booking_id
 AND b1.start_date < b2.end_date
 AND b1.end_date > b2.start_date;


-- Concepts tested: Temporal joins, range overlap detection.
