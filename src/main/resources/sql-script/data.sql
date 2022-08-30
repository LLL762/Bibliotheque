SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";
SET foreign_key_checks = 0;

--
-- Création de la table d'archive + remplissage avec des exemples
--
drop table IF EXISTS `emprunt_archive`;
create TABLE IF NOT EXISTS `emprunt_archive` (
	`id_emmprunt`       int NOT NULL,
	`id_exemplaire`     int NOT NULL,
	`id_adherent`       int NOT NULL,
	`date_emprunt`      date NOT NULL,
	`date_rendu_prevue` date NOT NULL,
	`date_rendu_eff`    date NOT NULL,
PRIMARY KEY (`id_emmprunt`)
);
delete from `emprunt_archive`;

insert into `emprunt_archive` (`id_emmprunt`, `id_exemplaire`, `id_adherent`, `date_emprunt`, `date_rendu_prevue`, `date_rendu_eff` ) VALUES
-- 2019
(1, 1, 1, "2019-02-01", "2019-02-22", "2019-02-19"),
(2, 9, 1, "2019-02-01", "2019-02-22", "2019-02-19"),
(3, 2, 2, "2019-02-05", "2019-02-26", "2019-02-15"),
(4, 12, 5, "2019-03-03", "2019-03-24", "2019-03-23"),
(5, 5, 5, "2019-03-03", "2019-03-24", "2019-03-23"),
(6, 3, 3, "2019-03-04", "2019-03-25", "2019-03-23"),
(7, 2, 1, "2019-03-06", "2019-03-27", "2019-03-24"),
(8, 4, 2, "2019-03-06", "2019-03-27", "2019-03-21"),
(9, 6, 2, "2019-03-06", "2019-03-27", "2019-03-21"),
(10, 8, 2, "2019-04-03", "2019-04-24", "2019-04-20"),
(11, 5, 4, "2019-04-09", "2019-04-30", "2019-04-29"),
(12, 1, 3, "2019-05-05", "2019-05-26", "2019-04-22"),
(13, 3, 2, "2019-05-05", "2019-05-26", "2019-04-21"),
(14, 4, 2, "2019-05-05", "2019-05-26", "2019-04-21"),
(15, 11, 2, "2019-05-05", "2019-05-26", "2019-04-21"),
(16, 15, 4, "2019-05-05", "2019-05-26", "2019-04-21"),
(17, 13, 1, "2019-06-05", "2019-06-26", "2019-06-21"),
(18, 12, 1, "2019-06-05", "2019-06-26", "2019-06-21"),
(19, 17, 5, "2019-07-05", "2019-07-26", "2019-07-21"),
-- 2020
(20, 12, 2, "2020-02-05", "2020-02-26", "2020-02-15"),
(21, 2, 5, "2020-03-03", "2020-03-24", "2020-03-23"),
(22, 5, 5, "2020-03-03", "2020-03-24", "2020-03-23"),
(23, 13, 3, "2020-03-04", "2020-03-25", "2020-03-23"),
(24, 2, 1, "2020-03-06", "2020-03-27", "2020-03-24"),
(25, 17, 2, "2020-03-06", "2020-03-27", "2020-03-21"),
(26, 6, 2, "2020-03-06", "2020-03-27", "2020-03-21"),
(27, 8, 2, "2020-04-03", "2020-04-24", "2020-04-20"),
(28, 19, 4, "2020-04-09", "2020-04-30", "2020-04-29"),
(29, 1, 3, "2020-05-05", "2020-05-26", "2020-04-22"),
(30, 3, 2, "2020-05-05", "2020-05-26", "2020-04-21"),
(31, 17, 2, "2020-05-05", "2020-05-26", "2020-04-21"),
(32, 2, 2, "2020-05-05", "2020-05-26", "2020-04-21"),
(33, 20, 4, "2020-05-05", "2020-05-26", "2020-04-21"),
(34, 5, 1, "2020-06-05", "2020-06-26", "2020-06-21"),
(35, 12, 1, "2020-06-05", "2020-06-26", "2020-06-21"),
(36, 17, 5, "2020-07-05", "2020-07-26", "2020-07-21"),
(37, 13, 1, "2020-07-05", "2020-07-26", "2020-07-21"),
(38, 4, 1, "2020-08-05", "2020-08-26", "2020-08-21"),
(39, 5, 2, "2020-08-05", "2020-08-26", "2020-08-21"),
(40, 10, 3, "2020-08-05", "2020-08-26", "2020-08-21"),
(41, 20, 3, "2020-08-05", "2020-08-26", "2020-08-21"),
(42, 19, 4, "2020-08-05", "2020-08-26", "2020-08-21"),
-- 2021
(43, 5, 1, "2021-02-01", "2021-02-22", "2021-02-19"),
(44, 19, 1, "2021-02-01", "2021-02-22", "2021-02-19"),
(45, 10, 2, "2021-02-05", "2021-02-26", "2021-02-15"),
(46, 4, 5, "2021-03-03", "2021-03-24", "2021-03-23"),
(47, 2, 5, "2021-03-03", "2021-03-24", "2021-03-23"),
(48, 13, 3, "2021-03-04", "2021-03-25", "2021-03-23"),
(49, 3, 1, "2021-03-06", "2021-03-27", "2021-03-24"),
(50, 17, 2, "2021-03-06", "2021-03-27", "2021-03-21"),
(51, 6, 2, "2021-03-06", "2021-03-27", "2021-03-21"),
(52, 8, 2, "2021-04-03", "2021-04-24", "2021-04-20"),
(53, 15, 4, "2021-04-09", "2021-04-30", "2021-04-29"),
(54, 13, 3, "2021-05-05", "2021-05-26", "2021-04-22"),
(55, 17, 2, "2021-05-05", "2021-05-26", "2021-04-21"),
(56, 8, 2, "2021-05-05", "2021-05-26", "2021-04-21"),
(57, 2, 2, "2021-05-05", "2021-05-26", "2021-04-21"),
(58, 20, 4, "2021-05-05", "2021-05-26", "2021-04-21"),
(59, 4, 1, "2021-06-05", "2021-06-26", "2021-06-21"),
(60, 9, 1, "2021-06-05", "2021-06-26", "2021-06-21"),
(61, 7, 5, "2021-07-05", "2021-07-26", "2021-07-21"),
(62, 11, 1, "2021-07-05", "2021-07-26", "2021-07-21"),
(63, 1, 1, "2021-08-05", "2021-08-26", "2021-08-21"),
(64, 8, 2, "2021-08-05", "2021-08-26", "2021-08-21"),
(65, 7, 3, "2021-08-05", "2021-08-26", "2021-08-21"),
(66, 12, 3, "2021-08-05", "2021-08-26", "2021-08-21"),
(67, 19, 4, "2021-09-05", "2021-09-26", "2021-09-21"),
(68, 11, 4, "2021-09-05", "2021-09-26", "2021-09-21"),
(69, 4, 2, "2021-09-05", "2021-09-26", "2021-09-21"),
(70, 6, 4, "2021-10-05", "2021-10-26", "2021-10-21"),
(71, 10, 1, "2021-10-05", "2021-10-26", "2021-10-21"),
(72, 8, 2, "2021-10-05", "2021-10-26", "2021-10-21"),
(73, 3, 2, "2021-10-05", "2021-10-26", "2021-10-21");

