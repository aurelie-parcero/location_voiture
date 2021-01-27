-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 27 jan. 2021 à 14:34
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
-- Base de données : `reservations`
--

-- --------------------------------------------------------

--
-- Structure de la table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
CREATE TABLE IF NOT EXISTS `reservations` (
  `booking_number` int(11) NOT NULL,
  `estimation_mileage` int(11) NOT NULL,
  `id_customer` bigint(20) DEFAULT NULL,
  `id_vehicle` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `invoice` int(11) NOT NULL,
  `mileage` int(11) NOT NULL,
  `pick_up_date` date DEFAULT NULL,
  `quote` float NOT NULL,
  `return_date` date DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`booking_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `reservations`
--

INSERT INTO `reservations` (`booking_number`, `estimation_mileage`, `id_customer`, `id_vehicle`, `invoice`, `mileage`, `pick_up_date`, `quote`, `return_date`, `type`) VALUES
(415263, 100, 9876, 'AB123CD', 123456, 12000, '2021-02-14', 449.5, '2021-02-15', 1),
(748596, 1000, 9876, 'AB123CD', 123456, 12000, '2021-02-14', 349.5, '2021-02-15', 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
