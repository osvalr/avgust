# --------------------------------------------------------
# Host:                         10.10.11.220
# Server version:               5.1.51
# Server OS:                    redhat-linux-gnu
# HeidiSQL version:             5.1.0.3533
# Date/time:                    2010-11-19 15:58:21
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
# Dumping data for table dde.boletaje: ~4 rows (approximately)
/*!40000 ALTER TABLE `boletaje` DISABLE KEYS */;
INSERT INTO `boletaje` (`idboletaje`, `nombreboletaje`, `valorboletaje`, `serieboletaje`, `obsboletaje`, `idrutaturismo`) VALUES
	(1, 'Turismo Aventura Adulto', 65, 210, 'Válido hasta por 7 días', 1),
	(2, 'Turismo Convencional Adulto', 5, 211, 'Válido por 1 día', 1),
	(4, 'Turismo Convencional Menores', 1.5, 213, 'Válido por 1 día', 1),
	(5, 'Turismo Aventura Adulto', 65, 250, 'Válido hasta por 7 días', 12),
	(6, 'Turismo Aventura Adulto', 65, 222, 'Válido hasta por 7 días', 15),
	(7, 'Turismo Convencional Adulto', 10, 223, 'Válido por 3 días', 15),
	(8, 'Turismo Convencional Adulto', 5, 224, 'Válido por 1 día', 15),
	(9, 'Turismo Convencional Menores', 1.5, 225, 'Válido por 1 día', 15);
/*!40000 ALTER TABLE `boletaje` ENABLE KEYS */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
