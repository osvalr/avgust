# --------------------------------------------------------
# Host:                         127.0.0.1
# Database:                     dde
# Server version:               5.1.36-community-log
# Server OS:                    Win32
# HeidiSQL version:             5.0.0.3272
# Date/time:                    2010-11-05 00:46:08
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

# Dumping structure for procedure dde.p_add_visitante
DROP PROCEDURE IF EXISTS `p_add_visitante`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `p_add_visitante`(IN `doc` VARCHAR(12), IN `country` int
, IN `tipodocumento` INT, IN `nacimiento` DATETIME, IN `idguia` INT, IN `idoperadorturismo` INT, IN `idoperadorturismoEmpresaturismo` INT, IN `fechaingreso` DATETIME, OUT `id` INT)
BEGIN
	#verificar si existe la persona
	SELECT personanatural.idpersonanatural 
	FROM personanatural
	LEFT JOIN visitante ON visitante.idpersonanatural = personanatural.idpersonanatural 
	WHERE numerodoc = doc LIMIT 0,1 INTO id;
IF id IS NULL THEN
		#insert persona
		INSERT INTO persona(idpais) VALUES (country);
SELECT LAST_INSERT_ID() INTO id;
#insert personanatural
		INSERT INTO personanatural(idpersona,idtipodoc,numerodoc,fechanacimiento) 
	   VALUES(id,tipodocumento,doc,nacimiento);
SELECT LAST_INSERT_ID() INTO id;
END IF;
#insert visitante
	INSERT INTO visitante
   	(idpersonanatural,idguia,idoperadorturismo,idoperadorturismoEmpresaturismo,fechaingreso)
   VALUES(id,idguia,idoperadorturismo,idoperadorturismoEmpresaturismo,fechaingreso);

	
END//
DELIMITER ;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
