CREATE DATABASE if not exists speedHome;

use speedHome;

CREATE TABLE `categories` (
  `categories_id` int NOT NULL AUTO_INCREMENT,
  `categories_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`categories_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `enable` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `properties` (
  `properties_id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `approved` bit(1) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `pincode` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `categories_id` int NOT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`properties_id`),
  KEY `FK7img2fpci2uxo2i01fm0n2g4h` (`categories_id`),
  KEY `FKtnyxik10x9mx26017sjnuo2nw` (`user_id`),
  CONSTRAINT `FK7img2fpci2uxo2i01fm0n2g4h` FOREIGN KEY (`categories_id`) REFERENCES `categories` (`categories_id`),
  CONSTRAINT `FKtnyxik10x9mx26017sjnuo2nw` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `roles` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `users_roles` (
  `users_user_id` int NOT NULL,
  `roles_role_id` int NOT NULL,
  KEY `FKtgou1kvdhyryu3fia6uu1fhoi` (`roles_role_id`),
  KEY `FKmaps3ffbyjaxkt50q1c7s7v5j` (`users_user_id`),
  CONSTRAINT `FKmaps3ffbyjaxkt50q1c7s7v5j` FOREIGN KEY (`users_user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FKtgou1kvdhyryu3fia6uu1fhoi` FOREIGN KEY (`roles_role_id`) REFERENCES `roles` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
