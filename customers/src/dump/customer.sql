-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 27 jan. 2021 à 09:21
-- Version du serveur :  5.7.26
-- Version de PHP :  7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `customers`
--

-- --------------------------------------------------------

--
-- Structure de la table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `drivinglicensenumber` bigint(20) NOT NULL,
  `currentrental` tinyint(1) DEFAULT '0',
  `dateofbirth` datetime(6) DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `firstname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `lastname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phonenumber` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`drivinglicensenumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `customer`
--

INSERT INTO `customer` (`drivinglicensenumber`, `currentrental`, `dateofbirth`, `email`, `firstname`, `lastname`, `phonenumber`) VALUES
(210692106969, 0, '2014-01-01 00:00:00.000000', 'pierre.galilelo@gmail.com', 'Pierre', 'Galileo', '0619184698'),
(210692106994, 0, '2000-01-01 00:00:00.000000', 'sancho.rodrigez@gmail.com', 'Sancho', 'Rodigez', '0619180825'),
(210692106995, 0, '1998-01-01 00:00:00.000000', 'liliane.elpepe@gmail.com', 'Liliane', 'Elpepe', '0619180826'),
(210692109469, 0, '1985-01-01 00:00:00.000000', 'tuyo.lechat@gmail.com', 'Tuyo', 'Lechat', '0619197549'),
(210692109879, 0, '2016-01-01 00:00:00.000000', 'kelly.liamero@gmail.com', 'Kelly', 'Liamero', '0619197548');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
