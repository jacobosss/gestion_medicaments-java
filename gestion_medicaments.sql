-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 06, 2022 at 12:40 PM
-- Server version: 5.7.11
-- PHP Version: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestion_medicaments`
--

-- --------------------------------------------------------

--
-- Table structure for table `dosages`
--

CREATE TABLE `dosages` (
  `DOS_CODE` int(10) NOT NULL,
  `DOS_QUANTITE` varchar(10) NOT NULL,
  `DOS_UNITE` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dosages`
--

INSERT INTO `dosages` (`DOS_CODE`, `DOS_QUANTITE`, `DOS_UNITE`) VALUES
(1, '2/J', 'Gélule de 5mg'),
(2, '3/J', 'Poudres de 3mg'),
(3, '1/J', 'Sirop 5ml'),
(4, '6/J', 'Suppositoire'),
(5, '8/J', 'Comprimé de 5mg'),
(6, '6/J', 'Sirop 6ml'),
(7, '1/J', 'Suppositoire'),
(8, '3/J', 'Poudre de 2mg'),
(9, '6/J', 'Gélule de 4mg'),
(10, '7/J', 'Comprimé de 5mg'),
(11, '4/J', 'Poudre DE 7mg'),
(12, '8/J', 'Suppositoire'),
(13, '7/J', 'Sirop de 7ml'),
(14, '6/J', 'Gélule de 3mg'),
(15, '4/J', 'Poudre de 8mg');

-- --------------------------------------------------------

--
-- Table structure for table `famille`
--

