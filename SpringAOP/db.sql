create database cyber;

create database album_console;

INSERT INTO `cyber`.`discipline` (`id`, `discipline_name`) VALUES ('1', 'Dota2');
INSERT INTO `cyber`.`discipline` (`id`, `discipline_name`) VALUES ('2', 'CS:GO');
INSERT INTO `cyber`.`discipline` (`id`, `discipline_name`) VALUES ('3', 'Heartstone');
INSERT INTO `cyber`.`discipline` (`id`, `discipline_name`) VALUES ('4', 'Starcraft');
INSERT INTO `cyber`.`discipline` (`id`, `discipline_name`) VALUES ('5', 'Fortnite');
INSERT INTO `cyber`.`discipline` (`id`, `discipline_name`) VALUES ('6', 'PUBG');
INSERT INTO `cyber`.`discipline` (`id`, `discipline_name`) VALUES ('7', 'Apex Legends');

INSERT INTO `cyber`.`command` (`id`, `discipline_id`, `name`) VALUES ('1', '1', 'NaVi');
INSERT INTO `cyber`.`command` (`id`, `discipline_id`, `name`) VALUES ('2', '3', 'Virtus Pro');
INSERT INTO `cyber`.`command` (`id`, `discipline_id`, `name`) VALUES ('3', '2', 'Astralis');
INSERT INTO `cyber`.`command` (`id`, `discipline_id`, `name`) VALUES ('4', '4', 'OG');
INSERT INTO `cyber`.`command` (`id`, `discipline_id`, `name`) VALUES ('5', '5', 'PSG.LGD');
INSERT INTO `cyber`.`command` (`id`, `discipline_id`, `name`) VALUES ('6', '1', 'Vici Gaming');
INSERT INTO `cyber`.`command` (`id`, `discipline_id`, `name`) VALUES ('7', '1', 'Alliance');
INSERT INTO `cyber`.`command` (`id`, `discipline_id`, `name`) VALUES ('8', '2', 'TNC Predator');
INSERT INTO `cyber`.`command` (`id`, `discipline_id`, `name`) VALUES ('9', '3', 'EHOME');
INSERT INTO `cyber`.`command` (`id`, `discipline_id`, `name`) VALUES ('10', '2', 'Team Liquid');
INSERT INTO `cyber`.`command` (`id`, `discipline_id`, `name`) VALUES ('11', '1', 'OG');
INSERT INTO `cyber`.`command` (`id`, `discipline_id`, `name`) VALUES ('12', '2', 'NaVi');
INSERT INTO `cyber`.`command` (`id`, `discipline_id`, `name`) VALUES ('13', '3', 'Virtus Pro');
