-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `apostamientotropa`
--
CREATE TABLE IF NOT EXISTS `apostamientotropa` (
    `codigoapostamiento` int (11) NOT NULL,
    `codigociudapostador` int (11) NOT NULL,
    `codigociudadapostada` int (11) NOT NULL,
    `fechaapostamiento` date NOT NULL,
    `horaapostamiento` time NOT NULL,
    `vigencia` tinyint (1) NOT NULL DEFAULT '1',
    PRIMARY KEY (`codigoapostamiento`),
    KEY `codigociudapostador` (`codigociudapostador`),
    KEY `codigociudadapostada` (`codigociudadapostada`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `apostamientounidad`
--
CREATE TABLE IF NOT EXISTS `apostamientounidad` (
    `codigoapostamiento` int (11) NOT NULL,
    `codigounidad` int (11) NOT NULL,
    `codigoarma` int (11) NOT NULL,
    `cantidad` int (11) NOT NULL,
    PRIMARY KEY (
                    `codigoapostamiento`, `codigounidad`,
                    `codigoarma`
                ),
    KEY `codigounidad` (`codigounidad`),
    KEY `codigoarma` (`codigoarma`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `arma`
--
CREATE TABLE IF NOT EXISTS `arma` (
    `codigoarma` int (11) NOT NULL AUTO_INCREMENT,
    `nombrearma` varchar (30) NOT NULL,
    `puntosataque` int (11) DEFAULT NULL,
    `puntosdefensa` int (11) DEFAULT NULL,
    `costo` int (11) DEFAULT NULL,
    `codigoimagen` int (11) NOT NULL,
    PRIMARY KEY (`codigoarma`),
    UNIQUE KEY `nombrearma` (`nombrearma`),
    KEY `codigoimagen` (`codigoimagen`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 28;
--
-- Volcado de datos para la tabla `arma`
--
INSERT INTO `arma` (
    `codigoarma`, `nombrearma`, `puntosataque`,
    `puntosdefensa`, `costo`, `codigoimagen`
)
VALUES
    (1, 'Arco Compuesto', 60, 20, 2, 94),
    (
        2, 'Ariete Medieval', 100, 100, 5, 95
    ),
    (
        3, 'Ariete Cubierto', 110, 100, 6, 96
    ),
    (
        4, 'Ariete de Asedio', 150, 100, 7,
        97
    ),
    (5, 'Longbow', 80, 30, 4, 98),
    (6, 'Ballesta', 90, 50, 6, 99),
    (7, 'Ballista', 100, 60, 7, 100),
    (8, 'Mangonel', 80, 50, 9, 101),
    (9, 'Petrary', 90, 60, 9, 102),
    (10, 'Trebuchet', 150, 100, 10, 103),
    (11, 'Gladius', 80, 20, 4, 104),
    (12, 'Claymore', 100, 10, 5, 105),
    (13, 'Falcata', 90, 30, 5, 106),
    (14, 'Carabina', 80, 10, 4, 107),
    (15, 'Escopeta', 100, 10, 5, 108),
    (
        16, 'Espada de bronce', 100, 80, 6,
        109
    ),
    (
        17, 'Espada de hierro', 100, 100, 8,
        110
    ),
    (
        18, 'Espada de acero', 120, 100, 8,
        111
    ),
    (
        19, 'bolas explosivas', 100, 10, 7,
        112
    ),
    (
        20, 'Barril explosivo', 150, 10, 10,
        113
    ),
    (21, 'Honda', 50, 10, 2, 114),
    (22, 'Daga', 50, 10, 2, 115),
    (23, 'Jabalina', 70, 10, 4, 116),
    (24, 'Tridente', 80, 80, 7, 117),
    (25, 'Pica', 90, 50, 7, 118),
    (26, 'Mortero', 100, 70, 10, 120),
    (27, 'Ninguna', NULL, NULL, NULL, 1);
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `armaconstruccion`
--
CREATE TABLE IF NOT EXISTS `armaconstruccion` (
    `codigoarma` int (11) NOT NULL DEFAULT '0',
    `codigorecurso` tinyint (3) unsigned NOT NULL DEFAULT '0',
    `cantidad` int (11) NOT NULL,
    PRIMARY KEY (`codigoarma`, `codigorecurso`),
    KEY `codigorecurso` (`codigorecurso`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
--
-- Volcado de datos para la tabla `armaconstruccion`
--
INSERT INTO `armaconstruccion` (
    `codigoarma`, `codigorecurso`, `cantidad`
)
VALUES
    (1, 6, 20),
    (2, 6, 80),
    (3, 6, 80),
    (3, 9, 20),
    (4, 6, 100),
    (4, 9, 20),
    (4, 12, 10),
    (5, 6, 50),
    (6, 6, 60),
    (6, 9, 30),
    (7, 6, 60),
    (7, 9, 20),
    (7, 12, 20),
    (8, 6, 90),
    (8, 9, 20),
    (9, 6, 100),
    (9, 9, 20),
    (10, 6, 100),
    (10, 9, 50),
    (11, 6, 30),
    (11, 9, 20),
    (12, 6, 40),
    (12, 9, 20),
    (13, 6, 30),
    (13, 9, 30),
    (14, 6, 70),
    (14, 9, 50),
    (15, 6, 70),
    (15, 9, 70),
    (19, 9, 70),
    (20, 6, 80),
    (20, 9, 60),
    (21, 6, 30),
    (21, 9, 10),
    (22, 6, 20),
    (22, 12, 20),
    (23, 6, 60),
    (23, 9, 30),
    (24, 6, 50),
    (24, 9, 60),
    (25, 6, 50),
    (25, 9, 30),
    (25, 12, 20),
    (26, 6, 60),
    (26, 9, 80);
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `armaunidad`
--
CREATE TABLE IF NOT EXISTS `armaunidad` (
    `codigounidad` int (11) NOT NULL DEFAULT '0',
    `codigoarma` int (11) NOT NULL DEFAULT '0',
    PRIMARY KEY (`codigounidad`, `codigoarma`),
    KEY `codigoarma` (`codigoarma`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
--
-- Volcado de datos para la tabla `armaunidad`
--
INSERT INTO `armaunidad` (`codigounidad`, `codigoarma`)
VALUES
    (25, 1),
    (28, 2),
    (28, 3),
    (28, 4),
    (25, 5),
    (25, 6),
    (25, 7),
    (29, 8),
    (29, 9),
    (29, 10),
    (21, 11),
    (23, 11),
    (23, 12),
    (23, 13),
    (26, 14),
    (26, 15),
    (32, 19),
    (32, 20),
    (27, 21),
    (27, 22),
    (30, 22),
    (21, 23),
    (24, 23),
    (24, 24),
    (24, 25),
    (30, 26);
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `asalto`
--
CREATE TABLE IF NOT EXISTS `asalto` (
    `codigoataque` int (11) NOT NULL,
    `codigorecurso` tinyint (3) unsigned NOT NULL,
    `cantidad` int (11) NOT NULL,
    PRIMARY KEY (`codigoataque`, `codigorecurso`),
    KEY `codigorecurso` (`codigorecurso`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `ataque`
--
CREATE TABLE IF NOT EXISTS `ataque` (
    `codigoataque` int (11) NOT NULL AUTO_INCREMENT,
    `codigociudadjugatacante` int (11) NOT NULL,
    `codigociudadjugatacado` int (11) NOT NULL,
    `fechasalida` date NOT NULL,
    `horasalida` time NOT NULL,
    `fechallegada` date NOT NULL,
    `horallegada` time NOT NULL,
    `codigomision` int (11) NOT NULL,
    `codjugadorganador` int (11) DEFAULT NULL,
    `vigencia` int (11) DEFAULT NULL,
    PRIMARY KEY (`codigoataque`),
    KEY `codigociudadjugatacante` (`codigociudadjugatacante`),
    KEY `codigociudadjugatacado` (`codigociudadjugatacado`),
    KEY `codigomision` (`codigomision`),
    KEY `codjugadorganador` (`codjugadorganador`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 1;
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `ataqueunidaddecombate`
--
CREATE TABLE IF NOT EXISTS `ataqueunidaddecombate` (
    `codigoataque` int (11) NOT NULL DEFAULT '0',
    `codigounidad` int (11) NOT NULL DEFAULT '0',
    `codigoarma` int (11) NOT NULL DEFAULT '0',
    `atacante` tinyint (1) NOT NULL,
    `cantidad` int (11) NOT NULL,
    PRIMARY KEY (
                    `codigoataque`, `codigounidad`, `codigoarma`
                ),
    KEY `codigounidad` (`codigounidad`),
    KEY `codigoarma` (`codigoarma`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `barcomovimiento`
--
CREATE TABLE IF NOT EXISTS `barcomovimiento` (
    `codigomov` int (11) NOT NULL DEFAULT '0',
    `codigobarco` int (11) NOT NULL DEFAULT '0',
    `cantidad` int (11) NOT NULL,
    PRIMARY KEY (`codigomov`, `codigobarco`),
    KEY `codigobarco` (`codigobarco`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
--
-- Volcado de datos para la tabla `barcomovimiento`
--
INSERT INTO `barcomovimiento` (
    `codigomov`, `codigobarco`, `cantidad`
)
VALUES
    (3, 1, 7),
    (4, 1, 1);
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `barcos`
--
CREATE TABLE IF NOT EXISTS `barcos` (
    `codigobarco` int (11) NOT NULL AUTO_INCREMENT,
    `nombre` varchar (30) NOT NULL,
    `descripcion` varchar (240) NOT NULL,
    `codigoimagen` int (11) NOT NULL,
    `capacidad` int (11) NOT NULL,
    `costo` float DEFAULT NULL,
    PRIMARY KEY (`codigobarco`),
    UNIQUE KEY `nombre` (`nombre`),
    KEY `codigoimagen` (`codigoimagen`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 2;
--
-- Volcado de datos para la tabla `barcos`
--
INSERT INTO `barcos` (
    `codigobarco`, `nombre`, `descripcion`,
    `codigoimagen`, `capacidad`, `costo`
)
VALUES
    (
        1, 'Barco Mercante', 'El barco mercante sirve para transpotar recursos y soldados entre las ciudades de los jugadores',
        47, 1000, 500
    );
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `carga`
--
CREATE TABLE IF NOT EXISTS `carga` (
    `codigomov` int (11) NOT NULL DEFAULT '0',
    `codigorecurso` tinyint (3) unsigned NOT NULL DEFAULT '0',
    `cantidad` int (11) NOT NULL,
    PRIMARY KEY (`codigomov`, `codigorecurso`),
    KEY `codigorecurso` (`codigorecurso`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
--
-- Volcado de datos para la tabla `carga`
--
INSERT INTO `carga` (
    `codigomov`, `codigorecurso`, `cantidad`
)
VALUES
    (3, 6, 6008),
    (3, 9, 0),
    (3, 12, 0),
    (3, 14, 0),
    (3, 15, 0),
    (4, 6, 717),
    (4, 9, 0),
    (4, 12, 0),
    (4, 14, 0),
    (4, 15, 0);
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `cargamilitar`
--
CREATE TABLE IF NOT EXISTS `cargamilitar` (
    `codigomov` int (11) NOT NULL DEFAULT '0',
    `codigounidad` int (11) NOT NULL DEFAULT '0',
    `codigoarma` int (11) NOT NULL DEFAULT '0',
    `cantidad` int (11) NOT NULL,
    PRIMARY KEY (
                    `codigomov`, `codigounidad`, `codigoarma`
                ),
    KEY `codigounidad` (`codigounidad`),
    KEY `codigoarma` (`codigoarma`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `ciudad`
--
CREATE TABLE IF NOT EXISTS `ciudad` (
    `codigociudad` int (11) NOT NULL AUTO_INCREMENT,
    `codigojugador` int (11) NOT NULL,
    `nombre` varchar (25) NOT NULL,
    `codigoisla` int (11) NOT NULL,
    `nivel` tinyint (3) unsigned NOT NULL DEFAULT '1',
    `capacidadrecurso` int (11) NOT NULL DEFAULT '2000',
    `cantidadhabitantes` int (11) DEFAULT '0',
    `crecimientodehabitante` int (11) DEFAULT '0',
    `gradodesatisfacciontotal` int (11) DEFAULT '0',
    `codigoestado` tinyint (3) unsigned NOT NULL,
    `numeroposicionisla` tinyint (3) unsigned NOT NULL,
    `activa` tinyint (1) NOT NULL DEFAULT '1',
    `capital` tinyint (1) NOT NULL,
    `cantidadhabitantesdisponibles` int (11) DEFAULT NULL,
    `fechaactualizacion` datetime DEFAULT NULL,
    PRIMARY KEY (`codigociudad`),
    UNIQUE KEY `codigojugador` (`codigojugador`, `nombre`),
    KEY `codigoisla` (`codigoisla`),
    KEY `nivel` (`nivel`),
    KEY `codigoestado` (`codigoestado`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 69;
--
-- Volcado de datos para la tabla `ciudad`
--
INSERT INTO `ciudad` (
    `codigociudad`, `codigojugador`,
    `nombre`, `codigoisla`, `nivel`,
    `capacidadrecurso`, `cantidadhabitantes`,
    `crecimientodehabitante`, `gradodesatisfacciontotal`,
    `codigoestado`, `numeroposicionisla`,
    `activa`, `capital`, `cantidadhabitantesdisponibles`,
    `fechaactualizacion`
)
VALUES
    (
        1, 6, 'Nación de Fuego', 50, 20, 42000,
        801, -300, 0, 1, 1, 1, 1, 801, '2014-11-18 00:46:41'
    ),
    (
        2, 6, 'Ba Sing Se', 51, 19, 2000, 1100,
        NULL, 0, 1, 1, 1, 0, 1100, '2014-11-18 00:46:41'
    ),
    (
        3, 6, 'Isla Kioshy', 52, 18, 2000, 1100,
        NULL, 0, 1, 1, 1, 0, 1100, '2014-11-18 00:46:41'
    ),
    (
        4, 6, 'Isla de Roku', 53, 17, 2000, 1100,
        -300, 0, 1, 1, 1, 0, 1100, '2014-11-18 00:46:41'
    ),
    (
        5, 6, 'Nomadas Aire', 54, 16, 2000, 1100,
        NULL, 0, 1, 1, 1, 0, 1100, '2014-11-18 00:46:43'
    ),
    (
        6, 6, 'Omashu', 55, 15, 2000, 1100, -300,
        0, 1, 1, 1, 0, 1100, '2014-11-18 00:46:44'
    ),
    (
        7, 6, 'Polo Sur', 56, 14, 2000, 1100,
        NULL, 0, 1, 1, 1, 0, 1100, '2014-11-18 00:46:45'
    ),
    (
        8, 6, 'Polo Norte', 57, 13, 2000, 1100,
        NULL, 0, 1, 1, 1, 0, 1100, '2014-11-18 00:46:45'
    ),
    (
        9, 7, 'Imperio Cesar I', 58, 12, 2000,
        1100, NULL, 0, 1, 1, 1, 1, 1100, '2014-11-18 00:46:45'
    ),
    (
        10, 7, 'Imperio Cesar II', 50, 11, 2000,
        1100, NULL, 0, 1, 2, 1, 0, 1100, '2014-11-18 00:46:45'
    ),
    (
        11, 7, 'Imperio Cesar III', 51, 10,
        2000, 1100, NULL, 0, 1, 2, 1, 0, 1100,
        '2014-11-18 00:46:46'
    ),
    (
        12, 7, 'Imperio Cesar IV', 52, 9, 2000,
        1100, NULL, 0, 1, 2, 1, 0, 1100, '2014-11-18 00:46:46'
    ),
    (
        13, 7, 'Imperio Cesar V', 53, 8, 2000,
        1100, NULL, 0, 1, 2, 1, 0, 1100, '2014-11-18 00:46:46'
    ),
    (
        14, 7, 'Imperio Cesar VI', 54, 7, 2000,
        1100, NULL, 0, 1, 2, 1, 0, 1100, '2014-11-18 00:46:46'
    ),
    (
        15, 8, 'Grecia I', 55, 14, 10000, 1100,
        -300, 0, 1, 2, 1, 1, 1100, '2014-11-18 00:46:46'
    ),
    (
        16, 8, 'Grecia II', 56, 5, 2000, 1100,
        NULL, 0, 1, 2, 1, 0, 1100, '2014-11-18 00:46:46'
    ),
    (
        17, 8, 'Grecia III', 57, 7, 2000, 1100,
        NULL, 0, 1, 2, 1, 0, 1100, '2014-11-18 00:46:46'
    ),
    (
        18, 8, 'Grecia IV', 58, 3, 2000, 1100,
        NULL, 0, 1, 2, 1, 0, 1100, '2014-11-18 00:46:46'
    );
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `ciudadacademia`
--
CREATE TABLE IF NOT EXISTS `ciudadacademia` (
    `codigociudad` int (11) NOT NULL DEFAULT '0',
    `investigadores` int (11) DEFAULT '0',
    `fechaactualizacion` date DEFAULT NULL,
    `horaactualizacion` time DEFAULT NULL,
    PRIMARY KEY (`codigociudad`),
    KEY `fechaactualizacion` (
                                 `fechaactualizacion`, `horaactualizacion`
                             )
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
--
-- Volcado de datos para la tabla `ciudadacademia`
--
INSERT INTO `ciudadacademia` (
    `codigociudad`, `investigadores`,
    `fechaactualizacion`, `horaactualizacion`
)
VALUES
    (1, 100, '2014-11-18', '00:46:40'),
    (2, 0, '2014-11-18', '00:46:41'),
    (3, 0, '2014-11-18', '00:46:41'),
    (4, 0, '2014-11-18', '00:46:43'),
    (5, 0, '2014-11-18', '00:46:44'),
    (6, 0, '2014-11-18', '00:46:44'),
    (7, 0, '2014-11-18', '00:46:44'),
    (8, 0, '2014-11-18', '00:46:44'),
    (9, 0, '2014-11-18', '00:46:45'),
    (10, 0, '2014-11-18', '00:46:45'),
    (11, 0, '2014-11-18', '00:46:45'),
    (12, 0, '2014-11-18', '00:46:45'),
    (13, 0, '2014-11-18', '00:46:45'),
    (14, 0, '2014-11-18', '00:46:45'),
    (15, 0, '2014-11-18', '00:46:46'),
    (16, 0, '2014-11-18', '00:46:46'),
    (17, 0, '2014-11-18', '00:46:46'),
    (18, 0, '2014-11-18', '00:46:46');
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `ciudadbarco`
--
CREATE TABLE IF NOT EXISTS `ciudadbarco` (
    `codigociudad` int (11) NOT NULL,
    `codigobarco` int (11) NOT NULL,
    `cantidadtotal` int (11) NOT NULL,
    `cantidaddisponible` int (11) DEFAULT NULL,
    PRIMARY KEY (`codigociudad`, `codigobarco`),
    KEY `codigobarco` (`codigobarco`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
--
-- Volcado de datos para la tabla `ciudadbarco`
--
INSERT INTO `ciudadbarco` (
    `codigociudad`, `codigobarco`, `cantidadtotal`,
    `cantidaddisponible`
)
VALUES
    (1, 1, 8, 2);
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `ciudadedificionivel`
--
CREATE TABLE IF NOT EXISTS `ciudadedificionivel` (
    `codigociudad` int (11) NOT NULL,
    `codigoedificio` int (11) NOT NULL,
    `lugarciudad` tinyint (3) unsigned NOT NULL,
    PRIMARY KEY (
                    `codigociudad`, `codigoedificio`
                ),
    KEY `codigoedificio` (`codigoedificio`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
--
-- Volcado de datos para la tabla `ciudadedificionivel`
--
INSERT INTO `ciudadedificionivel` (
    `codigociudad`, `codigoedificio`,
    `lugarciudad`
)
VALUES
    (1, 17, 11),
    (1, 21, 6),
    (1, 30, 3),
    (1, 36, 8),
    (1, 130, 7),
    (1, 160, 4),
    (1, 165, 9),
    (1, 178, 12),
    (1, 183, 2),
    (1, 211, 13),
    (1, 292, 15),
    (1, 312, 14),
    (1, 392, 10),
    (2, 34, 6),
    (2, 71, 8),
    (2, 101, 3),
    (2, 159, 4),
    (2, 164, 9),
    (2, 182, 2),
    (2, 196, 12),
    (2, 210, 13),
    (2, 332, 10),
    (3, 35, 6),
    (3, 75, 8),
    (3, 102, 3),
    (3, 158, 4),
    (3, 181, 2),
    (3, 196, 12),
    (3, 209, 13),
    (4, 78, 8),
    (4, 101, 3),
    (4, 116, 6),
    (4, 157, 4),
    (4, 180, 2),
    (4, 196, 12),
    (4, 208, 13),
    (5, 30, 3),
    (5, 79, 8),
    (5, 117, 6),
    (5, 156, 4),
    (5, 181, 2),
    (5, 196, 12),
    (5, 207, 13),
    (6, 29, 3),
    (6, 80, 8),
    (6, 118, 6),
    (6, 155, 4),
    (6, 182, 2),
    (6, 196, 12),
    (6, 206, 13),
    (6, 392, 15),
    (7, 81, 8),
    (7, 103, 3),
    (7, 119, 6),
    (7, 154, 4),
    (7, 180, 2),
    (7, 196, 12),
    (7, 205, 13),
    (8, 82, 8),
    (8, 104, 3),
    (8, 120, 6),
    (8, 153, 4),
    (8, 179, 2),
    (8, 195, 12),
    (8, 204, 13),
    (9, 65, 2),
    (9, 102, 3),
    (9, 152, 4),
    (9, 176, 12),
    (9, 203, 13),
    (10, 64, 2),
    (10, 85, 8),
    (10, 101, 3),
    (10, 122, 7),
    (10, 151, 4),
    (10, 194, 12),
    (10, 202, 13),
    (11, 18, 8),
    (11, 30, 3),
    (11, 63, 2),
    (11, 123, 7),
    (11, 150, 4),
    (11, 194, 12),
    (11, 201, 13),
    (12, 19, 8),
    (12, 29, 3),
    (12, 62, 2),
    (12, 124, 7),
    (12, 149, 4),
    (12, 194, 12),
    (12, 200, 13),
    (13, 20, 8),
    (13, 30, 3),
    (13, 51, 9),
    (13, 61, 2),
    (13, 125, 7),
    (13, 148, 4),
    (13, 194, 12),
    (13, 199, 13),
    (14, 28, 3),
    (14, 52, 9),
    (14, 62, 2),
    (14, 71, 8),
    (14, 126, 7),
    (14, 147, 4),
    (14, 194, 12),
    (14, 198, 13),
    (15, 16, 10),
    (15, 27, 3),
    (15, 36, 9),
    (15, 51, 6),
    (15, 59, 12),
    (15, 63, 2),
    (15, 129, 7),
    (15, 153, 4),
    (15, 292, 8),
    (16, 15, 13),
    (16, 20, 8),
    (16, 26, 3),
    (16, 50, 4),
    (16, 54, 9),
    (16, 64, 2),
    (16, 69, 12),
    (16, 128, 7),
    (17, 14, 13),
    (17, 27, 3),
    (17, 65, 2),
    (17, 69, 12),
    (17, 71, 8),
    (17, 129, 7),
    (17, 146, 4),
    (17, 161, 9),
    (18, 13, 13),
    (18, 19, 8),
    (18, 28, 3),
    (18, 48, 4),
    (18, 69, 12),
    (18, 161, 9),
    (18, 179, 2);
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `ciudadejercito`
--
CREATE TABLE IF NOT EXISTS `ciudadejercito` (
    `codigounidadciudad` int (11) NOT NULL AUTO_INCREMENT,
    `codigociudad` int (11) NOT NULL,
    `codigounidad` int (11) NOT NULL,
    `cantidadtotal` int (11) DEFAULT NULL,
    `cantidadsinarma` int (11) DEFAULT NULL,
    `capacidaddisponiblesinarma` int (11) DEFAULT NULL,
    PRIMARY KEY (`codigounidadciudad`),
    UNIQUE KEY `codigociudad` (`codigociudad`, `codigounidad`),
    KEY `codigounidad` (`codigounidad`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 324;
;
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `ciudadejercitoarma`
--
CREATE TABLE IF NOT EXISTS `ciudadejercitoarma` (
    `codigounidadciudad` int (11) NOT NULL DEFAULT '0',
    `codigoarma` int (11) NOT NULL,
    `cantidad` int (11) DEFAULT NULL,
    `cantidaddisponibleciudad` int (11) DEFAULT NULL,
    PRIMARY KEY (
                    `codigounidadciudad`, `codigoarma`
                ),
    KEY `codigoarma` (`codigoarma`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;

-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `ciudadproduccion`
--
CREATE TABLE IF NOT EXISTS `ciudadproduccion` (
    `codigociudad` int (11) NOT NULL DEFAULT '0',
    `codigorecurso` tinyint (3) unsigned NOT NULL DEFAULT '0',
    `cantidadhora` int (11) DEFAULT '0',
    `fechaactualizacion` date DEFAULT NULL,
    `horaactualizacion` time DEFAULT NULL,
    PRIMARY KEY (`codigociudad`, `codigorecurso`),
    KEY `codigorecurso` (`codigorecurso`),
    KEY `fechaactualizacion` (
                                 `fechaactualizacion`, `horaactualizacion`
                             )
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;

-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `ciudadrecurso`
--
CREATE TABLE IF NOT EXISTS `ciudadrecurso` (
    `codigociudad` int (11) NOT NULL,
    `codigorecurso` tinyint (3) unsigned NOT NULL,
    `cantidad` int (11) DEFAULT NULL,
    `fechaactualizacion` date DEFAULT NULL,
    `horaactualizacion` time DEFAULT NULL,
    PRIMARY KEY (`codigociudad`, `codigorecurso`),
    KEY `codigorecurso` (`codigorecurso`),
    KEY `codigociudad` (
                           `codigociudad`, `codigorecurso`,
                           `fechaactualizacion`, `horaactualizacion`
                       )
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
--
-- Volcado de datos para la tabla `ciudadrecurso`
--
INSERT INTO `ciudadrecurso` (
    `codigociudad`, `codigorecurso`,
    `cantidad`, `fechaactualizacion`,
    `horaactualizacion`
)
VALUES
    (
        1, 6, 50000, '2001-01-01', '01:00:00'
    ),
    (
        1, 9, 50000, '2014-10-23', '14:35:12'
    ),
    (
        1, 12, 50000, '2014-10-26', '00:36:47'
    ),
    (
        1, 14, 50000, '2014-10-26', '00:36:48'
    ),
    (
        1, 15, 50000, '2014-10-26', '00:36:49'
    ),
    (
        2, 6, 50000, '2014-10-26', '00:36:45'
    ),
    (
        2, 9, 50000, '2014-10-26', '00:36:46'
    ),
    (
        2, 12, 50000, '2014-10-26', '00:36:47'
    ),
    (
        2, 14, 50000, '2014-10-26', '00:36:48'
    ),
    (
        2, 15, 50000, '2014-10-26', '00:36:49'
    ),
    (
        3, 6, 50000, '2014-10-26', '00:36:45'
    ),
    (
        3, 9, 50000, '2014-10-26', '00:36:46'
    ),
    (
        3, 12, 50000, '2014-10-26', '00:36:47'
    ),
    (
        3, 14, 50000, '2014-10-26', '00:36:48'
    ),
    (
        3, 15, 50000, '2014-10-26', '00:36:48'
    ),
    (
        4, 6, 50000, '2014-10-26', '00:36:45'
    ),
    (
        4, 9, 50000, '2014-10-26', '00:36:46'
    ),
    (
        4, 12, 50000, '2014-10-26', '00:36:47'
    ),
    (
        4, 14, 50000, '2014-10-26', '00:36:48'
    ),
    (
        4, 15, 50000, '2014-10-26', '00:36:48'
    ),
    (
        5, 6, 50000, '2014-10-26', '00:36:45'
    ),
    (
        5, 9, 50000, '2014-10-26', '00:36:46'
    ),
    (
        5, 12, 50000, '2014-10-26', '00:36:47'
    ),
    (
        5, 14, 50000, '2014-10-26', '00:36:48'
    ),
    (
        5, 15, 50000, '2014-10-26', '00:36:48'
    ),
    (
        6, 6, 50000, '2014-10-26', '00:36:45'
    ),
    (
        6, 9, 50000, '2014-10-26', '00:36:46'
    ),
    (
        6, 12, 50000, '2014-10-26', '00:36:47'
    ),
    (
        6, 14, 50000, '2014-10-26', '00:36:48'
    ),
    (
        6, 15, 50000, '2014-10-26', '00:36:48'
    ),
    (
        7, 6, 50000, '2014-10-26', '00:36:45'
    ),
    (
        7, 9, 50000, '2014-10-26', '00:36:46'
    ),
    (
        7, 12, 50000, '2014-10-26', '00:36:47'
    ),
    (
        7, 14, 50000, '2014-10-26', '00:36:48'
    ),
    (
        7, 15, 50000, '2014-10-26', '00:36:48'
    ),
    (
        8, 6, 50000, '2014-10-26', '00:36:45'
    ),
    (
        8, 9, 50000, '2014-10-26', '00:36:46'
    ),
    (
        8, 12, 50000, '2014-10-26', '00:36:47'
    ),
    (
        8, 14, 50000, '2014-10-26', '00:36:48'
    ),
    (
        8, 15, 50000, '2014-10-26', '00:36:48'
    ),
    (
        9, 6, 50000, '2014-10-26', '00:36:45'
    ),
    (
        9, 9, 50000, '2014-10-26', '00:36:46'
    ),
    (
        9, 12, 50000, '2014-10-26', '00:36:47'
    ),
    (
        9, 14, 50000, '2014-10-26', '00:36:48'
    ),
    (
        9, 15, 50000, '2014-10-26', '00:36:48'
    ),
    (
        10, 6, 50000, '2014-10-26', '00:36:45'
    ),
    (
        10, 9, 50000, '2014-10-26', '00:36:46'
    ),
    (
        10, 12, 50000, '2014-10-26', '00:36:47'
    ),
    (
        10, 14, 50000, '2014-10-26', '00:36:47'
    ),
    (
        10, 15, 50000, '2014-10-26', '00:36:48'
    ),
    (
        11, 6, 50000, '2014-10-26', '00:36:45'
    ),
    (
        11, 9, 50000, '2014-10-26', '00:36:46'
    ),
    (
        11, 12, 50000, '2014-10-26', '00:36:47'
    ),
    (
        11, 14, 50000, '2014-10-26', '00:36:47'
    ),
    (
        11, 15, 50000, '2014-10-26', '00:36:48'
    ),
    (
        12, 6, 50000, '2014-10-26', '00:36:45'
    ),
    (
        12, 9, 50000, '2014-10-26', '00:36:46'
    ),
    (
        12, 12, 50000, '2014-10-26', '00:36:46'
    ),
    (
        12, 14, 50000, '2014-10-26', '00:36:47'
    ),
    (
        12, 15, 50000, '2014-10-26', '00:36:48'
    ),
    (
        13, 6, 50000, '2014-10-26', '00:36:45'
    ),
    (
        13, 9, 50000, '2014-10-26', '00:36:45'
    ),
    (
        13, 12, 50000, '2014-10-26', '00:36:46'
    ),
    (
        13, 14, 50000, '2014-10-26', '00:36:47'
    ),
    (
        13, 15, 50000, '2014-10-26', '00:36:48'
    ),
    (
        14, 6, 50000, '2014-10-26', '00:36:44'
    ),
    (
        14, 9, 50000, '2014-10-26', '00:36:45'
    ),
    (
        14, 12, 50000, '2014-10-26', '00:36:46'
    ),
    (
        14, 14, 50000, '2014-10-26', '00:36:47'
    ),
    (
        14, 15, 50000, '2014-10-26', '00:36:48'
    ),
    (
        15, 6, 50000, '2014-10-26', '00:36:44'
    ),
    (
        15, 9, 50000, '2014-10-26', '00:36:45'
    ),
    (
        15, 12, 50000, '2014-10-26', '00:36:46'
    ),
    (
        15, 14, 50000, '2014-10-26', '00:36:47'
    ),
    (
        15, 15, 50000, '2014-10-26', '00:36:48'
    ),
    (
        16, 6, 50000, '2014-10-26', '00:36:44'
    ),
    (
        16, 9, 50000, '2014-10-26', '00:36:45'
    ),
    (
        16, 12, 50000, '2014-10-26', '00:36:46'
    ),
    (
        16, 14, 50000, '2014-10-26', '00:36:47'
    ),
    (
        16, 15, 50000, '2014-10-26', '00:36:48'
    ),
    (
        17, 6, 50000, '2014-10-26', '00:36:44'
    ),
    (
        17, 9, 50000, '2014-10-26', '00:36:45'
    ),
    (
        17, 12, 50000, '2014-10-26', '00:36:46'
    ),
    (
        17, 14, 50000, '2014-10-26', '00:36:47'
    ),
    (
        17, 15, 50000, '2014-10-26', '00:36:48'
    ),
    (
        18, 6, 50000, '2014-10-26', '00:36:44'
    ),
    (
        18, 9, 50000, '2014-10-26', '00:36:45'
    ),
    (
        18, 12, 50000, '2014-10-26', '00:36:46'
    ),
    (
        18, 14, 50000, '2014-10-26', '00:36:47'
    ),
    (
        18, 15, 50000, '2014-10-26', '00:36:48'
    );
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `ciudadtaberna`
--
CREATE TABLE IF NOT EXISTS `ciudadtaberna` (
    `codigociudad` int (11) NOT NULL DEFAULT '0',
    `cantidadvinoservido` int (11) DEFAULT '0',
    `fechaactualizacion` date DEFAULT NULL,
    `horaactualizacion` time DEFAULT NULL,
    PRIMARY KEY (`codigociudad`),
    KEY `fechaactualizacion` (`fechaactualizacion`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
--
-- Volcado de datos para la tabla `ciudadtaberna`
--
INSERT INTO `ciudadtaberna` (
    `codigociudad`, `cantidadvinoservido`,
    `fechaactualizacion`, `horaactualizacion`
)
VALUES
    (1, 0, '2014-11-18', '00:46:41'),
    (4, 0, '2014-11-18', '00:46:41'),
    (6, 0, '2014-11-18', '00:46:41'),
    (15, 0, '2014-11-18', '00:46:42');
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `depositomercado`
--
CREATE TABLE IF NOT EXISTS `depositomercado` (
    `codigojugador` int (11) NOT NULL DEFAULT '0',
    `codigorecurso` tinyint (3) unsigned NOT NULL DEFAULT '0',
    `cantidad` int (11) DEFAULT NULL,
    PRIMARY KEY (
                    `codigojugador`, `codigorecurso`
                ),
    KEY `codigorecurso` (`codigorecurso`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;

-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `edificio`
--
CREATE TABLE IF NOT EXISTS `edificio` (
    `codigoedificio` int (11) NOT NULL AUTO_INCREMENT,
    `nombre` varchar (30) NOT NULL,
    `codigoimagen` int (11) DEFAULT NULL,
    `costo` float DEFAULT NULL,
    `descripcion` text NOT NULL,
    PRIMARY KEY (`codigoedificio`),
    KEY `codigoimagen` (`codigoimagen`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 33;
--
-- Volcado de datos para la tabla `edificio`
--
INSERT INTO `edificio` (
    `codigoedificio`, `nombre`, `codigoimagen`,
    `costo`, `descripcion`
)
VALUES
    (
        1, 'Taberna', 12, 50, 'Después de un día de arduo trabajo no hay nada más reconfortante que un fresco jarro lleno de Vino. Es por eso que los Ciudadanos se reónen en la Taberna. Cuando cae la noche y ya no quedan más canciones por cantar emprenden la vuelta serenos y alegres a sus hogares. Cada ampliación en tu Taberna te permite servir más Vino y, así, aumentar la Satisfacción.'
    ),
    (
        2, 'Academia', 1, 100, 'La Academia en Ikariam es la meca de la sabiduría, donde el conocimiento arraigado en la tradición se funde con las más modernas t?cnicas. ?Las mentes más inteligentes de tu ciudad esperan ser aceptadas! Ten en consideración que cada investigador necesita un laboratorio, lo cual genera gastos.'
    ),
    (
        3, 'Almacen', 2, 20, 'El Almacón en Ikariam te permite almacenar mayores cantidades de Recursos. Cada nivel de ampliación puede contener 32,000 unidades de cada tipo de Recurso. No obstante, el Almacón no está protegido contra Saqueos. Para construir el Almacón, es necesario haber completado la Investigación de Almacón '
    ),
    (
        4, 'Astillero de Guerra', 3, 150, 'Que sería de un imperio situado en una isla sin su flota, En el astillero de guerra se construyen y reparan las más poderosas naves de guerra que surcarón los 7 mares estremeciendo sus alrededores! Astilleros de Guerra más grandes permiten construir más rápido los barcos.Es necesario investigar Carenero.'
    ),
    (
        5, 'Cuartel', 4, 120, 'En el Cuartel de Ikariam, los jóvenes más impetuosos son adiestrados como audaces guerreros. Tus soldados dominan el arte de la espada, la lanza y la catapulta. Además saben maniobrar las más poderosas máquinas de guerra en el campo de Batalla. Si amplias el Cuartel, el tiempo necesario para instruir a tus soldados disminuir?.'
    ),
    (
        6, 'Deposito', 5, 50, 'El Depésito en Ikariam te permite almacenar Recursos en tu ciudad aunque solo una parte de tus suministros se protegen all?. Son protegidos de infames saqueos, como también de las tormentas, p?jaros y parésitos.'
    ),
    (
        7, 'Embajada', 6, 70, 'La Embajada de Ikariam es un sitio din?mico: Diplom?ticos de todo el mundo pactan aquí  tratados y forjan Alianzas. Para que tu Alianza crezca, debes ampliar tu Embajada. Por cada ampliación aumentan tus puntos de diplomacia. A partir del 3? nivel puedes fundar una Alianza'
    ),
    (
        8, 'Intendencia', 7, 175, 'En el corazón de la ciudad se halla la Intendencia de Ikariam. Con ella crece y se desarrolla la ciudad, sus idóneos funcionarios brindan a todo momento información actualizada acerca de los habitantes locales.'
    ),
    (
        9, 'Mercado', 8, 50, 'Mercaderes y comerciantes hacen sus negocios en la Tienda. All? se cierra siempre alguna que otra transacción o se encuentran ofertas, buenas oportunidades. ?Mercaderes de tierras lejanas dirigen afamadas y colosales Tiendas!Cada dos ampliaciones se extiende el radio de bésqueda de tu Tienda.En la Tienda puedes comprar y vender los Recursos que necesites, con el Oro como moneda de cambio, con otros jugadores cercanos. '
    ),
    (
        10, 'Palacio', 9, 350, 'Desde el Palacio de Ikariam puedes conducir el destino de tu imperio. As? mismo te ofrece una vista maravillosa hacia el mar. Cada ampliación realizada en el Palacio de tu Capital, te permite fundar una nueva colonia. '
    ),
    (
        11, 'Puerto', 10, 100, 'El puerto, lugar de origen con rumbo hacia el mundo. Aqu? puedes reclutar Barcos Mercantes y prepararlos para viajes a lugares lejanos. Asimismo puedes recibir bienes preciosos de todo el mundo. En Puertos más grandes, los barcos son cargados más rápido.'
    ),
    (
        12, 'Residencia del Gobernador',
        11, 350, 'Un gobernador en tu colonia garantiza que todos los asuntos administrativos diarios están al día. Además, reduce el nivel de Corrupción en tu colonia. La Residencia del Gobernador puede ser ampliada a Palacio por si quieres trasladar tu Capital.'
    ),
    (
        23, 'Cabaña del guarda Bosque',
        89, 75, 'Caba?a del GuardabosquesLos fuertes leñodores pueden cortar incluso los ?rboles más grandes. Pero ellos también saben que un bosque debe ser cultivado con la ayuda de la Caba?a del Guardabosques y nuevos ?rboles deben ser plantados, de modo que nosotros podamos seguir usando s?lo los mejores bosques para nuestras casas.;La producción de Madera aumenta un 2% por cada nivel de ampliación del edificio (s?lo en la ciudad en la que es construida).;Es necesario investigar Mejorada la Recolección de Recursos (Economía) para poder construir este edificio.'
    ),
    (
        24, 'Cantero', 54, 80, 'Un cantero bien entrenado siempre rompe con sus brazos fuertes los mejores bloques de m?rmol As? no se rompen muchas bloques y nuestros constructores tienen siempre el material que necesitan.;La producción de M?rmol aumenta un 2% por cada nivel de extensión (s?lo en la ciudad en la que es construida).;Es necesario investigar Mejorada la Recolección de Recursos (Economía) para poder construir este edificio.'
    ),
    (
        25, 'Soplador de Vidrio', 55, 80, 'Los verdaderos maestros de su arte crean pedazos brillantes en la casa del Soplador de Vidrio. Soplan tubos, cristales y todo tipo de aparatos que s?lo nuestros científicos entienden. Y son tan diestros, que las cosas se rompen s?lo muy de vez en cuando.;La producción de Cristal aumenta un 2% por cada nivel de extensión (s?lo en la ciudad en la que es construida).;Es necesario investigar Mejorada la Recolección de Recursos (Economía) para poder construir el Soplador de Vidrio.'
    ),
    (
        26, 'Torre del Alquimista', 56, 80,
        'Cuando el viento del Oeste sopla, un olor llena las calles alrededor de la Torre del Alquimista y son muchos los Ciudadanos que abandonan sus hogares con una mota en su nariz. Nuestros alquimistas trabajan sin descanso para encontrar la mezcla perfecta y así procurar sacar más Azufre del volcón.;La producción de Azufre aumenta un 2% por cada nivel de ampliación (s?lo en la ciudad en la que es construida).;Es necesario investigar Mejorada la Recolección de Recursos (Economía) para poder construir la Torre del Alquimista.'
    ),
    (
        27, 'Vinicultor', 57, 80, 'Vinicultor habilidoso escoge s?lo colinas soleadas para cubrirlas con el verde de la vid. As? es como los Vi?edos producen mejores uvas para una excelente cosecha.;La producción de Vino aumenta un 2% por cada nivel de ampliación (s?lo en la ciudad en la que es construida).;Es necesario investigar Mejorada la Recolección de Recursos (Economía) para poder construir el Vinicultor.'
    ),
    (
        28, 'Carpinteria', 58, 80, 'S?lo la mejor Madera es elaborada en el taller del Carpintero. Por lo tanto nuestros habilidosos artesanos son capaces de construir un marco s?lido y nuestras casas no tienen que ser reparadas todo el tiempo. ;Cada nivel de la Carpintería reduce la demanda de Madera en 1% (solo en la ciudad en la que es construido este edificio).;Este edificio reduce los costes de Madera en todos los Edificios, Unidades y Barcos de Guerra. Por esta razón es aconsejable tener una Carpintería en todas tus ciudades.;Este edificio no afecta a los costes de la donaciones a los Aserraderos, Canteras, Minas de Azufre, Vi?edos ni Minas de Cristal en la Isla.'
    ),
    (
        29, 'Prensa de Vino', 59, 80, 'S?lo los vinos más puros maduran en las profundas y frescas bodegas de la ciudad. El Maestro de la Prensa de Vino cuida de que no se filtre nada y de que todo el vino pueda fluir por las gargantas de tus Ciudadanos.;Cada nivel de la Prensa de Vino reduce la demanda de Vino en 1% (solo en la ciudad en la que es construido este edificio).;Este edificio reduce los costes de Vino en la Construcción del Palacio, las Residencias del Gobernador, el consumo de Vino en la Taberna  y el coste de entrenamiento de Cocineros en el Cuartel.;Este edificio no afecta a los costes de la donaciones a las Maravillas en la Isla.'
    ),
    (
        30, 'Oficina del Arquitecto', 60,
        80, 'óngulo, compés y regla: la Oficina del Arquitecto provee de todo lo necesario para construir tejados estables y paredes rectas. Y un edificio bien diseñodo requiere de menos m?rmol que uno chapucero. Por cada nivel disminuye el m?rmol necesario en la ciudad un 1% del valor base.;Cada nivel del Oficina del Arquitecto reduce la demanda de M?rmol en 1% (solo en la ciudad en la que es construido este edificio).;Este edificio reduce los costes de M?rmol en todos los Edificios, excepto la Academia y el Templo. Algunos edificios no se verón afectados en los niveles más bajos ya que solo requieren Madera para ser ampliados.;Este edificio no afecta a los costes de la donaciones a las Maravillas en la Isla.'
    ),
    (
        31, 'Optico', 61, 80, 'Las lentillas y lupas no s?lo ayudan a nuestros Científicos a ver claramente y encontrar papeles importantes sobre su escritorio, también son necesarias para inventar todas las nuevas tecnolog?as que nos hace ser tan orgullosos. El ?ptico guarda cuidadosamente todo lo que necesitan nuestros científicos. As? se pierden menos cosas y la demanda del Cristal disminuye.;Cada nivel del ?ptico reduce la demanda de Cristal en 1% (solo en la ciudad en la que es construido este edificio).;Este edificio reduce los costes de Cristal en la Construcción del Palacio y de las Residencias del Gobernador.;Tambión reduce el coste de las Mejoras de Unidades y Mejoras de Barcos (en el Taller de Invenciones) y el entrenamiento de M?dicos (en el Cuartel) y la construcción de Submarinos (en el Astillero).;El ?ptico reduce el coste de los Experimentos en la Academia hasta en un 32%.;Este edificio no afecta a los costes de la donaciones a las Maravillas en la Isla.'
    ),
    (
        32, 'Area de Pruebas Pirotecnicas',
        93, 80, 'Las pruebas con fuegos artificiales no s?lo hacen que la noche brille, a veces también brillan los edificios circundantes. Nuestros investigadores, sin embargo, s?lo pueden optimizar la demanda del azufre cuando prueban nuevas mezclas una y otra vez.;Cada nivel del Area de Pruebas Pirot?cnicas reduce la demanda de Azufre en 1% (solo en la ciudad en la que es construido este edificio).;Este edificio reduce los costes de Azufre en la Construcción del Palacio y de las Residencias del Gobernador, en las Unidades (excepto en Cocineros, M?dicos, Arietes, Honderos y Lanceros) y en los Barcos de Guerra (excepto Submarinos).;Este edificio no afecta a los costes de la donaciones a las Maravillas en la Isla.'
    );
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `edificionivel`
--
CREATE TABLE IF NOT EXISTS `edificionivel` (
    `codigoedifnivel` int (11) NOT NULL AUTO_INCREMENT,
    `codigoedificio` int (11) NOT NULL,
    `nivel` tinyint (3) unsigned NOT NULL,
    PRIMARY KEY (`codigoedifnivel`),
    UNIQUE KEY `codigoedificio` (`codigoedificio`, `nivel`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 412;
--
-- Volcado de datos para la tabla `edificionivel`
--
INSERT INTO `edificionivel` (
    `codigoedifnivel`, `codigoedificio`,
    `nivel`
)
VALUES
    (11, 1, 1),
    (12, 1, 2),
    (13, 1, 3),
    (14, 1, 4),
    (15, 1, 5),
    (197, 1, 6),
    (198, 1, 7),
    (199, 1, 8),
    (200, 1, 9),
    (201, 1, 10),
    (202, 1, 11),
    (203, 1, 12),
    (204, 1, 13),
    (205, 1, 14),
    (206, 1, 15),
    (207, 1, 16),
    (208, 1, 17),
    (209, 1, 18),
    (210, 1, 19),
    (211, 1, 20),
    (16, 2, 1),
    (17, 2, 2),
    (18, 2, 3),
    (19, 2, 4),
    (20, 2, 5),
    (71, 2, 6),
    (72, 2, 7),
    (73, 2, 8),
    (74, 2, 9),
    (75, 2, 10),
    (76, 2, 11),
    (77, 2, 12),
    (78, 2, 13),
    (79, 2, 14),
    (80, 2, 15),
    (81, 2, 16),
    (82, 2, 17),
    (83, 2, 18),
    (84, 2, 19),
    (85, 2, 20),
    (21, 3, 1),
    (22, 3, 2),
    (23, 3, 3),
    (24, 3, 4),
    (25, 3, 5),
    (86, 3, 6),
    (87, 3, 7),
    (88, 3, 8),
    (89, 3, 9),
    (90, 3, 10),
    (91, 3, 11),
    (92, 3, 12),
    (93, 3, 13),
    (94, 3, 14),
    (95, 3, 15),
    (96, 3, 16),
    (97, 3, 17),
    (98, 3, 18),
    (99, 3, 19),
    (100, 3, 20),
    (26, 4, 1),
    (27, 4, 2),
    (28, 4, 3),
    (29, 4, 4),
    (30, 4, 5),
    (101, 4, 6),
    (102, 4, 7),
    (103, 4, 8),
    (104, 4, 9),
    (105, 4, 10),
    (106, 4, 11),
    (107, 4, 12),
    (108, 4, 13),
    (109, 4, 14),
    (110, 4, 15),
    (111, 4, 16),
    (112, 4, 17),
    (113, 4, 18),
    (114, 4, 19),
    (115, 4, 20),
    (31, 5, 1),
    (32, 5, 2),
    (33, 5, 3),
    (34, 5, 4),
    (35, 5, 5),
    (116, 5, 6),
    (117, 5, 7),
    (118, 5, 8),
    (119, 5, 9),
    (120, 5, 10),
    (121, 5, 11),
    (122, 5, 12),
    (123, 5, 13),
    (124, 5, 14),
    (125, 5, 15),
    (126, 5, 16),
    (127, 5, 17),
    (128, 5, 18),
    (129, 5, 19),
    (130, 5, 20),
    (36, 6, 1),
    (37, 6, 2),
    (38, 6, 3),
    (39, 6, 4),
    (40, 6, 5),
    (131, 6, 6),
    (132, 6, 7),
    (133, 6, 8),
    (134, 6, 9),
    (135, 6, 10),
    (136, 6, 11),
    (137, 6, 12),
    (138, 6, 13),
    (139, 6, 14),
    (140, 6, 15),
    (141, 6, 16),
    (142, 6, 17),
    (143, 6, 18),
    (144, 6, 19),
    (145, 6, 20),
    (41, 7, 1),
    (42, 7, 2),
    (43, 7, 3),
    (44, 7, 4),
    (45, 7, 5),
    (46, 8, 1),
    (47, 8, 2),
    (48, 8, 3),
    (49, 8, 4),
    (50, 8, 5),
    (146, 8, 6),
    (147, 8, 7),
    (148, 8, 8),
    (149, 8, 9),
    (150, 8, 10),
    (151, 8, 11),
    (152, 8, 12),
    (153, 8, 13),
    (154, 8, 14),
    (155, 8, 15),
    (156, 8, 16),
    (157, 8, 17),
    (158, 8, 18),
    (159, 8, 19),
    (160, 8, 20),
    (51, 9, 1),
    (52, 9, 2),
    (53, 9, 3),
    (54, 9, 4),
    (55, 9, 5),
    (161, 9, 6),
    (162, 9, 7),
    (163, 9, 8),
    (164, 9, 9),
    (165, 9, 10),
    (166, 9, 11),
    (167, 9, 12),
    (168, 9, 13),
    (169, 9, 14),
    (170, 9, 15),
    (171, 9, 16),
    (172, 9, 17),
    (173, 9, 18),
    (174, 9, 19),
    (175, 9, 20),
    (56, 10, 1),
    (57, 10, 2),
    (58, 10, 3),
    (59, 10, 4),
    (60, 10, 5),
    (176, 10, 6),
    (177, 10, 7),
    (178, 10, 8),
    (61, 11, 1),
    (62, 11, 2),
    (63, 11, 3),
    (64, 11, 4),
    (65, 11, 5),
    (179, 11, 6),
    (180, 11, 7),
    (181, 11, 8),
    (182, 11, 9),
    (183, 11, 10),
    (184, 11, 11),
    (185, 11, 12),
    (186, 11, 13),
    (187, 11, 14),
    (188, 11, 15),
    (189, 11, 16),
    (190, 11, 17),
    (191, 11, 18),
    (192, 11, 19),
    (193, 11, 20),
    (66, 12, 1),
    (67, 12, 2),
    (68, 12, 3),
    (69, 12, 4),
    (70, 12, 5),
    (194, 12, 6),
    (195, 12, 7),
    (196, 12, 8),
    (392, 23, 1),
    (393, 23, 2),
    (394, 23, 3),
    (395, 23, 4),
    (396, 23, 5),
    (397, 23, 6),
    (398, 23, 7),
    (399, 23, 8),
    (400, 23, 9),
    (401, 23, 10),
    (402, 23, 11),
    (403, 23, 12),
    (404, 23, 13),
    (405, 23, 14),
    (406, 23, 15),
    (407, 23, 16),
    (408, 23, 17),
    (409, 23, 18),
    (410, 23, 19),
    (411, 23, 20),
    (212, 24, 1),
    (213, 24, 2),
    (214, 24, 3),
    (215, 24, 4),
    (216, 24, 5),
    (217, 24, 6),
    (218, 24, 7),
    (219, 24, 8),
    (220, 24, 9),
    (221, 24, 10),
    (222, 24, 11),
    (223, 24, 12),
    (224, 24, 13),
    (225, 24, 14),
    (226, 24, 15),
    (227, 24, 16),
    (228, 24, 17),
    (229, 24, 18),
    (230, 24, 19),
    (231, 24, 20),
    (232, 25, 1),
    (233, 25, 2),
    (234, 25, 3),
    (235, 25, 4),
    (236, 25, 5),
    (237, 25, 6),
    (238, 25, 7),
    (239, 25, 8),
    (240, 25, 9),
    (241, 25, 10),
    (242, 25, 11),
    (243, 25, 12),
    (244, 25, 13),
    (245, 25, 14),
    (246, 25, 15),
    (247, 25, 16),
    (248, 25, 17),
    (249, 25, 18),
    (250, 25, 19),
    (251, 25, 20),
    (252, 26, 1),
    (253, 26, 2),
    (254, 26, 3),
    (255, 26, 4),
    (256, 26, 5),
    (257, 26, 6),
    (258, 26, 7),
    (259, 26, 8),
    (260, 26, 9),
    (261, 26, 10),
    (262, 26, 11),
    (263, 26, 12),
    (264, 26, 13),
    (265, 26, 14),
    (266, 26, 15),
    (267, 26, 16),
    (268, 26, 17),
    (269, 26, 18),
    (270, 26, 19),
    (271, 26, 20),
    (272, 27, 1),
    (273, 27, 2),
    (274, 27, 3),
    (275, 27, 4),
    (276, 27, 5),
    (277, 27, 6),
    (278, 27, 7),
    (279, 27, 8),
    (280, 27, 9),
    (281, 27, 10),
    (282, 27, 11),
    (283, 27, 12),
    (284, 27, 13),
    (285, 27, 14),
    (286, 27, 15),
    (287, 27, 16),
    (288, 27, 17),
    (289, 27, 18),
    (290, 27, 19),
    (291, 27, 20),
    (292, 28, 1),
    (293, 28, 2),
    (294, 28, 3),
    (295, 28, 4),
    (296, 28, 5),
    (297, 28, 6),
    (298, 28, 7),
    (299, 28, 8),
    (300, 28, 9),
    (301, 28, 10),
    (302, 28, 11),
    (303, 28, 12),
    (304, 28, 13),
    (305, 28, 14),
    (306, 28, 15),
    (307, 28, 16),
    (308, 28, 17),
    (309, 28, 18),
    (310, 28, 19),
    (311, 28, 20),
    (312, 29, 1),
    (313, 29, 2),
    (314, 29, 3),
    (315, 29, 4),
    (316, 29, 5),
    (317, 29, 6),
    (318, 29, 7),
    (319, 29, 8),
    (320, 29, 9),
    (321, 29, 10),
    (322, 29, 11),
    (323, 29, 12),
    (324, 29, 13),
    (325, 29, 14),
    (326, 29, 15),
    (327, 29, 16),
    (328, 29, 17),
    (329, 29, 18),
    (330, 29, 19),
    (331, 29, 20),
    (332, 30, 1),
    (333, 30, 2),
    (334, 30, 3),
    (335, 30, 4),
    (336, 30, 5),
    (337, 30, 6),
    (338, 30, 7),
    (339, 30, 8),
    (340, 30, 9),
    (341, 30, 10),
    (342, 30, 11),
    (343, 30, 12),
    (344, 30, 13),
    (345, 30, 14),
    (346, 30, 15),
    (347, 30, 16),
    (348, 30, 17),
    (349, 30, 18),
    (350, 30, 19),
    (351, 30, 20),
    (352, 31, 1),
    (353, 31, 2),
    (354, 31, 3),
    (355, 31, 4),
    (356, 31, 5),
    (357, 31, 6),
    (358, 31, 7),
    (359, 31, 8),
    (360, 31, 9),
    (361, 31, 10),
    (362, 31, 11),
    (363, 31, 12),
    (364, 31, 13),
    (365, 31, 14),
    (366, 31, 15),
    (367, 31, 16),
    (368, 31, 17),
    (369, 31, 18),
    (370, 31, 19),
    (371, 31, 20),
    (372, 32, 1),
    (373, 32, 2),
    (374, 32, 3),
    (375, 32, 4),
    (376, 32, 5),
    (377, 32, 6),
    (378, 32, 7),
    (379, 32, 8),
    (380, 32, 9),
    (381, 32, 10),
    (382, 32, 11),
    (383, 32, 12),
    (384, 32, 13),
    (385, 32, 14),
    (386, 32, 15),
    (387, 32, 16),
    (388, 32, 17),
    (389, 32, 18),
    (390, 32, 19),
    (391, 32, 20);
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `edificiorecurso`
--
CREATE TABLE IF NOT EXISTS `edificiorecurso` (
    `codigoedifnivel` int (11) NOT NULL DEFAULT '0',
    `codigorecurso` tinyint (3) unsigned NOT NULL DEFAULT '0',
    `cantidadrecurso` int (11) NOT NULL,
    PRIMARY KEY (
                    `codigoedifnivel`, `codigorecurso`
                ),
    KEY `codigorecurso` (`codigorecurso`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
--
-- Volcado de datos para la tabla `edificiorecurso`
--
INSERT INTO `edificiorecurso` (
    `codigoedifnivel`, `codigorecurso`,
    `cantidadrecurso`
)
VALUES
    (11, 6, 101),
    (12, 6, 222),
    (13, 6, 367),
    (14, 6, 541),
    (14, 15, 94),
    (15, 6, 750),
    (15, 15, 122),
    (16, 6, 64),
    (17, 6, 68),
    (18, 6, 115),
    (19, 6, 263),
    (20, 6, 382),
    (20, 9, 225),
    (21, 6, 640),
    (21, 9, 384),
    (21, 12, 701),
    (21, 15, 497),
    (22, 6, 1152),
    (22, 9, 845),
    (22, 12, 1146),
    (22, 15, 932),
    (23, 6, 1766),
    (23, 9, 1398),
    (23, 12, 1668),
    (23, 15, 1445),
    (24, 6, 2504),
    (24, 9, 2061),
    (24, 12, 2278),
    (24, 15, 2051),
    (25, 6, 3388),
    (25, 9, 2858),
    (25, 12, 2991),
    (25, 15, 2762),
    (26, 6, 105),
    (27, 6, 202),
    (28, 6, 324),
    (29, 6, 477),
    (30, 6, 671),
    (31, 6, 49),
    (32, 6, 114),
    (33, 6, 195),
    (34, 6, 296),
    (35, 6, 420),
    (36, 6, 160),
    (37, 6, 288),
    (38, 6, 442),
    (39, 6, 626),
    (39, 15, 96),
    (40, 6, 847),
    (40, 15, 211),
    (47, 6, 158),
    (48, 6, 335),
    (49, 6, 623),
    (50, 6, 923),
    (50, 15, 285),
    (51, 6, 48),
    (52, 6, 173),
    (53, 6, 346),
    (54, 6, 581),
    (55, 6, 896),
    (55, 15, 540),
    (56, 6, 712),
    (57, 6, 5823),
    (57, 15, 1433),
    (58, 6, 16048),
    (58, 9, 3088),
    (58, 15, 4546),
    (59, 6, 36496),
    (59, 9, 10300),
    (59, 15, 10770),
    (60, 6, 77392),
    (60, 9, 24725),
    (60, 12, 21188),
    (60, 15, 23218),
    (61, 6, 60),
    (62, 6, 150),
    (63, 6, 274),
    (64, 6, 429),
    (65, 6, 637),
    (66, 6, 712),
    (67, 6, 5823),
    (67, 15, 1433),
    (68, 6, 16048),
    (68, 9, 3088),
    (68, 15, 4546),
    (69, 6, 36496),
    (69, 9, 10300),
    (69, 15, 10770),
    (70, 6, 77392),
    (70, 9, 24725),
    (70, 12, 21188),
    (70, 15, 23218),
    (71, 6, 573),
    (71, 12, 337),
    (72, 6, 859),
    (72, 12, 505),
    (73, 6, 1288),
    (73, 12, 757),
    (74, 6, 1932),
    (74, 12, 1135),
    (75, 6, 2898),
    (75, 12, 1702),
    (76, 6, 4347),
    (76, 12, 2553),
    (77, 6, 6520),
    (77, 12, 3829),
    (78, 6, 9780),
    (78, 12, 5743),
    (79, 6, 14670),
    (79, 12, 8614),
    (80, 6, 22005),
    (80, 12, 12921),
    (81, 6, 33007),
    (81, 12, 19381),
    (82, 6, 49510),
    (82, 12, 29071),
    (83, 6, 74265),
    (83, 12, 43606),
    (84, 6, 111397),
    (84, 12, 65409),
    (85, 6, 167095),
    (85, 12, 98113),
    (86, 6, 4517),
    (86, 9, 3810),
    (86, 12, 3988),
    (86, 15, 3682),
    (87, 6, 6022),
    (87, 9, 5080),
    (87, 12, 5317),
    (87, 15, 4909),
    (88, 6, 8029),
    (88, 9, 6773),
    (88, 12, 7089),
    (88, 15, 6545),
    (89, 6, 10705),
    (89, 9, 9030),
    (89, 12, 9452),
    (89, 15, 8726),
    (90, 6, 14273),
    (90, 9, 12040),
    (90, 12, 12602),
    (90, 15, 11634),
    (91, 6, 19030),
    (91, 9, 16053),
    (91, 12, 16802),
    (91, 15, 15512),
    (92, 6, 25373),
    (92, 9, 21404),
    (92, 12, 22402),
    (92, 15, 20682),
    (93, 6, 33830),
    (93, 9, 28538),
    (93, 12, 29869),
    (93, 15, 27576),
    (94, 6, 45106),
    (94, 9, 38050),
    (94, 12, 39825),
    (94, 15, 36768),
    (95, 6, 60141),
    (95, 9, 50733),
    (95, 12, 53100),
    (95, 15, 49024),
    (96, 6, 80188),
    (96, 9, 67644),
    (96, 12, 70800),
    (96, 15, 65365),
    (97, 6, 106917),
    (97, 9, 90192),
    (97, 12, 94400),
    (97, 15, 87153),
    (98, 6, 142556),
    (98, 9, 120256),
    (98, 12, 125866),
    (98, 15, 116204),
    (99, 6, 190074),
    (99, 9, 160341),
    (99, 12, 167821),
    (99, 15, 154938),
    (100, 6, 253432),
    (100, 9, 213788),
    (100, 12, 223761),
    (100, 15, 206584),
    (101, 6, 894),
    (102, 6, 1192),
    (103, 6, 1589),
    (104, 6, 2118),
    (105, 6, 2824),
    (106, 6, 3765),
    (107, 6, 5020),
    (108, 6, 6693),
    (109, 6, 8924),
    (110, 6, 11898),
    (111, 6, 15864),
    (112, 6, 21152),
    (113, 6, 28202),
    (114, 6, 37602),
    (115, 6, 50136),
    (116, 6, 560),
    (117, 6, 746),
    (118, 6, 994),
    (119, 6, 1325),
    (120, 6, 1766),
    (121, 6, 2354),
    (122, 6, 3138),
    (123, 6, 4184),
    (124, 6, 5578),
    (125, 6, 7437),
    (126, 6, 9916),
    (127, 6, 13221),
    (128, 6, 17628),
    (129, 6, 23504),
    (130, 6, 31338),
    (131, 6, 1129),
    (131, 15, 281),
    (132, 6, 1505),
    (132, 15, 374),
    (133, 6, 2006),
    (133, 15, 498),
    (134, 6, 2674),
    (134, 15, 664),
    (135, 6, 3565),
    (135, 15, 885),
    (136, 6, 4753),
    (136, 15, 1180),
    (137, 6, 6337),
    (137, 15, 1573),
    (138, 6, 8449),
    (138, 15, 2097),
    (139, 6, 11265),
    (139, 15, 2796),
    (140, 6, 15020),
    (140, 15, 3728),
    (141, 6, 20026),
    (141, 15, 4970),
    (142, 6, 26701),
    (142, 15, 6626),
    (143, 6, 35601),
    (143, 15, 8834),
    (144, 6, 47468),
    (144, 15, 11778),
    (145, 6, 63290),
    (145, 15, 15704),
    (146, 6, 1230),
    (146, 15, 380),
    (147, 6, 1640),
    (147, 15, 506),
    (148, 6, 2186),
    (148, 15, 674),
    (149, 6, 2914),
    (149, 15, 898),
    (150, 6, 3885),
    (150, 15, 1197),
    (151, 6, 5180),
    (151, 15, 1596),
    (152, 6, 6906),
    (152, 15, 2128),
    (153, 6, 9208),
    (153, 15, 2837),
    (154, 6, 12277),
    (154, 15, 3782),
    (155, 6, 16369),
    (155, 15, 5042),
    (156, 6, 21825),
    (156, 15, 6722),
    (157, 6, 29100),
    (157, 15, 8962),
    (158, 6, 38800),
    (158, 15, 11949),
    (159, 6, 51733),
    (159, 15, 15932),
    (160, 6, 68977),
    (160, 15, 21242),
    (161, 6, 1194),
    (161, 15, 720),
    (162, 6, 1592),
    (162, 15, 960),
    (163, 6, 2122),
    (163, 15, 1280),
    (164, 6, 2829),
    (164, 15, 1706),
    (165, 6, 3772),
    (165, 15, 2274),
    (166, 6, 5029),
    (166, 15, 3032),
    (167, 6, 6705),
    (167, 15, 4042),
    (168, 6, 8940),
    (168, 15, 5389),
    (169, 6, 11920),
    (169, 15, 7185),
    (170, 6, 15893),
    (170, 15, 9580),
    (171, 6, 21190),
    (171, 15, 12773),
    (172, 6, 28253),
    (172, 15, 17030),
    (173, 6, 37670),
    (173, 15, 22706),
    (174, 6, 50226),
    (174, 15, 30274),
    (175, 6, 66968),
    (175, 15, 40365),
    (176, 6, 103189),
    (176, 9, 32966),
    (176, 12, 28250),
    (176, 15, 30957),
    (177, 6, 137585),
    (177, 9, 43954),
    (177, 12, 37666),
    (177, 14, 10898),
    (177, 15, 41276),
    (178, 6, 183446),
    (178, 9, 58605),
    (178, 12, 50221),
    (178, 14, 22110),
    (178, 15, 55034),
    (179, 6, 849),
    (180, 6, 1132),
    (181, 6, 1509),
    (182, 6, 2012),
    (183, 6, 2682),
    (184, 6, 3576),
    (185, 6, 4768),
    (186, 6, 6357),
    (187, 6, 8476),
    (188, 6, 11301),
    (189, 6, 15068),
    (190, 6, 20090),
    (191, 6, 26786),
    (192, 6, 35714),
    (193, 6, 47618),
    (194, 6, 103189),
    (194, 9, 32966),
    (194, 12, 28250),
    (194, 15, 30957),
    (195, 6, 137585),
    (195, 9, 43954),
    (195, 12, 37666),
    (195, 14, 10898),
    (195, 15, 41276),
    (196, 6, 183446),
    (196, 9, 58605),
    (196, 12, 50221),
    (196, 14, 22110),
    (196, 15, 55034),
    (197, 6, 1000),
    (197, 15, 162),
    (198, 6, 1333),
    (198, 15, 216),
    (199, 6, 1777),
    (199, 15, 288),
    (200, 6, 2369),
    (200, 15, 384),
    (201, 6, 3158),
    (201, 15, 512),
    (202, 6, 4210),
    (202, 15, 682),
    (203, 6, 5613),
    (203, 15, 909),
    (204, 6, 7484),
    (204, 15, 1212),
    (205, 6, 9978),
    (205, 15, 1616),
    (206, 6, 13304),
    (206, 15, 2154),
    (207, 6, 17738),
    (207, 15, 2872),
    (208, 6, 23650),
    (208, 15, 3829),
    (209, 6, 31533),
    (209, 15, 5105),
    (210, 6, 42044),
    (210, 15, 6806),
    (211, 6, 56058),
    (211, 15, 9074),
    (212, 6, 274),
    (212, 14, 274),
    (212, 15, 0),
    (213, 6, 467),
    (213, 14, 467),
    (213, 15, 116),
    (214, 6, 718),
    (214, 14, 718),
    (214, 15, 255),
    (215, 6, 1045),
    (215, 14, 1045),
    (215, 15, 436),
    (216, 6, 1469),
    (216, 14, 1469),
    (216, 15, 671),
    (217, 6, 2203),
    (217, 14, 2203),
    (217, 15, 1006),
    (218, 6, 3304),
    (218, 14, 3304),
    (218, 15, 1509),
    (219, 6, 4956),
    (219, 14, 4956),
    (219, 15, 2263),
    (220, 6, 7434),
    (220, 14, 7434),
    (220, 15, 3394),
    (221, 6, 11151),
    (221, 14, 11151),
    (221, 15, 5091),
    (222, 6, 16726),
    (222, 14, 16726),
    (222, 15, 7636),
    (223, 6, 25089),
    (223, 14, 25089),
    (223, 15, 11454),
    (224, 6, 37633),
    (224, 14, 37633),
    (224, 15, 17181),
    (225, 6, 56449),
    (225, 14, 56449),
    (225, 15, 25771),
    (226, 6, 84673),
    (226, 14, 84673),
    (226, 15, 38656),
    (227, 6, 127009),
    (227, 14, 127009),
    (227, 15, 57984),
    (228, 6, 190513),
    (228, 14, 190513),
    (228, 15, 86976),
    (229, 6, 285769),
    (229, 14, 285769),
    (229, 15, 130464),
    (230, 6, 428653),
    (230, 14, 428653),
    (230, 15, 195696),
    (231, 6, 642979),
    (231, 14, 642979),
    (231, 15, 293544),
    (232, 6, 274),
    (232, 15, 0),
    (233, 6, 467),
    (233, 15, 116),
    (234, 6, 718),
    (234, 15, 255),
    (235, 6, 1045),
    (235, 15, 436),
    (236, 6, 1469),
    (236, 15, 671),
    (237, 6, 2203),
    (237, 15, 1006),
    (238, 6, 3304),
    (238, 15, 1509),
    (239, 6, 4956),
    (239, 15, 2263),
    (240, 6, 7434),
    (240, 15, 3394),
    (241, 6, 11151),
    (241, 15, 5091),
    (242, 6, 16726),
    (242, 15, 7636),
    (243, 6, 25089),
    (243, 15, 11454),
    (244, 6, 37633),
    (244, 15, 17181),
    (245, 6, 56449),
    (245, 15, 25771),
    (246, 6, 84673),
    (246, 15, 38656),
    (247, 6, 127009),
    (247, 15, 57984),
    (248, 6, 190513),
    (248, 15, 86976),
    (249, 6, 285769),
    (249, 15, 130464),
    (250, 6, 428653),
    (250, 15, 195696),
    (251, 6, 642979),
    (251, 15, 293544),
    (252, 6, 274),
    (252, 15, 0),
    (253, 6, 467),
    (253, 15, 116),
    (254, 6, 718),
    (254, 15, 255),
    (255, 6, 1045),
    (255, 15, 436),
    (256, 6, 1469),
    (256, 15, 671),
    (257, 6, 2203),
    (257, 15, 1006),
    (258, 6, 3304),
    (258, 15, 1509),
    (259, 6, 4956),
    (259, 15, 2263),
    (260, 6, 7434),
    (260, 15, 3394),
    (261, 6, 11151),
    (261, 15, 5091),
    (262, 6, 16726),
    (262, 15, 7636),
    (263, 6, 25089),
    (263, 15, 11454),
    (264, 6, 37633),
    (264, 15, 17181),
    (265, 6, 56449),
    (265, 15, 25771),
    (266, 6, 84673),
    (266, 15, 38656),
    (267, 6, 127009),
    (267, 15, 57984),
    (268, 6, 190513),
    (268, 15, 86976),
    (269, 6, 285769),
    (269, 15, 130464),
    (270, 6, 428653),
    (270, 15, 195696),
    (271, 6, 642979),
    (271, 15, 293544),
    (272, 6, 274),
    (272, 15, 0),
    (273, 6, 467),
    (273, 15, 116),
    (274, 6, 718),
    (274, 15, 255),
    (275, 6, 1045),
    (275, 15, 436),
    (276, 6, 1469),
    (276, 15, 671),
    (277, 6, 2203),
    (277, 15, 1006),
    (278, 6, 3304),
    (278, 15, 1509),
    (279, 6, 4956),
    (279, 15, 2263),
    (280, 6, 7434),
    (280, 15, 3394),
    (281, 6, 11151),
    (281, 15, 5091),
    (282, 6, 16726),
    (282, 15, 7636),
    (283, 6, 25089),
    (283, 15, 11454),
    (284, 6, 37633),
    (284, 15, 17181),
    (285, 6, 56449),
    (285, 15, 25771),
    (286, 6, 84673),
    (286, 15, 38656),
    (287, 6, 127009),
    (287, 15, 57984),
    (288, 6, 190513),
    (288, 15, 86976),
    (289, 6, 285769),
    (289, 15, 130464),
    (290, 6, 428653),
    (290, 15, 195696),
    (291, 6, 642979),
    (291, 15, 293544),
    (292, 6, 63),
    (292, 15, 0),
    (293, 6, 121),
    (293, 15, 0),
    (294, 6, 187),
    (294, 15, 0),
    (295, 6, 266),
    (295, 15, 0),
    (296, 6, 357),
    (296, 15, 0),
    (297, 6, 535),
    (297, 15, 0),
    (298, 6, 802),
    (298, 15, 0),
    (299, 6, 1203),
    (299, 15, 0),
    (300, 6, 1804),
    (300, 15, 0),
    (301, 6, 2706),
    (301, 15, 0),
    (302, 6, 4059),
    (302, 15, 0),
    (303, 6, 6088),
    (303, 15, 0),
    (304, 6, 9132),
    (304, 15, 0),
    (305, 6, 13698),
    (305, 15, 0),
    (306, 6, 20547),
    (306, 15, 0),
    (307, 6, 30820),
    (307, 15, 0),
    (308, 6, 46230),
    (308, 15, 0),
    (309, 6, 69345),
    (309, 15, 0),
    (310, 6, 104017),
    (310, 15, 0),
    (311, 6, 156025),
    (311, 15, 0),
    (312, 6, 339),
    (312, 15, 123),
    (313, 6, 423),
    (313, 15, 198),
    (314, 6, 520),
    (314, 15, 285),
    (315, 6, 631),
    (315, 15, 387),
    (316, 6, 758),
    (316, 15, 504),
    (317, 6, 1137),
    (317, 15, 756),
    (318, 6, 1705),
    (318, 15, 1134),
    (319, 6, 2557),
    (319, 15, 1701),
    (320, 6, 3835),
    (320, 15, 2551),
    (321, 6, 5752),
    (321, 15, 3826),
    (322, 6, 8628),
    (322, 15, 5739),
    (323, 6, 12942),
    (323, 15, 8608),
    (324, 6, 19413),
    (324, 15, 12912),
    (325, 6, 29119),
    (325, 15, 19368),
    (326, 6, 43678),
    (326, 15, 29052),
    (327, 6, 65517),
    (327, 15, 43578),
    (328, 6, 98275),
    (328, 15, 65367),
    (329, 6, 147412),
    (329, 15, 98050),
    (330, 6, 221118),
    (330, 15, 147075),
    (331, 6, 331677),
    (331, 15, 220612),
    (332, 6, 185),
    (332, 15, 106),
    (333, 6, 291),
    (333, 15, 158),
    (334, 6, 413),
    (334, 15, 218),
    (335, 6, 555),
    (335, 15, 286),
    (336, 6, 720),
    (336, 15, 364),
    (337, 6, 1080),
    (337, 15, 546),
    (338, 6, 1620),
    (338, 15, 819),
    (339, 6, 2430),
    (339, 15, 1228),
    (340, 6, 3645),
    (340, 15, 1842),
    (341, 6, 5467),
    (341, 15, 2763),
    (342, 6, 8200),
    (342, 15, 4144),
    (343, 6, 12300),
    (343, 15, 6216),
    (344, 6, 18450),
    (344, 15, 9324),
    (345, 6, 27675),
    (345, 15, 13986),
    (346, 6, 41512),
    (346, 15, 20979),
    (347, 6, 62268),
    (347, 15, 31468),
    (348, 6, 93402),
    (348, 15, 47202),
    (349, 6, 140103),
    (349, 15, 70803),
    (350, 6, 210154),
    (350, 15, 106204),
    (351, 6, 315231),
    (351, 15, 159306),
    (352, 6, 119),
    (352, 15, 0),
    (353, 6, 188),
    (353, 15, 35),
    (354, 6, 269),
    (354, 15, 96),
    (355, 6, 362),
    (355, 15, 167),
    (356, 6, 471),
    (356, 15, 249),
    (357, 6, 706),
    (357, 15, 373),
    (358, 6, 1059),
    (358, 15, 559),
    (359, 6, 1588),
    (359, 15, 838),
    (360, 6, 2382),
    (360, 15, 1257),
    (361, 6, 3573),
    (361, 15, 1885),
    (362, 6, 5359),
    (362, 15, 2827),
    (363, 6, 8038),
    (363, 15, 4240),
    (364, 6, 12057),
    (364, 15, 6360),
    (365, 6, 18085),
    (365, 15, 9540),
    (366, 6, 27127),
    (366, 15, 14310),
    (367, 6, 40690),
    (367, 15, 21465),
    (368, 6, 61035),
    (368, 15, 32197),
    (369, 6, 91552),
    (369, 15, 48295),
    (370, 6, 137328),
    (370, 15, 72442),
    (371, 6, 205992),
    (371, 15, 108663),
    (372, 6, 272),
    (372, 15, 135),
    (373, 6, 353),
    (373, 15, 212),
    (374, 6, 445),
    (374, 15, 302),
    (375, 6, 551),
    (375, 15, 405),
    (376, 6, 673),
    (376, 15, 526),
    (377, 6, 1009),
    (377, 15, 789),
    (378, 6, 1513),
    (378, 15, 1183),
    (379, 6, 2269),
    (379, 15, 1774),
    (380, 6, 3403),
    (380, 15, 2661),
    (381, 6, 5104),
    (381, 15, 3991),
    (382, 6, 7656),
    (382, 15, 5986),
    (383, 6, 11484),
    (383, 15, 8979),
    (384, 6, 17226),
    (384, 15, 13468),
    (385, 6, 25839),
    (385, 15, 20202),
    (386, 6, 38758),
    (386, 15, 30303),
    (387, 6, 58137),
    (387, 15, 45454),
    (388, 6, 87205),
    (388, 15, 68181),
    (389, 6, 130807),
    (389, 15, 102271),
    (390, 6, 196210),
    (390, 15, 153406),
    (391, 6, 294315),
    (391, 15, 230109),
    (392, 6, 250),
    (392, 15, 0),
    (393, 6, 430),
    (393, 15, 104),
    (394, 6, 664),
    (394, 15, 237),
    (395, 6, 968),
    (395, 15, 410),
    (396, 6, 1364),
    (396, 15, 635),
    (397, 6, 2046),
    (397, 15, 952),
    (398, 6, 3069),
    (398, 15, 1428),
    (399, 6, 4603),
    (399, 15, 2142),
    (400, 6, 6904),
    (400, 15, 3213),
    (401, 6, 10356),
    (401, 15, 4819),
    (402, 6, 15534),
    (402, 15, 7228),
    (403, 6, 23301),
    (403, 15, 10842),
    (404, 6, 34951),
    (404, 15, 16263),
    (405, 6, 52426),
    (405, 15, 24394),
    (406, 6, 78639),
    (406, 15, 36591),
    (407, 6, 117958),
    (407, 15, 54886),
    (408, 6, 176937),
    (408, 15, 82329),
    (409, 6, 265405),
    (409, 15, 123493),
    (410, 6, 398107),
    (410, 15, 185239),
    (411, 6, 597160),
    (411, 15, 277858);
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `estadociudad`
--
CREATE TABLE IF NOT EXISTS `estadociudad` (
    `codigoestado` tinyint (3) unsigned NOT NULL AUTO_INCREMENT,
    `estado` varchar (30) DEFAULT NULL,
    PRIMARY KEY (`codigoestado`),
    UNIQUE KEY `estado` (`estado`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 2;
--
-- Volcado de datos para la tabla `estadociudad`
--
INSERT INTO `estadociudad` (`codigoestado`, `estado`)
VALUES
    (1, 'Normal');
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `guerra`
--
CREATE TABLE IF NOT EXISTS `guerra` (
    `codigoguerra` int (11) NOT NULL AUTO_INCREMENT,
    `guerraactiva` tinyint (1) NOT NULL DEFAULT '1',
    `fechainicio` date NOT NULL,
    `horainicio` time NOT NULL,
    `fechafin` date DEFAULT NULL,
    `horafin` time DEFAULT NULL,
    `bandoganador` int (11) DEFAULT NULL,
    PRIMARY KEY (`codigoguerra`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 9;

-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `guerraataque`
--
CREATE TABLE IF NOT EXISTS `guerraataque` (
    `codigoguerra` int (11) NOT NULL,
    `codigoataque` int (11) NOT NULL,
    PRIMARY KEY (`codigoguerra`, `codigoataque`),
    KEY `codigoataque` (`codigoataque`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `guerraparticipante`
--
CREATE TABLE IF NOT EXISTS `guerraparticipante` (
    `codigoguerra` int (11) NOT NULL,
    `codigojugador` int (11) NOT NULL,
    `puntaje` int (11) DEFAULT NULL,
    `activo` tinyint (1) NOT NULL DEFAULT '1',
    `bando` int (11) NOT NULL,
    PRIMARY KEY (`codigoguerra`, `codigojugador`),
    KEY `codigojugador` (`codigojugador`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
--
-- Volcado de datos para la tabla `guerraparticipante`
--

-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `habilitarmision`
--
CREATE TABLE IF NOT EXISTS `habilitarmision` (
    `codigoinvestigacion` int (11) NOT NULL DEFAULT '0',
    `codigomision` int (11) NOT NULL DEFAULT '0',
    PRIMARY KEY (
                    `codigoinvestigacion`, `codigomision`
                ),
    KEY `codigomision` (`codigomision`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `imagenes`
--
CREATE TABLE IF NOT EXISTS `imagenes` (
    `codigoimagen` int (11) NOT NULL AUTO_INCREMENT,
    `direccion` varchar (100) DEFAULT NULL,
    PRIMARY KEY (`codigoimagen`),
    UNIQUE KEY `direccion` (`direccion`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 129;
--
-- Volcado de datos para la tabla `imagenes`
--
INSERT INTO `imagenes` (`codigoimagen`, `direccion`)
VALUES
    (94, 'arcocompuesto'),
    (30, 'Ariete'),
    (96, 'arietecubierto'),
    (97, 'arietedeasedio'),
    (95, 'arietemedieval'),
    (39, 'Arquero'),
    (19, 'Azufre'),
    (99, 'ballesta'),
    (100, 'ballista'),
    (47, 'barcomercante'),
    (113, 'barrilexplosivo'),
    (112, 'bolasexplosivas'),
    (107, 'carabina'),
    (31, 'Catapulta'),
    (105, 'claymore'),
    (16, 'Cristal'),
    (115, 'daga'),
    (1, 'edificioacademia'),
    (2, 'edificioalmacen'),
    (93, 'edificioareapirotecnia'),
    (3, 'edificioastillerodeguerra'),
    (
        89, 'edificiocabañaguardabosque'
    ),
    (54, 'edificiocantero'),
    (58, 'edificiocarpinteria'),
    (4, 'edificiocuartel'),
    (5, 'edificiodeposito'),
    (6, 'edificioembajada'),
    (7, 'edificiointendencia'),
    (8, 'edificiomercado'),
    (
        60, 'edificiooficinadelarquitecto'
    ),
    (61, 'edificiooptico'),
    (9, 'edificiopalacio'),
    (59, 'edificioprensadevino'),
    (10, 'edificiopuerto'),
    (
        11, 'edificioresidenciadelgobernador'
    ),
    (55, 'edificiosopladordevidrio'),
    (12, 'edificiotaberna'),
    (
        56, 'edificiotorredelalquimista'
    ),
    (57, 'edificiovinicultor'),
    (108, 'escopeta'),
    (37, 'Espadachin'),
    (111, 'espadadeacero'),
    (109, 'espadadebronce'),
    (110, 'espadadehierro'),
    (28, 'Espartano'),
    (106, 'falcata'),
    (40, 'Fusilero'),
    (26, 'Gigante a Vapor'),
    (45, 'Girocoptero'),
    (104, 'gladius'),
    (46, 'Globo Bombardero'),
    (114, 'honda'),
    (29, 'Hondero'),
    (27, 'Hoplita'),
    (121, 'imagenciudad1'),
    (123, 'imagenciudad2'),
    (48, 'imagenciudad3'),
    (124, 'imagenciudad4'),
    (125, 'imagenciudad5'),
    (126, 'imagenciudad6'),
    (127, 'imagenciudad7'),
    (128, 'imagenciudad8'),
    (52, 'islavacia1'),
    (49, 'islavacia2'),
    (50, 'islavacia3'),
    (116, 'jabalina'),
    (38, 'Lancero'),
    (98, 'longbow'),
    (14, 'Madera'),
    (101, 'mangonel'),
    (21, 'Marmol'),
    (32, 'Mortero'),
    (120, 'mortero_1'),
    (102, 'petrary'),
    (118, 'pica'),
    (103, 'trebuchet'),
    (117, 'tridente'),
    (20, 'Vino');
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `investigacion`
--
CREATE TABLE IF NOT EXISTS `investigacion` (
    `codigoinvestigacion` int (11) NOT NULL AUTO_INCREMENT,
    `titulo` varchar (100) NOT NULL,
    `descripcion` text NOT NULL,
    `puntosinvestigacion` int (11) NOT NULL,
    `codigotema` int (11) NOT NULL,
    `Efecto` varchar (200) NOT NULL,
    `numeroorden` int (11) NOT NULL,
    `codigoinvestigacionanterior` int (11) NOT NULL,
    PRIMARY KEY (`codigoinvestigacion`),
    KEY `codigotema` (`codigotema`),
    KEY `titulo` (`titulo`, `codigotema`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 32;
--
-- Volcado de datos para la tabla `investigacion`
--
INSERT INTO `investigacion` (
    `codigoinvestigacion`, `titulo`,
    `descripcion`, `puntosinvestigacion`,
    `codigotema`, `Efecto`, `numeroorden`,
    `codigoinvestigacionanterior`
)
VALUES
    (
        1, 'Conservación', 'Hemos aprendido c?mo almacenar y proteger nuestros recursos y en el largo plazo. Tambión una parte de nuestros recursos está a salvo de piratas y otros villanos que quieren robar a nosotros!',
        12, 4, 'Permite la construcción de Naves',
        1, 0
    ),
    (
        2, 'Poleas', 'Una idea brillante: Una cuerda que se tira más de un rollo de un hombre sencillo da la fuerza de H?rcules. As? que ahora los trabajadores pueden levantar enormes bloques de piedra por su propia cuenta y construir nuestros edificios, incluso más rápido!',
        24, 4, '2% de disminución en los costos de la construcción',
        2, 0
    ),
    (
        3, 'La riqueza, el bien de excavación',
        'La tierra acuna preciados tesoros! ?Hemos aprendido a producir azufre, cristal y m?rmol - a cultivar la vid en nuestras f?rtiles colinas y producir delicioso vino! Gozaremos una nueva era de bienestar si sabemos utilizar estos recursos. En nuestras tiendas podremos vender los bienes generados y proveernos de cuanto recurso nos sea necesario. Efecto: Permite la explotación de materias primas y la construcción de tiendas',
        112, 4, 'Permite la extracción de productos del comercio y la construcción de puestos de comercio',
        3, 0
    ),
    (
        4, 'Viticultura', 'A las necesidades de la población felices fiestas en las que pueden pasar horas y deleitóndose potable nuestros fantésticos fluido vino. Dionisio le gusta vernos disfrutar de lo que ?l nos ha dado!',
        336, 4, 'Permite la creación de Tabernas',
        4, 0
    ),
    (
        5, 'Mejora de Recolección de Recursos',
        'Ha pasado algón tiempo desde que aprend? a usar los tesoros de nuestra isla para nuestras necesidades. Ahora debemos educar a nuestros trabajadores y dejar que cada bosque, cantera o vi?edo, cada hoyo de azufre o de administrar las minas de cristal por los hombres que no s?lo son fuertes, pero también h?bil. De esta manera vamos a reunir aón más los ingresos y nuestra civilización se hacen más ricos que nunca!',
        1204, 4, 'Permite la construcción de la casa forestal, Glassblower, Alquimista''s Tower, viticultor, y picapedrero.',
        5, 0
    ),
    (
        6, 'Geometría', 'Derecho óngulos, trióngulos, c?rculos - algunos brillantes mentes pueden calcular c?mo podemos construir nuestros edificios, incluso mejor y más hermoso. Nuestras ciudades, y pronto servir? como ejemplo para el mundo entero!',
        2236, 4, 'Disminución adicional del 4% en los costos de la construcción (6% del total)',
        6, 0
    ),
    (
        7, 'Arquitectura', 'Una buena casa pueden soportar los más duros elementos. Puede soportar aón mejor cuando una brillante mente se ocupa de ella con muchos dibujos y un poco de matem?ticas antes de mano, de modo que todas las paredes son rectas y el techo es apretado. Gracias a la br?jula y el óngulo de nuestros edificios ser? mucho más estable y bien protegido de la lluvia. Un arquitecto `s Mesa ahorrarnos mucho m?rmol, s?lo pensar en el ahorro de la construcción de un nuevo edificio! Permite: Construcción de oficinas de arquitecto `s',
        3672, 4, 'Permite edificio del arquitecto Oficina',
        7, 0
    ),
    (
        8, 'Disminución de costos', 'El agua es siempre todav?a. Debemos utilizar este conocimiento para que nuestros edificios cada vez, también! Nuestra ciudad ser? cada vez más hermosa y vamos a utilizar menos la piedra y la madera para la construcción de nuestros edificios!',
        25632, 4, 'Disminución adicional del 8% en los costos de la construcción (14% total)',
        8, 0
    ),
    (
        9, 'Bodegas', 'Qué un evento anual de las fiestas son el vino! Toda la ciudad está en sus pies cuando las mejores uvas están dando en vino y cuando el oro l?quido en torno a las salpicaduras, los ni?os tienen sus más divertido! Con un vino de prensa, sin embargo, a cargo de un experimentado en?logo, perderíamos mucho menos. El winemaster también podría ocuparse de un almacenamiento adecuado que nos permite dejar que el vino de la edad madura y bien!',
        48000, 4, 'Permite la construcción de Bodegas',
        9, 0
    ),
    (
        10, 'Futuro de la Economía', 'Nuestros ciudadanos viven en la riqueza y el mercado se extienda con las delicias de todo el mundo! Las calles están limpias y desarrollados, de esta manera el material de construcción que llega a la obra de construcción más rápido.',
        532800, 4, '10 y 20 de satisfacción ciudadana número máximo en cada ciudad. Multiplicado por el nivel de esta investigación.',
        10, 0
    ),
    (
        11, 'Astillero de Guerra', 'Una cuenca sobre el mar cuyo agua nos es posible drenar! ?Finalmente podemos construir barcos y hacerlos a la mar! ?Que maravilla, una flota de guerra tan poderosa que mostrar? a nuestros enemigos el significado del miedo!',
        24, 2, 'Permite la creación de los Astilleros.',
        1, 0
    ),
    (
        12, 'Cartografia', 'Las largas marchas por montañas y pantanos implican un gran desgaste de material. Si dibujamos los caminos más propicios por donde puedan pasar los soldados de forma de que no pierdan tiempo entre las malezas o se llenen de lodo, habremos de lavar menos sus uniformes. ',
        24, 2, '2% más bajo para el mantenimiento de unidades de tierra.',
        2, 0
    ),
    (
        13, 'Ejército Profesional', 'Con un ejercito profesional podemos defendernos mucho mejor de piratas, barbaros y demás villanos! Cuesta más dinero que cuando mandamos a nuestros ciudadanos a la guerra, pero nuestras tropas saben ahora manejar espadas, lanzas y escudos.',
        336, 2, 'Reclutar espadachines y Hoplitas en el cuartel.',
        3, 0
    ),
    (
        14, 'Asedio', 'Con un ariete de cabeza de metal y la fuerza de 10 hombres podemos incluso derrumbar muros de ciudad enteros. ?A nuestros soldados les ser? algo más f?cil conquistar todas las ciudades!',
        1032, 2, 'Construcción de arietes en el cuartel',
        4, 0
    ),
    (
        15, 'C?digo de Honor', 'Nuestros soldados se sienten orgullosos de servir a su unidad y a su imperio! Con sus nuevos uniformes son más cuidados, así que no los debemos zurcir o reparar tanto.',
        2236, 2, '4% menos de manutención',
        5, 0
    ),
    (
        16, 'Baléstica', 'Finalmente sabemos como hacer para disparar mejor la flechas sobre nuestro enemigo. Con estos conocimientos deberíamos empezar a instruir soldados en este arte. ?Pronto podremos enviar arqueros a la guerra!',
        3264, 2, 'Arqueros', 6, 0
    ),
    (
        17, 'Regla de la Palanca', 'Con esta t?cnica podemos desatar fuerzas incre?bles, incluso podemos arrojar enormes rocas por los aires! ?Si estas rocas son lo suficientemente grandes, podremos también derribar los muros de cualquier ciudad!',
        7020, 2, 'Construcción de catapultas en el cuartel',
        7, 0
    ),
    (
        18, 'Gobernador', 'Si empleamos un funcionario, podremos no solo saquear la ciudad enemiga, sino también utilizarla y gerenciarla. ?Pronto gozaremos del bienestar de otros y nuestras ciudades florecerón con sus recursos!',
        11592, 2, 'Ocupación', 8, 0
    ),
    (
        19, 'Astillero de Guerra', 'Una cuenca sobre el mar cuyo agua nos es posible drenar! ?Finalmente podemos construir barcos y hacerlos a la mar! ?Que maravilla, una flota de guerra tan poderosa que mostrar? a nuestros enemigos el significado del miedo!',
        24, 2, 'Permite la creación de los Astilleros.',
        1, 0
    ),
    (
        20, 'Cartograf?a', 'Las largas marchas por monta?as y pantanos implican un gran desgaste de material. Si dibujamos los caminos más propicios por donde puedan pasar los soldados de forma de que no pierdan tiempo entre las malezas o se llenen de lodo, habremos de lavar menos sus uniformes. ',
        24, 2, '2% más bajo para el mantenimiento de unidades de tierra.',
        2, 0
    ),
    (
        21, 'Ejército Profesional', 'Con un ejército profesional podemos defendernos mucho mejor de piratas, b?rbaros y demás villanos! Cuesta más dinero que cuando mandamos a nuestros ciudadanos a la guerra, pero nuestras tropas saben ahora manejar espadas, lanzas y escudos.',
        336, 2, 'Reclutar espadachines y Hoplitas en el cuartel.',
        3, 0
    ),
    (
        22, 'Asedio', 'Con un ariete de cabeza de metal y la fuerza de 10 hombres podemos incluso derrumbar muros de ciudad enteros. ?A nuestros soldados les ser? algo más f?cil conquistar todas las ciudades!',
        1032, 2, 'Construcción de arietes en el cuartel',
        4, 0
    ),
    (
        23, 'C?digo de Honor', 'Nuestros soldados se sienten orgullosos de servir a su unidad y a su imperio! Con sus nuevos uniformes son más cuidados, así que no los debemos zurcir o reparar tanto.',
        2236, 2, '4% menos de manutención',
        5, 0
    ),
    (
        24, 'Baléstica', 'Finalmente sabemos como hacer para disparar mejor la flechas sobre nuestro enemigo. Con estos conocimientos deberíamos empezar a instruir soldados en este arte. ?Pronto podremos enviar arqueros a la guerra!',
        3264, 2, 'Arqueros', 6, 0
    ),
    (
        25, 'Regla de la Palanca', 'Con esta t?cnica podemos desatar fuerzas incre?bles, incluso podemos arrojar enormes rocas por los aires! ?Si estas rocas son lo suficientemente grandes, podremos también derribar los muros de cualquier ciudad!',
        7020, 2, 'Construcción de catapultas en el cuartel',
        7, 0
    ),
    (
        26, 'Gobernador', 'Si empleamos un funcionario, podremos no solo saquear la ciudad enemiga, sino también utilizarla y gerenciarla. ?Pronto gozaremos del bienestar de otros y nuestras ciudades florecerón con sus recursos!',
        11592, 2, 'Ocupación', 8, 0
    ),
    (
        27, 'Pirotecnia', 'El azufre es una sustancia rarésima! Y con cada nueva mezcla que realizamos, logramos un impacto mayor de este precioso recurso. Un campo de pr?cticas seguro permitiría probar nuestras nuevas invenciones sin daños colaterales a los demás edificios. Con mejores p?lvora y explosivos ?ahorraremos muchésimas cantidades de azufre!',
        19908, 2, 'Construir Campo de Pr?cticas de Fuegos Artificiales',
        9, 0
    ),
    (
        28, 'Logéstica', 'Nuestros solados puede luchar mucho mejor si no tienen que andar acarreando tantos b?rtulos. Además los uniformes no se ven tan deteriorados después de largas marchas, con lo cual no deben de ser reparados tan a menudo.',
        25632, 2, '8% menos de manutención para soldados',
        10, 0
    ),
    (
        29, 'Pólvora', 'Esta mezcla negra creada en la cocina del alquimista puede, con un ruidoso estruendo, atizar fuego, lo que nos permite poner en marcha cosas realmente diab?licas! ?Ahora podemos cargar tubos de hierro con este polvo para disparar pesadas bolas por los aires!',
        38400, 2, 'Formar fusileros en el cuartel',
        11, 0
    ),
    (
        30, 'Rob?tica', 'Nuestros investigadores han construido un gigante mecónico, con másculos de metal y corazón de vapor! ?Solo los soldados más valientes y h?biles pueden controlar semejante monstruo, que atormentar? al enemigo a diestra y siniestra en el campo de batalla!',
        106560, 2, 'Construir gigantes a vapor en el cuartel',
        12, 0
    ),
    (
        31, 'Fundición de Ca?ones', 'Nuestro hierro es cada vez mas pesado y duro. ?Ahora nos es posible fabricar tubos por donde tirar bolas gigantes a nuestros enemigos! ?Si podemos disparar bombas de largo alcance, nuestros enemigos y sus muros temblarón del miedo!',
        209040, 2, 'Construcción de morteros en el cuartel',
        13, 0
    );
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `investigaciondescuentos`
--
CREATE TABLE IF NOT EXISTS `investigaciondescuentos` (
    `codigoinvestigacion` int (11) NOT NULL DEFAULT '0',
    `descripcion` varchar (50) NOT NULL,
    `descuento` int (11) DEFAULT NULL,
    PRIMARY KEY (`codigoinvestigacion`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `investigacionedificio`
--
CREATE TABLE IF NOT EXISTS `investigacionedificio` (
    `codigoinvestigacion` int (11) NOT NULL DEFAULT '0',
    `codigoedificio` int (11) NOT NULL,
    PRIMARY KEY (`codigoinvestigacion`),
    KEY `codigoedificio` (`codigoedificio`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `investigacionjugador`
--
CREATE TABLE IF NOT EXISTS `investigacionjugador` (
    `codigoinvestigacion` int (11) NOT NULL DEFAULT '0',
    `codigojugador` int (11) NOT NULL DEFAULT '0',
    PRIMARY KEY (
                    `codigoinvestigacion`, `codigojugador`
                ),
    KEY `codigojugador` (`codigojugador`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;

-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `investigacionopmilitar`
--
CREATE TABLE IF NOT EXISTS `investigacionopmilitar` (
    `codigoinvestigacion` int (11) NOT NULL DEFAULT '0',
    `codigoopmilitar` int (11) NOT NULL,
    PRIMARY KEY (`codigoinvestigacion`),
    KEY `codigoopmilitar` (`codigoopmilitar`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `investigacionunidad`
--
CREATE TABLE IF NOT EXISTS `investigacionunidad` (
    `codigoinvestigacion` int (11) NOT NULL DEFAULT '0',
    `codigounidad` int (11) NOT NULL,
    PRIMARY KEY (`codigoinvestigacion`),
    KEY `codigounidad` (`codigounidad`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `isla`
--
CREATE TABLE IF NOT EXISTS `isla` (
    `codigoisla` int (11) NOT NULL AUTO_INCREMENT,
    `nombre` varchar (25) NOT NULL,
    `coordenadax` int (2) DEFAULT NULL,
    `coordenaday` int (2) DEFAULT NULL,
    `codigoimagen` int (11) NOT NULL,
    `capacidadciudades` int (11) NOT NULL,
    `capacidaddisponible` int (11) NOT NULL,
    PRIMARY KEY (`codigoisla`),
    UNIQUE KEY `nombre` (`nombre`),
    KEY `codigoimagen` (`codigoimagen`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 59;
--
-- Volcado de datos para la tabla `isla`
--
INSERT INTO `isla` (
    `codigoisla`, `nombre`, `coordenadax`,
    `coordenaday`, `codigoimagen`, `capacidadciudades`,
    `capacidaddisponible`
)
VALUES
    (50, 'Ares', 11, 11, 49, 16, 5),
    (51, 'Enduos', 11, 22, 50, 15, 11),
    (52, 'Zeuz', 11, 33, 52, 14, 10),
    (53, 'Hades', 22, 11, 49, 16, 13),
    (54, 'Marte', 22, 22, 50, 15, 11),
    (55, 'Mercurio', 22, 33, 52, 14, 11),
    (56, 'Saturno', 33, 11, 49, 16, 12),
    (57, 'Urano', 33, 22, 50, 15, 13),
    (58, 'Neptuno', 33, 33, 52, 14, 9);
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `islarecurso`
--
CREATE TABLE IF NOT EXISTS `islarecurso` (
    `codigoisla` int (11) NOT NULL,
    `codigorecurso` tinyint (3) unsigned NOT NULL,
    PRIMARY KEY (`codigoisla`, `codigorecurso`),
    KEY `codigorecurso` (`codigorecurso`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
--
-- Volcado de datos para la tabla `islarecurso`
--
INSERT INTO `islarecurso` (`codigoisla`, `codigorecurso`)
VALUES
    (50, 9),
    (51, 9),
    (58, 9),
    (52, 12),
    (53, 12),
    (54, 12),
    (55, 14),
    (57, 14),
    (56, 15);
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `jugador`
--
CREATE TABLE IF NOT EXISTS `jugador` (
    `codigojugador` int (11) NOT NULL AUTO_INCREMENT,
    `nick` varchar (30) NOT NULL,
    `clave` varchar (10) NOT NULL,
    `oro` int (11) DEFAULT NULL,
    `fechaingreso` date NOT NULL,
    `horaingreso` time NOT NULL,
    `puntostotales` int (11) DEFAULT '0',
    `protegido` tinyint (1) NOT NULL DEFAULT '1',
    `vacaciones` tinyint (1) NOT NULL DEFAULT '0',
    `fechaactualizacionoro` datetime DEFAULT NULL,
    PRIMARY KEY (`codigojugador`),
    UNIQUE KEY `nick` (`nick`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 46;
--
-- Volcado de datos para la tabla `jugador`
--
INSERT INTO `jugador` (
    `codigojugador`, `nick`, `clave`,
    `oro`, `fechaingreso`, `horaingreso`,
    `puntostotales`, `protegido`, `vacaciones`,
    `fechaactualizacionoro`
)
VALUES
    (
        6, 'Jonathan Victorica', '1234', 33333,
        '2014-09-30', '18:54:51', 780000,
        0, 0, '2014-11-11 12:00:00'
    ),
    (
        7, 'Martin', '1234', 33333, '2014-09-30',
        '18:54:51', 500000, 0, 0, '2014-11-11 12:00:00'
    ),
    (
        8, 'Guillermo', '1234', 33333, '2014-09-30',
        '18:54:51', 250000, 0, 0, '2014-11-11 12:00:00'
    );
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `mensajeprivado`
--
CREATE TABLE IF NOT EXISTS `mensajeprivado` (
    `codigomensaje` int (11) NOT NULL AUTO_INCREMENT,
    `codigojugadorremi` int (11) DEFAULT NULL,
    `codigojugadorrec` int (11) NOT NULL,
    `mensaje` varchar (255) NOT NULL,
    `titulo` varchar (30) NOT NULL,
    `fecha` date NOT NULL,
    `hora` time NOT NULL,
    `leido` tinyint (1) NOT NULL,
    PRIMARY KEY (`codigomensaje`),
    KEY `codigojugadorremi` (`codigojugadorremi`),
    KEY `codigojugadorrec` (`codigojugadorrec`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 9;

-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `misionmilitar`
--
CREATE TABLE IF NOT EXISTS `misionmilitar` (
    `codigomision` int (11) NOT NULL AUTO_INCREMENT,
    `nombremision` varchar (30) NOT NULL,
    PRIMARY KEY (`codigomision`),
    UNIQUE KEY `nombremision` (`nombremision`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 6;
--
-- Volcado de datos para la tabla `misionmilitar`
--
INSERT INTO `misionmilitar` (`codigomision`, `nombremision`)
VALUES
    (2, 'Apostar Barcos'),
    (1, 'Apostar Tropas'),
    (4, 'Bloquear Puerto'),
    (5, 'Defender Puerto'),
    (3, 'Saquear');
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `movimientobarcoactual`
--
CREATE TABLE IF NOT EXISTS `movimientobarcoactual` (
    `codigomov` int (11) NOT NULL AUTO_INCREMENT,
    `codigociudadsalida` int (11) NOT NULL,
    `codigociudaddestino` int (11) NOT NULL,
    `fechasalida` date NOT NULL,
    `horasalida` time NOT NULL,
    `fechallegada` date NOT NULL,
    `horallegada` time NOT NULL,
    PRIMARY KEY (`codigomov`),
    KEY `codigociudadsalida` (`codigociudadsalida`),
    KEY `codigociudaddestino` (`codigociudaddestino`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 5;

-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `movimientomilitar`
--
CREATE TABLE IF NOT EXISTS `movimientomilitar` (
    `codigomov` int (11) NOT NULL DEFAULT '0',
    `codigoataque` int (11) DEFAULT NULL,
    PRIMARY KEY (`codigomov`),
    KEY `codigoataque` (`codigoataque`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `nivelciudad`
--
CREATE TABLE IF NOT EXISTS `nivelciudad` (
    `nivel` tinyint (3) unsigned NOT NULL DEFAULT '0',
    `capacidadhabitante` int (11) DEFAULT NULL,
    `capacidadmilitarterrestre` int (11) DEFAULT NULL,
    `capacidadmilitarnaval` int (11) DEFAULT NULL,
    `impuestociudadano` int (11) DEFAULT NULL,
    `codigoimagen` int (11) NOT NULL,
    `cantidadmaderamaxima` int (11) NOT NULL,
    `cantidadrecursomaxima` int (11) NOT NULL,
    `codigoimagenciudad` int (11) NOT NULL,
    PRIMARY KEY (`nivel`),
    KEY `codigoimagen` (`codigoimagen`),
    KEY `codigoimagenciudad` (`codigoimagenciudad`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
--
-- Volcado de datos para la tabla `nivelciudad`
--
INSERT INTO `nivelciudad` (
    `nivel`, `capacidadhabitante`, `capacidadmilitarterrestre`,
    `capacidadmilitarnaval`, `impuestociudadano`,
    `codigoimagen`, `cantidadmaderamaxima`,
    `cantidadrecursomaxima`, `codigoimagenciudad`
)
VALUES
    (1, 500, 1000, 100, 5, 121, 250, 250, 1),
    (2, 750, 2000, 200, 5, 121, 375, 375, 1),
    (
        3, 1000, 3000, 300, 5, 121, 500, 500, 1
    ),
    (
        4, 1250, 4000, 400, 5, 123, 625, 625, 1
    ),
    (
        5, 1500, 5000, 500, 5, 123, 750, 750, 1
    ),
    (6, 1750, 6000, 600, 5, 48, 875, 875, 1),
    (
        7, 2000, 7000, 700, 5, 48, 1000, 1000,
        1
    ),
    (
        8, 2250, 8000, 800, 5, 124, 1125, 1125,
        1
    ),
    (
        9, 2500, 9000, 900, 5, 124, 1250, 1250,
        1
    ),
    (
        10, 2750, 10000, 1000, 10, 125, 1375,
        1375, 1
    ),
    (
        11, 3000, 11000, 1100, 10, 125, 1500,
        1500, 1
    ),
    (
        12, 3250, 12000, 1200, 10, 126, 1625,
        1625, 1
    ),
    (
        13, 3500, 13000, 1300, 10, 126, 1750,
        1750, 1
    ),
    (
        14, 3750, 14000, 1400, 10, 126, 1875,
        1875, 1
    ),
    (
        15, 4000, 15000, 1500, 10, 126, 2000,
        2000, 1
    ),
    (
        16, 4250, 16000, 1600, 10, 127, 2125,
        2125, 1
    ),
    (
        17, 4500, 17000, 1700, 10, 127, 2250,
        2250, 1
    ),
    (
        18, 4750, 18000, 1800, 10, 127, 2375,
        2375, 1
    ),
    (
        19, 5000, 19000, 1900, 10, 128, 2500,
        2500, 1
    ),
    (
        20, 5250, 20000, 2000, 10, 128, 2625,
        2625, 1
    );
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `oferta`
--
CREATE TABLE IF NOT EXISTS `oferta` (
    `codigooferta` int (11) NOT NULL AUTO_INCREMENT,
    `codigorecurso` tinyint (3) unsigned NOT NULL,
    `cantidadofrecida` int (11) DEFAULT NULL,
    `orobuscado` int (11) DEFAULT NULL,
    `codigorecursobuscado` tinyint (3) unsigned DEFAULT NULL,
    `jugador` tinyint (1) NOT NULL DEFAULT '0',
    `fecha` datetime DEFAULT NULL,
    PRIMARY KEY (`codigooferta`),
    KEY `codigorecurso` (`codigorecurso`),
    KEY `codigorecursobuscado` (`codigorecursobuscado`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 34;
--
-- Volcado de datos para la tabla `oferta`
--
INSERT INTO `oferta` (
    `codigooferta`, `codigorecurso`,
    `cantidadofrecida`, `orobuscado`,
    `codigorecursobuscado`, `jugador`,
    `fecha`
)
VALUES
    (
        1, 6, 217, 1, NULL, 0, '2014-10-29 23:54:12'
    ),
    (
        6, 15, 29667, 0, 9, 1, '2014-10-29 23:54:12'
    ),
    (
        7, 15, 22400, 0, 9, 1, '2014-10-29 23:54:12'
    ),
    (
        8, 15, 5600, 0, 6, 1, '2014-10-29 23:54:12'
    ),
    (
        10, 9, 12000, 0, 15, 1, '2014-10-29 23:54:12'
    ),
    (
        11, 9, 30000, 0, 6, 1, '2014-10-29 23:54:12'
    ),
    (
        12, 9, 3922, 0, 6, 1, '2014-10-29 23:54:12'
    ),
    (
        16, 14, 22, 1, NULL, 0, '2014-10-29 23:54:12'
    ),
    (
        21, 6, 8994, 0, 15, 1, '2014-10-30 11:21:50'
    ),
    (
        22, 6, 200000, 0, 15, 1, '2014-10-30 11:52:27'
    ),
    (
        23, 14, 10000, 0, 6, 1, '2014-10-30 12:04:41'
    ),
    (
        24, 6, 10000, 0, 15, 1, '2014-10-30 12:09:15'
    ),
    (
        25, 15, 2900, 0, 6, 1, '2014-10-30 14:57:55'
    ),
    (
        28, 6, 10000, 0, 15, 1, '2014-11-12 10:25:33'
    ),
    (
        29, 6, 1000000000, 0, 15, 1, '2014-12-14 12:15:52'
    ),
    (
        30, 6, 1000000000, 0, 14, 1, '2014-12-14 12:16:16'
    ),
    (
        31, 6, 147483647, 0, 15, 1, '2014-12-14 12:16:43'
    ),
    (
        33, 6, 888, 1, NULL, 1, '2015-02-19 16:59:32'
    );
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `ofertajugador`
--
CREATE TABLE IF NOT EXISTS `ofertajugador` (
    `codigooferta` int (11) NOT NULL DEFAULT '0',
    `codigojugador` int (11) NOT NULL,
    PRIMARY KEY (`codigooferta`),
    KEY `codigojugador` (`codigojugador`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
--
-- Volcado de datos para la tabla `ofertajugador`
--
INSERT INTO `ofertajugador` (`codigooferta`, `codigojugador`)
VALUES
    (6, 8),
    (7, 8),
    (8, 8),
    (10, 6),
    (11, 6),
    (12, 6),
    (21, 6),
    (22, 6),
    (23, 6),
    (24, 6),
    (25, 6),
    (28, 7),
    (29, 7),
    (30, 7),
    (31, 7),
    (33, 7);
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `puntosjugador`
--
CREATE TABLE IF NOT EXISTS `puntosjugador` (
    `codigojugador` int (11) NOT NULL AUTO_INCREMENT,
    `puntosconstructor` int (11) DEFAULT '0',
    `puntossoldado` int (11) DEFAULT '0',
    `puntosdefenta` int (11) DEFAULT '0',
    `puntosataque` int (11) DEFAULT '0',
    `puntosinvestigacion` int (11) NOT NULL DEFAULT '0',
    PRIMARY KEY (`codigojugador`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 46;
--
-- Volcado de datos para la tabla `puntosjugador`
--
INSERT INTO `puntosjugador` (
    `codigojugador`, `puntosconstructor`,
    `puntossoldado`, `puntosdefenta`,
    `puntosataque`, `puntosinvestigacion`
)
VALUES
    (6, 10, 10, 10, 10, 30000100),
    (7, 10, 10, 10, 10, 30000000),
    (8, 10, 10, 10, 10, 30000000)
   ;
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `recurso`
--
CREATE TABLE IF NOT EXISTS `recurso` (
    `codigorecurso` tinyint (3) unsigned NOT NULL AUTO_INCREMENT,
    `nombre` varchar (25) NOT NULL,
    `codigoimagen` int (11) NOT NULL,
    PRIMARY KEY (`codigorecurso`),
    UNIQUE KEY `nombre` (`nombre`),
    KEY `codigoimagen` (`codigoimagen`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 16;
--
-- Volcado de datos para la tabla `recurso`
--
INSERT INTO `recurso` (
    `codigorecurso`, `nombre`, `codigoimagen`
)
VALUES
    (6, 'Madera', 14),
    (9, 'Azufre', 16),
    (12, 'Cristal', 16),
    (14, 'Vino', 20),
    (15, 'Marmol', 21);
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `temainvestigacion`
--
CREATE TABLE IF NOT EXISTS `temainvestigacion` (
    `codigotema` int (11) NOT NULL DEFAULT '0',
    `tema` varchar (25) NOT NULL,
    PRIMARY KEY (`codigotema`),
    KEY `tema` (`tema`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
--
-- Volcado de datos para la tabla `temainvestigacion`
--
INSERT INTO `temainvestigacion` (`codigotema`, `tema`)
VALUES
    (3, 'Ciencia'),
    (4, 'Economìa'),
    (2, 'Milicia'),
    (1, 'Navegación');
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `tipomision`
--
CREATE TABLE IF NOT EXISTS `tipomision` (
    `codigomision` int (11) NOT NULL DEFAULT '0',
    `tipomision` varchar (30) NOT NULL,
    PRIMARY KEY (`codigomision`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `unidadmilitar`
--
CREATE TABLE IF NOT EXISTS `unidadmilitar` (
    `codigounidad` int (11) NOT NULL AUTO_INCREMENT,
    `nombre` varchar (30) NOT NULL,
    `descripcion` text NOT NULL,
    `codigoimagen` int (11) NOT NULL,
    `costo` int (11) DEFAULT NULL,
    `puntosdefensivos` int (11) DEFAULT NULL,
    `puntosataque` int (11) DEFAULT NULL,
    `barco` tinyint (1) NOT NULL,
    `nivelnecesario` int (11) NOT NULL,
    `carga` int (11) DEFAULT NULL,
    `cantidadhabitantes` int (11) DEFAULT NULL,
    PRIMARY KEY (`codigounidad`),
    UNIQUE KEY `nombre` (`nombre`),
    KEY `codigoimagen` (`codigoimagen`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT = 41;
--
-- Volcado de datos para la tabla `unidadmilitar`
--
INSERT INTO `unidadmilitar` (
    `codigounidad`, `nombre`, `descripcion`,
    `codigoimagen`, `costo`, `puntosdefensivos`,
    `puntosataque`, `barco`, `nivelnecesario`,
    `carga`, `cantidadhabitantes`
)
VALUES
    (
        20, 'Gigante a Vapor', 'Esta máquina poderosa se mueve como un humano en el campo de Batalla, pero tiene una fuerza de golpe sobrehumana. Piedras, flechas y espadas rebotan contra esta máquina. ?Ay de aquí l que se atreva a oponerse! ',
        31, 2, 3, 42, 0, 14, 10, 1
    ),
    (
        21, 'Hoplita', 'Los Hoplitas en Ikariam son pesados hombres armados con lanzas que provienen de la clase media de la ciudad. Forman el corazón de cada ejército griego. En la conocida como formación "en Falange", avanzan como una pared imparable de lanzas y escudos. ',
        31, 1, 1, 18, 0, 1, 15, 1
    ),
    (
        23, 'Espadachin', 'Los espadachines apenas están acorazados y luchan sin escudo para conservar su movilidad. De este modo, ellos pueden rodear las inm?viles formaciones de Hoplitas y atacar desde los flancos.',
        31, 1, 0, 10, 0, 3, 15, 1
    ),
    (
        24, 'Lancero', 'Los Lanceros son reclutas de la población rural que se lanzan a la Batalla equipados con una armadura ligera y una simple lanza. No suelen tener ninguna posibilidad contra la mayoría de los soldados profesionales.',
        31, 1, 0, 4, 0, 1, 10, 1
    ),
    (
        25, 'Arquero', 'El arco es un instrumento de caza muy difundido, así que no cuesta mucho esfuerzo reclutarlos de entre los ciudadanos. Con una formación militar, los simples ciudadanos se convertirón en una tropa formidable de combate a distancia. ',
        31, 1, 0, 5, 0, 4, 15, 1
    ),
    (
        26, 'Fusilero', 'Los disparos del fusilero pueden penetran hasta en los blindajes más resistentes. Sin embargo, debido a su lónea de visión, solamente una fila de tiradores pueden disparar, mientras el resto tiene que recargar. Investigación Requerida: Pólvora (Milicia)',
        31, 1, 0, 15, 0, 5, 15, 1
    ),
    (
        27, 'Hondero', 'Las hondas son armas ligeras y baratas. No infligen mucho da?o en los oponentes bien armados, pero al menos su munición está f?cilmente disponible.',
        31, 1, 0, 3, 0, 6, 15, 1
    ),
    (
        28, 'Ariete', 'Hombres robustos balancean el tronco macizo de un árbol contra los portones enemigos hasta que éstos ceden y los hombres corren para buscar cubierta bajo el tejado. Bien es verdad que es ?til solamente para derribar portones de madera o muros, pero hay que ver que no necesita ningón tipo de munición.',
        31, 5, 1, 45, 0, 7, 10, 1
    ),
    (
        29, 'Catapulta', 'Las catapultas lanzan grandes rocas contra las instalaciones de defensa del enemigo, destruyendo de este modo hasta los muros de piedra más robustos. No obstante, son poco eficaces en defensa contra ejércitos enemigos.',
        31, 5, 0, 70, 0, 8, 15, 1
    ),
    (
        30, 'Mortero', 'El mortero dispara balas explosivas contra los muros de una ciudad sitiada. No hay edificio que pueda resistir a su fuerza de destrucción. No obstante, la escasa munición tiene que ser tra?da adicionalmente, por ello, los disparos deben estar bien dirigidos.',
        31, 5, 0, 140, 0, 9, 15, 1
    ),
    (
        31, 'Girocoptero', 'Una nave muy novedosa que es muy r?pida, f?cil de manejar y que no depende de la dirección del viento. ?Con esta máquina podemos dar caza a nuestros enemigos que nos quieren atacar cobardemente desde el cielo! ',
        31, 3, 0, 17, 0, 11, 15, 1
    ),
    (
        32, 'Globo Bombardero', 'Nuestros inventores han descubierto que el sol es tan caliente porque atrae aire caliente. Es por eso que un globo lleno de aire caliente asciende en dirección al sol. Con este m?todo, nuestros soldados pueden tirar desde arriba barriles explosivos a nuestros enemigos. ',
        31, 5, 0, 48, 0, 17, 15, 1
    ),
    (
        33, 'Barco Espolon', 'Equipado con un simple espolón en la proa del barco, este barco es el barco de guerra elemental de la marina. Una docena de remeros fuertes hacen que este barco tome una gran velocidad para hundir con toda fuerza el espolón en el casco enemigo. A menudo esto es suficiente para hundir un barco enemigo. Investigación Requerida: Ninguna',
        31, 1, 10, 5, 1, 14, 0, 3
    ),
    (
        34, 'Barco Lanzallamas', 'En la proa del barco lanza llamas se encuentra un lanzallamas que echa fuego griego sobre el mar. Hasta en la superficie del océano, la mezcla sigue quemando y creando de esta manera una alfombra de llamas.;?Un barco de combate muy terror?fico! ;Investigación Requerida: Fuego Griego (Navegación)',
        31, 2, 15, 10, 1, 1, 0, 3
    ),
    (
        35, 'Barco Espolon a vapor', 'Al igual que el barco-espolón, el barco-espolón de vapor está equipado con un espolón en la proa. Sin embargo, se trata de una versión mucho más avanzada.Gracias a su mecanismo accionado por vapor, este barco es capaz de acelerar aón más deprisa y causar tremendos daños al enemigo.El barco-espolón de vapor es la nave más peligrosa de la lónea de batalla. ;Investigación Requerida: Espolón Macizo (Navegación)',
        31, 3, 20, 15, 1, 3, 0, 3
    ),
    (
        36, 'Barco Ballesta', 'Este barco esta provisto de una ballesta que estaba predestinada para disparar ganchos de abordaje.Sin embargo, la ballesta, como arma precisa de lucha a distancia, es muy valiosa para acertar a los enemigos bajo la lónea de agua; aunque no provoque graves daños. ;Investigación Requerida: Armamento en cubierta (Navegación)',
        31, 2, 10, 15, 1, 1, 0, 3
    ),
    (
        37, 'Barco Catapulta', 'La catapulta sobre la cubierta de este barco es más pequeño que su equivalente en tierra debido al espacio.Las olas del océano hacen que esta no sea precisa, no obstante, esta catapulta dispara orzas con aceite candente que dejan peligrosas mareas negras sobre el mar. ;Investigación Requerida: Contrapeso (Navegación)',
        31, 3, 10, 20, 1, 4, 0, 3
    ),
    (
        38, 'barco Mortero', 'El barco-mortero tiene un casco sumamente ancho con un elevado desplazamiento de agua a fin de que pueda resistir la enorme repercusión del mortero.Si la mecha de un proyectil es medida correctamente, el potente proyectil explota justo sobre la cubierta del enemigo. ;Investigación Requerida: Base para morteros (Navegación)',
        31, 3, 10, 30, 1, 5, 0, 3
    ),
    (
        39, 'Submarino', 'Un barco que navega por debajo de la superficie es el arma definitiva de los mares.Puede pasar casi desapercibido hasta las filas enemigas y ahí provocar daños terribles.;Investigación Requerida: Camara hiperborica (Ciencia)',
        31, 5, 25, 20, 1, 6, 0, 3
    ),
    (
        40, 'Barco LanzaMisiles', 'Gracias a sus investigaciones, nuestros científicos han conseguido rellenar con ingentes cantidades de polvo explosivo un depósito de madera.Si es encendido correctamente, puede recorrer varios cientos de metros sobre la superficie del mar y causar una formidable explosión al chocar contra los barcos enemigos.?Que tiemblen nuestros adversarios ante esta nueva arma! ;Investigación Requerida: Pólvora (Milicia)',
        31, 5, 15, 40, 1, 9, 0, 3
    );
-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `unidadmilitarconstruccion`
--
CREATE TABLE IF NOT EXISTS `unidadmilitarconstruccion` (
    `codigounidad` int (11) NOT NULL DEFAULT '0',
    `codigorecurso` tinyint (3) unsigned NOT NULL DEFAULT '0',
    `cantidad` int (11) NOT NULL,
    PRIMARY KEY (`codigounidad`, `codigorecurso`),
    KEY `codigorecurso` (`codigorecurso`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;
--
-- Volcado de datos para la tabla `unidadmilitarconstruccion`
--
INSERT INTO `unidadmilitarconstruccion` (
    `codigounidad`, `codigorecurso`,
    `cantidad`
)
VALUES
    (20, 6, 130),
    (20, 9, 180),
    (21, 6, 40),
    (21, 9, 30),
    (23, 6, 30),
    (23, 9, 30),
    (24, 6, 30),
    (25, 6, 30),
    (25, 9, 25),
    (26, 6, 50),
    (26, 9, 150),
    (27, 6, 20),
    (28, 6, 220),
    (29, 6, 260),
    (29, 9, 300),
    (30, 6, 300),
    (30, 9, 1250),
    (31, 6, 25),
    (31, 9, 100),
    (32, 6, 40),
    (32, 9, 250),
    (33, 6, 250),
    (33, 9, 0),
    (33, 12, 0),
    (34, 6, 80),
    (34, 9, 230),
    (34, 12, 0),
    (35, 6, 400),
    (35, 9, 800),
    (35, 12, 0),
    (36, 6, 180),
    (36, 9, 160),
    (36, 12, 0),
    (37, 6, 180),
    (37, 9, 140),
    (37, 12, 0),
    (38, 6, 220),
    (38, 9, 900),
    (38, 12, 0),
    (39, 6, 160),
    (39, 9, 100),
    (39, 12, 750),
    (40, 6, 200),
    (40, 9, 1200),
    (40, 12, 0);
--
-- Restricciones para tablas volcadas
--
--
-- Filtros para la tabla `apostamientotropa`
--
ALTER TABLE
    `apostamientotropa`
    ADD
        CONSTRAINT `apostamientotropa_ibfk_1` FOREIGN KEY (`codigoapostamiento`) REFERENCES `ataque` (`codigoataque`),
ADD
  CONSTRAINT `apostamientotropa_ibfk_2` FOREIGN KEY (`codigociudapostador`) REFERENCES `ciudad` (`codigociudad`),
ADD
  CONSTRAINT `apostamientotropa_ibfk_3` FOREIGN KEY (`codigociudadapostada`) REFERENCES `ciudad` (`codigociudad`);
--
-- Filtros para la tabla `apostamientounidad`
--
ALTER TABLE
    `apostamientounidad`
    ADD
        CONSTRAINT `apostamientounidad_ibfk_1` FOREIGN KEY (`codigoapostamiento`) REFERENCES `apostamientotropa` (`codigoapostamiento`),
ADD
  CONSTRAINT `apostamientounidad_ibfk_2` FOREIGN KEY (`codigounidad`) REFERENCES `unidadmilitar` (`codigounidad`),
ADD
  CONSTRAINT `apostamientounidad_ibfk_3` FOREIGN KEY (`codigoarma`) REFERENCES `arma` (`codigoarma`);
--
-- Filtros para la tabla `arma`
--
ALTER TABLE
    `arma`
    ADD
        CONSTRAINT `arma_ibfk_1` FOREIGN KEY (`codigoimagen`) REFERENCES `imagenes` (`codigoimagen`);
--
-- Filtros para la tabla `armaconstruccion`
--
ALTER TABLE
    `armaconstruccion`
    ADD
        CONSTRAINT `armaconstruccion_ibfk_1` FOREIGN KEY (`codigoarma`) REFERENCES `arma` (`codigoarma`),
ADD
  CONSTRAINT `armaconstruccion_ibfk_2` FOREIGN KEY (`codigorecurso`) REFERENCES `recurso` (`codigorecurso`);
--
-- Filtros para la tabla `armaunidad`
--
ALTER TABLE
    `armaunidad`
    ADD
        CONSTRAINT `armaunidad_ibfk_1` FOREIGN KEY (`codigounidad`) REFERENCES `unidadmilitar` (`codigounidad`),
ADD
  CONSTRAINT `armaunidad_ibfk_2` FOREIGN KEY (`codigoarma`) REFERENCES `arma` (`codigoarma`);
--
-- Filtros para la tabla `asalto`
--
ALTER TABLE
    `asalto`
    ADD
        CONSTRAINT `asalto_ibfk_1` FOREIGN KEY (`codigoataque`) REFERENCES `ataque` (`codigoataque`),
ADD
  CONSTRAINT `asalto_ibfk_2` FOREIGN KEY (`codigorecurso`) REFERENCES `recurso` (`codigorecurso`);
--
-- Filtros para la tabla `ataque`
--
ALTER TABLE
    `ataque`
    ADD
        CONSTRAINT `ataque_ibfk_1` FOREIGN KEY (`codigociudadjugatacante`) REFERENCES `ciudad` (`codigociudad`),
ADD
  CONSTRAINT `ataque_ibfk_2` FOREIGN KEY (`codigociudadjugatacado`) REFERENCES `ciudad` (`codigociudad`),
ADD
  CONSTRAINT `ataque_ibfk_3` FOREIGN KEY (`codigomision`) REFERENCES `misionmilitar` (`codigomision`),
ADD
  CONSTRAINT `ataque_ibfk_4` FOREIGN KEY (`codjugadorganador`) REFERENCES `jugador` (`codigojugador`);
--
-- Filtros para la tabla `ataqueunidaddecombate`
--
ALTER TABLE
    `ataqueunidaddecombate`
    ADD
        CONSTRAINT `ataqueunidaddecombate_ibfk_1` FOREIGN KEY (`codigoataque`) REFERENCES `ataque` (`codigoataque`),
ADD
  CONSTRAINT `ataqueunidaddecombate_ibfk_2` FOREIGN KEY (`codigounidad`) REFERENCES `unidadmilitar` (`codigounidad`),
ADD
  CONSTRAINT `ataqueunidaddecombate_ibfk_3` FOREIGN KEY (`codigoarma`) REFERENCES `arma` (`codigoarma`);
--
-- Filtros para la tabla `barcomovimiento`
--
ALTER TABLE
    `barcomovimiento`
    ADD
        CONSTRAINT `barcomovimiento_ibfk_1` FOREIGN KEY (`codigomov`) REFERENCES `movimientobarcoactual` (`codigomov`),
ADD
  CONSTRAINT `barcomovimiento_ibfk_2` FOREIGN KEY (`codigobarco`) REFERENCES `barcos` (`codigobarco`);
--
-- Filtros para la tabla `barcos`
--
ALTER TABLE
    `barcos`
    ADD
        CONSTRAINT `barcos_ibfk_1` FOREIGN KEY (`codigoimagen`) REFERENCES `imagenes` (`codigoimagen`);
--
-- Filtros para la tabla `carga`
--
ALTER TABLE
    `carga`
    ADD
        CONSTRAINT `carga_ibfk_1` FOREIGN KEY (`codigomov`) REFERENCES `movimientobarcoactual` (`codigomov`),
ADD
  CONSTRAINT `carga_ibfk_2` FOREIGN KEY (`codigorecurso`) REFERENCES `recurso` (`codigorecurso`);
--
-- Filtros para la tabla `cargamilitar`
--
ALTER TABLE
    `cargamilitar`
    ADD
        CONSTRAINT `cargamilitar_ibfk_1` FOREIGN KEY (`codigomov`) REFERENCES `movimientomilitar` (`codigomov`),
ADD
  CONSTRAINT `cargamilitar_ibfk_2` FOREIGN KEY (`codigounidad`) REFERENCES `unidadmilitar` (`codigounidad`),
ADD
  CONSTRAINT `cargamilitar_ibfk_3` FOREIGN KEY (`codigoarma`) REFERENCES `arma` (`codigoarma`);
--
-- Filtros para la tabla `ciudad`
--
ALTER TABLE
    `ciudad`
    ADD
        CONSTRAINT `ciudad_ibfk_1` FOREIGN KEY (`codigojugador`) REFERENCES `jugador` (`codigojugador`),
ADD
  CONSTRAINT `ciudad_ibfk_2` FOREIGN KEY (`codigoisla`) REFERENCES `isla` (`codigoisla`),
ADD
  CONSTRAINT `ciudad_ibfk_3` FOREIGN KEY (`nivel`) REFERENCES `nivelciudad` (`nivel`),
ADD
  CONSTRAINT `ciudad_ibfk_4` FOREIGN KEY (`codigoestado`) REFERENCES `estadociudad` (`codigoestado`);
--
-- Filtros para la tabla `ciudadacademia`
--
ALTER TABLE
    `ciudadacademia`
    ADD
        CONSTRAINT `ciudadacademia_ibfk_1` FOREIGN KEY (`codigociudad`) REFERENCES `ciudad` (`codigociudad`);
--
-- Filtros para la tabla `ciudadbarco`
--
ALTER TABLE
    `ciudadbarco`
    ADD
        CONSTRAINT `ciudadbarco_ibfk_1` FOREIGN KEY (`codigociudad`) REFERENCES `ciudad` (`codigociudad`),
ADD
  CONSTRAINT `ciudadbarco_ibfk_2` FOREIGN KEY (`codigobarco`) REFERENCES `barcos` (`codigobarco`);
--
-- Filtros para la tabla `ciudadedificionivel`
--
ALTER TABLE
    `ciudadedificionivel`
    ADD
        CONSTRAINT `ciudadedificionivel_ibfk_1` FOREIGN KEY (`codigociudad`) REFERENCES `ciudad` (`codigociudad`),
ADD
  CONSTRAINT `ciudadedificionivel_ibfk_2` FOREIGN KEY (`codigoedificio`) REFERENCES `edificionivel` (`codigoedifnivel`);
--
-- Filtros para la tabla `ciudadejercito`
--
ALTER TABLE
    `ciudadejercito`
    ADD
        CONSTRAINT `ciudadejercito_ibfk_1` FOREIGN KEY (`codigociudad`) REFERENCES `ciudad` (`codigociudad`),
ADD
  CONSTRAINT `ciudadejercito_ibfk_2` FOREIGN KEY (`codigounidad`) REFERENCES `unidadmilitar` (`codigounidad`);
--
-- Filtros para la tabla `ciudadejercitoarma`
--
ALTER TABLE
    `ciudadejercitoarma`
    ADD
        CONSTRAINT `ciudadejercitoarma_ibfk_1` FOREIGN KEY (`codigounidadciudad`) REFERENCES `ciudadejercito` (`codigounidadciudad`),
ADD
  CONSTRAINT `ciudadejercitoarma_ibfk_2` FOREIGN KEY (`codigoarma`) REFERENCES `arma` (`codigoarma`);
--
-- Filtros para la tabla `ciudadproduccion`
--
ALTER TABLE
    `ciudadproduccion`
    ADD
        CONSTRAINT `ciudadproduccion_ibfk_1` FOREIGN KEY (`codigociudad`) REFERENCES `ciudad` (`codigociudad`),
ADD
  CONSTRAINT `ciudadproduccion_ibfk_2` FOREIGN KEY (`codigorecurso`) REFERENCES `recurso` (`codigorecurso`);
--
-- Filtros para la tabla `ciudadrecurso`
--
ALTER TABLE
    `ciudadrecurso`
    ADD
        CONSTRAINT `ciudadrecurso_ibfk_1` FOREIGN KEY (`codigociudad`) REFERENCES `ciudad` (`codigociudad`),
ADD
  CONSTRAINT `ciudadrecurso_ibfk_2` FOREIGN KEY (`codigorecurso`) REFERENCES `recurso` (`codigorecurso`);
--
-- Filtros para la tabla `ciudadtaberna`
--
ALTER TABLE
    `ciudadtaberna`
    ADD
        CONSTRAINT `ciudadtaberna_ibfk_1` FOREIGN KEY (`codigociudad`) REFERENCES `ciudad` (`codigociudad`);
--
-- Filtros para la tabla `depositomercado`
--
ALTER TABLE
    `depositomercado`
    ADD
        CONSTRAINT `depositomercado_ibfk_1` FOREIGN KEY (`codigojugador`) REFERENCES `jugador` (`codigojugador`),
ADD
  CONSTRAINT `depositomercado_ibfk_2` FOREIGN KEY (`codigorecurso`) REFERENCES `recurso` (`codigorecurso`);
--
-- Filtros para la tabla `edificio`
--
ALTER TABLE
    `edificio`
    ADD
        CONSTRAINT `edificio_ibfk_1` FOREIGN KEY (`codigoimagen`) REFERENCES `imagenes` (`codigoimagen`);
--
-- Filtros para la tabla `edificionivel`
--
ALTER TABLE
    `edificionivel`
    ADD
        CONSTRAINT `edificionivel_ibfk_1` FOREIGN KEY (`codigoedificio`) REFERENCES `edificio` (`codigoedificio`);
--
-- Filtros para la tabla `edificiorecurso`
--
ALTER TABLE
    `edificiorecurso`
    ADD
        CONSTRAINT `edificiorecurso_ibfk_1` FOREIGN KEY (`codigoedifnivel`) REFERENCES `edificionivel` (`codigoedifnivel`),
ADD
  CONSTRAINT `edificiorecurso_ibfk_2` FOREIGN KEY (`codigorecurso`) REFERENCES `recurso` (`codigorecurso`);
--
-- Filtros para la tabla `guerraataque`
--
ALTER TABLE
    `guerraataque`
    ADD
        CONSTRAINT `guerraataque_ibfk_1` FOREIGN KEY (`codigoguerra`) REFERENCES `guerra` (`codigoguerra`),
ADD
  CONSTRAINT `guerraataque_ibfk_2` FOREIGN KEY (`codigoataque`) REFERENCES `ataque` (`codigoataque`);
--
-- Filtros para la tabla `guerraparticipante`
--
ALTER TABLE
    `guerraparticipante`
    ADD
        CONSTRAINT `guerraparticipante_ibfk_1` FOREIGN KEY (`codigoguerra`) REFERENCES `guerra` (`codigoguerra`),
ADD
  CONSTRAINT `guerraparticipante_ibfk_2` FOREIGN KEY (`codigojugador`) REFERENCES `jugador` (`codigojugador`);
--
-- Filtros para la tabla `investigacion`
--
ALTER TABLE
    `investigacion`
    ADD
        CONSTRAINT `investigacion_ibfk_1` FOREIGN KEY (`codigotema`) REFERENCES `temainvestigacion` (`codigotema`);
--
-- Filtros para la tabla `investigaciondescuentos`
--
ALTER TABLE
    `investigaciondescuentos`
    ADD
        CONSTRAINT `investigaciondescuentos_ibfk_1` FOREIGN KEY (`codigoinvestigacion`) REFERENCES `investigacion` (`codigoinvestigacion`);
--
-- Filtros para la tabla `investigacionedificio`
--
ALTER TABLE
    `investigacionedificio`
    ADD
        CONSTRAINT `investigacionedificio_ibfk_1` FOREIGN KEY (`codigoinvestigacion`) REFERENCES `investigacion` (`codigoinvestigacion`),
ADD
  CONSTRAINT `investigacionedificio_ibfk_2` FOREIGN KEY (`codigoedificio`) REFERENCES `edificio` (`codigoedificio`);
--
-- Filtros para la tabla `investigacionjugador`
--
ALTER TABLE
    `investigacionjugador`
    ADD
        CONSTRAINT `investigacionjugador_ibfk_1` FOREIGN KEY (`codigoinvestigacion`) REFERENCES `investigacion` (`codigoinvestigacion`),
ADD
  CONSTRAINT `investigacionjugador_ibfk_2` FOREIGN KEY (`codigojugador`) REFERENCES `jugador` (`codigojugador`);
--
-- Filtros para la tabla `investigacionopmilitar`
--
ALTER TABLE
    `investigacionopmilitar`
    ADD
        CONSTRAINT `investigacionopmilitar_ibfk_1` FOREIGN KEY (`codigoinvestigacion`) REFERENCES `investigacion` (`codigoinvestigacion`),
ADD
  CONSTRAINT `investigacionopmilitar_ibfk_2` FOREIGN KEY (`codigoopmilitar`) REFERENCES `misionmilitar` (`codigomision`);
--
-- Filtros para la tabla `investigacionunidad`
--
ALTER TABLE
    `investigacionunidad`
    ADD
        CONSTRAINT `investigacionunidad_ibfk_1` FOREIGN KEY (`codigoinvestigacion`) REFERENCES `investigacion` (`codigoinvestigacion`),
ADD
  CONSTRAINT `investigacionunidad_ibfk_2` FOREIGN KEY (`codigounidad`) REFERENCES `unidadmilitar` (`codigounidad`);
--
-- Filtros para la tabla `isla`
--
ALTER TABLE
    `isla`
    ADD
        CONSTRAINT `isla_ibfk_1` FOREIGN KEY (`codigoimagen`) REFERENCES `imagenes` (`codigoimagen`);
--
-- Filtros para la tabla `islarecurso`
--
ALTER TABLE
    `islarecurso`
    ADD
        CONSTRAINT `islarecurso_ibfk_1` FOREIGN KEY (`codigoisla`) REFERENCES `isla` (`codigoisla`),
ADD
  CONSTRAINT `islarecurso_ibfk_2` FOREIGN KEY (`codigorecurso`) REFERENCES `recurso` (`codigorecurso`);
--
-- Filtros para la tabla `mensajeprivado`
--
ALTER TABLE
    `mensajeprivado`
    ADD
        CONSTRAINT `mensajeprivado_ibfk_1` FOREIGN KEY (`codigojugadorremi`) REFERENCES `jugador` (`codigojugador`),
ADD
  CONSTRAINT `mensajeprivado_ibfk_2` FOREIGN KEY (`codigojugadorrec`) REFERENCES `jugador` (`codigojugador`);
--
-- Filtros para la tabla `movimientobarcoactual`
--
ALTER TABLE
    `movimientobarcoactual`
    ADD
        CONSTRAINT `movimientobarcoactual_ibfk_1` FOREIGN KEY (`codigociudadsalida`) REFERENCES `ciudad` (`codigociudad`),
ADD
  CONSTRAINT `movimientobarcoactual_ibfk_2` FOREIGN KEY (`codigociudaddestino`) REFERENCES `ciudad` (`codigociudad`);
--
-- Filtros para la tabla `movimientomilitar`
--
ALTER TABLE
    `movimientomilitar`
    ADD
        CONSTRAINT `movimientomilitar_ibfk_1` FOREIGN KEY (`codigomov`) REFERENCES `movimientobarcoactual` (`codigomov`),
ADD
  CONSTRAINT `movimientomilitar_ibfk_2` FOREIGN KEY (`codigoataque`) REFERENCES `ataque` (`codigoataque`);
--
-- Filtros para la tabla `nivelciudad`
--
ALTER TABLE
    `nivelciudad`
    ADD
        CONSTRAINT `nivelciudad_ibfk_1` FOREIGN KEY (`codigoimagen`) REFERENCES `imagenes` (`codigoimagen`),
ADD
  CONSTRAINT `nivelciudad_ibfk_2` FOREIGN KEY (`codigoimagenciudad`) REFERENCES `imagenes` (`codigoimagen`);
--
-- Filtros para la tabla `oferta`
--
ALTER TABLE
    `oferta`
    ADD
        CONSTRAINT `oferta_ibfk_1` FOREIGN KEY (`codigorecurso`) REFERENCES `recurso` (`codigorecurso`),
ADD
  CONSTRAINT `oferta_ibfk_2` FOREIGN KEY (`codigorecursobuscado`) REFERENCES `recurso` (`codigorecurso`);
--
-- Filtros para la tabla `ofertajugador`
--
ALTER TABLE
    `ofertajugador`
    ADD
        CONSTRAINT `ofertajugador_ibfk_1` FOREIGN KEY (`codigojugador`) REFERENCES `jugador` (`codigojugador`),
ADD
  CONSTRAINT `ofertajugador_ibfk_2` FOREIGN KEY (`codigooferta`) REFERENCES `oferta` (`codigooferta`);
--
-- Filtros para la tabla `puntosjugador`
--
ALTER TABLE
    `puntosjugador`
    ADD
        CONSTRAINT `puntosjugador_ibfk_1` FOREIGN KEY (`codigojugador`) REFERENCES `jugador` (`codigojugador`);
--
-- Filtros para la tabla `recurso`
--
ALTER TABLE
    `recurso`
    ADD
        CONSTRAINT `recurso_ibfk_1` FOREIGN KEY (`codigoimagen`) REFERENCES `imagenes` (`codigoimagen`);
--
-- Filtros para la tabla `unidadmilitar`
--
ALTER TABLE
    `unidadmilitar`
    ADD
        CONSTRAINT `unidadmilitar_ibfk_1` FOREIGN KEY (`codigoimagen`) REFERENCES `imagenes` (`codigoimagen`);
--
-- Filtros para la tabla `unidadmilitarconstruccion`
--
ALTER TABLE
    `unidadmilitarconstruccion`
    ADD
        CONSTRAINT `unidadmilitarconstruccion_ibfk_1` FOREIGN KEY (`codigounidad`) REFERENCES `unidadmilitar` (`codigounidad`),
ADD
  CONSTRAINT `unidadmilitarconstruccion_ibfk_2` FOREIGN KEY (`codigorecurso`) REFERENCES `recurso` (`codigorecurso`);
