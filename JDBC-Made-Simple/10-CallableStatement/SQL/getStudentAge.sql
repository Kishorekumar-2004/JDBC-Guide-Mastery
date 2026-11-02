-- Stored Procedure to retrieve student age given student id
USE college_db;

DROP PROCEDURE IF EXISTS getStudentAge;

DELIMITER //

CREATE PROCEDURE getStudentAge(
    IN in_student_id INT,
    OUT out_student_age INT
)
BEGIN
    SELECT age INTO out_student_age
    FROM students
    WHERE id = in_student_id;
END //

DELIMITER ;
