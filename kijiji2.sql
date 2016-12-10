-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Sam 10 Décembre 2016 à 13:48
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
  `prix` double NOT NULL DEFAULT '0',
  `adresse_ville` varchar(30) DEFAULT NULL,
  `adresse_codePostal` varchar(10) DEFAULT NULL,
  `adresse_province` varchar(30) DEFAULT NULL,
  `adresse_pays` varchar(30) DEFAULT NULL,
  `etatObjet` varchar(25) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `idMembre` int(11) NOT NULL,
  `etat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `annonce`
--

INSERT INTO `annonce` (`id`, `titre`, `description`, `typeObjet`, `prix`, `adresse_ville`, `adresse_codePostal`, `adresse_province`, `adresse_pays`, `etatObjet`, `date`, `idMembre`, `etat`) VALUES
(1, 'Mazda 3', 'null', 'automobile', 30.25, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'neuf', '2016-12-08 15:44:49', 25, NULL),
(2, 'Mazda 3', 'null', 'automobile', 30.25, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'neuf', '2016-12-08 15:45:28', 25, NULL),
(3, 'Mazda 4', 'null', 'automobile', 30.25, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'neuf', '2016-12-08 15:47:02', 25, NULL),
(4, 'Mazda 4', 'null', 'automobile', 30.25, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'neuf', '2016-12-08 15:48:27', 25, NULL),
(5, 'Mazda 4', 'null', 'automobile', 30.25, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'neuf', '2016-12-08 16:11:26', 25, NULL),
(6, 'Mazda 4', 'null', 'automobile', 30.25, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'neuf', '2016-12-08 16:14:26', 25, NULL),
(7, 'Mazda 4', 'null', 'automobile', 30.25, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'neuf', '2016-12-08 16:15:54', 25, NULL),
(8, 'Mazda 4', 'null', 'automobile', 30.25, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'neuf', '2016-12-08 16:16:27', 25, NULL),
(9, 'Mazda 4', 'null', 'automobile', 30.25, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'neuf', '2016-12-08 16:16:50', 25, NULL),
(10, 'Mazda 4', 'null', 'automobile', 30.25, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'neuf', '2016-12-08 16:17:42', 25, NULL),
(11, 'Mazda 4', 'null', 'automobile', 30.25, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'neuf', '2016-12-08 16:18:52', 25, NULL),
(12, 'Mazda 4', 'null', 'automobile', 30.25, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'neuf', '2016-12-08 16:19:41', 25, NULL),
(13, 'Mazda 4', 'null', 'automobile', 30.25, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'neuf', '2016-12-08 16:20:29', 25, NULL),
(14, 'Mazda 4', 'null', 'automobile', 30.25, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'neuf', '2016-12-08 16:21:44', 25, NULL),
(15, 'Mazda 4', 'null', 'automobile', 30.25, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'neuf', '2016-12-08 16:22:01', 25, NULL),
(16, 'Mazda 4', 'null', 'automobile', 30.25, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'neuf', '2016-12-08 16:24:32', 25, NULL),
(17, 'Mazda 4', 'null', 'automobile', 30.25, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'neuf', '2016-12-08 16:26:46', 25, NULL),
(20, 'Téléphone Galaxy S2', 'Vends mon Samsung Galaxy S2, bon état général. Fonctionne encore très bien. Batterie neuve remplacée en octobre.', 'cellulaire', 56, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'occasion', '2016-12-09 20:58:18', 25, NULL);

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
  `quoideneuf` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `membre`
--

INSERT INTO `membre` (`id`, `username`, `password`, `nom`, `prenom`, `email`, `avatar`, `adresse_numero`, `adresse_rue1`, `adresse_rue2`, `adresse_appartement`, `adresse_ville`, `adresse_codePostal`, `adresse_province`, `adresse_pays`, `quoideneuf`) VALUES
(23, '', '', 'Smith', 'John', '', '', '', '', '', '', '', '', '', 'Canada', 0),
(24, 'Dodo', 'dodo', 'Dorian', 'Bourcet', 'dodo@dodo.com', '', '5235', 'rue Desmarteau', '', '', 'Montréal', 'H1K 2N7', 'Québec', 'Canada', 1),
(25, 'Toto', 'toto', 'tototo', 'to', '', '', '', '', '', '', '', '', '', 'Canada', 1),
(26, 'jycy', 'jycy', 'Faul', 'JC', 'jcf', NULL, '445', 'rue BEaubien', '', '5', 'Montréal', 'HiT1T1', 'QC', 'Canada', 1),
(28, 'Jul', 'jul', 'Jul', 'Jul', 'jul@weshalors.fr', NULL, '', '', '', '', '', '', 'QC', 'Canada', 1);

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
(1, 24, 25, 'Ceci est un message test hahahah', '2016-12-06 18:40:23', 0),
(2, 24, 25, 'Ceci est un test de message', '2016-12-06 23:18:00', 0),
(3, 24, 25, 'Ceci est un test de message', '2016-12-06 23:18:30', 0),
(4, 24, 25, 'Ceci est un test de message', '2016-12-06 23:19:11', 0),
(5, 24, 25, 'Ceci est un test de message', '2016-12-06 23:20:39', 0),
(6, 24, 25, 'Ceci est un test de message', '2016-12-06 23:23:11', 0),
(7, 25, 24, 'Test message', '2016-12-07 20:40:10', 0),
(8, 24, 25, 'Test message haha', '2016-12-07 20:42:46', 0),
(9, 25, 24, 'Test message', '2016-12-07 20:47:16', 0),
(10, 24, 25, 'Test message haha hehe', '2016-12-08 02:23:37', 0),
(11, 28, 24, 'ofgashkjfdasg', '2016-12-08 03:04:55', 0),
(12, 24, 26, 'ghghdfh', '2016-12-08 03:03:43', 0),
(13, 24, 25, 'hey', '2016-12-08 03:09:28', 0),
(14, 25, 28, 'Salut', '2016-12-08 05:08:33', 0),
(15, 25, 28, 'Salut', '2016-12-08 05:08:52', 0),
(16, 24, 26, 'Salut', '2016-12-08 05:29:54', 0),
(17, 28, 24, 'Salut', '2016-12-08 05:33:43', 0),
(18, 24, 26, 'Salut', '2016-12-08 05:57:57', 0),
(19, 24, 28, 'Salut', '2016-12-08 06:09:41', 0),
(20, 24, 28, 'Salut', '2016-12-08 06:10:19', 0),
(21, 28, 25, 'Salut!', '2016-12-08 14:55:03', 0),
(22, 28, 25, 'Salut!', '2016-12-08 14:56:16', 0),
(23, 26, 24, 'Salut!!', '2016-12-08 15:03:44', 0),
(24, 26, 28, 'Salut!!', '2016-12-08 15:04:03', 0),
(25, 26, 25, 'Salut!', '2016-12-08 15:05:11', 0),
(26, 26, 25, 'Salut!', '2016-12-08 15:05:51', 0),
(27, 26, 25, 'Salut!', '2016-12-08 15:07:24', 0),
(28, 26, 25, 'Salut!', '2016-12-08 15:09:18', 0),
(29, 26, 24, 'Salut', '2016-12-08 15:19:07', 0),
(30, 28, 25, 'Salut!', '2016-12-08 15:20:42', 0),
(31, 28, 24, 'Salut!', '2016-12-08 15:23:36', 0),
(32, 26, 28, 'Salut', '2016-12-08 15:36:35', 0),
(33, 26, 28, 'Salut', '2016-12-08 15:36:39', 0);

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
  `kilometrage` int(11) NOT NULL,
  `annee` int(11) NOT NULL,
  `carburant` varchar(25) NOT NULL,
  `nombrePortes` int(11) NOT NULL,
  `couleur` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `type_automobile`
--

INSERT INTO `type_automobile` (`idAnnonce`, `marque`, `modele`, `puissance`, `kilometrage`, `annee`, `carburant`, `nombrePortes`, `couleur`) VALUES
(16, 'Mazda', '4', 120, 120, 2010, 'Diesel', 5, 'bleue'),
(17, 'Mazda', '4', 120, 120, 2010, 'Diesel', 5, 'bleue');

-- --------------------------------------------------------

--
-- Structure de la table `type_cellulaire`
--

CREATE TABLE `type_cellulaire` (
  `idAnnonce` int(11) DEFAULT NULL,
  `marque` varchar(25) DEFAULT NULL,
  `nomCommercial` varchar(25) DEFAULT NULL,
  `modele` varchar(25) DEFAULT NULL,
  `capaciteStockage` int(11) DEFAULT NULL,
  `stockageExterne` varchar(25) DEFAULT NULL,
  `typeReseau` varchar(25) DEFAULT NULL,
  `couleur` varchar(25) DEFAULT NULL,
  `systemeExploitation` varchar(25) DEFAULT NULL,
  `resolutionEcran` varchar(25) DEFAULT NULL,
  `tailleEcran` float DEFAULT NULL,
  `typeBatterie` varchar(25) DEFAULT NULL,
  `capaciteBatterie` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `type_cellulaire`
--

INSERT INTO `type_cellulaire` (`idAnnonce`, `marque`, `nomCommercial`, `modele`, `capaciteStockage`, `stockageExterne`, `typeReseau`, `couleur`, `systemeExploitation`, `resolutionEcran`, `tailleEcran`, `typeBatterie`, `capaciteBatterie`) VALUES
(20, 'Samsung', 'Galaxy S II', 'GT-I9100', 16, 'MicroSD', 'HSPA+', 'Noir', 'Android 4.1', '480*800', 4, 'Li-ion', 2300);

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
-- Index pour la table `type_automobile`
--
ALTER TABLE `type_automobile`
  ADD UNIQUE KEY `idAnnonce` (`idAnnonce`);

--
-- Index pour la table `type_cellulaire`
--
ALTER TABLE `type_cellulaire`
  ADD UNIQUE KEY `idAnnonce` (`idAnnonce`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT pour la table `message`
--
ALTER TABLE `message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
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
