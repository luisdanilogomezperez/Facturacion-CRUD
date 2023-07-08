-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-07-2023 a las 15:31:03
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `factura`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo`
--

CREATE TABLE `articulo` (
  `Id_Articulo` int(30) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Cantidad` int(30) NOT NULL,
  `Precio` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `articulo`
--

INSERT INTO `articulo` (`Id_Articulo`, `Nombre`, `Cantidad`, `Precio`) VALUES
(22, 'Arroz', 1, 2500),
(23, 'Azucar', 2, 4000),
(24, 'Sal', 10, 2000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `Cedula` varchar(30) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Apellido` varchar(30) NOT NULL,
  `Telefono` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`Cedula`, `Nombre`, `Apellido`, `Telefono`) VALUES
('1090493388', 'Danilo', 'Gomez', '3123504549'),
('1234', 'Andres', '25', ''),
('123654', 'Camilo', 'Hernandez', '231231412'),
('18945', 'Jairo', 'F', '3003504549'),
('2134234545654634', 'Marian', 'Barrera', '4324354534'),
('321', 'Julian', '30', ''),
('365f4', 'Camilo', 'Hernandez Patarrollo', '231231412'),
('6565656521212', 'Andres', 'Camilo', '6549897'),
('84526226', 'lorena', 'botia', '82162625'),
('874545132121', 'Maria', 'Jose', '5989636'),
('9797', 'Ana', '22', ''),
('9894566465', 'Jairo Antonio', 'Fuentes', '3003504566');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `Id_factura` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  `Cliente_Cliente` varchar(30) NOT NULL,
  `subtotal` int(11) NOT NULL,
  `IVA` int(30) NOT NULL,
  `Total` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`Id_factura`, `Fecha`, `Cliente_Cliente`, `subtotal`, `IVA`, `Total`) VALUES
(90934, '2023-07-06', '1090493388', 32500, 6175, 38675),
(90936, '2023-07-06', '1234', 25500, 4845, 30345),
(90937, '2023-07-08', '1090493388', 24000, 4560, 28560),
(90938, '2023-07-08', '84526226', 51000, 9690, 60690);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura_articulo`
--

CREATE TABLE `factura_articulo` (
  `id_factura_articulo` int(11) NOT NULL,
  `articulo_id` int(11) NOT NULL,
  `factura_id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `factura_articulo`
--

INSERT INTO `factura_articulo` (`id_factura_articulo`, `articulo_id`, `factura_id`, `nombre`, `cantidad`, `precio`) VALUES
(3, 22, 90934, 'Arroz', 5, 2500),
(4, 23, 90934, 'Azucar', 5, 4000),
(8, 22, 90936, 'Arroz', 3, 2500),
(9, 23, 90936, 'Azucar', 3, 4000),
(10, 24, 90936, 'Sal', 3, 2000),
(11, 22, 90937, 'Sal', 6, 2000),
(12, 24, 90937, 'Sal', 6, 2000),
(13, 22, 90938, 'Arroz', 2, 2500),
(14, 23, 90938, 'Azucar', 10, 4000),
(15, 24, 90938, 'Sal', 3, 2000);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `articulo`
--
ALTER TABLE `articulo`
  ADD PRIMARY KEY (`Id_Articulo`),
  ADD KEY `Id_Articulo` (`Id_Articulo`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`Cedula`),
  ADD KEY `Nombre_2` (`Nombre`),
  ADD KEY `Cedula` (`Cedula`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`Id_factura`),
  ADD KEY `Cliente_Cliente` (`Cliente_Cliente`) USING BTREE;

--
-- Indices de la tabla `factura_articulo`
--
ALTER TABLE `factura_articulo`
  ADD PRIMARY KEY (`id_factura_articulo`),
  ADD KEY `factura_articulo_ibfk_1` (`articulo_id`),
  ADD KEY `factura_articulo_ibfk_2` (`factura_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `articulo`
--
ALTER TABLE `articulo`
  MODIFY `Id_Articulo` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `Id_factura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=90946;

--
-- AUTO_INCREMENT de la tabla `factura_articulo`
--
ALTER TABLE `factura_articulo`
  MODIFY `id_factura_articulo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`Cliente_Cliente`) REFERENCES `cliente` (`Cedula`);

--
-- Filtros para la tabla `factura_articulo`
--
ALTER TABLE `factura_articulo`
  ADD CONSTRAINT `factura_articulo_ibfk_1` FOREIGN KEY (`articulo_id`) REFERENCES `articulo` (`Id_Articulo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `factura_articulo_ibfk_2` FOREIGN KEY (`factura_id`) REFERENCES `factura` (`Id_factura`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