--
-- remplissage de la table thème
--
delete from `theme`;
insert into `theme` (`id`, `libelle`, `description`) VALUES
(1, 'Historique', 'Ouvrage traitant de l histoire. Adapte a la jeunnesse.' ),
(2, 'Phylosophique', 'Ouvrage offrant des pistes de reflexion sur toi, sur moi, sur nous, sur le monde.' ),
(3, 'Jeune Adulte', 'Roman adapte a tout les ages.' ),
(4, 'Policier', 'Intrique palpitante !' );

--
-- Table 'livre' final
--
delete from `livre`;
insert into `livre` (`id`, `isbn`, `titre`, `iconUrl`, `id_theme`) VALUES
(1, '9782246780700', 'Ogres, brigands et compagnie', 'blank.html', 1),
(2, '9782012024106', 'A minuit', 'blank.html', 2),
(3, '9782847892184', 'Jeanne', 'blank.html', 3),
(4, '9782845657358', 'Rufus le loup', 'blank.html', 3),
(5, '9782092113534', 'Les grands explorateurs', 'blank.html', 3),
(6, '9782092113550', 'Mythes et monstres', 'blank.html',1),
(7, '9782749924038', 'Les gladiateurs', 'blank.html', 1),
(8, '9782012921528', 'Mirages', 'blank.html', 2),
(9, '9782350005850', 'I like Europe"', 'blank.html', 2),
(10, '9782035903112', 'Monsieur Lune', 'blank.html', 2);