CREATE TABLE `famille` (
  `FAM_CODE` int(3) NOT NULL,
  `FAM_LIBELLE` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `famille`
--

INSERT INTO `famille` (`FAM_CODE`, `FAM_LIBELLE`) VALUES
(1, 'Antidépresseur'),
(2, 'Antistaminique'),
(3, 'Antibiotique'),
(4, 'Anti-hypertenseur'),
(5, 'Anxiolytique'),
(6, 'Anti-inflammatoire'),
(7, 'Antifongique'),
(8, 'Anti-infectieux'),
(9, 'Antiviraux'),
(10, 'Antituberculeux'),
(11, 'Antidiabétique'),
(12, 'Laxatif'),
(13, 'Immunodépresseur'),
(14, 'Antalgique'),
(15, 'Vasoconstricteur');

-- --------------------------------------------------------

--
-- Table structure for table `interagir`
--

CREATE TABLE `interagir` (
  `MED_PERTURBATEUR` int(10) NOT NULL,
  `MED_PERTURBE` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `interagir`
--

INSERT INTO `interagir` (`MED_PERTURBATEUR`, `MED_PERTURBE`) VALUES
(1009, 45600),
(1010, 1009),
(1023, 2006),
(1023, 10493),
(1045, 1023),
(1045, 8004),
(1045, 45600),
(2006, 5900),
(3001, 5089),
(3001, 10493),
(3009, 45600),
(3098, 1045),
(3098, 5089),
(4500, 1009),
(4500, 10493);

-- --------------------------------------------------------

--
-- Table structure for table `medicaments`
--

CREATE TABLE `medicaments` (
  `MED_DEPOTLEGAL` int(10) NOT NULL,
  `MED_NOMCOMMERCIAL` varchar(25) NOT NULL,
  `FAM_CODE` int(3) NOT NULL,
  `MED_COMPOSITION` varchar(255) NOT NULL,
  `MED_EFFETS` varchar(255) NOT NULL,
  `MED_CONTREINDIC` varchar(255) NOT NULL,
  `MED_PRIXECHANTILLON` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medicaments`
--

INSERT INTO `medicaments` (`MED_DEPOTLEGAL`, `MED_NOMCOMMERCIAL`, `FAM_CODE`, `MED_COMPOSITION`, `MED_EFFETS`, `MED_CONTREINDIC`, `MED_PRIXECHANTILLON`) VALUES
(1009, 'Pariet', 11, 'Butanol, Cire de carnauba, Encre pour impression, Éthanol anhydre, Éthylcellulose, Fer rouge oxyde, Gomme laque blanche, Hyprolose, Hyprolose faiblement substituée', 'Calme la toux', 'Nourrissons de moins de 2 mois', 9.5),
(1010, 'Kardegic', 7, 'Glycine, arôme mandarine (huile essentielle de zeste de mandarine, jus concentré d\'orange, huile essentielle d\'orange', 'Fait pousser les cheveux', 'Femmes enceintes', 14),
(1023, 'Efferalgan', 2, 'hydroxypropylcellulose, croscarmellose sodique, béhénate de glycérol, stéarate de magnésium, silice colloïdale anhydre. Pelliculage : Opadry OY-S-38901 : hypromellose (E464), dioxyde de titane (E1', 'soigne les maux de tete', 'Avant de conduire', 5),
(1045, 'Xanax', 8, 'Lactose monohydraté, cellulose microcristalline, silice colloïdale anhydre, mélange de docusate de sodium (85 %) et de benzoate de sodium (E 211) (15 %), amidon de maïs, stéarate de magnésium, laque aluminique d\'indigotine', 'Calme l\'hyperactivité', 'Femmes enceintes', 16),
(2006, 'Diprosone', 12, 'vaseline, alcool cétostéarylique, paraffine liquide, éther monocétylique de polyoxyéthylène glycol 1000, dihydrogénophosphate de sodium monohydraté, chlorocrésol, acide phosphorique concentré', 'Solidifie les dents', 'Cancéreux', 4),
(3001, 'Amlor', 10, 'benzoate de sodium, povidone K30, monoglycérides acétylés, arôme orange, saccharose.\r\nRéaction d\'hypersensibilité, Choc anaphylactique, Oedème de Quincke, Erythème cutané, Urticaire', 'aide a\r\nà s\'endormir', 'Avant de conduire', 12),
(3009, 'xyzall', 4, 'cellulose microcristalline, lactose monohydraté, silice colloïdale anhydre, stéarate de magnésium. Pelliculage : OPADRY® Y-1-7000 (composé d\'hypromellose (E464), dioxyde de titane (E171)', 'Calme les allergies', 'Juifs', 7),
(3098, 'Levothyrox', 5, 'Mannitol, amidon de maïs, gélatine, croscarmellose sodique, stéarate de magnésium, acide citrique anhydre', 'Soigne le sida', 'Nourrissons de moins de 2 mois', 9),
(4500, 'Plavix', 14, 'Macrogol 6000, Cellulose microcristalline, Hydroxypropylcellulose faiblement substituée, Enrobage : Hypromellose, Triacétine, Titane dioxyde, Oxyde ferrique rouge, Agent polissant : Cire de carnauba', 'Renforce les os', 'Diabétique', 14),
(5089, 'Spasfon', 3, 'lactose monohydraté, saccharose, acétate de polyvinyle, amidon de blé, acide stéarique, stéarate de magnésium. Enrobage : acétate de polyvinyle, talc, saccharose, gomme arabique, gélatine', 'Soigne du cancer', 'Enfants', 10),
(5900, 'Lamaline', 11, 'Glycérides hémisynthétiques solides', 'Aide a la concentration', 'Personnes de plus de 70 ans', 8.9),
(8004, 'Solupred', 9, 'Cp à 20 mg : acide tartrique, acide citrique anhydre, bicarbonate de sodium, benzoate de lithium, citron arôme naturel (maltodextrine, gomme végétale, sorbitol, huile essentielle de citron, citral, citronellal)', 'Aide à la selle', 'Allergiques au pollen', 10),
(10493, 'Imodium', 6, 'Lactose monohydraté, amidon de maïs, talc, stéarate de magnésium. Composition de l\'enveloppe de la gélule', 'Soigne de la paralysie', 'Personnes de plus de 70 ans', 11),
(28601, 'Doliprane', 1, 'gélatine, azorubine (E122), jaune de quinoléine (E104), oxyde de fer jaune (E172). Excipient à effet notoire : azorubine (E122)(0,135 mg/gélule). Excipients : benzoate de sodium', 'soigne les maux de tete', 'Cancéreux', 12),
(45600, 'Advil', 15, 'Calcium carbonate, Talc, Cire de carnauba, Fer oxyde rouge , Encre noire Opacode S-1-17823 : Gomme laque, Fer oxyde noir, N-butylalcool, Eau purifiée, Propylène glycol, Isopropylique alcool, Ammonium hydroxyde', 'Brule la graisse', 'Handicapés', 10.45);

-- --------------------------------------------------------

--
-- Table structure for table `prescription`
--

CREATE TABLE `prescription` (
  `MED_DEPOTLEGAL` int(10) NOT NULL,
  `TIN_CODE` int(5) NOT NULL,
  `DOS_CODE` int(10) NOT NULL,
  `PRE_POSOLOGIE` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prescription`
--

INSERT INTO `prescription` (`MED_DEPOTLEGAL`, `TIN_CODE`, `DOS_CODE`, `PRE_POSOLOGIE`) VALUES
(1009, 3, 1, 'matin, midi et soir'),
(1010, 1, 2, 'le soir'),
(1023, 4, 3, 'toutes les 3h'),
(1045, 3, 4, 'le midi'),
(2006, 3, 5, 'le matin'),
(3001, 5, 6, 'l\'après-midi'),
(3009, 2, 7, 'le matin'),
(3098, 1, 8, 'après les repas'),
(3098, 3, 14, 'jamais'),
(4500, 2, 9, 'le midi '),
(5089, 5, 10, 'le soir'),
(5900, 4, 11, 'au réveil'),
(8004, 5, 12, 'au coucher'),
(10493, 4, 13, 'le matin'),
(28601, 5, 14, 'toutes les 6H'),
(45600, 4, 15, 'matin, midi et soir');

-- --------------------------------------------------------

--
-- Table structure for table `type_individu`
--

CREATE TABLE `type_individu` (
  `TIN_CODE` int(5) NOT NULL,
  `TIN_LIBELLE` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `type_individu`
--

INSERT INTO `type_individu` (`TIN_CODE`, `TIN_LIBELLE`) VALUES
(1, 'Nourrisson'),
(2, 'Enfant2'),
(3, 'Adolescent'),
(4, 'Adulte'),
(5, 'Personne agée'),
(6, 'vielle');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `idUser` int(11) NOT NULL,
  `loginUser` varchar(20) NOT NULL,
  `pwdUser` varchar(20) NOT NULL,
  `prenomUser` varchar(20) NOT NULL,
  `nomUser` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`idUser`, `loginUser`, `pwdUser`, `prenomUser`, `nomUser`) VALUES
(1, 'Athi', 'admin', 'Athittyan', 'balagow'),
(1, 'Jacob', 'admin', 'Jacob', 'Taieb');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dosages`
--
ALTER TABLE `dosages`
  ADD PRIMARY KEY (`DOS_CODE`);

--
-- Indexes for table `famille`
--
ALTER TABLE `famille`
  ADD PRIMARY KEY (`FAM_CODE`);

--
-- Indexes for table `interagir`
--
ALTER TABLE `interagir`
  ADD PRIMARY KEY (`MED_PERTURBATEUR`,`MED_PERTURBE`),
  ADD KEY `MED_PERTURBATEUR` (`MED_PERTURBATEUR`),
  ADD KEY `MED_MED_PERTURBE` (`MED_PERTURBE`);

--
-- Indexes for table `medicaments`
--
ALTER TABLE `medicaments`
  ADD PRIMARY KEY (`MED_DEPOTLEGAL`),
  ADD KEY `FAM_CODE` (`FAM_CODE`);

--
-- Indexes for table `prescription`
--
ALTER TABLE `prescription`
  ADD PRIMARY KEY (`MED_DEPOTLEGAL`,`TIN_CODE`,`DOS_CODE`),
  ADD KEY `TIN_CODE` (`TIN_CODE`),
  ADD KEY `DOS_CODE` (`DOS_CODE`),
  ADD KEY `MED_DEPOTLEGAL` (`MED_DEPOTLEGAL`);

--
-- Indexes for table `type_individu`
--
ALTER TABLE `type_individu`
  ADD PRIMARY KEY (`TIN_CODE`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `famille`
--
ALTER TABLE `famille`
  MODIFY `FAM_CODE` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `medicaments`
--
ALTER TABLE `medicaments`
  MODIFY `MED_DEPOTLEGAL` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45601;
--
-- AUTO_INCREMENT for table `type_individu`
--
ALTER TABLE `type_individu`
  MODIFY `TIN_CODE` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `interagir`
--
ALTER TABLE `interagir`
  ADD CONSTRAINT `interagir_ibfk_1` FOREIGN KEY (`MED_PERTURBATEUR`) REFERENCES `medicaments` (`MED_DEPOTLEGAL`),
  ADD CONSTRAINT `interagir_ibfk_2` FOREIGN KEY (`MED_PERTURBE`) REFERENCES `medicaments` (`MED_DEPOTLEGAL`);

--
-- Constraints for table `medicaments`
--
ALTER TABLE `medicaments`
  ADD CONSTRAINT `medicaments_ibfk_1` FOREIGN KEY (`FAM_CODE`) REFERENCES `famille` (`FAM_CODE`);

--
-- Constraints for table `prescription`
--
ALTER TABLE `prescription`
  ADD CONSTRAINT `prescription_ibfk_2` FOREIGN KEY (`DOS_CODE`) REFERENCES `dosages` (`DOS_CODE`),
  ADD CONSTRAINT `prescription_ibfk_4` FOREIGN KEY (`TIN_CODE`) REFERENCES `type_individu` (`TIN_CODE`),
  ADD CONSTRAINT `prescription_ibfk_5` FOREIGN KEY (`MED_DEPOTLEGAL`) REFERENCES `medicaments` (`MED_DEPOTLEGAL`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
