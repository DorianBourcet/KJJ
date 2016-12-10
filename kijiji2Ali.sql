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

-- --------------------------------------------------------

--
-- Structure de la table `annonce`
--

CREATE TABLE `annonce` (
  `id` int(11) NOT NULL,
  `titre` varchar(50) NOT NULL,
  `description` text,
  `typeObjet` varchar(25) DEFAULT NULL,
  `prix` double NOT NULL,
  `adresse_ville` varchar(30) NOT NULL,
  `adresse_codePostal` varchar(10) NOT NULL,
  `adresse_province` varchar(30) NOT NULL,
  `adresse_pays` varchar(30) NOT NULL,
  `etatObjet` varchar(25) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `idMembre` int(11) NOT NULL,
  `etat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `annonce`
--

INSERT INTO `annonce` (`id`, `titre`, `description`, `typeObjet`, `prix`, `adresse_ville`, `adresse_codePostal`, `adresse_province`, `adresse_pays`, `etatObjet`, `date`, `idMembre`, `etat`) VALUES
(1, 'Je vends mon nokia lumia', 'je vends mon nokia lumia 850. il est usagé je le possède depuis 3 ans et je veux m\'en débarrassée pour le modèle 900.', 'cellulaire', 45.62, 'beaubien', 'H1H5G6', 'Quebec', 'Canada', 'usagé', '2016-12-07 22:22:00', 24, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

CREATE TABLE `commentaire` (
  `id` int(11) NOT NULL,
  `contenu` text NOT NULL,
  `idMembre` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `evaluation`
--

CREATE TABLE `evaluation` (
  `id` int(11) NOT NULL,
  `contenu` text NOT NULL,
  `note` int(3) NOT NULL,
  `idMembre` int(11) NOT NULL,
  `idAnnonce` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `favoris`
--

CREATE TABLE `favoris` (
  `id` int(11) NOT NULL,
  `idMembre` int(11) NOT NULL,
  `idAnnonce` int(11) NOT NULL
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

--
-- Contenu de la table `message`
--

INSERT INTO `message` (`id`, `idExpediteur`, `idDestinataire`, `contenu`, `date`, `lu`) VALUES
(1, 24, 25, 'Salut', '2016-12-07 20:40:20', 0),
(2, 24, 25, 'je m\'appelle dodo', '2016-12-07 20:40:20', 0),
(3, 25, 24, 'salut dodo', '2016-12-07 20:44:35', 0),
(4, 25, 24, 'je me nomme toto', '2016-12-07 20:44:35', 0);

-- --------------------------------------------------------

--
-- Structure de la table `notification`
--

CREATE TABLE `notification` (
  `id` int(11) NOT NULL,
  `type` varchar(50) NOT NULL,
  `titre` varchar(50) NOT NULL,
  `idMembre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `transaction`
--

CREATE TABLE `transaction` (
  `id` int(11) NOT NULL,
  `idAcheteur` int(11) NOT NULL,
  `idVendeur` int(11) NOT NULL,
  `titreAnnonce` varchar(50) NOT NULL,
  `montant` double NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `transaction`
--

INSERT INTO `transaction` (`id`, `idAcheteur`, `idVendeur`, `titreAnnonce`, `montant`, `date`) VALUES
(1, 24, 25, 'Ceci est un nom test hahahah', 25.45, '2016-12-07 22:05:52');

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
-- Index pour la table `alerte`
--
ALTER TABLE `alerte`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `evaluation`
--
ALTER TABLE `evaluation`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `favoris`
--
ALTER TABLE `favoris`
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
-- Index pour la table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `alerte`
--
ALTER TABLE `alerte`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `annonce`
--
ALTER TABLE `annonce`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `commentaire`
--
ALTER TABLE `commentaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `evaluation`
--
ALTER TABLE `evaluation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `favoris`
--
ALTER TABLE `favoris`
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `notification`
--
ALTER TABLE `notification`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
