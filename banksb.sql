-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 07 juin 2022 à 12:44
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `banksb`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `code` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`code`, `email`, `nom`) VALUES
(1, 'picsou@gmail.com', 'picsou');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `type_cpte` varchar(2) NOT NULL,
  `code_compte` varchar(255) NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `solde` double NOT NULL,
  `taux` double DEFAULT NULL,
  `decouvert` double DEFAULT NULL,
  `code_client` bigint(20) DEFAULT NULL,
  `client_code` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`code_compte`),
  KEY `FK4j39u1ymy78ien5aes05ut81e` (`code_client`),
  KEY `FKk7jey77c2jxt4siax5ay5vk2n` (`client_code`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`type_cpte`, `code_compte`, `date_creation`, `solde`, `taux`, `decouvert`, `code_client`, `client_code`) VALUES
('CC', '1', '2022-05-16 04:27:35', 99969, 0.5, 19, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `employes`
--

DROP TABLE IF EXISTS `employes`;
CREATE TABLE IF NOT EXISTS `employes` (
  `code_employe` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom_employe` varchar(255) DEFAULT NULL,
  `code_emp_sup` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`code_employe`),
  KEY `FK23v4veeg6d1rml0cfu7i6j6jl` (`code_emp_sup`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `emp_gr`
--

DROP TABLE IF EXISTS `emp_gr`;
CREATE TABLE IF NOT EXISTS `emp_gr` (
  `num_emp` bigint(20) NOT NULL,
  `num_groupe` bigint(20) NOT NULL,
  KEY `FKpljewhl5d2nov2rqm0fgty9m4` (`num_groupe`),
  KEY `FKg8u4bpuos0cuhn8sk6glow981` (`num_emp`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `groupes`
--

DROP TABLE IF EXISTS `groupes`;
CREATE TABLE IF NOT EXISTS `groupes` (
  `code_groupe` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom_groupe` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`code_groupe`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(4),
(4);

-- --------------------------------------------------------

--
-- Structure de la table `operation`
--

DROP TABLE IF EXISTS `operation`;
CREATE TABLE IF NOT EXISTS `operation` (
  `type_op` varchar(1) NOT NULL,
  `numero` bigint(20) NOT NULL,
  `date_operation` datetime DEFAULT NULL,
  `montant` double NOT NULL,
  `code_cpte` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`numero`),
  KEY `FKkr9nfjf0ipqrw5xwcf9jqq6gv` (`code_cpte`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `operation`
--

INSERT INTO `operation` (`type_op`, `numero`, `date_operation`, `montant`, `code_cpte`) VALUES
('R', 1, '2022-05-26 04:28:37', 10, '1'),
('R', 2, '2022-05-26 04:47:58', 10, '1'),
('R', 3, '2022-06-07 12:22:31', 10, '1');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
