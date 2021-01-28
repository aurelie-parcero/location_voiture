-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 28 jan. 2021 à 12:21
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
-- Base de données : `billings`
--

-- --------------------------------------------------------

--
-- Structure de la table `billings`
--

DROP TABLE IF EXISTS `billings`;
CREATE TABLE IF NOT EXISTS `billings` (
  `booking_number` int(11) NOT NULL,
  `id_invoice` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `payable_amount` float NOT NULL,
  `payment_date` date DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`booking_number`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `billings`
--

INSERT INTO `billings` (`booking_number`, `id_invoice`, `payable_amount`, `payment_date`, `type`) VALUES
(161858, 'FAC45827', 865.98, '2021-01-21', 0),
(684231, 'FAC15351', 456.65, '2020-12-26', 1),
(254865, 'FAC16115', 678.8, '2021-01-09', 2);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