--
-- Table 'contribution' final
--
delete from `contribution`;
insert into `contribution` (`id`, `libelle`) VALUES
(1, 'Auteur'),
(2, 'Co-auteur'),
(3, 'Dessinateur');

--
-- Table 'contributeur' final
--
delete from `contributeur`;
insert into `contributeur` (`id`, `nom`, `prenom`, `pseudo`) VALUES
(1, 'Ungerer','TOMI',  ''),
(2, 'Merike', 'EDUARD', ''),
(3, 'Cassabois', 'JACQUES', ''),
(4, '', '', 'Tarek'),
(5, 'Platt', 'RICHARD', ''),
(6, 'Buller','LAURA', '' ),
(7, 'Malam','JOHN', '' ),
(8, 'Robillard','ANNE', '' ),
(9, 'Gillet','CAROLINE', '' ),
(10, '','', 'Corbeyran' );



--
-- Table 'contributeur_contribution' final
--
delete from `contributeur_contribution`;
insert into `contributeur_contribution` ( `contributeur_id`, `contribution_id` ) VALUES
(1,1),
(2,1),
(3,1),
(4,1),
(5,1),
(6,1),
(7,1),
(8,1),
(9,1),
(10,1);

--
-- Table 'livre_contributeur_contribution' final
--
delete from `livre_contributeur_contribution`;
insert into `livre_contributeur_contribution` (`livre_id`, `contributeur_id`, `contribution_id` ) VALUES
(1,1,1),
(2,2,1),
(3,3,1),
(4,4,1),
(5,5,1),
(6,6,1),
(7,7,1),
(8,8,1),
(9,9,1),
(10,10,1);

--
-- Table 'exemplaire' final
--
delete from `exemplaire`;
insert into `exemplaire` (`id`, `id_emplac`, `id_livre`, `id_usure`, `id_emprunt`, `commentaire`) VALUES
(1, 1, 1, 1, 1, 'RAS' ),
(2, 1, 1, 2, '', 'Verifier la page 3'),
(3, 4, 1, 1, '', 'RAS' ),
(4, 2, 2, 1, '', 'RAS' ),
(5, 8, 2, 1, '', 'RAS' ),
(6, 6, 3, 2, '', 'Verifier la quatrieme de couverture' ),
(7, 9, 4, 1, '', 'RAS' ),
(8, 3, 4, 1, '', 'RAS' ),
(9, 3, 5, 1, '', 'RAS' ),
(10, 4, 6, 1, '', 'RAS' ),
(11, 7, 6, 1, '', 'RAS' ),
(12, 7, 7, 2, 2, 'Verifier la page 39' ),
(13, 7, 7, 1, '', 'RAS' ),
(14, 4, 7, 1, '', 'RAS' ),
(15, 8, 8, 1, '', 'RAS' ),
(16, 5, 8, 1, '', 'RAS' ),
(17, 5, 8, 3, '', 'Pensez a changer l exemplaire' ),
(18, 2, 9, 1, '', 'RAS' ),
(19, 2, 10, 2, '', 'Possible page dechiree - 25' ),
(20, 8, 10, 1, '', 'RAS' );



