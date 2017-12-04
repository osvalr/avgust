drop procedure if exists test;
-- --------------------------------------------------------------------------------
-- Routine DDL
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE PROCEDURE `dde`.`test` ( 
	IN idpais INT,
	IN idtipodoc INT,
	IN numerodoc VARCHAR(128),
	IN fechanacimiento DATETIME,
	IN fechaingreso DATETIME,
	OUT maxid INT
)
BEGIN
	INSERT INTO persona(idpais) VALUES(idpais);
 	SELECT MAX(idpersona) FROM persona INTO maxid;
 	
	INSERT INTO personanatural(idpersona,idtipodoc,numerodoc,fechanacimiento) 
	 	VALUES(maxid,idtipodoc,numerodoc,fechanacimiento);
	
 	SELECT MAX(idpersonanatural) FROM personanatural INTO maxid;
	INSERT INTO visitante(idpersonanatural,fechaingreso)
		VALUES(maxid,fechaingreso);
END$$

drop procedure if exists spinsertvisitante;
-- --------------------------------------------------------------------------------
-- Routine DDL
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE PROCEDURE `dde`.`spinsertvisitante` ( 
	IN size INT,
	IN fecharegistro DATETIME,
	OUT maxid INT
)
BEGIN
   DECLARE x  INT;
   SET x = 1;
   WHILE x  <= size DO
		CALL test(171,null,null,null,fecharegistro,@idvistante);
   	SET  x = x + 1; 
   END WHILE;
END$$

