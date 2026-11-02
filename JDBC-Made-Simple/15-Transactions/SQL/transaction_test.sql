-- Transaction test helper queries
USE college_db;

-- Verify initial student state before transaction
SELECT * FROM students WHERE id = 101;
