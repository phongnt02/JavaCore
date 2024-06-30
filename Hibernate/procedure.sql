DELIMITER //

CREATE PROCEDURE GetPagedPatients(IN p_offset INT, IN p_limit INT)
BEGIN
    SELECT * FROM Patient
    LIMIT p_offset, p_limit;
END //

DELIMITER ;
