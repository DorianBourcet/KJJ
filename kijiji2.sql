-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Mar 13 Décembre 2016 à 02:33
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
(50, 'Ordinateur portable MacBook', 'Vends laptop Apple MacBook Pro 2014\r\nBatterie correcte\r\nMac OS X El Capitan', 'null', 785, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'Usagé', '2016-12-13 01:15:24', 24, NULL),
(51, 'Téléphone Galaxy S2', 'Vends mon Samsung Galaxy S2, bon état général. Fonctionne encore très bien. Batterie neuve remplacée en octobre.', 'cellulaire', 56, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'occasion', '2016-12-13 01:16:37', 25, NULL),
(52, 'Enceinte Bluetooth', 'Speaker Bluetooth Bose bon état. Perdu emballage', '', 23, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'occasion', '2016-12-13 01:51:04', 25, NULL),
(53, 'Cross volé', 'Cabre même si la roue est voilée.', '', 300, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'occasion', '2016-12-13 01:59:22', 28, NULL),
(54, 'Téléphone Galaxy S2', 'Vends mon Samsung Galaxy S2, bon état général. Fonctionne encore très bien. Batterie neuve remplacée en octobre.', 'cellulaire', 56, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'occasion', '2016-12-13 01:17:08', 25, NULL),
(55, 'Téléphone Galaxy S2', 'Vends mon Samsung Galaxy S2, bon état général. Fonctionne encore très bien. Batterie neuve remplacée en octobre.', 'cellulaire', 56, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'occasion', '2016-12-13 01:17:27', 25, NULL),
(56, 'Téléphone Galaxy S2', 'Vends mon Samsung Galaxy S2, bon état général. Fonctionne encore très bien. Batterie neuve remplacée en octobre.', 'cellulaire', 56, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'occasion', '2016-12-13 01:17:34', 25, NULL),
(57, 'Téléphone Galaxy S2', 'Vends mon Samsung Galaxy S2, bon état général. Fonctionne encore très bien. Batterie neuve remplacée en octobre.', 'cellulaire', 56, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'occasion', '2016-12-13 01:17:42', 25, NULL),
(58, 'Téléphone Galaxy S2', 'Vends mon Samsung Galaxy S2, bon état général. Fonctionne encore très bien. Batterie neuve remplacée en octobre.', 'cellulaire', 56, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'occasion', '2016-12-13 01:17:48', 25, NULL),
(59, 'PlayStation 3', 'console en bon état avec jeux', '', 150, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'occasion', '2016-12-13 02:32:11', 25, NULL),
(60, 'Téléphone Galaxy S2', 'Vends mon Samsung Galaxy S2, bon état général. Fonctionne encore très bien. Batterie neuve remplacée en octobre.', 'cellulaire', 56, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'occasion', '2016-12-13 01:17:57', 25, NULL),
(61, 'Galaxy S3', 'Vends mon Samsung Galaxy S3', 'cellulaire', 56, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'occasion', '2016-12-13 02:29:16', 25, NULL),
(62, 'Téléphone Galaxy S2', 'Vends mon Samsung Galaxy S2, bon état général. Fonctionne encore très bien. Batterie neuve remplacée en octobre.', 'cellulaire', 56, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'occasion', '2016-12-13 01:18:12', 25, NULL),
(63, 'Téléphone Galaxy S2', 'Vends mon Samsung Galaxy S2, bon état général. Fonctionne encore très bien. Batterie neuve remplacée en octobre.', 'cellulaire', 56, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'occasion', '2016-12-13 01:18:24', 25, NULL),
(64, 'Téléphone Galaxy S2', 'Vends mon Samsung Galaxy S2, bon état général. Fonctionne encore très bien. Batterie neuve remplacée en octobre.', 'cellulaire', 56, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'occasion', '2016-12-13 01:18:24', 25, NULL),
(65, 'Téléphone Galaxy S2', 'Vends mon Samsung Galaxy S2, bon état général. Fonctionne encore très bien. Batterie neuve remplacée en octobre.', 'cellulaire', 56, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'occasion', '2016-12-13 01:18:34', 25, NULL),
(68, 'Téléphone Galaxy S2', 'Vends mon Samsung Galaxy S2, bon état général. Fonctionne encore très bien. Batterie neuve remplacée en octobre.', 'cellulaire', 56, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'occasion', '2016-12-13 01:20:09', 25, NULL),
(71, 'Sony Xperia', 'À vendre Sony Xperia', 'cellulaire', 56, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'occasion', '2016-12-13 02:06:49', 28, NULL),
(72, 'Pneus neige', 'Lot de 4 pneus neige bon état', 'null', 120, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'occasion', '2016-12-13 02:07:50', 28, NULL),
(73, 'Pneus hiver', 'Lot de 4 pneus neige bon état', 'null', 120, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'occasion', '2016-12-13 02:08:14', 25, NULL),
(74, 'Manteau hiver bleu', 'Canada Goose', 'null', 120, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'occasion', '2016-12-13 02:08:50', 25, NULL),
(75, 'Horloge murale', 'Horloge murale à affichage numérique', 'null', 100, 'Montréal', 'H1T1T1', 'QC', 'Canada', 'occasion', '2016-12-13 02:09:28', 25, NULL);

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
(24, 'Dodo', 'dodo', 'Dorian', 'Bourcet', 'dodo@dodo.com', '', '5235', 'rue Desmarteau', '', '', 'Montréal', 'H1K 2N7', 'Québec', 'Canada', 0),
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
(1, 24, 25, 'Ceci est un message test hahahah', '2016-12-11 17:26:32', 1),
(2, 24, 25, 'Ceci est un test de message', '2016-12-11 17:26:32', 1),
(3, 24, 25, 'Ceci est un test de message', '2016-12-11 17:26:32', 1),
(4, 24, 25, 'Ceci est un test de message', '2016-12-11 17:26:32', 1),
(5, 24, 25, 'Ceci est un test de message', '2016-12-11 17:26:32', 1),
(6, 24, 25, 'Ceci est un test de message', '2016-12-11 17:26:32', 1),
(7, 25, 24, 'Test message', '2016-12-11 17:26:32', 1),
(8, 24, 25, 'Test message haha', '2016-12-11 17:26:32', 1),
(9, 25, 24, 'Test message', '2016-12-11 17:26:32', 1),
(10, 24, 25, 'Test message haha hehe', '2016-12-11 17:26:32', 1),
(11, 28, 24, 'ofgashkjfdasg', '2016-12-08 03:04:55', 0),
(12, 24, 26, 'ghghdfh', '2016-12-11 19:03:19', 1),
(13, 24, 25, 'hey', '2016-12-11 17:26:32', 1),
(14, 25, 28, 'Salut', '2016-12-13 02:15:06', 1),
(15, 25, 28, 'Salut', '2016-12-13 02:15:06', 1),
(16, 24, 26, 'Salut', '2016-12-11 19:03:19', 1),
(17, 28, 24, 'Salut', '2016-12-08 05:33:43', 0),
(18, 24, 26, 'Salut', '2016-12-11 19:03:19', 1),
(19, 24, 28, 'Salut', '2016-12-08 06:09:41', 0),
(20, 24, 28, 'Salut', '2016-12-08 06:10:19', 0),
(21, 28, 25, 'Salut!', '2016-12-13 02:15:06', 1),
(22, 28, 25, 'Salut!', '2016-12-13 02:15:06', 1),
(23, 26, 24, 'Salut!!', '2016-12-11 19:03:19', 1),
(24, 26, 28, 'Salut!!', '2016-12-08 15:04:03', 0),
(25, 26, 25, 'Salut!', '2016-12-08 15:05:11', 0),
(26, 26, 25, 'Salut!', '2016-12-08 15:05:51', 0),
(27, 26, 25, 'Salut!', '2016-12-08 15:07:24', 0),
(28, 26, 25, 'Salut!', '2016-12-08 15:09:18', 0),
(29, 26, 24, 'Salut', '2016-12-11 19:03:19', 1),
(30, 28, 25, 'Salut!', '2016-12-13 02:15:06', 1),
(31, 28, 24, 'Salut!', '2016-12-08 15:23:36', 0),
(32, 26, 28, 'Salut', '2016-12-08 15:36:35', 0),
(33, 26, 28, 'Salut', '2016-12-08 15:36:39', 0),
(34, 28, 24, 'Wesh alors', '2016-12-11 07:04:29', 0),
(38, 24, 26, 'Wesh alors', '2016-12-11 19:03:19', 1),
(39, 28, 25, 'null', '2016-12-13 02:15:06', 1);

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

