-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Sam 10 Décembre 2016 à 03:22
-- Version du serveur :  5.7.11
-- Version de PHP :  5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `kijiji2`
--

-- --------------------------------------------------------

--
-- Structure de la table `alerte`
--

CREATE TABLE `alerte` (
  `id` int(11) NOT NULL,
  `criteresRecherche` text NOT NULL,
  `dateDernierResultat` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `idMembre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `alerte`
--

INSERT INTO `alerte` (`id`, `criteresRecherche`, `dateDernierResultat`, `idMembre`) VALUES
(2, 'dishiduofhfniopsdabfousdb', '2016-12-10 00:15:15', 24),
(3, 'dishiduofhfniopsdabfousdb', '2016-12-10 00:15:15', 25),
(4, 'dishiduofhfniopsdabfousdb', '2016-12-10 00:15:15', 23),
(5, 'dishiduofhfniopsdabfousdb', '2016-12-10 00:15:15', 24);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `alerte`
--
ALTER TABLE `alerte`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `alerte`
--
ALTER TABLE `alerte`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
