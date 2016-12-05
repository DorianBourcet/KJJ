-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Lun 05 Décembre 2016 à 23:12
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
-- Structure de la table `annonce`
--

CREATE TABLE `annonce` (
  `id` int(11) NOT NULL,
  `titre` varchar(50) NOT NULL,
  `description` text,
  `typeObjet` varchar(25) DEFAULT NULL,
  `adresse_ville` varchar(30) NOT NULL,
  `adresse_codePostal` varchar(10) NOT NULL,
  `adresse_province` varchar(30) NOT NULL,
  `adresse_pays` varchar(30) NOT NULL,
  `etatObjet` varchar(25) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `idMembre` int(11) NOT NULL,
  `etat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `membre`
--

CREATE TABLE `membre` (
  `id` int(11) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `avatar` longblob,
  `adresse_numero` varchar(25) DEFAULT NULL,
  `adresse_rue1` varchar(25) DEFAULT NULL,
  `adresse_rue2` varchar(25) DEFAULT NULL,
  `adresse_appartement` varchar(25) DEFAULT NULL,
  `adresse_ville` varchar(25) DEFAULT NULL,
  `adresse_codePostal` varchar(25) DEFAULT NULL,
  `adresse_province` varchar(25) DEFAULT NULL,
  `adresse_pays` varchar(25) NOT NULL,
  `quoideneuf` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `membre`
--

INSERT INTO `membre` (`id`, `username`, `password`, `nom`, `prenom`, `email`, `avatar`, `adresse_numero`, `adresse_rue1`, `adresse_rue2`, `adresse_appartement`, `adresse_ville`, `adresse_codePostal`, `adresse_province`, `adresse_pays`, `quoideneuf`) VALUES
(23, '', '', 'Smith', 'John', '', '', '', '', '', '', '', '', '', 'Canada', 0),
(24, 'Dodo', 'dodo', 'Dorian', 'Bourcet', 'dodo@dodo.com', '', '5235', 'rue Desmarteau', '', '', 'Montréal', 'H1K 2N7', 'Québec', 'Canada', 0),
(25, 'Toto', 'toto', 'tototo', 'to', '', '', '', '', '', '', '', '', '', 'Canada', 0);

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE `message` (
  `id` int(11) NOT NULL,
  `idExpediteur` int(11) NOT NULL,
  `idDestinataire` int(11) NOT NULL,
  `contenu` text NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `lu` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `type_automobile`
--

CREATE TABLE `type_automobile` (
  `idAnnonce` int(11) NOT NULL,
  `marque` varchar(25) NOT NULL,
  `modele` varchar(25) NOT NULL,
  `puissance` int(11) NOT NULL,
  `annee` int(11) NOT NULL,
  `carburant` varchar(25) NOT NULL,
  `nombrePortes` int(11) NOT NULL,
  `couleur` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `type_cellulaire`
--

CREATE TABLE `type_cellulaire` (
  `idAnnonce` int(11) NOT NULL,
  `marque` varchar(25) NOT NULL,
  `nomCommercial` varchar(25) NOT NULL,
  `modele` varchar(25) NOT NULL,
  `capaciteStockage` int(11) NOT NULL,
  `stockageExterne` varchar(25) NOT NULL,
  `typeReseau` varchar(25) NOT NULL,
  `Couleur` varchar(25) NOT NULL,
  `systemeExploitation` varchar(25) NOT NULL,
  `typeEcran` varchar(25) NOT NULL,
  `tailleEcran` int(11) NOT NULL,
  `typeBatterie` varchar(25) NOT NULL,
  `capaciteBatterie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `membre`
--
ALTER TABLE `membre`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `index_username` (`username`);

--
-- Index pour la table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `annonce`
--
ALTER TABLE `annonce`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `membre`
--
ALTER TABLE `membre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT pour la table `message`
--
ALTER TABLE `message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
