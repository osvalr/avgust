# --------------------------------------------------------
# Host:                         10.10.11.220
# Server version:               5.0.77
# Server OS:                    redhat-linux-gnu
# HeidiSQL version:             5.1.0.3533
# Date/time:                    2010-10-11 11:21:26
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
  `idActividadeTurismo` int(11) NOT NULL auto_increment,
  `nombreActividadTurismo` varchar(128) default NULL,
  `detalleActividadTurismo` text,
  PRIMARY KEY  (`idActividadeTurismo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.actividadturismo: ~0 rows (approximately)
/*!40000 ALTER TABLE `actividadturismo` DISABLE KEYS */;
/*!40000 ALTER TABLE `actividadturismo` ENABLE KEYS */;


# Dumping structure for table dde.areanatural
CREATE TABLE IF NOT EXISTS `areanatural` (
  `idAreaNatural` int(3) NOT NULL auto_increment COMMENT 'Id del Area Natural',
  `codAreaNatural` char(4) NOT NULL default '' COMMENT 'Codigo del Area Natural',
  `desAreaNatural` varchar(200) default NULL COMMENT 'Descripcion del Area Natural',
  `estado` int(2) default NULL COMMENT 'Estado del registro',
  `idCategoriaanp` int(3) NOT NULL,
  PRIMARY KEY  (`idAreaNatural`),
  KEY `fk_areanatural_categoriaanp1` (`idCategoriaanp`),
  CONSTRAINT `fk_areanatural_categoriaanp1` FOREIGN KEY (`idCategoriaanp`) REFERENCES `categoriaanp` (`idCategoriaanp`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

# Dumping data for table dde.areanatural: ~68 rows (approximately)
/*!40000 ALTER TABLE `areanatural` DISABLE KEYS */;
INSERT INTO `areanatural` (`idAreaNatural`, `codAreaNatural`, `desAreaNatural`, `estado`, `idCategoriaanp`) VALUES
	(1, '0101', 'CUTERVO', 1, 1),
	(2, '0102', 'TINGO MARIA', 1, 1),
	(3, '0103', 'MANU', 1, 1),
	(4, '0104', 'HUASCARAN', 1, 1),
	(5, '0105', 'CERROS DE AMOTAPE', 1, 1),
	(6, '0106', 'RIO ABISEO', 1, 1),
	(7, '0107', 'YANACHAGA CHEMILLEN', 1, 1),
	(8, '0108', 'BAHUAJA SONENE', 1, 1),
	(9, '0109', 'CORDILLERA AZUL', 1, 1),
	(10, '0110', 'OTISHI', 1, 1),
	(11, '0111', 'ALTO PURUS', 1, 1),
	(12, '0112', 'ICHIGKAT MUJA - CORDILLERA DEL CONDOR', 1, 1),
	(13, '0201', 'HUAYLLAY', 1, 2),
	(14, '0202', 'CALIPUY', 1, 2),
	(15, '0203', 'LAGUNAS DE MEJIA', 1, 2),
	(16, '0204', 'AMPAY', 1, 2),
	(17, '0205', 'MANGLARES DE TUMBES', 1, 2),
	(18, '0206', 'TABACONAS NAMBALLE', 1, 2),
	(19, '0207', 'MEGANTONI', 1, 2),
	(20, '0208', 'PAMPA HERMOSA', 1, 2),
	(21, '0301', 'CHACAMARCA', 1, 3),
	(22, '0302', 'PAMPA DE AYACUCHO', 1, 3),
	(23, '0303', 'MACHUPICCHU', 1, 3),
	(24, '0304', 'BOSQUE DE POMAC', 1, 3),
	(25, '0401', 'PAMPA GALERAS BARBARA D\' ACHILLE', 1, 4),
	(26, '0402', 'JUNIN', 1, 4),
	(27, '0403', 'PARACAS', 1, 4),
	(28, '0404', 'LACHAY', 1, 4),
	(29, '0405', 'TITICACA', 1, 4),
	(30, '0406', 'SALINAS Y AGUADA BLANCA', 1, 4),
	(31, '0407', 'CALIPUY', 1, 4),
	(32, '0408', 'PACAYA SAMIRIA', 1, 4),
	(33, '0409', 'TAMBOPATA', 1, 4),
	(34, '0410', 'ALLPAHUAYO MISHANA', 1, 4),
	(35, '0411', 'TUMBES', 1, 4),
	(36, '0412', 'MATSES', 1, 4),
	(37, '0501', 'LAQUIPAMPA', 1, 5),
	(38, '0502', 'LOS PANTANOS DE VILLA', 1, 5),
	(39, '0601', 'NOR YAUYOS COCHAS', 1, 6),
	(40, '0602', 'SUB CUENCA DEL COTAHUASI', 1, 6),
	(41, '0701', 'YANESHA', 1, 7),
	(42, '0702', 'EL SIRA', 1, 7),
	(43, '0703', 'AMARAKAERI', 1, 7),
	(44, '0704', 'MACHIGUENGA', 1, 7),
	(45, '0705', 'ASHANINKA', 1, 7),
	(46, '0706', 'PURUS', 1, 7),
	(47, '0707', 'TUNTANAIN', 1, 7),
	(48, '0801', 'ALEDAÑO A LA BOCATOMA DEL CANAL NUEVO IMPERIAL', 1, 8),
	(49, '0802', 'PUQUIO SANTA ROSA', 1, 8),
	(50, '0803', 'PUI PUI', 1, 8),
	(51, '0804', 'SAN MATIAS SAN CARLOS', 1, 8),
	(52, '0805', 'PAGAIBAMBA', 1, 8),
	(53, '0806', 'ALTO MAYO', 1, 8),
	(54, '0901', 'EL ANGOLO', 1, 9),
	(55, '0902', 'SUNCHUBAMBA', 1, 9),
	(56, '1001', 'CHANCAYBAÑOS', 1, 10),
	(57, '1002', 'GÜEPPI', 1, 10),
	(58, '1003', 'SANTIAGO COMAINA', 1, 10),
	(59, '1004', 'CORDILLERA DE COLAN', 1, 2),
	(60, '1005', 'CORDILLERA HUAYHUASH', 1, 10),
	(61, '1006', 'PUCACURO', 1, 10),
	(62, '1007', 'SIERRA DEL DIVISOR', 1, 10),
	(63, '1008', 'HUMEDALES DE PUERTO VIEJO', 1, 10),
	(64, '1009', 'SAN FERNANDO', 1, 10),
	(65, '0100', 'SEDE CENTRAL - SERNANP', 1, 11),
	(66, '0413', 'SISTEMA DE ISLAS, ISLOTES Y PUNTAS GUANERAS', 1, 4),
	(67, '1010', 'UDIMA', 1, 10),
	(68, '0708', 'CHAYUNAIN', 1, 7);
/*!40000 ALTER TABLE `areanatural` ENABLE KEYS */;


# Dumping structure for table dde.areaorganica
CREATE TABLE IF NOT EXISTS `areaorganica` (
  `idArea` int(3) NOT NULL auto_increment COMMENT 'Id del Area',
  `codArea` char(4) default NULL COMMENT 'Codigo del Area',
  `desArea` varchar(60) default NULL COMMENT 'Descripcion del Area',
  `idTipoarea` int(3) default NULL COMMENT 'Id del tipo de area',
  `idAreanatural` int(3) default NULL COMMENT 'Id del Area Natural',
  PRIMARY KEY  (`idArea`),
  KEY `FK_tipoareaorganica_areaorganica` (`idTipoarea`),
  KEY `FK_areanatural_areaorganica` (`idAreanatural`),
  CONSTRAINT `FK_areanatural_areaorganica0` FOREIGN KEY (`idAreanatural`) REFERENCES `areanatural` (`idAreaNatural`),
  CONSTRAINT `FK_tipoareaorganica_areaorganica0` FOREIGN KEY (`idTipoarea`) REFERENCES `tipoareaorganica` (`idTipoarea`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

# Dumping data for table dde.areaorganica: ~0 rows (approximately)
/*!40000 ALTER TABLE `areaorganica` DISABLE KEYS */;
/*!40000 ALTER TABLE `areaorganica` ENABLE KEYS */;


# Dumping structure for table dde.beneficiario
CREATE TABLE IF NOT EXISTS `beneficiario` (
  `idbeneficiario` int(11) NOT NULL,
  `idtipobeneficiario` int(11) NOT NULL,
  `desc` varchar(45) default NULL,
  `idTurismo` int(11) NOT NULL,
  PRIMARY KEY  (`idbeneficiario`),
  KEY `fk_beneficiario_tipobeneficiario1` (`idtipobeneficiario`),
  KEY `fk_beneficiario_turismo1` (`idTurismo`),
  CONSTRAINT `fk_beneficiario_tipobeneficiario1` FOREIGN KEY (`idtipobeneficiario`) REFERENCES `tipobeneficiario` (`idtipobeneficiario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_beneficiario_turismo1` FOREIGN KEY (`idTurismo`) REFERENCES `turismo` (`idTurismo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.beneficiario: ~0 rows (approximately)
/*!40000 ALTER TABLE `beneficiario` DISABLE KEYS */;
/*!40000 ALTER TABLE `beneficiario` ENABLE KEYS */;


# Dumping structure for table dde.categoriaanp
CREATE TABLE IF NOT EXISTS `categoriaanp` (
  `idCategoriaanp` int(3) NOT NULL auto_increment COMMENT 'Id del la categoria de ANP',
  `codCategoriaanp` char(2) default NULL COMMENT 'Codigo de la categoria del ANP',
  `desCategoriaanp` varchar(200) default NULL COMMENT 'Descripcion de la categoria del ANP',
  `estado` int(2) default NULL COMMENT 'Estado del registro',
  PRIMARY KEY  (`idCategoriaanp`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

# Dumping data for table dde.categoriaanp: ~11 rows (approximately)
/*!40000 ALTER TABLE `categoriaanp` DISABLE KEYS */;
INSERT INTO `categoriaanp` (`idCategoriaanp`, `codCategoriaanp`, `desCategoriaanp`, `estado`) VALUES
	(1, '01', 'PARQUES NACIONALES', 1),
	(2, '02', 'SANTUARIOS NACIONALES', 1),
	(3, '03', 'SANTUARIOS HISTORICOS', 1),
	(4, '04', 'RESERVAS NACIONALES', 1),
	(5, '05', 'REFUGIO DE VIDA SILVESTRE', 1),
	(6, '06', 'RESERVA PAISAJISTICA', 1),
	(7, '07', 'RESERVAS COMUNALES', 1),
	(8, '08', 'BOSQUES DE PROTECCION', 1),
	(9, '09', 'COTOS DE CAZA', 1),
	(10, '10', 'ZONAS RESERVADAS', 1),
	(11, '00', 'SEDE CENTRAL', 1);
/*!40000 ALTER TABLE `categoriaanp` ENABLE KEYS */;


# Dumping structure for table dde.guia
CREATE TABLE IF NOT EXISTS `guia` (
  `idGuia` int(11) NOT NULL auto_increment,
  `codigoGuia` varchar(12) default NULL,
  `idPersonal` int(11) NOT NULL,
  PRIMARY KEY  (`idGuia`),
  KEY `fk_guia_persona1` (`idPersonal`),
  CONSTRAINT `fk_guia_persona1` FOREIGN KEY (`idPersonal`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.guia: ~0 rows (approximately)
/*!40000 ALTER TABLE `guia` DISABLE KEYS */;
/*!40000 ALTER TABLE `guia` ENABLE KEYS */;


# Dumping structure for table dde.operadorturismo
CREATE TABLE IF NOT EXISTS `operadorturismo` (
  `idOperadorTurismo` int(11) NOT NULL,
  `nombre` varchar(128) default NULL,
  PRIMARY KEY  (`idOperadorTurismo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.operadorturismo: ~0 rows (approximately)
/*!40000 ALTER TABLE `operadorturismo` DISABLE KEYS */;
/*!40000 ALTER TABLE `operadorturismo` ENABLE KEYS */;


# Dumping structure for table dde.perfil
CREATE TABLE IF NOT EXISTS `perfil` (
  `idPerfil` int(11) NOT NULL auto_increment,
  `desPerfil` varchar(255) default NULL,
  PRIMARY KEY  (`idPerfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.perfil: ~0 rows (approximately)
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;


# Dumping structure for table dde.perfilusuario
CREATE TABLE IF NOT EXISTS `perfilusuario` (
  `idPerfilUsuario` int(11) NOT NULL auto_increment,
  `idUsuario` int(11) default NULL,
  `idPerfil` int(11) default NULL,
  PRIMARY KEY  (`idPerfilUsuario`),
  KEY `fk_pu_perfil` (`idPerfil`),
  KEY `fk_pu_usuario` (`idUsuario`),
  CONSTRAINT `fk_pu_perfil0` FOREIGN KEY (`idPerfil`) REFERENCES `perfil` (`idPerfil`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pu_usuario0` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.perfilusuario: ~0 rows (approximately)
/*!40000 ALTER TABLE `perfilusuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `perfilusuario` ENABLE KEYS */;


# Dumping structure for table dde.persona
CREATE TABLE IF NOT EXISTS `persona` (
  `idPersona` int(11) NOT NULL auto_increment,
  `apePat` varchar(45) default NULL,
  `apeMat` varchar(45) default NULL,
  `nombres` varchar(45) default NULL,
  `nroDocu` varchar(45) default NULL,
  `fecNac` date default NULL,
  `idTipoDoc` varchar(2) default NULL,
  `idTurno` int(11) default NULL,
  `sexo` char(1) default NULL,
  `idEstCivil` int(11) default NULL,
  `nroHijos` int(11) default '0',
  `nroRuc` varchar(11) default NULL,
  `direccion` varchar(255) default NULL,
  `telefono` varchar(15) default NULL,
  `celular` varchar(15) default NULL,
  `email` varchar(45) default NULL,
  `lugar` varchar(255) default NULL,
  `IdOcupacion` varchar(6) default NULL,
  `nroLicencia` varchar(45) default NULL,
  `idUbigeo` varchar(6) default NULL,
  `idNacionalidad` varchar(4) default NULL,
  `idNivEdu` varchar(2) default NULL,
  `urbanizacion` varchar(255) default NULL,
  PRIMARY KEY  (`idPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.persona: ~0 rows (approximately)
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;


# Dumping structure for table dde.puestoscontrol
CREATE TABLE IF NOT EXISTS `puestoscontrol` (
  `idPuestosControl` int(11) NOT NULL auto_increment,
  `idAreaNatural` int(3) NOT NULL,
  `turismo` tinyint(4) default NULL,
  PRIMARY KEY  (`idPuestosControl`),
  KEY `fk_puestosControl_areanatural1` (`idAreaNatural`),
  CONSTRAINT `fk_puestosControl_areanatural1` FOREIGN KEY (`idAreaNatural`) REFERENCES `areanatural` (`idAreaNatural`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.puestoscontrol: ~0 rows (approximately)
/*!40000 ALTER TABLE `puestoscontrol` DISABLE KEYS */;
/*!40000 ALTER TABLE `puestoscontrol` ENABLE KEYS */;


# Dumping structure for table dde.rutaturismo
CREATE TABLE IF NOT EXISTS `rutaturismo` (
  `idRutaTurismo` int(11) NOT NULL auto_increment,
  `nombreRutaTurismo` varchar(128) default NULL,
  `detalleRutaTurismo` text,
  `idTurismo` int(11) NOT NULL,
  PRIMARY KEY  (`idRutaTurismo`),
  KEY `fk_rutaTurismo_turismo1` (`idTurismo`),
  CONSTRAINT `fk_rutaTurismo_turismo1` FOREIGN KEY (`idTurismo`) REFERENCES `turismo` (`idTurismo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.rutaturismo: ~0 rows (approximately)
/*!40000 ALTER TABLE `rutaturismo` DISABLE KEYS */;
/*!40000 ALTER TABLE `rutaturismo` ENABLE KEYS */;


# Dumping structure for table dde.tipoareaorganica
CREATE TABLE IF NOT EXISTS `tipoareaorganica` (
  `idTipoarea` int(3) NOT NULL auto_increment COMMENT 'Id del tipo de Area',
  `codTipoarea` char(2) default NULL COMMENT 'Codigo del tipo de Area',
  `desTipoarea` varchar(200) default NULL COMMENT 'Nombre del tipo de Area',
  PRIMARY KEY  (`idTipoarea`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

# Dumping data for table dde.tipoareaorganica: ~0 rows (approximately)
/*!40000 ALTER TABLE `tipoareaorganica` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipoareaorganica` ENABLE KEYS */;


# Dumping structure for table dde.tipobeneficiario
CREATE TABLE IF NOT EXISTS `tipobeneficiario` (
  `idtipobeneficiario` int(11) NOT NULL,
  `desctipobene` varchar(150) default NULL,
  PRIMARY KEY  (`idtipobeneficiario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.tipobeneficiario: ~0 rows (approximately)
/*!40000 ALTER TABLE `tipobeneficiario` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipobeneficiario` ENABLE KEYS */;


# Dumping structure for table dde.tipoturismo
CREATE TABLE IF NOT EXISTS `tipoturismo` (
  `idTipoTurismo` int(11) NOT NULL auto_increment,
  `nombreTipoTurismo` varchar(128) default NULL,
  `idTurismo` int(11) NOT NULL,
  PRIMARY KEY  (`idTipoTurismo`),
  KEY `fk_tipoTurismo_turismo1` (`idTurismo`),
  CONSTRAINT `fk_tipoTurismo_turismo1` FOREIGN KEY (`idTurismo`) REFERENCES `turismo` (`idTurismo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.tipoturismo: ~0 rows (approximately)
/*!40000 ALTER TABLE `tipoturismo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipoturismo` ENABLE KEYS */;


# Dumping structure for table dde.tipoturismoactividadturismo
CREATE TABLE IF NOT EXISTS `tipoturismoactividadturismo` (
  `idTipoTurismo` int(11) NOT NULL,
  `idActividadeTurismo` int(11) NOT NULL,
  PRIMARY KEY  (`idTipoTurismo`,`idActividadeTurismo`),
  KEY `fk_tipoTurismoactividadTurismo_actividadTurismo1` (`idActividadeTurismo`),
  CONSTRAINT `fk_tipoTurismoactividadTurismo_actividadTurismo1` FOREIGN KEY (`idActividadeTurismo`) REFERENCES `actividadturismo` (`idActividadeTurismo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tipoTurismoactividadTurismo_tipoTurismo1` FOREIGN KEY (`idTipoTurismo`) REFERENCES `tipoturismo` (`idTipoTurismo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.tipoturismoactividadturismo: ~0 rows (approximately)
/*!40000 ALTER TABLE `tipoturismoactividadturismo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipoturismoactividadturismo` ENABLE KEYS */;


# Dumping structure for table dde.turismo
CREATE TABLE IF NOT EXISTS `turismo` (
  `idTurismo` int(11) NOT NULL auto_increment,
  `idAreaNatural` int(3) NOT NULL,
  PRIMARY KEY  (`idTurismo`),
  KEY `fk_turismo_areanatural1` (`idAreaNatural`),
  CONSTRAINT `fk_turismo_areanatural1` FOREIGN KEY (`idAreaNatural`) REFERENCES `areanatural` (`idAreaNatural`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.turismo: ~0 rows (approximately)
/*!40000 ALTER TABLE `turismo` DISABLE KEYS */;
/*!40000 ALTER TABLE `turismo` ENABLE KEYS */;


# Dumping structure for table dde.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int(11) NOT NULL auto_increment COMMENT 'Id del Usuario',
  `usuario` varchar(20) default NULL COMMENT 'Codigo de usuario',
  `clave` varchar(20) default NULL COMMENT 'Clave de acceso',
  `nombres` varchar(64) default NULL COMMENT 'Nombres',
  `apepat` varchar(32) default NULL COMMENT 'Apellido paterno',
  `apemat` varchar(32) default NULL COMMENT 'Apellido materno',
  `correo` varchar(100) default NULL COMMENT 'Correo electronico',
  `direccion` varchar(200) default NULL COMMENT 'Domicilio',
  `telefono` varchar(15) default NULL COMMENT 'Telefono',
  `estado` int(1) default NULL COMMENT 'Estado del registro',
  `idArea` int(3) default NULL COMMENT 'Id del Area',
  `idPersona` int(11) default NULL,
  PRIMARY KEY  (`idUsuario`),
  KEY `FK_areaorganica_usuario` (`idArea`),
  KEY `fk_usuario_persona1` (`idPersona`),
  CONSTRAINT `FK_areaorganica_usuario0` FOREIGN KEY (`idArea`) REFERENCES `areaorganica` (`idArea`),
  CONSTRAINT `fk_usuario_persona1` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

# Dumping data for table dde.usuario: ~1 rows (approximately)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`idUsuario`, `usuario`, `clave`, `nombres`, `apepat`, `apemat`, `correo`, `direccion`, `telefono`, `estado`, `idArea`, `idPersona`) VALUES
	(3, 'admin', '1234', 'Enrique', 'Juan de Dios', 'Valencia', 'juandedioz@gmail.com', 'Av. Las Pruebas', '222-2222', 1, NULL, NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;


# Dumping structure for table dde.visitante
CREATE TABLE IF NOT EXISTS `visitante` (
  `idVisitante` int(11) NOT NULL auto_increment,
  `idOperadorTurismo` int(11) default NULL,
  `idEmpresaTurismo` int(11) default NULL,
  `idGuia` int(11) default NULL,
  `idRutaTurismo` int(11) NOT NULL,
  `idPersonal` int(11) NOT NULL,
  PRIMARY KEY  (`idVisitante`),
  KEY `fk_visitante_persona1` (`idPersonal`),
  KEY `fk_visitante_operadorTurismo1` (`idOperadorTurismo`),
  KEY `fk_visitante_operadorTurismo2` (`idEmpresaTurismo`),
  KEY `fk_visitante_guia1` (`idGuia`),
  KEY `fk_visitante_rutaTurismo1` (`idRutaTurismo`),
  CONSTRAINT `fk_visitante_guia1` FOREIGN KEY (`idGuia`) REFERENCES `guia` (`idGuia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_visitante_operadorTurismo1` FOREIGN KEY (`idOperadorTurismo`) REFERENCES `operadorturismo` (`idOperadorTurismo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_visitante_operadorTurismo2` FOREIGN KEY (`idEmpresaTurismo`) REFERENCES `operadorturismo` (`idOperadorTurismo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_visitante_persona1` FOREIGN KEY (`idPersonal`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_visitante_rutaTurismo1` FOREIGN KEY (`idRutaTurismo`) REFERENCES `rutaturismo` (`idRutaTurismo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.visitante: ~0 rows (approximately)
/*!40000 ALTER TABLE `visitante` DISABLE KEYS */;
/*!40000 ALTER TABLE `visitante` ENABLE KEYS */;


# Dumping structure for table dde.visitantetipoturismoactividadturismo
CREATE TABLE IF NOT EXISTS `visitantetipoturismoactividadturismo` (
  `idVisitante` int(11) NOT NULL,
  `idTipoTurismo` int(11) NOT NULL,
  `idActividadeTurismo` int(11) NOT NULL,
  KEY `fk_visitantetipoTurismoactividadTurismo_tipoTurismoactividadT1` (`idTipoTurismo`,`idActividadeTurismo`),
  KEY `fk_visitantetipoTurismoactividadTurismo_visitante1` (`idVisitante`),
  CONSTRAINT `fk_visitantetipoTurismoactividadTurismo_tipoTurismoactividadT1` FOREIGN KEY (`idTipoTurismo`, `idActividadeTurismo`) REFERENCES `tipoturismoactividadturismo` (`idTipoTurismo`, `idActividadeTurismo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_visitantetipoTurismoactividadTurismo_visitante1` FOREIGN KEY (`idVisitante`) REFERENCES `visitante` (`idVisitante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Dumping data for table dde.visitantetipoturismoactividadturismo: ~0 rows (approximately)
/*!40000 ALTER TABLE `visitantetipoturismoactividadturismo` DISABLE KEYS */;
/*!40000 ALTER TABLE `visitantetipoturismoactividadturismo` ENABLE KEYS */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
