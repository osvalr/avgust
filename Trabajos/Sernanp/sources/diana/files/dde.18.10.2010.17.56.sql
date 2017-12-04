# --------------------------------------------------------
# Host:                         10.10.11.220
# Server version:               5.0.77
# Server OS:                    redhat-linux-gnu
# HeidiSQL version:             5.1.0.3533
# Date/time:                    2010-10-18 17:27:18
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

# Dumping database structure for dde
CREATE DATABASE IF NOT EXISTS `dde` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dde`;


# Dumping structure for table dde.actividadturismo
CREATE TABLE IF NOT EXISTS `actividadturismo` (
  `idactividadeturismo` int(11) NOT NULL auto_increment,
  `nombreactividadturismo` varchar(128) default NULL,
  `detalleactividadturismo` text,
  PRIMARY KEY  (`idactividadeturismo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

# Dumping data for table dde.actividadturismo: ~3 rows (approximately)
DELETE FROM `actividadturismo`;
/*!40000 ALTER TABLE `actividadturismo` DISABLE KEYS */;
INSERT INTO `actividadturismo` (`idactividadeturismo`, `nombreactividadturismo`, `detalleactividadturismo`) VALUES
	(1, 'Trekking (Caminata)', NULL),
	(2, 'Escalada (Climbing)', NULL),
	(3, 'Cabalgatas', NULL);
/*!40000 ALTER TABLE `actividadturismo` ENABLE KEYS */;


