USE college_db;

DROP PROCEDURE IF EXISTS getStudentCountByDept;

DELIMITER //

CREATE PROCEDURE getStudentCountByDept(
    IN in_dept VARCHAR(50),
    OUT out_count INT
)
BEGIN
    SELECT COUNT(*) INTO out_count
    FROM students
    WHERE department = in_dept;
END //

DELIMITER ;
