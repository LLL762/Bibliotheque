SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";
SET foreign_key_checks = 0;

--
-- Table 'theme' final
--
DELETE FROM `theme`;
INSERT INTO `theme` (`id`, `libelle`, `description`) VALUES
(1, 'Historique', 'Ouvrage traitant de l histoire. Adapte a la jeunnesse.' ),
(2, 'Phylosophique', 'Ouvrage offrant des pistes de reflexion sur toi, sur moi, sur nous, sur le monde.' ),
(3, 'Jeunesse', 'Roman adapte a tout les ages.' );

--
-- Table 'livre' final
--
DELETE FROM `livre`;
INSERT INTO `livre` (`id`, `isbn`, `titre`, `iconUrl`, `id_theme`) VALUES
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
DELETE FROM `contribution`;
INSERT INTO `contribution` (`id`, `libelle`) VALUES
(1, 'Auteur'),
(2, 'Co-auteur'),
(3, 'Dessinateur');

--
-- Table 'contributeur' final
--
DELETE FROM `contributeur`;
INSERT INTO `contributeur` (`id`, `nom`, `prenom`, `pseudo`) VALUES
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
DELETE FROM `contributeur_contribution`;
INSERT INTO `contributeur_contribution` ( `contributeur_id`, `contribution_id` ) VALUES
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
DELETE FROM `livre_contributeur_contribution`;
INSERT INTO `livre_contributeur_contribution` (`livre_id`, `contributeur_id`, `contribution_id` ) VALUES
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
DELETE FROM `exemplaire`;
INSERT INTO `exemplaire` (`id`, `id_emplac`, `id_livre`, `id_usure`, `id_emprunt`, `commentaire`) VALUES
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
DELETE FROM `usure`;
INSERT INTO `usure` (`id`, `libelle`, `description`) VALUES
(1, 'Tres bon etat', 'L exemplaire est dans un excellent etat, pas ou tres peu de marque d usures' ),
(2, 'Etat moyen', 'L exemplaire est dans un etat convenable' ),
(3, 'Mauvais etat', 'L exemplaire est dans un etat qui necessite de le changer' );

--
-- Table 'bibliotheque' final
--
DELETE FROM `bibliotheque`;
INSERT INTO `bibliotheque` (`id`, `libelle`, `adresse`) VALUES
(1, 'Mediatheque de Riom', '2 ter Faubourg de la Bade - 63200 Riom'),
(2, 'Bibliotheque du Patrimoine' , '17 rue Bardoux - 63000 Clermont-Ferrand'),
(3, 'Mediatheque Jacques-Prevert', '1 rue Saint Verny - 63370 Lempdes');

--
-- Table 'emplacement' final
--
DELETE FROM `emplacement`;
INSERT INTO `emplacement` (`id`, `id_bibli`, `id_theme`, `libelle`) VALUES
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
DELETE FROM `employe`;
INSERT INTO `employe` (`id`, `nom`, `prenom`, `adresse`, `telephone`, `email`, `pwd`, `id_role`, `id_bibli`) VALUES
(1, 'Rouget', 'Marc', '2 rue du haricot - Riom', '0987653214', 'marc.rouget@caramail.com', 'Maman1955', 1, 1),
(2, 'Goujon', 'Jimmy', '31 rue des lentilles - Lempdes', '0712345684', 'jimmy.goujon@gmail.com', 'j@imeleschats', 1, 2),
(3, 'Truite', 'Sandrine', '16 boulevard de la carotte - Cournon', '0523856149', 'sandrine.ruite@outlook.com', 'azerty1234', 1, 3);

--
-- Table 'role' final
--
DELETE FROM `role`;
INSERT INTO `role` (`id`, `libelle`, `niv_accred`) VALUES
(1, 'bibliotecaire', 5),
(2, 'administrateur', 10);

--
-- Table 'utilisateur' final
--
DELETE FROM `utilisateur`;
INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `adresse`, `telephone`, `email`, `pwd`, `date_adhesion`, `date_fin_adhesion`) VALUES
(1, 'Oeillet', 'Tristan', '4 rue du chevalier - Gerzat', '0563217421', 'tristanlegeant@yopmail.com', 'Mamounette99', '2022-01-01' , '2023-01-01'),
(2, 'Geranium', 'France', '95 rue des poissoniers - Cournon', '0123524596', 'france.Geranium@gmail.com', 'j@imePASleschats', '2022-09-02', '2023-09-02'),
(3, 'Tulipe', 'Eddy', '124 rue de la boucherie - Blanzat', '0396854512', 'Eddy.Tulipe@outlook.com', 'password1', '2021-11-21', '2022-11-21'),
(4, 'Iris', 'Delphine', '62 bis boulevard des manuisiers - Ceyrat', '0212457896', 'Delphine.Iris@outlook.com', 'azertyuiop63', '2022-03-02', '2023-03-02'),
(5, 'Lavande', 'Juliane', '53 avenue de la boulangerie - Clermont-Ferrand', '0323568985', 'Juliane.Lavande@outlook.com', 'passe-de-mot','2021-10-04', '2022-10-04');


DELETE FROM `emprunt`;
INSERT INTO `emprunt` (id, id_adherent, date_emprunt, date_rendu_prevu) VALUES
(1,1,'2022-11-21', '2022-12-21' ), (2,1,'2022-11-21', '2022-12-21' );
