CREATE
DATABASE `zz8alsto5xji5csq` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `car`
(
    `Car_ID`         int          NOT NULL AUTO_INCREMENT,
    `Chassis_number` varchar(17)  NOT NULL,
    `Make`           varchar(255) NOT NULL,
    `Model`          varchar(255) NOT NULL,
    `Colour`         varchar(255) NOT NULL,
    `Available`      tinyint      NOT NULL,
    PRIMARY KEY (`Car_ID`),
    UNIQUE KEY `Chassis_number_UNIQUE` (`Chassis_number`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `customer`
(
    `Customer_id`     int NOT NULL AUTO_INCREMENT,
    `Name`            varchar(255) DEFAULT NULL,
    `Phone_number`    varchar(255) DEFAULT NULL,
    `Email`           varchar(255) DEFAULT NULL,
    `Address`         varchar(255) DEFAULT NULL,
    `Credit_approved` tinyint      DEFAULT NULL,
    `Drivers_licens`  tinyint      DEFAULT NULL,
    PRIMARY KEY (`Customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `damage`
(
    `Damage_id`       int          NOT NULL AUTO_INCREMENT,
    `Car_id`          int          NOT NULL,
    `Lease_id`        int          NOT NULL,
    `Dmg_description` varchar(255) NOT NULL,
    `Price`           double       NOT NULL,
    `Repaired`        tinyint DEFAULT NULL,
    PRIMARY KEY (`Damage_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `lease`
(
    `Lease_id`     int    NOT NULL AUTO_INCREMENT,
    `Car_id`       int    NOT NULL,
    `Costumer_id`  int    NOT NULL,
    `Price`        double NOT NULL,
    `Start_date`   date         DEFAULT NULL,
    `Stop_date`    date         DEFAULT NULL,
    `Status`       tinyint      DEFAULT NULL,
    `Lease_type`   tinyint      DEFAULT NULL,
    `Pickup_place` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`Lease_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user`
(
    `User_id`           int          NOT NULL AUTO_INCREMENT,
    `Username`          varchar(255) NOT NULL,
    `Password`          varchar(255) NOT NULL,
    `Business_role`     tinyint      NOT NULL,
    `Damage_role`       tinyint      NOT NULL,
    `Registration_role` tinyint      NOT NULL,
    PRIMARY KEY (`User_id`),
    UNIQUE KEY `User_id_UNIQUE` (`User_id`),
    UNIQUE KEY `Username_UNIQUE` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;