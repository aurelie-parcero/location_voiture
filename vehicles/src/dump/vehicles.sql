-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 28 jan. 2021 à 15:04
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
  `license_plate` varchar(255) NOT NULL,
  `rachp` int(11) NOT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `cylinder` varchar(255) DEFAULT NULL,
  `kilometer_rate` float NOT NULL,
  `model` varchar(255) DEFAULT NULL,
  `price` float NOT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`license_plate`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `vehicles`
--

INSERT INTO `vehicles` (`license_plate`, `rachp`, `brand`, `color`, `cylinder`, `kilometer_rate`, `model`, `price`, `type`) VALUES
('GH220GIU', 5, 'Audi', 'red', NULL, 1.5, 'Q3', 20, 0);

-- --------------------------------------------------------

--
-- Structure de la table `vehicle_is_booked`
--

DROP TABLE IF EXISTS `vehicle_is_booked`;
CREATE TABLE IF NOT EXISTS `vehicle_is_booked` (
  `vehicle_license_plate` varchar(255) NOT NULL,
  `is_booked` date DEFAULT NULL,
  KEY `FKa838yna6wq7iw1sgfxonl8a49` (`vehicle_license_plate`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `vehicle_is_booked`
--

INSERT INTO `vehicle_is_booked` (`vehicle_license_plate`, `is_booked`) VALUES
('GH220GIU', '2021-02-24'),
('GH220GIU', '2021-02-21'),
('GH220GIU', '2021-05-20'),
('GH220GIU', '2021-02-25'),
('GH220GIU', '2021-02-22'),
('GH220GIU', '2021-09-23');

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