-- --------------------------------------------------------

--
-- Structure de la table `type_cellulaire`
--

CREATE TABLE `type_cellulaire` (
  `idAnnonce` int(11) NOT NULL,
  `marque` varchar(25) DEFAULT NULL,
  `nomCommercial` varchar(25) DEFAULT NULL,
  `modele` varchar(25) DEFAULT NULL,
  `capaciteStockage` int(11) DEFAULT '-1',
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
(51, 'Samsung', 'Galaxy S II', 'GT-I9100', 16, 'MicroSD', 'HSPA+', 'Noir', 'Android 4.1', '480*800', 4.3, 'Li-ion', 2300),
(53, 'Samsung', 'Galaxy S II', 'GT-I9100', 16, 'MicroSD', 'HSPA+', 'Noir', 'Android 4.1', '480*800', 4.3, 'Li-ion', 2300),
(54, 'Samsung', 'Galaxy S II', 'GT-I9100', 16, 'MicroSD', 'HSPA+', 'Noir', 'Android 4.1', '480*800', 4.3, 'Li-ion', 2300),
(55, 'Samsung', 'Galaxy S II', 'GT-I9100', 16, 'MicroSD', 'HSPA+', 'Noir', 'Android 4.1', '480*800', 4.3, 'Li-ion', 2300),
(56, 'Samsung', 'Galaxy S II', 'GT-I9100', 16, 'MicroSD', 'HSPA+', 'Noir', 'Android 4.1', '480*800', 4.3, 'Li-ion', 2300),
(57, 'Samsung', 'Galaxy S II', 'GT-I9100', 16, 'MicroSD', 'HSPA+', 'Noir', 'Android 4.1', '480*800', 4.3, 'Li-ion', 2300),
(58, 'Samsung', 'Galaxy S II', 'GT-I9100', 16, 'MicroSD', 'HSPA+', 'Noir', 'Android 4.1', '480*800', 4.3, 'Li-ion', 2300),
(60, 'Samsung', 'Galaxy S II', 'GT-I9100', 16, 'MicroSD', 'HSPA+', 'Noir', 'Android 4.1', '480*800', 4.3, 'Li-ion', 2300),
(61, 'Samsung', 'Galaxy S II', 'GT-I9100', 16, 'MicroSD', 'HSPA+', 'Noir', 'Android 4.1', '480*800', 4.3, 'Li-ion', 2300),
(62, 'Samsung', 'Galaxy S II', 'GT-I9100', 16, 'MicroSD', 'HSPA+', 'Noir', 'Android 4.1', '480*800', 4.3, 'Li-ion', 2300),
(63, 'Samsung', 'Galaxy S II', 'GT-I9100', 16, 'MicroSD', 'HSPA+', 'Noir', 'Android 4.1', '480*800', 4.3, 'Li-ion', 2300),
(64, 'Samsung', 'Galaxy S II', 'GT-I9100', 16, 'MicroSD', 'HSPA+', 'Noir', 'Android 4.1', '480*800', 4.3, 'Li-ion', 2300),
(65, 'Samsung', 'Galaxy S II', 'GT-I9100', 16, 'MicroSD', 'HSPA+', 'Noir', 'Android 4.1', '480*800', 4.3, 'Li-ion', 2300),
(66, 'Samsung', 'Galaxy S II', 'GT-I9100', 16, 'MicroSD', 'HSPA+', 'Noir', 'Android 4.1', '480*800', 4.3, 'Li-ion', 2300),
(67, 'Samsung', 'Galaxy S II', 'GT-I9100', 16, 'MicroSD', 'HSPA+', 'Noir', 'Android 4.1', '480*800', 4.3, 'Li-ion', 2300),
(68, 'Samsung', 'Galaxy S II', 'GT-I9100', 16, 'MicroSD', 'HSPA+', 'Noir', 'Android 4.1', '480*800', 4.3, 'Li-ion', 2300),
(71, 'Sony', 'Galaxy S II', 'GT-I9100', 16, 'MicroSD', 'HSPA+', 'Noir', 'Android 4.1', '480*800', 4.3, 'Li-ion', 2300);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=76;
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
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
