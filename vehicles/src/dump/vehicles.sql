-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 27 jan. 2021 à 09:22
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `vehicles`
--

-- --------------------------------------------------------

--
-- Structure de la table `vehicles`
--

DROP TABLE IF EXISTS `vehicles`;
CREATE TABLE IF NOT EXISTS `vehicles` (
  `license_plate` varchar(255) CHARACTER SET latin1 NOT NULL,
  `rachp` int(11) NOT NULL,
  `brand` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `color` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `cylinder` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `kilometer_rate` float NOT NULL,
  `model` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `price` float NOT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`license_plate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `vehicles`
--

INSERT INTO `vehicles` (`license_plate`, `rachp`, `brand`, `color`, `cylinder`, `kilometer_rate`, `model`, `price`, `type`) VALUES
('BD680BJ', 5, 'Peugeot', 'red', NULL, 1.5, '408', 10, 0),
('GH220GG', 5, 'Renault', 'silver', NULL, 1.5, 'Partner', 10, 2);

-- --------------------------------------------------------

--
-- Structure de la table `vehicle_is_booked`
--

DROP TABLE IF EXISTS `vehicle_is_booked`;
CREATE TABLE IF NOT EXISTS `vehicle_is_booked` (
  `vehicle_license_plate` varchar(255) CHARACTER SET latin1 NOT NULL,
  `is_booked` date DEFAULT NULL,
  KEY `FKa838yna6wq7iw1sgfxonl8a49` (`vehicle_license_plate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `vehicle_is_booked`
--
ALTER TABLE `vehicle_is_booked`
  ADD CONSTRAINT `FKa838yna6wq7iw1sgfxonl8a49` FOREIGN KEY (`vehicle_license_plate`) REFERENCES `vehicles` (`license_plate`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
