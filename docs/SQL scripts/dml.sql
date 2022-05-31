/*
zz8alsto5xji5csq
*/

INSERT INTO `user` (`User_id`, `Username`, `Password`, `Business_role`, `Damage_role`, `Registration_role`)
VALUES (1, 'admin', 'admin', 1, 1, 1);
INSERT INTO `user` (`User_id`, `Username`, `Password`, `Business_role`, `Damage_role`, `Registration_role`)
VALUES (2, 'guest', 'guest', 0, 0, 0);
INSERT INTO `user` (`User_id`, `Username`, `Password`, `Business_role`, `Damage_role`, `Registration_role`)
VALUES (3, 'datadottie', '1234', 0, 0, 1);
INSERT INTO `user` (`User_id`, `Username`, `Password`, `Business_role`, `Damage_role`, `Registration_role`)
VALUES (4, 'skadejan', '4321', 0, 1, 0);
INSERT INTO `user` (`User_id`, `Username`, `Password`, `Business_role`, `Damage_role`, `Registration_role`)
VALUES (5, 'firmafrank', '9876', 1, 0, 0);
INSERT INTO `user` (`User_id`, `Username`, `Password`, `Business_role`, `Damage_role`, `Registration_role`)
VALUES (6, 'multimax', '9999', 0, 1, 1);

INSERT INTO `customer` (`Customer_id`, `Name`, `Phone_number`, `Email`, `Address`, `Credit_approved`, `Drivers_licens`)
VALUES (1, 'Hans 67tt9g5lmn4v2', 'ASDKJHASDK', '73ghd9kk6720876bhj', '867ghj323nkjnf0ugf5456jhbjh', 1, 1);
INSERT INTO `customer` (`Customer_id`, `Name`, `Phone_number`, `Email`, `Address`, `Credit_approved`, `Drivers_licens`)
VALUES (2, 'Janni 09hjhd7333hnjifrp987', 'ASD:KJASD:', '864gjbhvfbk04jkbkj9865kjb', '8676ubhjkndsmv078763bkhbh', 1, 1);
INSERT INTO `customer` (`Customer_id`, `Name`, `Phone_number`, `Email`, `Address`, `Credit_approved`, `Drivers_licens`)
VALUES (3, 'Britt hjf0098jodis776', 'SHDIGKEHWY', '875nvdihe66393vbjk11hjbf', 'kjbjhbfr85604jbkjb80934bf8', 1, 1);
INSERT INTO `customer` (`Customer_id`, `Name`, `Phone_number`, `Email`, `Address`, `Credit_approved`, `Drivers_licens`)
VALUES (4, 'Peter 8hjk754nvjdiw02bdj84nu', 'JSDHFUEYDK', '879745hjkjr094njkng0', '097984bjkbjvnklm00vihl8b', 1, 1);

INSERT INTO `car` (`Car_ID`, `Chassis_number`, `Make`, `Model`, `Colour`, `Available`)
VALUES (1, 'DNK9033LKYW36G4PP', 'Citroën', 'C3', 'Hvid', 0);
INSERT INTO `car` (`Car_ID`, `Chassis_number`, `Make`, `Model`, `Colour`, `Available`)
VALUES (2, 'DNK7633JVFN5H32LK', 'Skoda', 'Octavia', 'Sort', 1);
INSERT INTO `car` (`Car_ID`, `Chassis_number`, `Make`, `Model`, `Colour`, `Available`)
VALUES (3, 'DNK1327OLMA632GGF', 'Fiat', 'Punto', 'Rød', 0);
INSERT INTO `car` (`Car_ID`, `Chassis_number`, `Make`, `Model`, `Colour`, `Available`)
VALUES (4, 'DNK9000OIK87GFE34', 'Peugeot', '3008GT', 'Turkis', 1);
INSERT INTO `car` (`Car_ID`, `Chassis_number`, `Make`, `Model`, `Colour`, `Available`)
VALUES (5, 'DNK7234LLKMNUH76G', 'Citroën', 'C1', 'Sort', 1);
INSERT INTO `car` (`Car_ID`, `Chassis_number`, `Make`, `Model`, `Colour`, `Available`)
VALUES (6, 'DNK23596396452938', 'Citroën', 'Berlingo', 'Gul', 0);
INSERT INTO `car` (`Car_ID`, `Chassis_number`, `Make`, `Model`, `Colour`, `Available`)
VALUES (7, 'DNKq4698030963403', 'DS', 'DS7 Performance Line Pack', 'Perlemor', 0);
INSERT INTO `car` (`Car_ID`, `Chassis_number`, `Make`, `Model`, `Colour`, `Available`)
VALUES (8, 'DNK809480346435J5', 'DS', 'DS7 Crossback Performance Line Pack', 'Sort', 1);
INSERT INTO `car` (`Car_ID`, `Chassis_number`, `Make`, `Model`, `Colour`, `Available`)
VALUES (9, 'DNKT34567239J3233', 'Peugeot', '2008 Allure Pack', 'Orange', 1);
INSERT INTO `car` (`Car_ID`, `Chassis_number`, `Make`, `Model`, `Colour`, `Available`)
VALUES (10, 'DNK57263H2353L789', 'Opel', 'Crossland Sport', 'Magenta', 1);

INSERT INTO `lease` (`Lease_id`, `Car_id`, `Costumer_id`, `Price`, `Start_date`, `Stop_date`, `Status`, `Lease_type`,
                     `Pickup_place`)
VALUES (11, 1, 1, 3900, '2022-05-01', '2022-07-30', 1, NULL, NULL);
INSERT INTO `lease` (`Lease_id`, `Car_id`, `Costumer_id`, `Price`, `Start_date`, `Stop_date`, `Status`, `Lease_type`,
                     `Pickup_place`)
VALUES (25, 7, 2, 4800, '2022-04-01', '2022-11-30', 1, NULL, NULL);
INSERT INTO `lease` (`Lease_id`, `Car_id`, `Costumer_id`, `Price`, `Start_date`, `Stop_date`, `Status`, `Lease_type`,
                     `Pickup_place`)
VALUES (26, 6, 3, 3250, '2022-05-29', '2022-09-30', 1, NULL, NULL);
INSERT INTO `lease` (`Lease_id`, `Car_id`, `Costumer_id`, `Price`, `Start_date`, `Stop_date`, `Status`, `Lease_type`,
                     `Pickup_place`)
VALUES (27, 3, 4, 3450, '2022-02-28', '2022-05-29', 0, NULL, NULL);

INSERT INTO `damage` (`Damage_id`, `Car_id`, `Lease_id`, `Dmg_description`, `Price`, `Repaired`)
VALUES (35, 3, 27, 'Skadet dæk', 500, 0);
INSERT INTO `damage` (`Damage_id`, `Car_id`, `Lease_id`, `Dmg_description`, `Price`, `Repaired`)
VALUES (36, 3, 27, 'Ridser i lak', 2900, 0);
INSERT INTO `damage` (`Damage_id`, `Car_id`, `Lease_id`, `Dmg_description`, `Price`, `Repaired`)
VALUES (37, 3, 27, 'Manglende nøgle', 499, 0);