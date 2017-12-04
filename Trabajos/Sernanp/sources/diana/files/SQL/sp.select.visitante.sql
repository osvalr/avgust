DROP PROCEDURE IF EXISTS sp_visitantexpais;
-- --------------------------------------------------------------------------------
-- Routine DDL
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE PROCEDURE `dde`.`sp_visitantexpais` ()
BEGIN

	SELECT *
	from visitante v 
	INNER JOIN personanatural pn ON pn.idpersonanatural = v.idvisitante
	INNER JOIN persona p ON p.idpersona = pn.idpersona;
	
END$$
