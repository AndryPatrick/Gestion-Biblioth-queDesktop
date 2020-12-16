-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mar 08 Novembre 2016 à 06:01
-- Version du serveur :  5.6.26
-- Version de PHP :  5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestion_bibliotheque`
--

-- --------------------------------------------------------

--
-- Structure de la table `lecteur`
--

CREATE TABLE IF NOT EXISTS `lecteur` (
  `NUMLECTEUR` varchar(255) NOT NULL,
  `NOM` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `lecteur`
--

INSERT INTO `lecteur` (`NUMLECTEUR`, `NOM`) VALUES
('2', 'Cynthia'),
('3', 'Rinah'),
('4', 'Romi'),
('5', 'zero'),
('6', 'henr3');

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

CREATE TABLE IF NOT EXISTS `livre` (
  `NUMLIVRE` varchar(255) NOT NULL,
  `DESIGNATION` varchar(255) NOT NULL,
  `TITRE` varchar(255) NOT NULL,
  `AUTEUR` varchar(255) DEFAULT NULL,
  `DATE_EDITION` date DEFAULT NULL,
  `DISPONIBLE` varchar(255) DEFAULT NULL,
  `NBFOISPRET` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `livre`
--

INSERT INTO `livre` (`NUMLIVRE`, `DESIGNATION`, `TITRE`, `AUTEUR`, `DATE_EDITION`, `DISPONIBLE`, `NBFOISPRET`) VALUES
('L0011', 'Physique', 'Les elements chimique', 'La voisine', '2016-10-11', 'Oui', '1'),
('LI0001', 'Mathematique', 'Livre noire', 'Thales', '1996-08-01', 'Non', '1'),
('LI0002', 'Physique', 'Mecanique', 'Newton', '1996-09-01', 'Oui', '1'),
('LI0003', 'SVT', 'Le vaccin', 'Edward Jenner', '1996-10-01', 'Oui', '1'),
('LI0004', 'Français', 'La grande vacances', 'Pierre', '1996-11-01', 'Oui', '1'),
('LI0005', 'Histoire', 'La 1ère Guerre Mondiale', 'Lenine', '1996-12-01', 'Non', '1'),
('LI0006', 'Geographie', 'Le temps', 'Cristophe', '1997-01-01', 'Oui', '1'),
('LI0007', 'Allemand', 'Ihr und wir plus', 'Markus', '1997-02-01', 'Oui', '1'),
('LI0008', 'Anglais', 'Grammar in use', 'Christine', '1997-03-01', 'Oui', '1'),
('LI0009', 'Philosophie', 'Le Discours de la Methode', 'Rene descartes', '1997-04-01', 'Oui', '1'),
('LI0010', 'Malagasy', 'Ho Avy Ny Maraina', 'Clarisse Ratsifandriamanana', '1997-05-01', 'Oui', '1');

-- --------------------------------------------------------

--
-- Structure de la table `pret`
--

CREATE TABLE IF NOT EXISTS `pret` (
  `NUMPRET` varchar(255) NOT NULL,
  `LECTEURNUM` varchar(255) NOT NULL,
  `LIVRENUM` varchar(255) NOT NULL,
  `DATEPRET` date DEFAULT NULL,
  `DATERETOUR` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `pret`
--

INSERT INTO `pret` (`NUMPRET`, `LECTEURNUM`, `LIVRENUM`, `DATEPRET`, `DATERETOUR`) VALUES
('PR0001', '3', 'LI0008', '2016-10-15', '2016-10-25'),
('PR0003', '3', 'LI0004', '2015-08-30', '2015-09-06'),
('PR0005', '4', 'LI0004', '2015-09-11', '2015-09-18'),
('PR0013', '2', 'LI0003', '2015-08-29', '2015-09-05'),
('PR0015', '4', 'LI0010', '2015-12-11', '2015-12-18'),
('PR0016', '6', 'LI0001', '2016-10-15', '2016-10-22'),
('PR0017', '4', 'LI0010', '2016-10-15', '2016-10-22'),
('PR0018', '4', 'LI0003', '2016-10-16', '2016-11-04');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL,
  `Login` varchar(40) NOT NULL,
  `Password` varchar(40) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id`, `Login`, `Password`) VALUES
(2, 'pa', 'pa'),
(3, 'pa', 'pa');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `lecteur`
--
ALTER TABLE `lecteur`
  ADD PRIMARY KEY (`NUMLECTEUR`);

--
-- Index pour la table `livre`
--
ALTER TABLE `livre`
  ADD PRIMARY KEY (`NUMLIVRE`);

--
-- Index pour la table `pret`
--
ALTER TABLE `pret`
  ADD PRIMARY KEY (`NUMPRET`),
  ADD KEY `I_FK_PRET_LECTEUR` (`LECTEURNUM`),
  ADD KEY `I_FK_PRET_LIVRE` (`LIVRENUM`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `pret`
--
ALTER TABLE `pret`
  ADD CONSTRAINT `pret_ibfk_1` FOREIGN KEY (`LECTEURNUM`) REFERENCES `lecteur` (`NUMLECTEUR`),
  ADD CONSTRAINT `pret_ibfk_2` FOREIGN KEY (`LIVRENUM`) REFERENCES `livre` (`NUMLIVRE`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