--
-- Table 'usure' final
--
delete from `usure`;
insert into `usure` (`id`, `libelle`, `description`) VALUES
(1, 'Tres bon etat', 'L exemplaire est dans un excellent etat, pas ou tres peu de marque d usures' ),
(2, 'Etat moyen', 'L exemplaire est dans un etat convenable' ),
(3, 'Mauvais etat', 'L exemplaire est dans un etat qui necessite de le changer' );

--
-- Table 'bibliotheque' final
--
delete from `bibliotheque`;
insert into `bibliotheque` (`id`, `libelle`, `adresse`) VALUES
(1, 'Mediatheque de Riom', '2 ter Faubourg de la Bade - 63200 Riom'),
(2, 'Bibliotheque du Patrimoine' , '17 rue Bardoux - 63000 Clermont-Ferrand'),
(3, 'Mediatheque Jacques-Prevert', '1 rue Saint Verny - 63370 Lempdes');

--
-- Table 'emplacement' final
--
delete from `emplacement`;
insert into `emplacement` (`id`, `id_bibli`, `id_theme`, `libelle`) VALUES
(1, 1, 1, "Rayonnage 1-A"),
(2, 1, 2, "Presentoir central"),
(3, 1, 3, "Rayonnage 1-B"),
(4, 2, 1, "Rayonnage 2-A"),
(5, 2, 2, "Rayonnage 2-B"),
(6, 2, 3, "Rayonnage 2-C"),
(7, 3, 1, "Rayonnage 3-A"),
(8, 3, 2, "Presentoir central"),
(9, 3, 3, "Rayonnage 3-B");

--
-- Table 'employe' final
--
delete from `employe`;
insert into `employe` (`id`, `nom`, `prenom`, `adresse`, `telephone`, `email`, `pwd`, `id_role`, `id_bibli`) VALUES
(1, 'Rouget', 'Marc', '2 rue du haricot - Riom', '0987653214', 'marc.rouget@caramail.com', 'Maman1955', 1, 1),
(2, 'Goujon', 'Jimmy', '31 rue des lentilles - Lempdes', '0712345684', 'jimmy.goujon@gmail.com', 'j@imeleschats', 1, 2),
(3, 'Truite', 'Sandrine', '16 boulevard de la carotte - Cournon', '0523856149', 'sandrine.ruite@outlook.com', 'azerty1234', 1, 3);

--
-- Table 'role' final
--
delete from `role`;
insert into `role` (`id`, `libelle`, `niv_accred`) VALUES
(1, 'bibliotecaire', 5),
(2, 'administrateur', 10);

--
-- Table 'utilisateur' final
--
delete from `utilisateur`;
insert into `utilisateur` (`id`, `nom`, `prenom`, `adresse`, `telephone`, `email`, `pwd`, `date_adhesion`, `date_fin_adhesion`) VALUES
(1, 'Oeillet', 'Tristan', '4 rue du chevalier - Gerzat', '0563217421', 'tristanlegeant@yopmail.com', 'Mamounette99', '2022-01-01' , '2023-01-01'),
(2, 'Geranium', 'France', '95 rue des poissoniers - Cournon', '0123524596', 'france.Geranium@gmail.com', 'j@imePASleschats', '2022-09-02', '2023-09-02'),
(3, 'Tulipe', 'Eddy', '124 rue de la boucherie - Blanzat', '0396854512', 'Eddy.Tulipe@outlook.com', 'password1', '2021-11-21', '2022-11-21'),
(4, 'Iris', 'Delphine', '62 bis boulevard des manuisiers - Ceyrat', '0212457896', 'Delphine.Iris@outlook.com', 'azertyuiop63', '2022-03-02', '2023-03-02'),
(5, 'Lavande', 'Juliane', '53 avenue de la boulangerie - Clermont-Ferrand', '0323568985', 'Juliane.Lavande@outlook.com', 'passe-de-mot','2021-10-04', '2022-10-04');


delete from `emprunt`;
insert into `emprunt` (id, id_adherent, date_emprunt, date_rendu_prevu) VALUES
(1,1,'2022-11-21', '2022-12-21' ), (2,1,'2022-11-21', '2022-12-21' );
