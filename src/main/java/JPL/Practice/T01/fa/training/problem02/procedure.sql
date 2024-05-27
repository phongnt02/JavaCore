DELIMITER //
CREATE PROCEDURE saveEmployee(
    IN birth_date DATE,
    IN first_name VARCHAR(255),
    IN last_name VARCHAR(255),
    IN gender CHARACTER(1),
    IN hire_date DATE
)
BEGIN
INSERT INTO Employee (birth_date, first_name, last_name, gender, hire_date)
VALUES (birth_date, first_name, last_name, gender, hire_date);
END //

DELIMITER //