# Dumping structure for table dde.areanatural
CREATE TABLE IF NOT EXISTS `areanatural` (
  `idareanatural` int(3) NOT NULL auto_increment COMMENT 'Id del Area Natural',
  `codareanatural` char(4) default '' COMMENT 'Codigo del Area Natural',
  `desareanatural` varchar(200) default NULL COMMENT 'Descripcion del Area Natural',
  `estado` int(2) default NULL COMMENT 'Estado del registro',
  `idcategoriaanp` int(3) NOT NULL,
  `jefeareanatural` int(11) default NULL COMMENT ' no obligatorio (por ahora)\n',
  `ubicacionareanatural` varchar(250) default NULL,
  `codigosigareanatural` varchar(45) default NULL,
  PRIMARY KEY  (`idareanatural`),
  KEY `fk_areanatural_personanatural1` (`jefeareanatural`),
  KEY `fk_areanatural_categoriaanp1` (`idcategoriaanp`),
  CONSTRAINT `fk_areanatural_personanatural1` FOREIGN KEY (`jefeareanatural`) REFERENCES `personanatural` (`idpersonanatural`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_areanatural_categoriaanp1` FOREIGN KEY (`idcategoriaanp`) REFERENCES `categoriaanp` (`idCategoriaanp`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

# Dumping data for table dde.areanatural: ~68 rows (approximately)
DELETE FROM `areanatural`;
/*!40000 ALTER TABLE `areanatural` DISABLE KEYS */;
INSERT INTO `areanatural` (`idareanatural`, `codareanatural`, `desareanatural`, `estado`, `idcategoriaanp`, `jefeareanatural`, `ubicacionareanatural`, `codigosigareanatural`) VALUES
	(1, '0101', 'CUTERVO', 1, 1, NULL, NULL, NULL),
	(2, '0102', 'TINGO MARIA', 1, 1, NULL, NULL, NULL),
	(3, '0103', 'MANU', 1, 1, NULL, NULL, NULL),
	(4, '0104', 'HUASCARAN', 1, 1, NULL, NULL, NULL),
	(5, '0105', 'CERROS DE AMOTAPE', 1, 1, NULL, NULL, NULL),
	(6, '0106', 'RIO ABISEO', 1, 1, NULL, NULL, NULL),
	(7, '0107', 'YANACHAGA CHEMILLEN', 1, 1, NULL, NULL, NULL),
	(8, '0108', 'BAHUAJA SONENE', 1, 1, NULL, NULL, NULL),
	(9, '0109', 'CORDILLERA AZUL', 1, 1, NULL, NULL, NULL),
	(10, '0110', 'OTISHI', 1, 1, NULL, NULL, NULL),
	(11, '0111', 'ALTO PURUS', 1, 1, NULL, NULL, NULL),
	(12, '0112', 'ICHIGKAT MUJA - CORDILLERA DEL CONDOR', 1, 1, NULL, NULL, NULL),
	(13, '0201', 'HUAYLLAY', 1, 2, NULL, NULL, NULL),
	(14, '0202', 'CALIPUY', 1, 2, NULL, NULL, NULL),
	(15, '0203', 'LAGUNAS DE MEJIA', 1, 2, NULL, NULL, NULL),
	(16, '0204', 'AMPAY', 1, 2, NULL, NULL, NULL),
	(17, '0205', 'MANGLARES DE TUMBES', 1, 2, NULL, NULL, NULL),
	(18, '0206', 'TABACONAS NAMBALLE', 1, 2, NULL, NULL, NULL),
	(19, '0207', 'MEGANTONI', 1, 2, NULL, NULL, NULL),
	(20, '0208', 'PAMPA HERMOSA', 1, 2, NULL, NULL, NULL),
	(21, '0301', 'CHACAMARCA', 1, 3, NULL, NULL, NULL),
	(22, '0302', 'PAMPA DE AYACUCHO', 1, 3, NULL, NULL, NULL),
	(23, '0303', 'MACHUPICCHU', 1, 3, NULL, NULL, NULL),
	(24, '0304', 'BOSQUE DE POMAC', 1, 3, NULL, NULL, NULL),
	(25, '0401', 'PAMPA GALERAS BARBARA D\' ACHILLE', 1, 4, NULL, NULL, NULL),
	(26, '0402', 'JUNIN', 1, 4, NULL, NULL, NULL),
	(27, '0403', 'PARACAS', 1, 4, NULL, NULL, NULL),
	(28, '0404', 'LACHAY', 1, 4, NULL, NULL, NULL),
	(29, '0405', 'TITICACA', 1, 4, NULL, NULL, NULL),
	(30, '0406', 'SALINAS Y AGUADA BLANCA', 1, 4, NULL, NULL, NULL),
	(31, '0407', 'CALIPUY', 1, 4, NULL, NULL, NULL),
	(32, '0408', 'PACAYA SAMIRIA', 1, 4, NULL, NULL, NULL),
	(33, '0409', 'TAMBOPATA', 1, 4, NULL, NULL, NULL),
	(34, '0410', 'ALLPAHUAYO MISHANA', 1, 4, NULL, NULL, NULL),
	(35, '0411', 'TUMBES', 1, 4, NULL, NULL, NULL),
	(36, '0412', 'MATSES', 1, 4, NULL, NULL, NULL),
	(37, '0501', 'LAQUIPAMPA', 1, 5, NULL, NULL, NULL),
	(38, '0502', 'LOS PANTANOS DE VILLA', 1, 5, NULL, NULL, NULL),
	(39, '0601', 'NOR YAUYOS COCHAS', 1, 6, NULL, NULL, NULL),
	(40, '0602', 'SUB CUENCA DEL COTAHUASI', 1, 6, NULL, NULL, NULL),
	(41, '0701', 'YANESHA', 1, 7, NULL, NULL, NULL),
	(42, '0702', 'EL SIRA', 1, 7, NULL, NULL, NULL),
	(43, '0703', 'AMARAKAERI', 1, 7, NULL, NULL, NULL),
	(44, '0704', 'MACHIGUENGA', 1, 7, NULL, NULL, NULL),
	(45, '0705', 'ASHANINKA', 1, 7, NULL, NULL, NULL),
	(46, '0706', 'PURUS', 1, 7, NULL, NULL, NULL),
	(47, '0707', 'TUNTANAIN', 1, 7, NULL, NULL, NULL),
	(48, '0801', 'ALEDAÑO A LA BOCATOMA DEL CANAL NUEVO IMPERIAL', 1, 8, NULL, NULL, NULL),
	(49, '0802', 'PUQUIO SANTA ROSA', 1, 8, NULL, NULL, NULL),
	(50, '0803', 'PUI PUI', 1, 8, NULL, NULL, NULL),
	(51, '0804', 'SAN MATIAS SAN CARLOS', 1, 8, NULL, NULL, NULL),
	(52, '0805', 'PAGAIBAMBA', 1, 8, NULL, NULL, NULL),
	(53, '0806', 'ALTO MAYO', 1, 8, NULL, NULL, NULL),
	(54, '0901', 'EL ANGOLO', 1, 9, NULL, NULL, NULL),
	(55, '0902', 'SUNCHUBAMBA', 1, 9, NULL, NULL, NULL),
	(56, '1001', 'CHANCAYBAÑOS', 1, 10, NULL, NULL, NULL),
	(57, '1002', 'GÜEPPI', 1, 10, NULL, NULL, NULL),
	(58, '1003', 'SANTIAGO COMAINA', 1, 10, NULL, NULL, NULL),
	(59, '1004', 'CORDILLERA DE COLAN', 1, 2, NULL, NULL, NULL),
	(60, '1005', 'CORDILLERA HUAYHUASH', 1, 10, NULL, NULL, NULL),
	(61, '1006', 'PUCACURO', 1, 10, NULL, NULL, NULL),
	(62, '1007', 'SIERRA DEL DIVISOR', 1, 10, NULL, NULL, NULL),
	(63, '1008', 'HUMEDALES DE PUERTO VIEJO', 1, 10, NULL, NULL, NULL),
	(64, '1009', 'SAN FERNANDO', 1, 10, NULL, NULL, NULL),
	(65, '0100', 'SEDE CENTRAL - SERNANP', 1, 11, NULL, NULL, NULL),
	(66, '0413', 'SISTEMA DE ISLAS, ISLOTES Y PUNTAS GUANERAS', 1, 4, NULL, NULL, NULL),
	(67, '1010', 'UDIMA', 1, 10, NULL, NULL, NULL),
	(68, '0708', 'CHAYUNAIN', 1, 7, NULL, NULL, NULL);
/*!40000 ALTER TABLE `areanatural` ENABLE KEYS */;


# Dumping structure for table dde.areanaturalproyecto
CREATE TABLE IF NOT EXISTS `areanaturalproyecto` (
  `idareaNatural` int(3) NOT NULL,
  `idproyecto` int(11) NOT NULL,
  PRIMARY KEY  (`idareaNatural`,`idproyecto`),
  KEY `fk_areanaturalproyecto_proyecto1` (`idproyecto`),
  CONSTRAINT `fk_areanaturalproyecto_areanatural1` FOREIGN KEY (`idareaNatural`) REFERENCES `areanatural` (`idAreaNatural`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_areanaturalproyecto_proyecto1` FOREIGN KEY (`idproyecto`) REFERENCES `proyecto` (`idproyecto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.areanaturalproyecto: ~4 rows (approximately)
DELETE FROM `areanaturalproyecto`;
/*!40000 ALTER TABLE `areanaturalproyecto` DISABLE KEYS */;
/*!40000 ALTER TABLE `areanaturalproyecto` ENABLE KEYS */;


# Dumping structure for table dde.areaorganica
CREATE TABLE IF NOT EXISTS `areaorganica` (
  `idarea` int(3) NOT NULL auto_increment COMMENT 'Id del Area',
  `codarea` char(4) default NULL COMMENT 'Codigo del Area',
  `desarea` varchar(60) default NULL COMMENT 'Descripcion del Area',
  `idtipoarea` int(3) default NULL COMMENT 'Id del tipo de area',
  `idareanatural` int(3) default NULL COMMENT 'Id del Area Natural',
  PRIMARY KEY  (`idarea`),
  KEY `FK_tipoareaorganica_areaorganica` (`idtipoarea`),
  KEY `FK_areanatural_areaorganica` (`idareanatural`),
  CONSTRAINT `FK_areanatural_areaorganica0` FOREIGN KEY (`idareanatural`) REFERENCES `areanatural` (`idareanatural`),
  CONSTRAINT `FK_tipoareaorganica_areaorganica0` FOREIGN KEY (`idtipoarea`) REFERENCES `tipoareaorganica` (`idTipoarea`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

# Dumping data for table dde.areaorganica: ~0 rows (approximately)
DELETE FROM `areaorganica`;
/*!40000 ALTER TABLE `areaorganica` DISABLE KEYS */;
/*!40000 ALTER TABLE `areaorganica` ENABLE KEYS */;


# Dumping structure for table dde.beneficiario
CREATE TABLE IF NOT EXISTS `beneficiario` (
  `idbeneficiario` int(11) NOT NULL,
  `idtipobeneficiario` int(11) NOT NULL,
  `desc` varchar(45) default NULL,
  `idturismo` int(11) NOT NULL,
  PRIMARY KEY  (`idbeneficiario`),
  KEY `fk_beneficiario_tipobeneficiario1` (`idtipobeneficiario`),
  KEY `fk_beneficiario_turismo1` (`idturismo`),
  CONSTRAINT `fk_beneficiario_turismo1` FOREIGN KEY (`idturismo`) REFERENCES `turismo` (`idTurismo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_beneficiario_tipobeneficiario1` FOREIGN KEY (`idtipobeneficiario`) REFERENCES `tipobeneficiario` (`idtipobeneficiario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.beneficiario: ~0 rows (approximately)
DELETE FROM `beneficiario`;
/*!40000 ALTER TABLE `beneficiario` DISABLE KEYS */;
/*!40000 ALTER TABLE `beneficiario` ENABLE KEYS */;


# Dumping structure for table dde.categoriaanp
CREATE TABLE IF NOT EXISTS `categoriaanp` (
  `idcategoriaanp` int(3) NOT NULL auto_increment COMMENT 'Id del la categoria de ANP',
  `codcategoriaanp` char(2) default NULL COMMENT 'Codigo de la categoria del ANP',
  `descategoriaanp` varchar(200) default NULL COMMENT 'Descripcion de la categoria del ANP',
  `estado` int(2) default NULL COMMENT 'Estado del registro',
  PRIMARY KEY  (`idcategoriaanp`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

# Dumping data for table dde.categoriaanp: ~11 rows (approximately)
DELETE FROM `categoriaanp`;
/*!40000 ALTER TABLE `categoriaanp` DISABLE KEYS */;
INSERT INTO `categoriaanp` (`idcategoriaanp`, `codcategoriaanp`, `descategoriaanp`, `estado`) VALUES
	(1, '01', 'PARQUE NACIONAL', 1),
	(2, '02', 'SANTUARIO NACIONAL', 1),
	(3, '03', 'SANTUARIO HISTORICO', 1),
	(4, '04', 'RESERVA NACIONAL', 1),
	(5, '05', 'REFUGIO DE VIDA SILVESTRE', 1),
	(6, '06', 'RESERVA PAISAJISTICA', 1),
	(7, '07', 'RESERVA COMUNALE', 1),
	(8, '08', 'BOSQUES DE PROTECCION', 1),
	(9, '09', 'COTO DE CAZA', 1),
	(10, '10', 'ZONA RESERVADA', 1),
	(11, '00', 'SEDE CENTRAL', 0);
/*!40000 ALTER TABLE `categoriaanp` ENABLE KEYS */;


# Dumping structure for table dde.comunidad
CREATE TABLE IF NOT EXISTS `comunidad` (
  `comunidad` int(11) NOT NULL auto_increment,
  `nombrecomunida` varchar(45) default NULL,
  `ubicacioncomunidad` varchar(45) default NULL,
  PRIMARY KEY  (`comunidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.comunidad: ~0 rows (approximately)
DELETE FROM `comunidad`;
/*!40000 ALTER TABLE `comunidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `comunidad` ENABLE KEYS */;


# Dumping structure for table dde.ejecutor
CREATE TABLE IF NOT EXISTS `ejecutor` (
  `idejecutor` int(11) NOT NULL auto_increment,
  `idpersonajuridica` int(11) NOT NULL,
  PRIMARY KEY  (`idejecutor`),
  KEY `fk_ejecutor_personajuridica1` (`idpersonajuridica`),
  CONSTRAINT `fk_ejecutor_personajuridica1` FOREIGN KEY (`idpersonajuridica`) REFERENCES `personajuridica` (`idpersonajuridica`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

# Dumping data for table dde.ejecutor: ~2 rows (approximately)
DELETE FROM `ejecutor`;
/*!40000 ALTER TABLE `ejecutor` DISABLE KEYS */;
INSERT INTO `ejecutor` (`idejecutor`, `idpersonajuridica`) VALUES
	(1, 6),
	(2, 7);
/*!40000 ALTER TABLE `ejecutor` ENABLE KEYS */;


# Dumping structure for table dde.fuentefinanciamiento
CREATE TABLE IF NOT EXISTS `fuentefinanciamiento` (
  `idftefto` int(11) NOT NULL auto_increment,
  `idpersonajuridica` int(11) NOT NULL,
  PRIMARY KEY  (`idftefto`),
  KEY `fk_ftefto_personajuridica1` (`idpersonajuridica`),
  CONSTRAINT `fk_ftefto_personajuridica1` FOREIGN KEY (`idpersonajuridica`) REFERENCES `personajuridica` (`idpersonajuridica`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.fuentefinanciamiento: ~2 rows (approximately)
DELETE FROM `fuentefinanciamiento`;
/*!40000 ALTER TABLE `fuentefinanciamiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `fuentefinanciamiento` ENABLE KEYS */;


# Dumping structure for table dde.guia
CREATE TABLE IF NOT EXISTS `guia` (
  `idguia` int(11) NOT NULL auto_increment,
  `codigoguia` varchar(12) default NULL,
  `idpersonanatural` int(11) NOT NULL,
  PRIMARY KEY  (`idguia`),
  KEY `fk_guia_personanatural1` (`idpersonanatural`),
  CONSTRAINT `fk_guia_personanatural1` FOREIGN KEY (`idpersonanatural`) REFERENCES `personanatural` (`idpersonanatural`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

# Dumping data for table dde.guia: ~1 rows (approximately)
DELETE FROM `guia`;
/*!40000 ALTER TABLE `guia` DISABLE KEYS */;
INSERT INTO `guia` (`idguia`, `codigoguia`, `idpersonanatural`) VALUES
	(1, '0365', 1);
/*!40000 ALTER TABLE `guia` ENABLE KEYS */;


# Dumping structure for table dde.modulo
CREATE TABLE IF NOT EXISTS `modulo` (
  `idmodulo` int(11) NOT NULL auto_increment,
  `nombremodulo` varchar(45) default NULL,
  `nombrecortomodulo` varchar(45) default NULL,
  `imgmodulo` varchar(250) default NULL,
  `nivelmodulo` int(11) default NULL,
  `niveldependemodulo` int(11) default NULL,
  `ordenmodulo` int(11) default NULL,
  `flagmodulo` int(11) default NULL,
  PRIMARY KEY  (`idmodulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.modulo: ~0 rows (approximately)
DELETE FROM `modulo`;
/*!40000 ALTER TABLE `modulo` DISABLE KEYS */;
/*!40000 ALTER TABLE `modulo` ENABLE KEYS */;


# Dumping structure for table dde.operadorturismo
CREATE TABLE IF NOT EXISTS `operadorturismo` (
  `idoperadorturismo` int(11) NOT NULL auto_increment,
  `idpersonajuridica` int(11) NOT NULL,
  PRIMARY KEY  (`idoperadorturismo`),
  KEY `fk_operadorturistico_personajuridica1` (`idpersonajuridica`),
  CONSTRAINT `fk_operadorturistico_personajuridica1` FOREIGN KEY (`idpersonajuridica`) REFERENCES `personajuridica` (`idpersonajuridica`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

# Dumping data for table dde.operadorturismo: ~3 rows (approximately)
DELETE FROM `operadorturismo`;
/*!40000 ALTER TABLE `operadorturismo` DISABLE KEYS */;
INSERT INTO `operadorturismo` (`idoperadorturismo`, `idpersonajuridica`) VALUES
	(1, 1),
	(2, 2),
	(3, 3);
/*!40000 ALTER TABLE `operadorturismo` ENABLE KEYS */;


# Dumping structure for table dde.pais
CREATE TABLE IF NOT EXISTS `pais` (
  `idpais` int(11) NOT NULL auto_increment,
  `codepais` varchar(45) default NULL,
  `nombrepais` varchar(45) default NULL,
  PRIMARY KEY  (`idpais`)
) ENGINE=InnoDB AUTO_INCREMENT=242 DEFAULT CHARSET=utf8;

# Dumping data for table dde.pais: ~241 rows (approximately)
DELETE FROM `pais`;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` (`idpais`, `codepais`, `nombrepais`) VALUES
	(1, 'AC', 'Isla Ascensión'),
	(2, 'AD', 'Andorra'),
	(3, 'AE', 'Emiratos Árabes Unidos'),
	(4, 'AF', 'Afganistán'),
	(5, 'AG', 'Antigua y Barbuda'),
	(6, 'AI', 'Anguila'),
	(7, 'AL', 'Albania'),
	(8, 'AM', 'Armenia'),
	(9, 'AN', 'Antillas Neerlandesas'),
	(10, 'AO', 'Angola'),
	(11, 'AP', 'Región Asia-Pacífico'),
	(12, 'AQ', 'Antártida'),
	(13, 'AR', 'Argentina'),
	(14, 'AS', 'Samoa Americana'),
	(15, 'AT', 'Austria'),
	(16, 'AU', 'Australia'),
	(17, 'AW', 'Aruba'),
	(18, 'AX', 'Islas de Åland'),
	(19, 'AZ', 'Azerbaiyán'),
	(20, 'BA', 'Bosnia-Herzegovina'),
	(21, 'BB', 'Barbados'),
	(22, 'BD', 'Bangladesh'),
	(23, 'BE', 'Bélgica'),
	(24, 'BF', 'Burkina Faso'),
	(25, 'BG', 'Bulgaria'),
	(26, 'BH', 'Bahrein'),
	(27, 'BI', 'Burundi'),
	(28, 'BJ', 'Benín'),
	(29, 'BM', 'Bermudas'),
	(30, 'BN', 'Brunéi'),
	(31, 'BO', 'Bolivia'),
	(32, 'BR', 'Brasil'),
	(33, 'BS', 'Bahamas'),
	(34, 'BT', 'Bután'),
	(35, 'BW', 'Botsuana'),
	(36, 'BY', 'Bielorrusia'),
	(37, 'BZ', 'Belice'),
	(38, 'CA', 'Canadá'),
	(39, 'CD', 'República Democrática del Congo'),
	(40, 'CF', 'República Centroafricana'),
	(41, 'CG', 'Congo'),
	(42, 'CH', 'Suiza'),
	(43, 'CI', 'Costa de Marfil'),
	(44, 'CK', 'Islas Cook'),
	(45, 'CL', 'Chile'),
	(46, 'CM', 'Camerún'),
	(47, 'CN', 'China'),
	(48, 'CO', 'Colombia'),
	(49, 'CR', 'Costa Rica'),
	(50, 'CU', 'Cuba'),
	(51, 'CV', 'Cabo Verde'),
	(52, 'CX', 'Isla de Navidad'),
	(53, 'CY', 'Chipre'),
	(54, 'CZ', 'República Checa'),
	(55, 'DE', 'Alemania'),
	(56, 'DJ', 'Yibuti'),
	(57, 'DK', 'Dinamarca'),
	(58, 'DM', 'Dominica'),
	(59, 'DO', 'República Dominicana'),
	(60, 'DZ', 'Argelia'),
	(61, 'EC', 'Ecuador'),
	(62, 'EE', 'Estonia'),
	(63, 'EG', 'Egipto'),
	(64, 'ER', 'Eritrea'),
	(65, 'ES', 'España'),
	(66, 'ET', 'Etiopía'),
	(67, 'EU', 'Europa'),
	(68, 'FI', 'Finlandia'),
	(69, 'FJ', 'Fiyi'),
	(70, 'FK', 'Islas Malvinas'),
	(71, 'FM', 'Estados Federados de Micronesia'),
	(72, 'FO', 'Islas Feroe'),
	(73, 'FR', 'Francia'),
	(74, 'GA', 'Gabón'),
	(75, 'GB', 'Reino Unido'),
	(76, 'GD', 'Granada'),
	(77, 'GE', 'Georgia'),
	(78, 'GF', 'Guayana Francesa'),
	(79, 'GG', 'Guernsey'),
	(80, 'GH', 'Ghana'),
	(81, 'GI', 'Gibraltar'),
	(82, 'GL', 'Groenlandia'),
	(83, 'GM', 'Gambia'),
	(84, 'GN', 'Guinea'),
	(85, 'GP', 'Guadalupe'),
	(86, 'GQ', 'Guinea Ecuatorial'),
	(87, 'GR', 'Grecia'),
	(88, 'GT', 'Guatemala'),
	(89, 'GU', 'Guam'),
	(90, 'GW', 'Guinea-Bissau'),
	(91, 'GY', 'Guyana'),
	(92, 'HK', 'Hong Kong'),
	(93, 'HM', 'Islas Heard y McDonald'),
	(94, 'HN', 'Honduras'),
	(95, 'HR', 'Croacia'),
	(96, 'HT', 'Haití'),
	(97, 'HU', 'Hungría'),
	(98, 'ID', 'Indonesia'),
	(99, 'IE', 'Irlanda'),
	(100, 'IL', 'Israel'),
	(101, 'IM', 'Isla de Man'),
	(102, 'IN', 'India'),
	(103, 'IO', 'Territorio Británico del Océano Índico'),
	(104, 'IQ', 'Iraq'),
	(105, 'IR', 'Irán'),
	(106, 'IS', 'Islandia'),
	(107, 'IT', 'Italia'),
	(108, 'JE', 'Jersey'),
	(109, 'JM', 'Jamaica'),
	(110, 'JO', 'Jordania'),
	(111, 'JP', 'Japón'),
	(112, 'KE', 'Kenia'),
	(113, 'KG', 'Kirguistán'),
	(114, 'KH', 'Camboya'),
	(115, 'KI', 'Kiribati'),
	(116, 'KM', 'Comoras'),
	(117, 'KN', 'San Cristóbal y Nieves'),
	(118, 'KP', 'Corea del Norte'),
	(119, 'KR', 'Corea del Sur'),
	(120, 'KW', 'Kuwait'),
	(121, 'KY', 'Islas Caimán'),
	(122, 'KZ', 'Kazajistán'),
	(123, 'LA', 'Laos'),
	(124, 'LB', 'Líbano'),
	(125, 'LC', 'Santa Lucía'),
	(126, 'LI', 'Liechtenstein'),
	(127, 'LK', 'Sri Lanka'),
	(128, 'LR', 'Liberia'),
	(129, 'LS', 'Lesotho'),
	(130, 'LT', 'Lituania'),
	(131, 'LU', 'Luxemburgo'),
	(132, 'LV', 'Letonia'),
	(133, 'LY', 'Libia'),
	(134, 'MA', 'Marruecos'),
	(135, 'MC', 'Mónaco'),
	(136, 'MD', 'Moldavia'),
	(137, 'ME', 'Montenegro'),
	(138, 'MF', 'San Martín'),
	(139, 'MG', 'Madagascar'),
	(140, 'MH', 'Islas Marshall'),
	(141, 'MK', 'Macedonia'),
	(142, 'ML', 'Malí'),
	(143, 'MM', 'Myanmar'),
	(144, 'MN', 'Mongolia'),
	(145, 'MO', 'Macao'),
	(146, 'MP', 'Islas Marianas del Norte'),
	(147, 'MQ', 'Martinica'),
	(148, 'MR', 'Mauritania'),
	(149, 'MS', 'Montserrat'),
	(150, 'MT', 'Malta'),
	(151, 'MU', 'Mauricio'),
	(152, 'MV', 'Maldivas'),
	(153, 'MW', 'Malawi'),
	(154, 'MX', 'Méjico'),
	(155, 'MY', 'Malasia'),
	(156, 'MZ', 'Mozambique'),
	(157, 'NA', 'Namibia'),
	(158, 'NC', 'Nueva Caledonia'),
	(159, 'NE', 'Níger'),
	(160, 'NF', 'Isla Norfolk'),
	(161, 'NG', 'Nigeria'),
	(162, 'NI', 'Nicaragua'),
	(163, 'NL', 'Países Bajos'),
	(164, 'NO', 'Noruega'),
	(165, 'NP', 'Nepal'),
	(166, 'NR', 'Nauru'),
	(167, 'NU', 'Niue'),
	(168, 'NZ', 'Nueva Zelanda'),
	(169, 'OM', 'Omán'),
	(170, 'PA', 'Panamá'),
	(171, 'PE', 'Perú'),
	(172, 'PF', 'Polinesia Francesa'),
	(173, 'PG', 'Papúa Nueva Guinea'),
	(174, 'PH', 'Filipinas'),
	(175, 'PK', 'Pakistán'),
	(176, 'PL', 'Polonia'),
	(177, 'PM', 'San Pedro y Miguelón'),
	(178, 'PR', 'Puerto Rico'),
	(179, 'PS', 'Territorios Palestinos'),
	(180, 'PT', 'Portugal'),
	(181, 'PW', 'Palaos'),
	(182, 'PY', 'Paraguay'),
	(183, 'QA', 'Qatar'),
	(184, 'RE', 'Reunión'),
	(185, 'RO', 'Rumanía'),
	(186, 'RS', 'Serbia'),
	(187, 'RU', 'Rusia'),
	(188, 'RW', 'Ruanda'),
	(189, 'SA', 'Arabia Saudita'),
	(190, 'SB', 'Islas Salomón'),
	(191, 'SC', 'Seychelles'),
	(192, 'SD', 'Sudán'),
	(193, 'SE', 'Suecia'),
	(194, 'SG', 'Singapur'),
	(195, 'SH', 'Santa Helena'),
	(196, 'SI', 'Eslovenia'),
	(197, 'SK', 'Eslovaquia'),
	(198, 'SL', 'Sierra Leona'),
	(199, 'SM', 'San Marino'),
	(200, 'SN', 'Senegal'),
	(201, 'SO', 'Somalia'),
	(202, 'SR', 'Surinam'),
	(203, 'ST', 'Santo Tomé y Príncipe'),
	(204, 'SV', 'El Salvador'),
	(205, 'SY', 'Siria'),
	(206, 'SZ', 'Swazilandia'),
	(207, 'TC', 'Islas Turcas y Caicos'),
	(208, 'TD', 'Chad'),
	(209, 'TG', 'Togo'),
	(210, 'TH', 'Tailandia'),
	(211, 'TJ', 'Tayikistán'),
	(212, 'TK', 'Tokelau'),
	(213, 'TL', 'Timor Oriental'),
	(214, 'TM', 'Turkmenistán'),
	(215, 'TN', 'Túnez'),
	(216, 'TO', 'Tonga'),
	(217, 'TR', 'Turquía'),
	(218, 'TT', 'Trinidad y Tobago'),
	(219, 'TV', 'Tuvalu'),
	(220, 'TW', 'Taiwán'),
	(221, 'TZ', 'Tanzania'),
	(222, 'UA', 'Ucrania'),
	(223, 'UG', 'Uganda'),
	(224, 'UM', 'Islas Ultramarinas de Estados Unidos'),
	(225, 'US', 'Estados Unidos'),
	(226, 'UY', 'Uruguay'),
	(227, 'UZ', 'Uzbekistán'),
	(228, 'VA', 'Ciudad del Vaticano'),
	(229, 'VC', 'San Vicente y las Granadinas'),
	(230, 'VE', 'Venezuela'),
	(231, 'VG', 'Islas Vírgenes Británicas'),
	(232, 'VI', 'Islas Vírgenes de los Estados Unidos'),
	(233, 'VN', 'Vietnam'),
	(234, 'VU', 'Vanuatu'),
	(235, 'WF', 'Wallis y Futuna'),
	(236, 'WS', 'Samoa'),
	(237, 'YE', 'Yemen'),
	(238, 'YT', 'Mayotte'),
	(239, 'ZA', 'Sudáfrica'),
	(240, 'ZM', 'Zambia'),
	(241, 'ZW', 'Zimbabue');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;


# Dumping structure for table dde.persona
CREATE TABLE IF NOT EXISTS `persona` (
  `idpersona` int(11) NOT NULL auto_increment,
  `direccion` varchar(250) default NULL,
  `telefono` int(11) default NULL,
  `email` varchar(250) default NULL,
  `idpais` int(11) default NULL,
  PRIMARY KEY  (`idpersona`),
  KEY `fk_persona_pais1` (`idpais`),
  CONSTRAINT `fk_persona_pais1` FOREIGN KEY (`idpais`) REFERENCES `pais` (`idpais`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

# Dumping data for table dde.persona: ~5 rows (approximately)
DELETE FROM `persona`;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` (`idpersona`, `direccion`, `telefono`, `email`, `idpais`) VALUES
	(1, NULL, 4528015, NULL, 171),
	(2, NULL, 2748617, NULL, 171),
	(3, NULL, 6536830, NULL, 171),
	(4, NULL, NULL, NULL, 171),
	(10, NULL, NULL, NULL, 171),
	(11, NULL, NULL, NULL, 171),
	(12, NULL, NULL, NULL, 171),
	(13, NULL, NULL, NULL, 171),
	(14, NULL, NULL, NULL, 171),
	(15, NULL, NULL, NULL, 171),
	(16, NULL, NULL, NULL, 171),
	(17, NULL, NULL, NULL, 171),
	(18, NULL, NULL, NULL, 171),
	(19, NULL, NULL, NULL, 171),
	(20, NULL, NULL, NULL, 171),
	(21, NULL, NULL, NULL, 171),
	(22, NULL, NULL, NULL, 171),
	(23, NULL, NULL, NULL, 171),
	(24, NULL, NULL, NULL, 171),
	(25, NULL, NULL, NULL, 171),
	(26, NULL, NULL, NULL, 171),
	(27, NULL, NULL, NULL, 171),
	(28, NULL, NULL, NULL, 171),
	(29, NULL, NULL, NULL, 171);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;


# Dumping structure for table dde.personajuridica
CREATE TABLE IF NOT EXISTS `personajuridica` (
  `idpersonajuridica` int(11) NOT NULL auto_increment,
  `idpersona` int(11) NOT NULL,
  `nombrepersonajuridica` varchar(250) default NULL,
  `siglas` varchar(45) default NULL,
  `ruc` varchar(45) default NULL,
  PRIMARY KEY  (`idpersonajuridica`),
  KEY `fk_personajuridica_persona1` (`idpersona`),
  CONSTRAINT `fk_personajuridica_persona1` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

# Dumping data for table dde.personajuridica: ~7 rows (approximately)
DELETE FROM `personajuridica`;
/*!40000 ALTER TABLE `personajuridica` DISABLE KEYS */;
INSERT INTO `personajuridica` (`idpersonajuridica`, `idpersona`, `nombrepersonajuridica`, `siglas`, `ruc`) VALUES
	(1, 1, 'ALIANZA TOURS S.R.L.', NULL, NULL),
	(2, 2, 'CALYPSO REPS S.A.', NULL, NULL),
	(3, 3, 'ALOJA TRAVEL & TOURS', NULL, NULL),
	(4, 1, 'Banco Mundial', 'BM', NULL),
	(5, 2, 'G de F ', 'GEF', NULL),
	(6, 1, 'Fondo de promocion de las Areas naturales', 'PROFONANPE', NULL),
	(7, 2, 'Servicio Natural de Areas Naturales Protegidas Por el Estado', 'SERNANP', NULL);
/*!40000 ALTER TABLE `personajuridica` ENABLE KEYS */;


# Dumping structure for table dde.personanatural
CREATE TABLE IF NOT EXISTS `personanatural` (
  `idpersonanatural` int(11) NOT NULL auto_increment,
  `idpersona` int(11) NOT NULL,
  `nombre` varchar(45) default NULL,
  `apepat` varchar(45) default NULL,
  `apemat` varchar(45) default NULL,
  `idtipodoc` int(11) default NULL,
  `numerodoc` varchar(45) default NULL,
  `fechanacimiento` date default NULL,
  `sexo` varchar(45) default NULL,
  `comunidad` int(11) default NULL,
  PRIMARY KEY  (`idpersonanatural`),
  KEY `fk_personanatural_persona1` (`idpersona`),
  KEY `fk_personanatural_comunidad1` (`comunidad`),
  CONSTRAINT `fk_personanatural_persona1` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_personanatural_comunidad1` FOREIGN KEY (`comunidad`) REFERENCES `comunidad` (`comunidad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

# Dumping data for table dde.personanatural: ~2 rows (approximately)
DELETE FROM `personanatural`;
/*!40000 ALTER TABLE `personanatural` DISABLE KEYS */;
INSERT INTO `personanatural` (`idpersonanatural`, `idpersona`, `nombre`, `apepat`, `apemat`, `idtipodoc`, `numerodoc`, `fechanacimiento`, `sexo`, `comunidad`) VALUES
	(1, 4, 'Daniél', 'Abárca', 'Soto', 0, '', NULL, 'm', NULL),
	(8, 11, NULL, NULL, NULL, NULL, '', '0000-00-00', NULL, NULL),
	(9, 12, NULL, NULL, NULL, NULL, '', '0000-00-00', NULL, NULL),
	(10, 13, NULL, NULL, NULL, NULL, '', '0000-00-00', NULL, NULL),
	(11, 14, NULL, NULL, NULL, NULL, '', '0000-00-00', NULL, NULL),
	(12, 15, NULL, NULL, NULL, NULL, '', '0000-00-00', NULL, NULL),
	(13, 16, NULL, NULL, NULL, NULL, '', '0000-00-00', NULL, NULL),
	(14, 17, NULL, NULL, NULL, NULL, '', '0000-00-00', NULL, NULL),
	(15, 18, NULL, NULL, NULL, NULL, '', '0000-00-00', NULL, NULL),
	(16, 19, NULL, NULL, NULL, NULL, '', '0000-00-00', NULL, NULL),
	(17, 20, NULL, NULL, NULL, NULL, '', '0000-00-00', NULL, NULL),
	(18, 21, NULL, NULL, NULL, NULL, '', '0000-00-00', NULL, NULL),
	(19, 22, NULL, NULL, NULL, NULL, '', '0000-00-00', NULL, NULL),
	(20, 23, NULL, NULL, NULL, NULL, '', '0000-00-00', NULL, NULL),
	(21, 24, NULL, NULL, NULL, NULL, '', '0000-00-00', NULL, NULL),
	(22, 25, NULL, NULL, NULL, NULL, '', '0000-00-00', NULL, NULL),
	(23, 26, NULL, NULL, NULL, NULL, '', '0000-00-00', NULL, NULL),
	(24, 27, NULL, NULL, NULL, NULL, '', '0000-00-00', NULL, NULL),
	(25, 28, NULL, NULL, NULL, 1, '432234234', '2000-10-20', NULL, NULL),
	(26, 29, NULL, NULL, NULL, NULL, '', '1981-03-16', NULL, NULL);
/*!40000 ALTER TABLE `personanatural` ENABLE KEYS */;


# Dumping structure for table dde.proyecto
CREATE TABLE IF NOT EXISTS `proyecto` (
  `idproyecto` int(11) NOT NULL auto_increment,
  `nombreproyecto` text,
  `objetivoproyecto` text,
  `areaespecificaproyecto` text,
  `periodoproyecto` varchar(250) default NULL COMMENT 'tiempo en meses\nsistema muestra en años',
  `anioinicioproyecto` int(11) default NULL,
  `aniofinproyecto` int(11) default NULL,
  `observacionproyecto` text,
  `compromisoproyecto` text,
  `estadoproyecto` varchar(45) default NULL,
  `idtipoproyecto` int(11) NOT NULL,
  PRIMARY KEY  (`idproyecto`),
  KEY `fk_proyecto_tipoproyecto1` (`idtipoproyecto`),
  CONSTRAINT `fk_proyecto_tipoproyecto1` FOREIGN KEY (`idtipoproyecto`) REFERENCES `tipoproyecto` (`idtipoproyecto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

# Dumping data for table dde.proyecto: ~22 rows (approximately)
DELETE FROM `proyecto`;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
INSERT INTO `proyecto` (`idproyecto`, `nombreproyecto`, `objetivoproyecto`, `areaespecificaproyecto`, `periodoproyecto`, `anioinicioproyecto`, `aniofinproyecto`, `observacionproyecto`, `idtipoproyecto`, `compromisoproyecto`, `estadoproyecto`) VALUES
	(1, 'Actualizacion e implementacion de la I etapa del Plan Maestro del Parque Nacional Ichigket Muja - Cordillera del Condor y Reserva Comunal Tuntanain', 'Establecer los mecanismos de cooperacion entre SERNANP y el FONDAM, para la actualizacion de la propuesta del Plan Maestro del PNIMCC y la elaboracion del Plan Maestro de la RCT, formulados durante la I etapa del projecto ITTO Condor, asi como para su implementacion en infraestructura, equipamiento y personal.', '', '36', 0, 2011, '', 1, NULL, NULL),
	(2, 'Apoyo a la gestión sostenible de la Reserva Nacional Sistema de Islas, Islotes y Puntas Guanera(RNSIIPG)', 'El objetivo general de la propuesta es contribuir a la conservación de la biodiversidad marino costera apoyando los esfuerzos del SERNANP para organizar y poner en marcha la gestión de la recientemente creada Reserva Nacional Sistema de Islas, Islotes y Puntas Guaneras (RNSIIPG). ', 'Comprende a 11 puntas y 22 islas, islotes y grupos de islas guaneras, que cubren 140.883,47 ha a lo largo de casi todo el litoral peruano. ', '36', 0, 2012, '', 1, NULL, NULL),
	(3, 'Apoyo al programa Trinacional conservación y desarrollo sostenible del corredor de las áreas naturales protegidas La Paya (Colombia), Gueppí (Perú) y Cuyabeno (Ecuador)', 'Contribuir a la consolidación del corredor que involucra a las áreas protegidas de La Paya en Colombia, Güeppí en Perú y Cuyabeno en Ecuador, de alto valor para la conservación de la diversidad biológica y sujeta a crecientes presiones sobre sus recursos, como un modelo para la gestión coordinada de áreas protegidas colindantes en zona de frontera y que se espera sea replicable en otros lugares de la región amazónica', '', '24', 0, 2011, 'Programa Trinacional de Conservación y Desarrollo Sostenible del Corredor de Areas Naturales Protegidas', 1, NULL, NULL),
	(4, 'Aprovechamiento sostenible del agua marina, para la obtencion de la sal en pozas de cristalizacion, en el desierto de playa Mendieta - RNP Distrito de Paracas', 'Aprovechamiento sostenible del agua de mar para la extraccion de sal, contribuyendo en promover trabajo para la poblacion local, respetando la conservacion del ambiente y de la biodiversidad de la Reserva Nacional de Paracas en el desierto de playa Mendieta', 'Playa Mendieta', '', 0, 0, '', 1, NULL, NULL),
	(5, 'Beneficios de los bienes y servicios ecosistemicos reducen la pobreza en areas de alta biodiversidad de la Amazonia Andina Peruana', 'Contribuir a la reducción de la pobreza y la degradación ambiental en áreas de alta biodiversidad de la Amazonía andina peruana a través de la generación de capacidades y condiciones políticas, técnicas y empresariales para el desarrollo de experiencias exitosas de aprovechamiento sostenible de bienes y servicios ecosistémicos en una alianza público-privada.', 'Amazonia Andina peruana', '48', 0, 0, '', 1, NULL, NULL),
	(6, 'Building adaptation to climate change in Andean protected area systems: A trinational initiative', 'La creación y consolidación de una red de seis nuevas áreas protegidas por un total de 563.114 hectáreas en los flancos orientales de los Andes, con un sistema integrado de vigilancia que se alimenta de información sobre los impactos del cambio climático en la mejora de la capacidad de adaptación de los sistemas de áreas protegidas andinas.', '', '48', 0, 2012, 'Proyecto en el marco a la Iniciativa de la 10 million  Ha liderada por Ecuador.  Life Web Iniciative y TNC ayudaron en la elaboración del proyecto. ', 1, NULL, NULL),
	(7, 'Canje de deuda por Conservacion - Reserva Nacional Pacaya Samiria (RNPS)', 'Contribuir a la conservación de la biodivesidad de la RNPS', '', '144', 0, 2014, '', 1, NULL, NULL),
	(8, 'Canje de Deuda por Conservación en la Reserva Nacional Pacaya Samiria, Perú - Fase II', 'Incrementar los beneficios económicos percibidos por los grupos de manejo de las cuencas Yanayacu Pucate y Pacaya a través del aprovechamiento sostenible de los recursos naturales de la RNPS.', '', '24', 0, 2010, '', 1, NULL, NULL),
	(9, 'Communities of Conservation: Safeguarding the World\'s Most Threatened Species', 'The goal of this project is to conserve AZE biodiversity sites in the tropical Andes.  Through careful selection of up to 12 campaign sites where a reciprocal agreements for watershed services (ARA) program is an appropriate strategy to improve the protected status of AZE habitat, this project will build the capacity of local leaders and their communities to recognize, validate, and contribute towards sustained provision of local watershed and global biodiversity conservation benefits.', '', '36', 0, 2012, '', 1, NULL, NULL),
	(11, 'Conservacion de la Biodiversidad en la Selva Peruana considerando aspectos de proteccion del clima', 'Contribuir a la realizacion de los objetivos nacionales para la conservacion de la biodiversidad y la proteccion del clima', '', '36', 0, 2012, 'Iniciativa internacional parala proteccion del clima (del ministerio federal del medio ambiente …-Alemania)', 1, NULL, NULL),
	(12, 'Conservación de la biodiversidad y cambio climatico en el bosque tropical peruano en la RC El Sira.', 'Reforzamiento de estrategias de conservación y de uso sostenible de la biodiversidad, para mejorar la capacidad de adaptación al cambio climático mediante la captura y la fijación de carbono, basada en la conservación de la RC El Sira y su zona de influencia, ecosistemas de alto valor biológico de la Selva Central del Perú', '', '36', 0, 2012, '', 1, NULL, NULL),
	(13, 'Conservacion de los bosques de Arena Blanca dela Reserva Nacional Allpahuayo Mishana', 'Prevenir la extincion de la especie endemica Perlita de Iquitos (Polioptila clementsi) previendo de Habitat a esta y otras aves restringidas a los bosques de arena blanca', '', '11', 0, 2010, '', 1, NULL, NULL),
	(14, 'Conservación de los recursos forestales en la cuenca del Rio Sepahua', 'Elaborar el Plan de Desarrollo Integral de la Cuenca del Rio Sepahua, para permitir a la Municipalidad Distrital de Sepahua tener una base para un ordenamiento y priorización de actividades que lleven a un crecimiento adecuado y sostenible de los recursos naturales del distrito', 'Cuenca del Rio Sepahua', '24', 0, 2007, 'Es parte del Acuerdo para la Conservacion de Bosques Topicales', 1, NULL, NULL),
	(15, 'Conservación y Uso Sostenible de la Biodiversidad asociada a los caminos ancestrales andinos', 'Promover actividades de conservación y uso sostenible de la biodiversidad que apoyen  la consolidación del programa de gestión subregional del paisaje natural y cultural de áreas naturales protegidas asociadas a Caminos Ancestrales Andinos, principalmente la Gran Ruta Inca (GRI). ', '', '', 0, 0, 'Proyecto incluido en la Estrategia Regional de Biodiversidad de los Países del Trópico Andino (ERB), apoyo a la propuesta de la Gran Ruta Inca ', 1, NULL, NULL),
	(16, 'Conservation and Ecological Restoration of Lomas and Community based Management of Natural Resoruces in Atiquipa, Perú.', 'Consolidación de los resultados obtenidos antes de iniciativas de la comunidad  de Atiquipa, soporte técnico de diferentes instituciones, reforestación de las lomas, restauración y implementación de mejoras para retensión de agua, etc.', 'Lomas de Atiquipa (perteneciente a la Atiquipa Peasant Community).', '48', 0, 0, '', 1, NULL, NULL),
	(17, 'Consolidacion del Corredor de Conservacion de los Polylepis en los Conchucos Sur', 'Establecer un corredor de conservacion para proteger y restaurar los ecosistemas altoandinos entre el PNH y la ZRCHU', 'Conchucos Sur - Region Ancash', '12', 0, 2011, 'Convenio entre Conservation Stewards Program y Conservation International Peru Program', 1, NULL, NULL),
	(18, 'Constitución de Áreas de Conservación Municipal', 'Incorporar la conservación de la biodiversidad y el manejo sostenible de recursos como Política del Estado ', '', '12', 0, 2006, 'Es parte del Acuerdo para la Conservacion de Bosques Topicales', 1, NULL, NULL),
	(19, 'Construcción e implementación de Puestos de Control en Altos Purús', 'Lograr la construcción e implementación de 2 puestos de vigilancia, uno ubicado en la boca del Rio Inuya surcando el Rio Urubamba mano izquierda y otro en el Rio Sepahua, dada que ambas ubicaciones fueron identificadas como las de mayor incidencia de extracción forestal ilegal en el ámbito de influencia del Parque Nacional Alto Purus.', '', '24', 0, 2005, 'Es parte del Acuerdo para la Conservacion de Bosques Topicales', 1, NULL, NULL),
	(20, 'Control de la Extracción Forestal ilegal en el Sector Sur-oriental del PN Alto Purús y el ámbito de la administración técnica forestal y de fauna silvestre de Tahuamanu', 'Reducir los niveles de tala y comercio ilegal de madera y contribuir a la conservación de la naturaleza en las cuencas del Rio Tahuamanu y las Piedras, instalar e implementar un puesto de control y vigilancia en las áreas de influencia del Parque Nacional Alto Purús y la Reserva Territorial del Estado para indígenas en aislamiento voluntario, contando para ello con el compromiso de las poblaciones ubicadas en estos ámbitos.', '', '10', 0, 2005, 'Es parte del Acuerdo para la Conservacion de Bosques Topicales', 1, NULL, NULL),
	(21, 'Convenio Marco de cooperacion entre el INRENA (hoy SERNANP) y la asociacion de Ecosistemas Andino ECOAN', 'Conservacion de la biodiversidad biologica y proteccion del medio ambiente', '', '24', 0, 2010, '', 1, NULL, NULL),
	(22, 'Creación y consolidación de un mosaico de áreas de conservación, reservas indígenas y áreas de uso sostenible en la región fronteriza de Sierra del Divisor', 'Integrar los esfuerzos de ONG nacionales e internacionales para crear un mosaico territorial que responda a las necesidades locales y nacionales de conservación de diversidad biológica, protección de pueblos indígenas en aislamiento y tierras bajo manejo y uso sostenible de recursos.', '', '36', 0, 2011, 'Dentro de la Zona Reservada se encuentra la Reserva Territorial Isconahua la cual debe seguir un proceso de adecuación para ser declarada como Reserva Indígena de acuerdo a la legislación sobre indígenas en aislamiento voluntario.', 1, NULL, NULL),
	(23, 'Desarrollo de la Capacidad Institucional del SINANPE para la Gestión, Administración y Aprovechamiento Sostenible de la Biodiversidad y los Recursos Naturales en Áreas Naturales Protegidas – SINANPE II', 'Brindar asistencia técnica al Servicio Nacional de Áreas Naturales Protegidas por el Estado-SERNANP en aspectos temáticos en las que aún no cuenta con capacidades', 'SINANPE', '', 0, 0, 'En informe de gestión institucional IV trimestre 2009', 1, NULL, NULL),
	(24, 'Desarrollo Sostenible de las Comunidades Locales y Conservación de la Diversidad Biológica en el Corredor Biologico Nanay- Pucacuro', 'Promover el desarrollo sostenible de las comunidades locales, la conservación y uso sostenible de la biodiversidad, y la creación y consolidación del Corredor Biológico Nanay – Pucacuro', '', '36', 0, 2012, 'EL Fondo Finlandia es un Convenio de Cooperación Finlandia - Perú ', 1, NULL, NULL),
	(25, 'Difusión documental Manu Hotspot', '', '', '6', 0, 2005, 'Es parte del Acuerdo para la Conservacion de Bosques Topicales', 1, NULL, NULL),
	(26, 'Diseño y Ejecución de un Sistema de Monitoreo y Evaluación Biológico y Social de la Zona Reservada de Güeppí, Zona Reservada Santiago Comaina, Zona Reservada del Alto Purús, Reserva Comunal El Sira y la Reserva Nacional Pacaya Samiria', 'Definir participativamente los sitios para desarrollar actividades de monitoreo biológico  y social en laa ANP seleccionadas como condición base para la construcción de un sistema de monitoreo para estas ANPs', '', '', 0, 0, '(Proyecto PIMA / Tercer producto de la Consultoría / Parte I)', 1, NULL, NULL),
	(27, 'Disminucion de la extraccion ilegal de especies maderables, con fines comerciales de la Reserva de biosfera de Oxapampa Ashaninka Yanesha (Peru): Generacion de alternativas de uso sostenible de productos maderables y no maderables del bosque', 'Disminuir la extraccion ilegal e insostenible de especies maderable, no maderables y de fauna silvestre, respetando la zonificacion de la propuesta de la Reserva de Biosfera de Oxapampa, Yanesha y Ashaninka', 'Reserva de Biósfera Oxapampa-Asháninka-Yánesha', '18', 0, 2011, '', 1, NULL, NULL),
	(28, 'Elaboración del plan de recuperación y reforestación del Santuario Histórico Bosque de Pómac', 'Elaboración del plan de recuperación y reforestación del Santuario Histórico Bosque de Pómac', '', '3', 0, 2009, '', 1, NULL, NULL),
	(29, 'Estrategias de mitigacion para asegurar la conservacion de sternula lorata, "Gaviotin peruano" en la Reserva Nacional de Paracas (RNP), Ica - Peru Fase II', 'Implementar un sistema de señales (hitos) en la periferia de la colonia reproductiva del "gaviotin peruano" hallado en la peninsula de Paracas', '', '', 0, 0, '', 1, NULL, NULL),
	(30, 'Evaluación Inicial del Hábitat y la estructura de bosque de la estación biológica La Nube dentro del PN Bahuaja Sonene', 'Construir la Estación Biológica La Nube, a fin de realizar la evaluación inicial del hábitat y estructura del bosque; y permitir las iniciativas de futuras investigaciones', '', '12', 0, 2005, 'Es parte del Acuerdo para la Conservacion de Bosques Topicales', 1, NULL, NULL),
	(31, 'Fondo de Capacitación', 'Cubrir los gastos incurridos de 3 becarios del SINANPE en la participación al curso “Capacitación y manejo de Áreas silvestres tropicales” que se efectuó en la ciudad de Costa Rica, entre el 6 de marzo y 3 de abril del 2005 y que fue organizado por la organización para estudios tropicales (OET)', 'SINANPE', '2', 0, 2005, 'Es parte del Acuerdo para la Conservacion de Bosques Topicales', 1, NULL, NULL),
	(33, 'Fortalecimiento de la gestión ambiental y restauración ecológica en el área de conservación municipal Apu Pachatusan y la ZA del SH Machupicchu', 'Pomover la corrsponsabilidad de los gobiernos locales en la conservacion de la biodiversidad como politica del Estado, que involucra la participacion activa de la sociedad civil en el manejo de recursos naturales', 'Area de Conservacion Municipal Apu Pachatusan', '24', 0, 2010, 'Es parte del Acuerdo para la Conservacion de Bosques Topicales', 1, NULL, NULL),
	(34, 'Fortalecimiento de la gestión de la RN Tumbes mediante el ordenamiento de la actividad ganadera y la generacion de conciencia sobre el area natural protegida', 'Fortalecer la gestion de la RNT a traves del manejo ordenado de la actividad ganadera y la generacion de conciencia sobre la importancia del area entre grupos de interes local', '', '24', 0, 2010, 'Es parte del Acuerdo para la Conservacion de Bosques Topicales', 1, NULL, NULL),
	(35, 'Fortalecimiento de la Gestión, Protección y Vigilancia de la Reserva Nacional Pacaya Samiria', 'Fortalecer la gestión de la cuenca del río Samiria y afluentes de la Reserva Nacional Pacaya Samiria. ', '', '60', 0, 2015, '', 1, NULL, NULL),
	(36, 'Fortalecimiento de las autoridades científicas y administrativas CITES-Perú para la implementación de CITES Apéndice II Caoba', 'Apoyar los esfuerzos de las autoridades científicas y administrativas de la Convención sobre el Comercio Internacional de Especies Amenazadas de Fauna y Flora Silvestre(CITES), el proyecto realizó la revisión y verificación de información de 24 planes operativos anuales (POA) de un total de 18 concesiones Forestales con fines maderables', 'SINANPE', '12', 0, 2006, 'Es parte del Acuerdo para la Conservacion de Bosques Topicales', 1, NULL, NULL),
	(37, 'Fortalecimiento Institucional del SERNANP en el Marco del Environmental Development Policy Loan', 'Esta Consultoría incluirá: Una identificación de las necesidades específicas de apoyo del SERNANP, Una propuesta de una metodología sobre cómo estructurar y realizar la consultoría de fortalecimiento el apoyo, La elaboración de los Términos de Referencia para la misma y las Bases de Licitación y El apoyo al SERNANP en la contratación de la consultoría para el fortalecimiento institucional.', 'SINANPE', '', 0, 0, 'Consultoria', 1, NULL, NULL),
	(38, 'Fortalecimiento Institucional y de capacidades para la Participación Indígena en la conservación, control y manejo de la Biodiversidad en la Reserva Amakaeri, las comunidades y la Reserva para indígenas aislados en Madre de Dios', 'Fortalecer las capacidades locales en aspectos sustanciales para el buen manejo de los recursos de los bosques comunales ubicados en las áreas circundantes y aledañas a la Reserva Comunal Amarakaeri. ', '', '24', 0, 2007, 'Es parte del Acuerdo para la Conservacion de Bosques Topicales', 1, NULL, NULL),
	(39, 'Fortalecimiento y Consolidación del sistema de protección, control, vigilancia y permanente operatividad del puesto de control en el rio Las Piedras, Parque Nacional Alto Purús', 'Establecer mecanismos de control y vigilancia a fin de prevenir, reducir y evitar actividades no permitidas que afecten los objetos de conservación del Parque y que se eviten contactos con indígenas en aislamiento voluntario.', '', '36', 0, 2011, 'Ejecutado al 44%. En el Informe de Gestión Institucional IV Trimestre 2009', 1, NULL, NULL),
	(40, 'Gestión Ambiental Estratégica de RRNN base para promover el Desarrollo Económico Sostenible y Alivio de la Pobreza.', 'Aliviar la pobreza, en base al uso sostenible de los RRNN, en armonía con el ambiente, promover desarrollo económico de zonas priorizadas, usando tecnologías innovadoras, para incrementar competitividad, rentabilizar el campo y que posibiliten el acceso a los mercados.', 'Pasco, Junin y Ayacucho', '36', 0, 2013, 'Programa indicativo de Cooperación 2010-2013 (PIC): Programa de Desarrollo Económico Sostenible y Gestión Estratégica de los RRNN', 1, NULL, NULL),
	(41, 'Gestión de colaboración para la Conservación y Desarrollo Sostenible de la Reserva de la Biosfera del Noroeste', 'El proyecto busca lograr el manejo colaborativo de la Reserva de Biosfera del Noroeste, por la creación de capacidad entre las partes interesadas para permitir una participación real de los tomadores de decisiones locales a diferentes niveles en el proceso de gestión, con el objetivo de revertir las tendencias negativas (especialmente los procesos de desertificación) y conservación de la diversidad biológica existente.', '', '36', 0, 2002, '', 1, NULL, NULL),
	(42, 'Gestión eficiente, participativa y sostenible en el sector Sepahua-Inuya del Parque Nacional Alto Purús', 'Contribuir a la gestión eficiente, participativa y sostenible el Parque Nacional Alto Purús (PNAP), atendiendo a sus objetivos de creación y sus necesidades más urgentes.', '', '9', 0, 2009, '', 1, NULL, NULL),
	(43, 'Gestión integral y uso sostenible del tramo de la Gran Ruta Inca: Huancabamba – Caxas y sus áreas de influencia (Piura)', 'Integrar la conservación del patrimonio natural y cultural a lo largo de la Gran Ruta Inca.', '', '36', 0, 2011, 'PROGRAMA REGIONAL SOBRE USO Y CONSERVACIÓN DE LA BIODIVERSIDAD EN LOS PAISAJES NATURALES Y CULTURALES ASOCIADOS CAMINOS ANCESTRALES ANDINOS', 1, NULL, NULL),
	(44, 'Gestión Participativa de la RC. Ashaninka y el PN Otishi y su ZA', 'La ZA funciona en la protección de las RCAs y PNO, con producción compatible en las CCNN y organizaciones de base que asumen y comparten eficientemente funciones con el estado.', '', '36', 0, 2011, 'Canje de deuda por naturaleza entre Perú y EEUU', 1, NULL, NULL),
	(45, 'Gestión Participativa para la conservación y desarrollo sostenible de los bosques secos del SHBP', 'Mejorar el control y vigilancia de los recursos al interior del SHBP mediante la implementación de equipos de comunicación, movilidad y capacitación en patrullajes por promotores de conservación.', '', '12', 0, 2007, 'Es parte del Acuerdo para la Conservacion de Bosques Topicales', 1, NULL, NULL),
	(46, 'Gestión participativa para la conservación y el desarrollo sostenible de los bosques secos del SHBP y su ZA -II etapa (Proy. Pómac)', 'Fortalecer la gestión del SHBP reduciendo las presiones sobre los objetos de conservación.', '', '36', 0, 2011, 'Ejecución al 61.01%. En el Informe de Gestión Institucional IV Trimestre 2009', 1, NULL, NULL),
	(47, 'Gestión Sostenible de Áreas Protegidas y  Bosques de la Sierra Norte del Perú', 'Promover la gestión participativa y sostenible de las áreas protegidas y tierras forestales comunales en la región altoandina del norte del Perú.', 'Lambayeque y cajamarca (Bosque de Cañaris y  y ACP Chaparri)', '60', 0, 0, 'A nivel de perfil a marzo del 2009', 1, NULL, NULL),
	(48, 'Hacia un manejo con enfoque ecosistémico del Gran ecosistema Marino de la Corriente Humboldt.', 'Avanzar hacia el manejo ecosistémico para el GEMCH a través de un marco coordinado que fortalezca la gobernanza y eluso sostenible de los recursos vivios y servicios marinos.', 'ANPs del Gran Ecosistema Marino de la Corriente de Humboldt', '', 0, 0, 'Chile y Peru son parte del programa GEF/PNUD/OMT para la Gestión Global de Aguas de Lastre (GloBallast)', 1, NULL, NULL),
	(49, 'Implementación de los Apéndices II y III de la CITES para especies maderables por la Autoridad Administrativa CITES – Perú', 'Verificar las existencias de caoba y cedro declarados en Planes Operativos Anuales de concesionarios y comunidades nativas en los departamentos de San Martin y Ucayali, permitiendo así la verificación de la correcta información consignada de 23 POAs; 8 POAs en concesiones forestales en San Martin y 15 POAs en Ucayali correspondientes a 14 concesiones forestales y una comunidad nativa.', '', '8', 0, 2006, 'Es parte del Acuerdo para la Conservacion de Bosques Topicales', 1, NULL, NULL),
	(50, 'Implementación de Unidad para áreas de conservación regionales y privadas dentro del SERNANP y de programa de enlace para apoyo en la gestión de áreas protegidas regionales con los gobiernos regionales de Cusco, Loreto y Piura. ', 'Apoyo financiero de la CAF al Servicio Nacional de Áreas Naturales Protegidas – SERNANP para la Implementación de Unidad para áreas de conservación regionales y privadas dentro del Servicio Nacional de Áreas Naturales Protegidas – SERNANP y de programa de enlace para el apoyo en la gestión de áreas protegidas regionales con los gobiernos regionales de Cusco, Loreto y Piura.', 'Cuzco Loreto  y Piura', '15', 0, 2011, 'Sólo está la solicitud a la CAF presentada por SERNANP', 1, NULL, NULL),
	(51, 'Implementación del Centro del Bosque de los niños  en Madre de Dios', 'Construir y equipar el Centro del Bosque de los Niños, creando un espacio especialmente diseñado para promover valores y prácticas de responsabilidad social y ambiental en la niñez', '', '24', 0, 2006, 'Es parte del Acuerdo para la Conservacion de Bosques Topicales', 1, NULL, NULL),
	(52, 'Implementación del Plan de Capacitación para el personal y los actores que participan en la gestión del SINANPE', 'Implementar el Plan de capacitación para el personal y los actores que participan en la gestion del SINANPE', 'SINANPE', '36', 0, 2011, 'Es parte del Acuerdo para la Conservacion de Bosques Topicales', 1, NULL, NULL),
	(53, 'Implementación y Manejo del Parque Nacional Cordillera Azul', 'Brindar apoyo técnico y logístico a la Jefatura del Parque Nacional Cordillera Azul y los puestos de vigilancia del ANP. Para ello el proyecto realizó un recorrido por los 8 puestos de vigilancia, elaborando un informe técnico sobre el estado, capacidades y necesidades del parque.', '', '6', 0, 2003, 'Es parte del Acuerdo para la Conservacion de Bosques Topicales', 1, NULL, NULL),
	(54, 'Iniciativa de Conservación del BPAM', 'Contribuir en los esfuerzos de conservacion de dicha ANP y al manejo sostenible de su ZA,mediante esquemas de reducción de emisiones.', '', '6', 0, 2010, 'Convenio entre Conservation Stewards Program y Conservation International Peru Program', 1, NULL, NULL),
	(55, 'Manejo Integrado para el Desarrollo Sostenible del Corredor de Gestión Trinacional de las Áreas Protegidas La Paya (Colombia), Cuyabeno (Ecuador) y Güeppi (Perú)', 'consolidación del corredor de gestión del Parque Nacional La Paya en Colombia, la Zona Reservada de Güeppí en el Perú y la Reserva de Producción Faunística Cuyabeno en el Ecuador, como modelo de conservación y de desarrollo sostenible regional, en el marco del la cooperación y el fortalecimiento de las relaciones en la zona de frontera.', '', '', 0, 0, 'PROGRAMA: plan de desarrollo e integracion fronteriza Colombia Peru', 1, NULL, NULL),
	(56, 'Manejo Integral de bosques comunitarios en el Valle de Pichis - Selva Central', '', '', '', 0, 0, '', 1, NULL, NULL),
	(57, 'Manejo integral de los recursos naturales en tres localidades de los departamentos de Apurímac, Ayacucho y Huancavelica', 'Mejorar la calidad de vida de las poblaciones beneficiarias, potenciando su desarrollo económico en un marco de sostenibilidad. ', 'Pasco, Junin y Ayacucho', '36', 0, 2013, 'A nivel de perfil a marzo del 2009', 1, NULL, NULL),
	(58, 'Mejora en la produccion de camelidos sudamericanos y generacion de autoempleo en la RNSAB', 'Garantizar la conservacion de los recursos naturales y paisajisticos, propiciar la utilizacion racional de los recursos naturales renovables, fomentar el turismo y promover el desarrollo socioeconomico de las poblaciones aledañas', 'Comunidades de la RNSAB', '36', 0, 2012, '', 1, NULL, NULL),
	(59, 'Mejoramiento del circuito turistico Cueva de Lechuzas en el Parque Nacional Tingo Maria', 'Mejoramieno del acceso de ingreso y balcones suspendidos de la Cueva de las Lechuzas del PNTM', '', '5', 0, 2009, 'Actualmente se encuentra paralizada la obra por falta de desembolso de parte del programa Construyendo Peru, al 12 de marzo del 2009', 1, NULL, NULL),
	(60, 'Mejoramiento y acondicionamiento de franja perimétrica del sector de recuperacion del refugio de vida silvestre los pantanos de villa, con fines de minimizacion de efectos contaminantes e integracion de las poblaciones locales en el cuidado del humedal', 'Conservar y proteger al área natural a través del mejoramiento ya condicionamiento de franja perimétrica del sector de recuperacion del RVSPV, para minimizar y prevenir las alteraciones que puedna estar ocurriendo en su interior.', '', '12', 0, 2010, '', 1, NULL, NULL),
	(61, 'Modelo de coordinación fronteriza para la conservación y el desarrollo sostenible en el corredor Paya (Colombia), Gueppí (Perú) y Cuyabeno (Ecuador) (PROYECTO COHESIÓN SOCIAL II)', 'Consolidación del corredor de gestión del Parque Nacional La Paya en Colombia, la Zona Reservada de Güeppí en el Perú y la Reserva de Producción Faunística Cuyabeno en el Ecuador, como modelo de conservación y de desarrollo sostenible regional, en el marco del la cooperación y el fortalecimiento ', '', '36', 0, 2013, 'El proyecto se enmarca dentro del Plan Estratégico 2004-2012. de la Organización del Tratado de Cooperación Amazónica OTCA', 1, NULL, NULL),
	(62, 'Ordenamiento territorial y uso sostenible de los recursos naturales en las cuencas de los río Morona y Pastaza  ', 'Priorización de la gestión sostenible de los recursos naturales y la conservación de la biodiversidad a fin de incrementar los beneficios para las comunidades nativas y los actores locales', 'Cuencas de los ríos Morona y Pastaza – Región Loreto', '120', 0, 2013, '', 1, NULL, NULL),
	(63, 'Paz y Conservación Binacional en la Cordillera “El Cóndor”, Ecuador – Perú / Componente Peruano, Fase I (2002-2004)', 'Promover la conservación de la biodiversidad a través del fortalecimiento de las capacidades de las comunidades indígenas para usar los recursos naturales en sus áreas de ocupación en forma sostenible conforme a la estrategia nacional para las áreas naturales protegidas.', '', '24', 0, 2004, '', 1, NULL, NULL),
	(64, 'Paz y Conservación Binacional en la Cordillera del Cóndor, Ecuador-Perú Fase II (componente Peruano)', 'Apoyar el fortalecimiento de la gestión y difusión del Parque Nacional Ichigkat Muja – Cordillera del Cóndor, con la implementación del Plan Maestro del Parque Nacional Ichigkat Muja – Cordillera del Cóndor y funcionamiento del Comité de Gestión del Parque.', '', '36', 0, 2010, '', 1, NULL, NULL),
	(65, 'Prevision de Emisiones mediante una gestion eficaz de resevas Naturales en la Amazonia Peruana', 'Contribuir a la prevension de emisiones de gases de efecto invernadero, asi como la conservacion de la biodiversidad', 'El ámbito del proyecto es de aproximadamente 1.65  millones de ha [616,413.41 ha correspondientes a la Reserva Comunal y 1´032,340 a la zona de amortiguamiento', '36', 0, 2012, 'Iniciativa internacional parala proteccion del clima (del ministerio federal del medio ambiente …-Alemania)', 1, NULL, NULL),
	(66, 'Programa de Apoyo al Desarrollo Sostenible de la Zona de Influencia del Santuario Nacional Tabaconas Namballe (Provincia de San Ignacio, Departamento de Cajamarca) ', 'Contribuir a mejorar las capacidades de gestión del Santuario, promover el desarrollo de actividades económicas a través de la aplicación de prácticas agropecuarias ambientalmente adecuadas. ', '', '36', 0, 2009, 'Programa indicativo de Cooperación 2010-2013 (PIC): Programa de Desarrollo Económico Sostenible y Gestión Estratégica de los RRNN', 1, NULL, NULL),
	(67, 'Programa de Centros de servicios empresariales no financieros en Ayacucho - Apurimac y Huancavelica - Fase II ', 'Favorecerá la constitución de asociaciones de productores rurales y de Conglomerados de MYPES urbanos dinámicos a través del impulso de cadenas productivas con potencial Competitivo y del fortalecimiento de las capacidades Empresariales.', 'Huancavelica, Ayacucho y Apurimac', '36', 0, 2013, 'Programa indicativo de Cooperación 2010-2013 (PIC): Programa de Desarrollo Económico Sostenible y Gestión Estratégica de los RRNN', 1, NULL, NULL),
	(68, 'Programa Indicativo de Cooperación – PIC VII (2010-2013).', 'Nivel de pobreza de los hombres y mujeres de las regiones consideradas en el ámbito del Programa reducido aprovechando en forma ordenada los recursos naturales y tomando en cuenta las necesidades de las generaciones futuras.', '', '36', 0, 2013, '', 1, NULL, NULL),
	(69, 'Propuesta para la Administración del Fondo de Becas - ACBT', 'Gestionar eficiente y responsablemente la administracion de fondo de becas (ACBT) por un periodo de 3 años para el personal tecnico y administrativo de instituciones publicas y privadas cuyo trabajo se relacione con la conservacion de bosques tropicales en las 17 areas naturales protegidas priorizadas  ', '', '36', 0, 2011, 'Es parte del Acuerdo para la Conservacion de Bosques Topicales', 1, NULL, NULL),
	(70, 'Proteccion de la cuenca de Alto Mayo', 'Proteger el bosque de Alto Mayo y las especies endemicas de fauna y flora, asimismo contribuir a lamitigacion del cambio climatico con la reduccion de la emision de gases producto de la deforestacion ', '', '60', 0, 0, '', 1, NULL, NULL),
	(71, 'Proteccion del bosque de  Alto Mayo', 'Reducir la deforestacion del BPAM y de su zona de amortiguamiento promoviendo actividades economicas sostenibles para su restauracion y el mantenimiento de sus servicios ecosistemicos incluyendo biodiversidad, agua y carbono', 'Region de San Martin y Amazonas', '240', 0, 0, '', 1, NULL, NULL),
	(72, 'Proyecto de Deforestacion Evitada en el Bosque de Proteccion Alto Mayo', 'Contribuir con la proteccion del BPAM y la proteccion de los servicios ambientales que ofrece a las poblaciones locales (agua, fauna, paisajes) y a ni vel global (carbono, biodiversidad)', '', '12', 0, 2011, 'Convenio entre Conservation Stewards Program y Conservation International Peru Program', 1, NULL, NULL),
	(73, 'Proyecto de Gestión Sostenible de Áreas Protegidas y  Bosques de la Sierra Norte del Perú', 'Promover el manejo sostenible y participativo de áreas protegidas y tierras forestales comunales de la Sierra Norte', 'Lambayeque y Cajamarca', '60', 0, 2014, '', 1, NULL, NULL),
	(74, 'Proyecto Fondo Paracas', 'Apoyar la recuperación y gestión de la Reserva Nacional de Paracas', '', '480', 0, 0, '', 1, NULL, NULL),
	(75, 'Proyecto integral Araucaria XXI - Conservacion y Desarrollo Sostenible de la Reserva de Biosfera del Noroeste.', 'Conservacion de biodiversidad biologica en la Reserva de Biosfera del Nor oeste', '', '36', 0, 2011, '', 1, NULL, NULL),
	(76, 'PROYECTO PIMA: Participación de las Comunidades Nativas en el Manejo de las Áreas Naturales Protegidas en la Región Amazónica Peruana', 'Plan de manejo de RRNN en la RNPS Plan de investigacion y linea base', '', '', 0, 0, 'Plan de Investigación de la RN Pacaya Samiria 2005 - 2015 y Plan de Manejo de RRN de la RNPS', 1, NULL, NULL),
	(77, 'Recuperacion ambiental del Humedal Luganilla y puesta en valor como atractivo turistico, garantizando la conservacion de la biodiversidad en la RNP - Pisco - Ica', 'Lograr la conservacion de la biodiversidad del sector de Lagunilla, distrito de Paracas, mediante la recuperacion del paisaje y su puesta en valor para la promocion y desarrollo turistico, cultural y social de la poblacion local y region Ica', '', '', 0, 0, '', 1, NULL, NULL),
	(78, 'Reserva Comunal Chayu Nain (Amazonas, Perú): fortalecimiento de la capacidades locales para el manejo y la educación para la conservación', 'Los líderes awajun capacitados para conformar el ejecutor del contrato de administracion, profesores de escuelas de las CCNN mejoran sus capacidades de educacion, maestros dela comunidad como lìderes de opinión promueven valores de conservacion y los guaedaparques del ANP se capacitan.', '', '', 0, 0, 'Proyecto recien va a aplicar para obtener financiamiento', 1, NULL, NULL),
	(79, 'Reserva Comunal de Polylepis en la Cordillera de Vilcanota', 'Crear y consolidar un Sistema de Reservas de los Bosques de Polylepis dirigido y conducido por las comunidades campesinas locales, con alternativas reales conducentes al uso y desarrollo sostenible de los bosques alto andinos, la misma que permita la recuperación de las poblaciones de aves en estado crítico. ', 'Cordillera del Vilcanota', '12', 0, 2005, 'Es parte del Acuerdo para la Conservacion de Bosques Topicales', 1, NULL, NULL),
	(80, 'Supporting Manu National Park Natural World Heritage Site in Peru - Climate Change Adaptation and Risk Management Project', 'Mantener la biodiversidad global excepcional y la diversidad cultural del Manu en relación con los emergentes en relación los impactos del cambio climático, los riesgos de desastre, y el desarrollo humano', '', '24', 0, 0, '', 1, NULL, NULL),
	(81, 'Un paisaje integrado de conservación y desarrollo sostenible: fortalecimiento de un SIRAP y Territorios Indígenas en la cuenca Trinacional del Río Putumayo" (PROYECTO PUTUMAYO TRES FRONTERAS) (2010-2014)', 'Contribuir a la conservación de la biodiversidad y al desarrollo sostenible de la cuenca media del río Putumayo en el marco de los acuerdos y compromisos ambientales multilaterales adquiridos por Colombia, Ecuador y Perú.', '', '48', 0, 2014, 'Programa Trinacional de Conservación y Desarrollo Sostenible del Corredor de Areas Naturales Protegidas ', 1, NULL, NULL),
	(83, 'RAINFOR: Un proyecto para entender el balance  de carbono en los bosque amazonicos', 'Determinar el actual balance de carbono en los bosques amazonicos , junto con los flujos ecologicos asociados y su sensibilidad a las variaciones climaticas y del suelo', '', '12', 0, 0, '', 1, NULL, NULL),
	(84, 'Caminando al Apu Pariaca: Promoción del Turismo Rural Comunitario asociado al Camino Inca del Nevado Pariacaca para la conservación ambiental y el desarrollo económico de las poblaciones alto‐andinas de la RPNYC', 'Promover el turismo rural comunitario como vector del desarrollo económico local y como promotor de estrategias de conservación de potencialidades y recursos tangibles e intangibles de las comunidades alto andinas de la RPNYC', '', '24', 0, 2012, '', 1, NULL, NULL),
	(85, 'Conservacion de la Biodiversidad en Areas Naturales Protegidas del Peru para la mitigacion planificada al cambio climatico MACC Selva Central', 'Evitar la deforestacion y contribuir a la mitigacion y adaptacion al cambio climatico a traves de la conservacion participativa y sostenible de los ecosistemas del Peru, mediante la aplicación de un conjunto de  medidas de gestion', '', '48', 0, 2013, '', 2, '', NULL),
	(86, 'Instalacion Piscicola para produccion y Comercializacion de Peces Tropicales', '', '', '', 0, 0, '', 2, '', NULL),
	(87, 'Manejo Diversificado de cultivos de achiote y cacao para la generacion de ingresos economicos en una comunidad nativa Yanesha del distrito de Palcazu', '', 'Comunidad nativa ubicada en la ZA de RCY', '', 0, 0, '', 2, '', NULL),
	(88, 'Mejorar la produccion de cafe organico y reforestar a traves de sistemas agroforestales en el Centro Kokari, distrito de Puerto Bermudez, provincia de Oxapampa, Region Pasco', '', '', '', 0, 0, '', 2, '', NULL),
	(89, 'Plantaciones forestales para la recuperacion de terrenos degradados en la ZA de la microcuenca San Alberto - Oxapampa', '', '', '', 0, 0, '', 2, '', NULL),
	(90, 'Reducción de Emisiones Derivadas de la Deforestación y Degradación de los Bosques, a través de Áreas Protegidas en la Región Amazónica. Fase I', 'Contribuir a la proteccion del bosque y a la reduccion de emisiones de CO2, logrando un efecto economico positivo para la poblacion', '', '24', 0, 2011, '', 2, 'Propuestas normativas para la legislación de ANP en el marco de PSA, Elaboracion de propuestas para la implementacion de los mecanimos regulatorios para esquemas de PSA', NULL),
	(91, 'Reduccion de la deforestacion y degradacion en la Reserva Nacional Tambopata y en el Parque Nacional Bahuaja Sonene del ambito de la region Madre de Dios', 'Reducción de la deforestación en las áreas naturales protegidas a través de las promoción de actividades económicas sostenibles en la zona de amortiguamiento y mejoramiento del sistema de monitoreo y control.', '', '240', 0, 2031, 'El proyecto puede ser clasificado como REDD de acuerdo a los standares de VCS. Es un proyecto individual, no grupal', 2, '', NULL),
	(92, 'Proyecto REDD en la Reserva Comunal Ashaninka', 'Proteger las areas que sirven de fuente de recursos biologicos y de agua para las poblaciones Ashaninka asentada en la margen derecha de los rios Tambo, Ene y Apurimac, protegiendo su belleza escenica y valores culturales intrinsico', '', '240', 0, 2032, '', 2, '', NULL),
	(93, 'Armonización del marco legal, institucional y político relacionado a la viabilidad de los proyectos REDD en el Perú', 'Armonizar de una manera participativa, multisectorial y descentralizada el marco político, institucional y legal relacionado a la viabilidad de los mecanismos de reducción de Emisiones derribadas de la Deforestación (REDD) y Carbono Forestal en el Perú.', '', '18', 0, 2010, '', 2, '', NULL),
	(94, 'Proyecto REDD de la Concesión de Conservación Los Amigos', 'El proyecto REDD en la concesión de conservación Los Amigos tiene como objetivo proteger para siempre las más de 145 hectáreas de bosque amazónico primario prístino. Para llevar a cabo esto, el proyecto involucrará a la comunidad local en la conservación a través de la implementación de mecanismos tales como acuerdos de conservación, y fondos, entre otros mecanismos que se irán determinando durante el proceso para asegurar la protección del área y el beneficio de la comunidad local.', '', '', 0, 0, '', 2, '', NULL),
	(155, '"Agricultura y Bosques Sostenibles para una vida mejor,', NULL, NULL, NULL, 0, 0, NULL, 3, NULL, NULL),
	(156, 'Reserva Nacional Tambopata"', 'Mejorar la situación socio – económica y alimentaria de las familias involucradas, mediante la capacitación y promoción de la agroforestería, cuya propuesta amigable con la naturaleza contribuirá a la disminución de la deforestación en el eje carretero y en la Zona de Amortiguamiento de la Reserva Nacional Tambopata.', 'Comunidades Santa Rita Alta, Santa Rita Baja, Primavera Baja y Nueva Generación, distrito de Inambari, provincia de Tambopata, departamento de Madre de Dios', '14', 0, 2007, 'Los socios de AGROBOSQUE están comprometidos con el proyecto y están convencidos que la agroforestería es una buena alternativa para alcanzar el bienestar económico sin deforestar el bosque que componen sus parcelas.', 3, NULL, NULL),
	(157, 'Ampliación de la reforestación bajo sistemas agroforestales con especies maderables para el mejoramiento del medio ambiente, Parque Nacional Bahuaja Sonene', 'Contribuir a la mitigación del impacto sobre el medio ambiente del ecosistema del sector Santa Rosa – Corredor Mazuco – Puerto Maldonado, mejorando la calidad de vida de sus pobladores mediante la reforestación y la instalación y manejo del cacao bajo sistemas de agroforesteria.', 'Sectores Santa Rosa, Nueva Esperanza, Santa Rita Alta y Primavera Alta, Distrito Inambari, Provincia Tambopata, Departamento Madre de Dios', '24', 0, 2009, '', 3, NULL, NULL),
	(158, 'Aprovechamiento sostenible de la diversidad biológica y el ecosistema en el Parque Nacional Huascarán', 'Fomentar el aprovechamiento sostenible de la diversidad biológica en la zona del parque Huascaran de la comunidad Campesina de Tumpa y la recuperación de los recursos biológicos, a través de selección de semillas, esquejes y raíces, según las especies que se encuentra en la zona.', '', '72', 0, 2007, '', 3, NULL, NULL),
	(159, '"Aprovechamiento sostenible de la fruticultura tecnificada mediante sistemas agroforestales en la zona de amortiguamiento del PNBS-San Gabán,', NULL, NULL, NULL, 0, 0, NULL, 3, NULL, NULL),
	(160, 'Parque Nacional Bahuaja Sonene"', 'Incrementar de manera sostenible el ingreso y empleo de las 24 familias beneficiarias del proyecto, en la zona de amortiguamiento del PNBS.', 'Sectores Coricancha, Corimayo, Santa Teresa, Jabonmayo, Trinchera, Limonchaya y Calcel Punco, Distrito San Gabán, Provincia Carabaya, Región Puno.', '22', 0, 2009, '', 3, NULL, NULL),
	(161, 'Cercos de Exclusión para manejo de ganado doméstico, mejoramiento y manejo de pasturas nativas y mejoradas', 'Recuperar la condición vegetal de los pastizales y promover la ampliación de sitios de pastura en la comunidad campesina de Huayllacucho', '', '12', 0, 2007, 'Se instalaron 22 cercos de exclusión para el manejo de pasturas, 15 fueron instalados con el financiamiento del Proyecto GPAN y 7 con el aporte de la Municipalidad Distrital de San Juan de Tarucani.', 3, NULL, NULL),
	(162, '"Consolidación del Centro Ñape, de la Comunidad Nativa de Infierno, como promotor de la medicina tradicional regional y difusor de la cultura Ese’eja,', NULL, NULL, NULL, 0, 0, NULL, 3, NULL, NULL),
	(163, 'Reserva Nacional Tambopata"', 'Construir e Implementar la infraestructura necesaria para la realización de actividades de tipo místico, de relajación y de difusión cultural en el Centro Ñape de la Comunidad Nativa de Infierno.', '', '12', 0, 2008, 'Se han construido los diferentes ambientes del Centro Ñape y se han sembrado plantas medicinales que son utilizadas como insumos para la elaboración de medicina natural.', 3, NULL, NULL),
	(164, '"Consolidación productiva y empresarial de los agricultores del Centro Poblado Mayor de Lechemayo en la zona de amortiguamiento del PNBS,', NULL, NULL, NULL, 0, 0, NULL, 3, NULL, NULL),
	(165, 'Parque Nacional Bahuaja Sonene"', 'Contribuir a generar ingresos económicos y empleos productivos en las familias de agricultores asentadas en el ámbito de la zona de amortiguamiento del PNBS.', 'Comunidad de Lechemayo, Distrito San Gabán, Provincia Carabaya, Región Puno.', '24', 0, 2009, '', 3, NULL, NULL),
	(166, '"Constitución y promoción de la empresa procesadora y comercializadora de sal de la C.C. Santa Lucía de Salinas,', NULL, NULL, NULL, 0, 0, NULL, 3, NULL, NULL),
	(167, 'Reserva Nacional Salinas y Aguada Blanca"', 'Manejo, conservación y recuperación del lecho de la laguna de Salinas mejorando sus condiciones medioambientales, base de la actividad económica de la C.C. de Santa Lucia de Salinas; obteniendo un producto con valor agregado, requisito para la superación de la pobreza y elevar los niveles socioeconómicos de Comunidad.', 'Comunidad Campesina de Salinas Huito', '11', 0, 2008, 'El proyecto fue reformulado debido al incremento de los precios de los materiales y la disminución del tipo de cambio. Todo esto, sumado al cambio de asistente técnico ocasionó un retraso en la ejecución del proyecto.', 3, NULL, NULL),
	(168, '"Construcción de un albergue turístico en Puerto 25,', NULL, NULL, NULL, 0, 0, NULL, 3, NULL, NULL),
	(169, 'Santuario Nacional Los Manglares de Tumbes"', 'Mejorar las condiciones de atención a los turistas que visiten el Santuario Nacional Los Manglares de Tumbes – SNLMT en los sectores “El Oscuro” y “Puerto 25”', 'Zonas Puerto 25 y El Oscuro; Distrito Zarumilla, Provincia Zarumilla, Departamento Tumbes', '9', 0, 2008, 'Se ha construido el esqueleto del albergue y la sala de espera turística. La página web de la Organización es: www.turismoaseprohi.com', 3, NULL, NULL),
	(170, 'Control y vigilancia para la conservación y manejo sostenible de la vicuña en San Antonio de Chuca - Imata, Reserva Nacional Salinas y Aguada Blanca', 'Control y Vigilancia para la Conservación y Manejo Sostenible de la Vicuña en San Antonio de Chuca – Imata', '', '11', 0, 2008, 'Se han realizado talleres sobre manejo de vicuñas y se han adquirido radios portátil, binoculares y módulos de esquila mecanizada para el control y vigilancia de las vicuñas.', 3, NULL, NULL),
	(171, '"Desarrollo de capacidades para asegurar las características genotípicas de especies maderables y no maderables para la implementación de sistemas agroforestales,', NULL, NULL, NULL, 0, 0, NULL, 3, NULL, NULL),
	(172, 'Reserva Nacional Tambopata"', 'Desarrollar capacidades para asegurar las características genotípicas de especies maderables para la implementación de sistemas agroforestales como instrumento en la regeneración del bosque.', 'Localidad Nueva América, Distrito Tambopata, Provincia Tambopata, Región Madre de Dios.', '12', 0, 2009, '', 3, NULL, NULL),
	(173, '"Desarrollo sostenible mediante el Ecoturismo Vivencial en la zona de amortiguamiento de la Reserva Nacional Tambopata,', NULL, NULL, NULL, 0, 0, NULL, 3, NULL, NULL),
	(174, 'Reserva Nacional Tambopata"', 'Fomentar el desarrollo sostenible a través de la promoción del turismo vivencial generado bajo una experiencia piloto de gestión participativa para conservación y ecoturismo en la Zona de Amortiguamiento de la RNTAMB, sector La Torre, Madre de Dios.', '', '12', 0, 2008, '', 3, NULL, NULL),
	(175, 'Ecoturismo vivencial como una actividad económica sostenible – Parte II, Santuario Nacional Los Manglares de Tumbes', 'Desarrollar la actividad del Ecoturismo Vivencial reemplazando actividades que amenazan a la preservación y conservación del área natural protegida del Santuario Nacional Los Manglares de Tumbes.', '', '9', 0, 2008, '', 3, NULL, NULL),
	(176, '"Ecoturismo vivencial como una actividad económica sostenible,', NULL, NULL, NULL, 0, 0, NULL, 3, NULL, NULL),
	(177, 'Santuario Nacional Los Manglares de Tumbes"', 'Desarrollar la actividad del Ecoturismo Vivencial reemplazando actividades que amenazan a la preservación y conservación del área natural protegida del Santuario Nacional Los Manglares de Tumbes.', '', '12', 0, 2007, 'Los beneficiarios estuvieron muy comprometidos con la ejecución del proyecto, el cual ha contado con el aporte financiero del presupuesto participativo del Municipio de Zarumilla, con lo que ha logrado construir un segundo albergue y un puente colgante en la zona de Puerto 25.', 3, NULL, NULL),
	(178, '"Establecimiento de sistemas agroforestales de café con especies forestales y frutales nativos en el margen derecha del río Tambopata,', NULL, NULL, NULL, 0, 0, NULL, 3, NULL, NULL),
	(179, 'Parque Nacional Bahuaja Sonene"', 'Contribuir a mejorar la calidad de vida y el nivel de ingresos de las familias involucradas a través de un manejo adecuado del ecosistema frágil de la zona de amortiguamiento del Parque Nacional Bahuaja Sonene.', 'Sectores Alto y Bajo Tunquimayo, Paují Playa, Pampa Grande, Chocal, Centro y Alto Arcopunco, Margen derecha del río Tambopata, Distrito San Pedro Putina Punco, Provincia Sandia, Departamento Puno', '22', 0, 2008, 'La Cooperativa Agraria Cafetalera San Jorge ha recibido el apoyo y supervisión técnica de la ONG Acción Agraria – Sur Café y de la JANP del PNBS.', 3, NULL, NULL),
	(180, '"Fortalecimiento de capacidades técnico operativas para el manejo y uso sustentable de la vicuña en la localidad de San Juan de Tarucani,', NULL, NULL, NULL, 0, 0, NULL, 3, NULL, NULL),
	(181, 'Reserva Nacional Salinas y Aguada Blanca"', 'Fortalecer las capacidades de la comunidad campesina para la protección, conservación, manejo y aprovechamiento de la vicuña', '', '11', 0, 2008, 'El asistente técnico ha realizado capacitaciones a los beneficiarios en el control y vigilancia de vicuñas.', 3, NULL, NULL),
	(182, '"Fortalecimiento de capacidades, producción e instalación de plantaciones en el eje carretero de la Interoceánica – tramo Pto. Maldonado - Mazuko,', NULL, NULL, NULL, 0, 0, NULL, 3, NULL, NULL),
	(183, 'Reserva Nacional Tambopata"', 'Contribuir a un modelo de desarrollo alternativo de actividad productiva forestal que ayude a mitigar y recuperar la deforestación desordenada y descontrolada por la tala, roce y quema de los bosques naturales del Eje Carretero.', '', '12', 0, 2008, '', 3, NULL, NULL),
	(184, '"Fortalecimiento y articulación de la cadena productiva de cítricos en el valle de Tambopata,', NULL, NULL, NULL, 0, 0, NULL, 3, NULL, NULL),
	(185, 'Parque Nacional Bahuaja Sonene"', 'Contribuir al establecimiento de una actividad agroforestal sostenible en la zona de amortiguamiento del Parque Nacional Bahuaja Sonene.', 'Sectores Santo Tomas, Tunquipata, San Benigno, Ñacaria, Chocal, Pampas de Moho, y Chunchusmayo, Distrito San Pedro de Putina Punco, Provincia Sandia, Departamento Puno', '12', 0, 2008, '', 3, NULL, NULL),
	(186, 'Gestión Participativa de Areas Naturales Protegidas', 'Asistencia técnica y gerencia de la unidad ejecutora del programa PAN II.', '', '', 0, 0, '', 3, NULL, NULL),
	(187, 'Implementación de parcelas agroforestales en la comunidad de Jorge Chávez, Reserva Nacional Tambopata', 'Contribuir a detener la deforestación del bosque y mejorar la situación social, y económica de lo pobladores, en el ámbito de la comunidad Jorge Chávez, mediante la implementación de un modelo sostenible de uso de la tierra, la Agroforesteria. Las actividades estarán orientadas a la producción sostenible de productos para el autoconsumo y el mercado, usando tecnologías sencillas, amigables con la conservación que ayuden a disminuir la deforestación en la Reserva Nacional Tambopata.', 'Comunidad Jorge Chávez, Sector Bajo Tambopata, Distrito Tambopata, Provincia Tambopata, Departamento Madre de Dios', '24', 0, 2008, 'Los pobladores de la comunidad están empezando a valorar su entorno, al comprobar en la práctica el valor y la importancia del bosque y descubrir que existen opciones económicamente viables que no requieren deforestar y/o depredar la flora y fauna que compone sus parcelas', 3, NULL, NULL),
	(188, '"Implementación de sistema de riego piloto en plantaciones agroforestales y/o biohuertos familiares en comunidades del Sector La Pampa,', NULL, NULL, NULL, 0, 0, NULL, 3, NULL, NULL),
	(189, 'Reserva Nacional Tambopata"', 'Contribuir a la conservación de la Biodiversidad en Tambopata mediante la Agroforestería con cultivos de alto rendimiento.', 'Sector La Pampa, Comunidades Florida Alta, Residentes cusqueños, Vírgenes del Sol, San Juan, Unión Progreso y El Progreso, Distritos Laberinto e Inambari, Provincia Tambopata, Región Madre de Dios.', '12', 0, 2009, '', 3, NULL, NULL),
	(190, '"Implementación del corredor turístico “Kiajabaki Bame” en Bajo Tambopata – Isuyama: realzando los valores naturales y culturales,', NULL, NULL, NULL, 0, 0, NULL, 3, NULL, NULL),
	(191, 'Reserva Nacional Tambopata"', 'Mitigar la presión sobre los recursos naturales existentes en la Reserva Nacional Tambopata, y evitar el proceso de deforestación por la expansión urbana de Puerto Maldonado hacia la RNT.', 'Localidad Bajo Tambopata-Izuyama, Distrito Tambopata, Provincia Tambopata, Departamento Madre de Dios.', '12', 0, 2008, 'Se han realizado coordinaciones con las autoridades del GOREMAD para el ensanchamiento y la reforestación en los márgenes de la vía terrestre. Además la Organización está realizando los trámites correspondientes para la creación de un Área de Conservación Privada.', 3, NULL, NULL),
	(192, '"Incremento de alimento nutricional y socioeconómico con la producción del cultivo de Sacha Inchi,', NULL, NULL, NULL, 0, 0, NULL, 3, NULL, NULL),
	(193, 'Parque Nacional Bahuaja Sonene"', 'Introducir el cultivo Alternativo de Sacha Inchi en zona ANP para Incrementar la Alimentación nutricional y Socioeconómico en las Familias con el fin de contrarrestar la Desnutrición de la población.', 'Sectores Alto Pauji Playa, Alto Urubamba, Arco Punco, Centro Miraflores, Janansaya, Miraflores lanza, Palmirani, Pauji Playa, San Ignacio, San Roman, Urubamba, Distrito San Pedro de Putina Punco, Provincia Sandia, Departamento Puno', '12', 0, 2008, 'A través del proyecto, se han instalado viveros sectoriales en la zona de Pauji Playa y Arco Punco para la producción de sacha inchi, y se han realizado capacitaciones en el manejo de este cultivo.', 3, NULL, NULL),
	(194, 'Incremento de la producción de copoazú en sistema agroforestal con manejo sostenible en Madre de Dios, Reserva Nacional Tambopata', 'Contribuir al desarrollo socio – económico y disminución de áreas deforestadas e intervenidas utilizando estrategias de sobre vivencia en el sector Progreso Verde Laberinto Madre de Dios.', 'Sector progreso Verde, Distrito Laberinto, Provincia Tambopata, Departamento Madre de Dios.', '12', 0, 2008, '', 3, NULL, NULL),
	(195, 'Incremento de la productividad de la castaña de la RNTAMB organizando la oferta de acopio y generación de valor agregado con trasformación artesanal y su comercialización, Reserva Nacional Tambopata', 'Contribuir al desarrollo social. Económico y ambiental de la actividad castañera de la Reserva Nacional Tambopata mejorando el sistema de acopio coherente al Plan de Manejo y el impulso a la transformación artesanal de la castaña.', 'Comunidades Jorge Chávez, La Torre, Infierno, Condenado, Briolo, Palma Real Grande, Palma Real Chico, Patuyacu y Heath, Distrito Tambopata, Provincia Tambopata, Región Madre de Dios.', '11', 0, 2009, '', 3, NULL, NULL),
	(196, 'Instalación de café bajo sistemas agroforestales en la zona de amortiguamiento del PNBS margen izquierdo del río Tambopata, Parque Nacional Bahuaja Sonene', 'Contribuir en la conservación de ecosistemas y la biodiversidad, con la producción de café bajo sistemas agroforestales, con un enfoque de desarrollo socio-económico mejorando la calidad de vida de los pobladores, en la zona de amortiguamiento y áreas de influencia del Parque Nacional Bahuaja Sonene.', 'Sectores Victoria, Centro San Fermin, Alto Azata, Monte Sinaí y Huaranca, Distrito San Pedro de Putina Punco, Provincia Sandia, Departamento Puno', '12', 0, 2008, 'Se han producido 8,617 plántulas forestales, de las cuales se han entregado 4,258 de la especie mara o caoba a 60 beneficiarios.', 3, NULL, NULL),
	(197, '"Instalación de café bajo sistemas agroforestales en la zona de amortiguamiento del PNBS, margen derecho del rió Inambari,', NULL, NULL, NULL, 0, 0, NULL, 3, NULL, NULL),
	(198, 'Parque Nacional Bahuaja Sonene"', 'Contribuir en la conservación de ecosistemas y la biodiversidad, mediante la producción de café bajo sistemas agroforestales, con un enfoque de desarrollo socio-económico mejorando la calidad de vida de los pobladores, en la zona de amortiguamiento y áreas de influencia del Parque Nacional Bahuaja Sonene.', 'Sectores Pacaysuizo, Santa Rosa y Misca San Antón Distrito Alto Inambari, Provincia Sandia, Departamento Puno', '12', 0, 2008, '', 3, NULL, NULL),
	(199, '"Instalación de sistemas agroforestales de café en la zona de amortiguamiento del distrito de Alto Inambari,', NULL, NULL, NULL, 0, 0, NULL, 3, NULL, NULL),
	(200, 'Parque Nacional Bahuaja Sonene"', 'Contribuir al desarrollo de una agricultura sostenible con el establecimiento del sistema agroforestal moderno de café con especies forestales maderables.', 'Sectores Pacayzuiso, Padrioc, Buenavista, Patayanamayo y Llinquipata, Distrito Alto Inambari, Provincia Sandia, Departamento Puno', '12', 0, 2008, 'Acción Agraria es un Organismo No Gubernamental (ONG) que ha venido trabajando en el tema de cultivos agroforestales en el ámbito de la zona de amortiguamiento del Parque Nacional Bahuaja Sonene', 3, NULL, NULL),
	(201, '"Instalación, capacitación y asistencia técnica en la Cadena Productiva de Piña.,', NULL, NULL, NULL, 0, 0, NULL, 3, NULL, NULL),
	(202, 'Parque Nacional Bahuaja Sonene"', 'Contribuir con la disminución de las amenazas al ANP y al mejoramiento de la calidad de vida de las familias que integran la asociación del sector Yahuarmayo', 'Sector Yahuarmayo agroindustrial, Centro Poblado Cuesta Blanca, Distrito San Gabán, Provincia Carabaya, Departamento Puno.', '22', 0, 2008, 'El año pasado la Organización percibió ingresos a través de la venta de piña en ferias agropecuarias realizadas en Juliaca. Actualmente, las plantaciones de piña están en proceso de floración para luego ser comercializado.', 3, NULL, NULL),
	(203, '"Instalación, manejo y recuperación de áreas deforestadas por la actividad cafetalera, bajo un sistema de agroforestería en Alto Tambopata,', NULL, NULL, NULL, 0, 0, NULL, 3, NULL, NULL),
	(204, 'Parque Nacional Bahuaja Sonene"', 'Contribuir a la conservación de la biodiversidad biológica de la Zona de Amortiguamiento del Parque Nacional Bahuaja Sonene, con la conversión de cafetales tradicionales ecológicos a sistemas agroforestales aplicando las mejores prácticas de conservación y contribuyendo a la mejora de los ingresos económicos y la calidad de vida de las familias.', 'Sectores Alto Tunquimayo, Bajo Tunquimayo, Pampas de Moho, San Ignacio, Distrito San Pedro de Putina Punco, Provincia Sandia, Departamento Puno', '12', 0, 2008, 'Se instalado 1,100 plántulas de caoba en el vivero de la Central de Cooperativas Agrarias Cafetaleras del Valle de Sandia (CECOVASA) y se han distribuido 800 plántulas entre los beneficiarios.', 3, NULL, NULL),
	(205, 'Introducción del cultivo de plátano en sistemas agroforestales en los sectores de la margen derecha del rió Inambari, Parque Nacional Bahuaja Sonene', '"Contribuir al establecimiento de una actividad agroforestal', NULL, NULL, 0, 0, 'Actualmente, los beneficiarios perciben ingresos económicos por la venta de hijuelos de plátano (S/.1 c/u), siendo un ingreso adicional que no estaba contemplado en el Proyecto y que se debe a la introducción en la zona de variedades comerciales de plátano como el Inguiri y Bellaco y a la expectativa de la población por la culminación de la carretera Interoceánica, que significará una oportunidad de mercado\r\n', 3, NULL, NULL),
	(206, 'sostenible en la zona de amortiguamiento del Parque Nacional', NULL, NULL, NULL, 0, 0, NULL, 3, NULL, NULL),
	(207, NULL, NULL, NULL, NULL, 0, 0, NULL, 3, NULL, NULL),
	(208, 'Jardín Botánico escondido en el Lago Sandoval. Reserva Nacional Tambopata', 'La instalación de un jardín botánico y un vivero de las especies mas representativas tanto de especies ornamentales como las forestales dentro de la zona del Lago Sandoval.', 'Centro poblado Lago Sandoval, distrito de Tambopata, Provincia de Tambopata, región de Madre de Dios', '22', 0, 2008, '', 3, NULL, NULL),
	(209, '"Manejo de la pradera nativa, pastos mejorados y sanidad ganadera en una zona piloto de la Sub-Cuenca Carhuascancha,', NULL, NULL, NULL, 0, 0, NULL, 3, NULL, NULL),
	(210, 'Parque nacional Huascarán"', 'Incrementar los ingresos de las familias pobres en la zona de amortiguamiento del PNH y contribuir a la conservación de la flora, fauna y biodiversidad del área núcleo', 'Zona Sub – Cuenca Carhuascancha, localidad Centro Poblado de Acopara , distrito de Huantar, provincia de Huari, departamento de Ancash', '18', 0, 2008, 'CARE es un Organismo No Gubernamental (ONG) que tiene experiencia trabajando en la zona. Como contrapartida del proyecto los beneficiarios han instalado 1,000 plantones de quenual en la zona de la Sub-Cuenca Carhuascancha.', 3, NULL, NULL),
	(211, 'Manejo de piscigranjas familiares para la crianza de peces nativos (paco), en el margen izquierdo del Rió Tambopata, Parque Nacional Bahuaja Sonene', 'Promocionar la piscicultura a través de la reproducción y crianza de peces nativos, Colossoma brachypomun “paco” como una actividad complementaria a la agricultura y en concordancia con el medio ambiente de la zona de amortiguamiento del Parque Nacional Bahuaja Sonene', 'Sectores San Ingnacio, Villa Carmen Chocal, Distrito San Pedro de Putina Punco, Provincia Sandia, Departamento Puno', '12', 0, 2008, '', 3, NULL, NULL),
	(212, 'Manejo y mejoramiento de bofedales y pastizales mediante la propagación de especies de pastos nativos en el anexo de Tocra', 'Manejar y mejorar los bofedales y pastizales mediante la propagación de especies de pastos nativos y mantener la cobertura vegetal de la reserva nacional de salinas y aguada blanca y el anexo de Tocra. Esto permitirá manejar, ampliar bofedales, aumentar y optimizar la carga de los bofedales siendo esta propuesta uno de los objetivos dentro del plan maestro de la reserva nacional de salinas y aguada blanca y que contribuirá a la conservación del área protegida.', 'Comunidad Anexo Tocra, Distrito Yanque, Provincia Caylloma Departamento Arequipa', '12', 0, 2007, 'Los miembros de la Asociación reconocen la importancia del manejo de los pastos naturales y la importancia de estas en su relación con el entorno del ANP y con ellos mismos. La organización ha logrado apalancar recursos financieros del Proyecto Sierra Sur, para continuar con el proyecto.', 3, NULL, NULL),
	(213, 'Manejo y producción orgánica de módulos forrajeros para camélidos domésticos: una estrategia para conservar los bofedales en la comunidad campesina de San Juan de Tarucani.', 'Diseñar e implementar una propuesta de manejo y producción orgánica de forraje para animales domésticos, como una estrategia para mejorar la conservación del bofedal.', 'Comunidad San Juan de Tarucani, Distrito San Juan de Tarucani, Provincia Arequipa, Departamento Arequipa', '24', 0, 2008, 'Este proyecto ha sufrido contratiempos que han impedido el desarrollo normal de las actividades programadas. Entre los contratiempos se pueden identificar la estacionalidad del clima, problemas de carácter documentarios con el banco y débil relación entre beneficiarios y asistente técnico.', 3, NULL, NULL),
	(214, 'Mejora de la capacidad productiva del sector de los camélidos sudamericanos domésticos en la localidad de Tambo de Ají, Reserva Nacional Salinas y Aguada Blanca', 'Contribuir a mejorar los niveles de ingresos económicos de las familias alpaqueras de la Asociación de Mejoramiento de Camélidos Sudamericanos de la localidad de Tambo de Ají (AMALP) para mejorar la capacidad productiva del sector mediante la optimización de los recursos agropecuarios existentes en la zona, a través de un manejo sostenible, mejor organizaión, capacidad productiva y administrativa', 'Localidad de Tambo de Ají, Distrito San Juan de Tarucani, Provincia Arequipa, Departamento Arequipa', '11', 0, 2008, 'Buen avance en la ejecución del proyecto. La organización tiene un pequeño reservorio y una población de 155 camélidos.', 3, NULL, NULL),
	(215, 'Mejoramiento de la producción y productividad de pastos naturales en los Anexos Paty y La Yunta, San Juan de Tarucani Reserva Nacional Salinas y Aguada Blanca', '"Contribuir a la conservación de la biodiversidad de los pastizales y de la calidad de vida de los', NULL, NULL, 0, 0, NULL, 3, NULL, NULL),
	(216, 'pobladores en los Anexos Paty y La Yunta, San Juan de Tarucani"', '"Anexos Paty y La Yunta, Distrito San Juan de Tarucani, Provincia', NULL, NULL, 0, 0, NULL, 3, NULL, NULL),
	(217, 'Área de conservacion participativa de la Biodiversidad del Bosque seco de la costa norte del Perú', 'Gestión adecuada de las Áreas de Conservación articuladas al SINANPE en el marco de un sistema regional de AC en Lambayeque, Piura y Tumbes, priorizando acciones en la Ecorregión Bosque Seco Ecuatorial', '06 ACR  y ANPs de la ecorregión bosque seco ecuatorial (Lambayeque Piura y tumbes)', '48', 0, 2011, 'PAN II - Proyecto Componente Bosque Seco', 4, NULL, NULL),
	(218, '"Conservación Participativa de la Biodiversidad del', '"Conservación de la Diversidad Biológica, Cambio Climático y Lucha contra la desertificación, lo que constituye además una oportunidad para lograr apoyo financiero adicional que', NULL, NULL, 0, 0, NULL, 4, NULL, NULL),
	(219, 'Bosque Seco de la Costa Norte del Perú"', 'contribuya a la sostenibilidad de las áreas de conservación regionales, locales y comunales."', NULL, NULL, 0, 0, NULL, 4, NULL, NULL),
	(220, 'contribuya a la sostenibilidad de las áreas de conservación regionales, locales y comunales."', '', '48', '2007', 0, 0, NULL, 4, NULL, NULL),
	(221, 'Diagnóstico del PNH y su ZA: Propuesta de sistema de monitoreo de la diversidad biológica prioritaria para la gestion de la conservacion del PNH y su ZA', 'Guia para los sistemas de monitoreo para conservación de ecosistemas de la Cordillera Blanca del PNH, dentro de la actualización del Plan Maestro', '', '', 0, 0, 'Consultoria', 4, NULL, NULL),
	(222, '"Formulación de un PIN ', NULL, NULL, NULL, 0, 0, 'Consultoria\r\n', 4, NULL, NULL),
	(223, 'para un Proyecto REDD para el Parque Nacional Bahuaja Sonene” dentro del Proyecto Protección de Áreas Naturales Protegidas – PAN II', NULL, NULL, NULL, 0, 0, NULL, 4, NULL, NULL);
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;


# Dumping structure for table dde.proyectoejecutor
CREATE TABLE IF NOT EXISTS `proyectoejecutor` (
  `idproyecto` int(11) NOT NULL,
  `idejecutor` int(11) NOT NULL,
  PRIMARY KEY  (`idproyecto`,`idejecutor`),
  KEY `fk_proyectoejecutor_ejecutor1` (`idejecutor`),
  CONSTRAINT `fk_proyectoejecutor_proyecto1` FOREIGN KEY (`idproyecto`) REFERENCES `proyecto` (`idproyecto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_proyectoejecutor_ejecutor1` FOREIGN KEY (`idejecutor`) REFERENCES `ejecutor` (`idejecutor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.proyectoejecutor: ~2 rows (approximately)
DELETE FROM `proyectoejecutor`;
/*!40000 ALTER TABLE `proyectoejecutor` DISABLE KEYS */;
/*!40000 ALTER TABLE `proyectoejecutor` ENABLE KEYS */;


# Dumping structure for table dde.proyectoftefto
CREATE TABLE IF NOT EXISTS `proyectoftefto` (
  `idproyecto` int(11) NOT NULL,
  `idftefto` int(11) NOT NULL,
  PRIMARY KEY  (`idproyecto`,`idftefto`),
  KEY `fk_proyectoftefto_ftefto1` (`idftefto`),
  CONSTRAINT `fk_proyectoftefto_proyecto1` FOREIGN KEY (`idproyecto`) REFERENCES `proyecto` (`idproyecto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_proyectoftefto_ftefto1` FOREIGN KEY (`idftefto`) REFERENCES `fuentefinanciamiento` (`idftefto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.proyectoftefto: ~2 rows (approximately)
DELETE FROM `proyectoftefto`;
/*!40000 ALTER TABLE `proyectoftefto` DISABLE KEYS */;
/*!40000 ALTER TABLE `proyectoftefto` ENABLE KEYS */;


# Dumping structure for table dde.puestoscontrol
CREATE TABLE IF NOT EXISTS `puestoscontrol` (
  `idpuestoscontrol` int(11) NOT NULL auto_increment,
  `idareanatural` int(3) NOT NULL,
  `turismo` tinyint(4) default NULL,
  PRIMARY KEY  (`idpuestoscontrol`),
  KEY `fk_puestosControl_areanatural1` (`idareanatural`),
  CONSTRAINT `fk_puestosControl_areanatural1` FOREIGN KEY (`idareanatural`) REFERENCES `areanatural` (`idareanatural`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.puestoscontrol: ~0 rows (approximately)
DELETE FROM `puestoscontrol`;
/*!40000 ALTER TABLE `puestoscontrol` DISABLE KEYS */;
/*!40000 ALTER TABLE `puestoscontrol` ENABLE KEYS */;


# Dumping structure for table dde.rol
CREATE TABLE IF NOT EXISTS `rol` (
  `idrol` int(11) NOT NULL auto_increment,
  `desrol` varchar(45) default NULL,
  `pesorol` int(11) default NULL,
  `flagrol` varchar(45) default NULL,
  PRIMARY KEY  (`idrol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.rol: ~0 rows (approximately)
DELETE FROM `rol`;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;


# Dumping structure for table dde.rolmodulo
CREATE TABLE IF NOT EXISTS `rolmodulo` (
  `idrol` int(11) NOT NULL,
  `idmodulo` int(11) NOT NULL,
  PRIMARY KEY  (`idrol`,`idmodulo`),
  KEY `fk_rolmodulo_modulo1` (`idmodulo`),
  CONSTRAINT `fk_rolmodulo_rol1` FOREIGN KEY (`idrol`) REFERENCES `rol` (`idrol`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rolmodulo_modulo1` FOREIGN KEY (`idmodulo`) REFERENCES `modulo` (`idmodulo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.rolmodulo: ~0 rows (approximately)
DELETE FROM `rolmodulo`;
/*!40000 ALTER TABLE `rolmodulo` DISABLE KEYS */;
/*!40000 ALTER TABLE `rolmodulo` ENABLE KEYS */;


# Dumping structure for table dde.rutaturismo
CREATE TABLE IF NOT EXISTS `rutaturismo` (
  `idrutaturismo` int(11) NOT NULL auto_increment,
  `nombrerutaturismo` varchar(128) default NULL,
  `detallerutaturismo` text,
  `idturismo` int(11) NOT NULL,
  `serviciosrutaturismo` varchar(45) default NULL,
  PRIMARY KEY  (`idrutaturismo`),
  KEY `fk_rutaTurismo_turismo1` (`idturismo`),
  CONSTRAINT `fk_rutaTurismo_turismo1` FOREIGN KEY (`idturismo`) REFERENCES `turismo` (`idTurismo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.rutaturismo: ~0 rows (approximately)
DELETE FROM `rutaturismo`;
/*!40000 ALTER TABLE `rutaturismo` DISABLE KEYS */;
/*!40000 ALTER TABLE `rutaturismo` ENABLE KEYS */;


# Dumping structure for table dde.tipoareaorganica
CREATE TABLE IF NOT EXISTS `tipoareaorganica` (
  `idtipoarea` int(3) NOT NULL auto_increment COMMENT 'Id del tipo de Area',
  `codtipoarea` char(2) default NULL COMMENT 'Codigo del tipo de Area',
  `destipoarea` varchar(200) default NULL COMMENT 'Nombre del tipo de Area',
  PRIMARY KEY  (`idtipoarea`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

# Dumping data for table dde.tipoareaorganica: ~0 rows (approximately)
DELETE FROM `tipoareaorganica`;
/*!40000 ALTER TABLE `tipoareaorganica` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipoareaorganica` ENABLE KEYS */;


# Dumping structure for table dde.tipobeneficiario
CREATE TABLE IF NOT EXISTS `tipobeneficiario` (
  `idtipobeneficiario` int(11) NOT NULL,
  `desctipobene` varchar(150) default NULL,
  PRIMARY KEY  (`idtipobeneficiario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.tipobeneficiario: ~0 rows (approximately)
DELETE FROM `tipobeneficiario`;
/*!40000 ALTER TABLE `tipobeneficiario` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipobeneficiario` ENABLE KEYS */;


# Dumping structure for table dde.tipoproyecto
CREATE TABLE IF NOT EXISTS `tipoproyecto` (
  `idtipoproyecto` int(11) NOT NULL auto_increment,
  `nombretipoproyecto` varchar(45) default NULL,
  PRIMARY KEY  (`idtipoproyecto`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

# Dumping data for table dde.tipoproyecto: ~2 rows (approximately)
DELETE FROM `tipoproyecto`;
/*!40000 ALTER TABLE `tipoproyecto` DISABLE KEYS */;
INSERT INTO `tipoproyecto` (`idtipoproyecto`, `nombretipoproyecto`) VALUES
	(1, 'proyecto'),
	(2, 'MACC'),
	(3, 'GPAN'),
	(4, 'PAN'),
	(5, 'Proyectos SNIP');
/*!40000 ALTER TABLE `tipoproyecto` ENABLE KEYS */;


# Dumping structure for table dde.tipoturismo
CREATE TABLE IF NOT EXISTS `tipoturismo` (
  `idtipoturismo` int(11) NOT NULL auto_increment,
  `nombretipoturismo` varchar(128) default NULL,
  `idturismo` int(11) default NULL,
  PRIMARY KEY  (`idtipoturismo`),
  KEY `fk_tipoTurismo_turismo1` (`idturismo`),
  CONSTRAINT `fk_tipoTurismo_turismo1` FOREIGN KEY (`idturismo`) REFERENCES `turismo` (`idTurismo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

# Dumping data for table dde.tipoturismo: ~6 rows (approximately)
DELETE FROM `tipoturismo`;
/*!40000 ALTER TABLE `tipoturismo` DISABLE KEYS */;
INSERT INTO `tipoturismo` (`idtipoturismo`, `nombretipoturismo`, `idturismo`) VALUES
	(1, 'Aventura', NULL),
	(2, 'Observación de aves', NULL),
	(3, 'Cultural', NULL),
	(4, 'Ecoturismo', NULL),
	(5, 'Vivencial', NULL),
	(6, 'Terapéutico', NULL);
/*!40000 ALTER TABLE `tipoturismo` ENABLE KEYS */;


# Dumping structure for table dde.tipoturismoactividadturismo
CREATE TABLE IF NOT EXISTS `tipoturismoactividadturismo` (
  `idtipoturismo` int(11) NOT NULL,
  `idactividadeturismo` int(11) NOT NULL,
  PRIMARY KEY  (`idtipoturismo`,`idactividadeturismo`),
  KEY `fk_tipoTurismoactividadTurismo_actividadTurismo1` (`idactividadeturismo`),
  CONSTRAINT `fk_tipoTurismoactividadTurismo_actividadTurismo1` FOREIGN KEY (`idactividadeturismo`) REFERENCES `actividadturismo` (`idactividadeturismo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tipoTurismoactividadTurismo_tipoTurismo1` FOREIGN KEY (`idtipoturismo`) REFERENCES `tipoturismo` (`idtipoturismo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.tipoturismoactividadturismo: ~0 rows (approximately)
DELETE FROM `tipoturismoactividadturismo`;
/*!40000 ALTER TABLE `tipoturismoactividadturismo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipoturismoactividadturismo` ENABLE KEYS */;


# Dumping structure for table dde.turismo
CREATE TABLE IF NOT EXISTS `turismo` (
  `idturismo` int(11) NOT NULL auto_increment,
  `idareanatural` int(3) NOT NULL,
  PRIMARY KEY  (`idturismo`),
  KEY `fk_turismo_areanatural1` (`idareanatural`),
  CONSTRAINT `fk_turismo_areanatural1` FOREIGN KEY (`idareanatural`) REFERENCES `areanatural` (`idareanatural`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.turismo: ~0 rows (approximately)
DELETE FROM `turismo`;
/*!40000 ALTER TABLE `turismo` DISABLE KEYS */;
/*!40000 ALTER TABLE `turismo` ENABLE KEYS */;


# Dumping structure for table dde.turismoatractivo
CREATE TABLE IF NOT EXISTS `turismoatractivo` (
  `idturismoatractivo` int(11) NOT NULL auto_increment,
  `tipoturismoatractivo` varchar(45) default NULL,
  `nombrezonaturismoatractivo` varchar(45) default NULL,
  `ubicacionturismoatractivo` varchar(45) default NULL,
  `imgturismoatractivo` varchar(45) default NULL,
  `idturismo` int(11) NOT NULL,
  PRIMARY KEY  (`idturismoatractivo`),
  KEY `fk_turismoatractivo_turismo1` (`idturismo`),
  CONSTRAINT `fk_turismoatractivo_turismo1` FOREIGN KEY (`idturismo`) REFERENCES `turismo` (`idTurismo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.turismoatractivo: ~0 rows (approximately)
DELETE FROM `turismoatractivo`;
/*!40000 ALTER TABLE `turismoatractivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `turismoatractivo` ENABLE KEYS */;


# Dumping structure for table dde.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int(11) NOT NULL auto_increment COMMENT 'Id del Usuario',
  `usuario` varchar(20) default NULL COMMENT 'Codigo de usuario',
  `clave` varchar(20) default NULL COMMENT 'Clave de acceso',
  `estado` int(1) default NULL COMMENT 'Estado del registro',
  `idArea` int(3) default NULL COMMENT 'Id del Area',
  `idpersonanatural` int(11) NOT NULL,
  `idrol` int(11) NOT NULL,
  PRIMARY KEY  (`idUsuario`),
  KEY `FK_areaorganica_usuario` (`idArea`),
  KEY `fk_usuario_personanatural1` (`idpersonanatural`),
  KEY `fk_usuario_rol1` (`idrol`),
  CONSTRAINT `FK_areaorganica_usuario0` FOREIGN KEY (`idArea`) REFERENCES `areaorganica` (`idarea`),
  CONSTRAINT `fk_usuario_personanatural1` FOREIGN KEY (`idpersonanatural`) REFERENCES `personanatural` (`idpersonanatural`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_rol1` FOREIGN KEY (`idrol`) REFERENCES `rol` (`idrol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

# Dumping data for table dde.usuario: ~1 rows (approximately)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`idUsuario`, `usuario`, `clave`, `estado`, `idArea`, `idpersonanatural`, `idrol`) VALUES
	(3, 'admin', '1234', 1, NULL, 0, 0);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;


# Dumping structure for table dde.visitante
CREATE TABLE IF NOT EXISTS `visitante` (
  `idvisitante` int(11) NOT NULL auto_increment,
  `idguia` int(11) default NULL,
  `idrutaturismo` int(11) default NULL,
  `idpersonanatural` int(11) NOT NULL,
  `idoperadorturismo` int(11) default NULL,
  `idoperadorturismoEmpresaturismo` int(11) default NULL,
  PRIMARY KEY  (`idvisitante`),
  KEY `fk_visitante_personanatural1` (`idpersonanatural`),
  KEY `fk_visitante_operadorturismo1` (`idoperadorturismo`),
  KEY `fk_visitante_operadorturismo2` (`idoperadorturismoEmpresaturismo`),
  KEY `fk_visitante_guia1` (`idguia`),
  KEY `fk_visitante_rutaTurismo1` (`idrutaturismo`),
  CONSTRAINT `fk_visitante_rutaTurismo1` FOREIGN KEY (`idrutaturismo`) REFERENCES `rutaturismo` (`idrutaturismo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_visitante_personanatural1` FOREIGN KEY (`idpersonanatural`) REFERENCES `personanatural` (`idpersonanatural`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_visitante_guia1` FOREIGN KEY (`idguia`) REFERENCES `guia` (`idguia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_visitante_operadorturismo1` FOREIGN KEY (`idoperadorturismo`) REFERENCES `operadorturismo` (`idoperadorturismo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_visitante_operadorturismo2` FOREIGN KEY (`idoperadorturismoEmpresaturismo`) REFERENCES `operadorturismo` (`idoperadorturismo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8;

# Dumping data for table dde.visitante: ~138 rows (approximately)
DELETE FROM `visitante`;
/*!40000 ALTER TABLE `visitante` DISABLE KEYS */;
INSERT INTO `visitante` (`idvisitante`, `idguia`, `idrutaturismo`, `idpersonanatural`, `idoperadorturismo`, `idoperadorturismoEmpresaturismo`) VALUES
	(1, NULL, NULL, 1, NULL, NULL),
	(2, NULL, NULL, 1, NULL, NULL),
	(3, NULL, NULL, 1, NULL, NULL),
	(4, NULL, NULL, 1, NULL, NULL),
	(5, NULL, NULL, 1, NULL, NULL),
	(6, NULL, NULL, 1, NULL, NULL),
	(7, NULL, NULL, 1, NULL, NULL),
	(8, NULL, NULL, 1, NULL, NULL),
	(9, NULL, NULL, 1, NULL, NULL),
	(10, NULL, NULL, 1, NULL, NULL),
	(11, NULL, NULL, 1, NULL, NULL),
	(12, NULL, NULL, 1, NULL, NULL),
	(13, NULL, NULL, 1, NULL, NULL),
	(14, NULL, NULL, 1, NULL, NULL),
	(15, NULL, NULL, 1, NULL, NULL),
	(16, NULL, NULL, 1, NULL, NULL),
	(17, NULL, NULL, 1, NULL, NULL),
	(18, NULL, NULL, 1, NULL, NULL),
	(19, NULL, NULL, 1, NULL, NULL),
	(20, NULL, NULL, 1, NULL, NULL),
	(21, NULL, NULL, 1, NULL, NULL),
	(22, NULL, NULL, 1, NULL, NULL),
	(23, NULL, NULL, 1, NULL, NULL),
	(24, NULL, NULL, 1, NULL, NULL),
	(25, NULL, NULL, 1, NULL, NULL),
	(26, NULL, NULL, 1, NULL, NULL),
	(27, NULL, NULL, 1, NULL, NULL),
	(28, NULL, NULL, 1, NULL, NULL),
	(29, NULL, NULL, 1, NULL, NULL),
	(30, NULL, NULL, 1, NULL, NULL),
	(31, NULL, NULL, 1, NULL, NULL),
	(32, NULL, NULL, 1, NULL, NULL),
	(33, NULL, NULL, 1, NULL, NULL),
	(34, NULL, NULL, 1, NULL, NULL),
	(35, NULL, NULL, 1, NULL, NULL),
	(36, NULL, NULL, 1, NULL, NULL),
	(37, NULL, NULL, 1, NULL, NULL),
	(38, NULL, NULL, 1, NULL, NULL),
	(39, NULL, NULL, 1, NULL, NULL),
	(40, NULL, NULL, 1, NULL, NULL);
/*!40000 ALTER TABLE `visitante` ENABLE KEYS */;


# Dumping structure for table dde.visitantetipoturismoactividadturismo
CREATE TABLE IF NOT EXISTS `visitantetipoturismoactividadturismo` (
  `idvisitante` int(11) NOT NULL,
  `idtipoturismo` int(11) default NULL,
  `idactividadeturismo` int(11) default NULL,
  KEY `fk_visitantetipoTurismoactividadTurismo_tipoTurismoactividadT1` (`idtipoturismo`,`idactividadeturismo`),
  KEY `fk_visitantetipoTurismoactividadTurismo_visitante1` (`idvisitante`),
  CONSTRAINT `fk_visitantetipoTurismoactividadTurismo_tipoTurismoactividadT1` FOREIGN KEY (`idtipoturismo`, `idactividadeturismo`) REFERENCES `tipoturismoactividadturismo` (`idtipoturismo`, `idactividadeturismo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_visitantetipoTurismoactividadTurismo_visitante1` FOREIGN KEY (`idvisitante`) REFERENCES `visitante` (`idvisitante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.visitantetipoturismoactividadturismo: ~0 rows (approximately)
DELETE FROM `visitantetipoturismoactividadturismo`;
/*!40000 ALTER TABLE `visitantetipoturismoactividadturismo` DISABLE KEYS */;
INSERT INTO `visitantetipoturismoactividadturismo` (`idvisitante`, `idtipoturismo`, `idactividadeturismo`) VALUES
	(1, NULL, NULL),
	(2, NULL, NULL),
	(3, NULL, NULL),
	(4, NULL, NULL),
	(5, NULL, NULL),
	(6, NULL, NULL),
	(7, NULL, NULL),
	(8, NULL, NULL),
	(9, NULL, NULL),
	(10, NULL, NULL),
	(11, NULL, NULL),
	(12, NULL, NULL),
	(13, NULL, NULL),
	(14, NULL, NULL),
	(15, NULL, NULL),
	(16, NULL, NULL),
	(17, NULL, NULL),
	(18, NULL, NULL),
	(19, NULL, NULL),
	(20, NULL, NULL),
	(21, NULL, NULL),
	(22, NULL, NULL),
	(23, NULL, NULL),
	(24, NULL, NULL),
	(27, NULL, NULL),
	(28, NULL, NULL),
	(29, NULL, NULL),
	(30, NULL, NULL),
	(31, NULL, NULL),
	(32, NULL, NULL),
	(33, NULL, NULL),
	(34, NULL, NULL),
	(35, NULL, NULL),
	(36, NULL, NULL),
	(37, NULL, NULL),
	(38, NULL, NULL),
	(39, NULL, NULL),
	(40, NULL, NULL);
/*!40000 ALTER TABLE `visitantetipoturismoactividadturismo` ENABLE KEYS */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
