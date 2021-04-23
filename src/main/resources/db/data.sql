use speedHome;

INSERT INTO `speedHome`.`roles`
(`role_id`,`role_name`) VALUES (1,'ADMIN'),(2,'LANDLORD'),(3,'USER');


INSERT INTO `speedHome`.`categories`
(`categories_id`,`categories_name`) VALUES (1,'ROW HOUSE'),(2,'FLAT');

INSERT INTO `speedHome`.`users`
(`enable`,`password`,`user_name`) VALUES (1,'$2a$10$dTeyTx8iP7GdQEgnEBuV7ubqrQSU5fZzcINvphYYZh0.jdmiHZsbq','admin1'),
(1,'$2a$10$lZ.U95ww4t8jYb99oXfQT.z80B410zJor6RnILIx3b2JJS7HGg0vO','user1');

INSERT INTO `speedHome`.`users_roles`
(`users_user_id`,`roles_role_id`) VALUES (1,1),(2,3);




