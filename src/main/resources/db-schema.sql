CREATE TABLE `get_quote` (
  `idget_quote` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `zip` varchar(45) DEFAULT NULL,
  `resdience_use` varchar(45) DEFAULT NULL,
  `resdience_type` varchar(45) DEFAULT NULL,
  `user_id` varchar(45) DEFAULT NULL,
  `address_line_2` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idget_quote`)
);

CREATE TABLE `home_info` (
  `idhome_info` int(11) NOT NULL AUTO_INCREMENT,
  `value_of_home` varchar(45) DEFAULT NULL,
  `year_was_built` varchar(45) DEFAULT NULL,
  `square_footage` varchar(45) DEFAULT NULL,
  `number_of_half_baths` varchar(45) DEFAULT NULL,
  `number_of_full_baths` varchar(45) DEFAULT NULL,
  `dwelling_style` varchar(45) DEFAULT NULL,
  `type_garage` varchar(45) DEFAULT NULL,
  `pool` varchar(45) DEFAULT NULL,
  `roof_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idhome_info`)
);

CREATE TABLE `home_owner` (
  `idhome_owner` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `are_you_retired` varchar(45) DEFAULT NULL,
  `social_security_number` varchar(45) DEFAULT NULL,
  `date_of_birth` varchar(45) DEFAULT NULL,
  `user_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idhome_owner`)
);

CREATE TABLE `quote` (
  `quote_id` int(11) NOT NULL AUTO_INCREMENT,
  `premium` varchar(45) DEFAULT NULL,
  `coverage` varchar(45) DEFAULT NULL,
  `detached_structure` varchar(45) DEFAULT NULL,
  `pp` varchar(45) DEFAULT NULL,
  `adle` varchar(45) DEFAULT NULL,
  `me` varchar(45) DEFAULT NULL,
  `ded` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`quote_id`)
);

CREATE TABLE `username` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `user_role` int(11) DEFAULT '1',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`)
);
