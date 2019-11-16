INSERT INTO `snooker_booking`.`city` (`city_id`, `city_name`) VALUES ('1', 'Hyderabad');
INSERT INTO `snooker_booking`.`city` (`city_id`, `city_name`) VALUES ('2', 'Chennai');
INSERT INTO `snooker_booking`.`city` (`city_id`, `city_name`) VALUES ('3', 'Bengaluru');


INSERT INTO `snooker_booking`.`slot_status` (`slot_status_id`, `status_code`) VALUES ('1', 'UNAVAILABLE');
INSERT INTO `snooker_booking`.`slot_status` (`slot_status_id`, `status_code`) VALUES ('2', 'AVAILABLE');
INSERT INTO `snooker_booking`.`slot_status` (`slot_status_id`, `status_code`) VALUES ('3', 'PENDING');
INSERT INTO `snooker_booking`.`slot_status` (`slot_status_id`, `status_code`) VALUES ('4', 'BOOKED');


INSERT INTO `snooker_booking`.`board_type` (`board_type_id`, `board_type_name`) VALUES ('1', 'English');
INSERT INTO `snooker_booking`.`board_type` (`board_type_id`, `board_type_name`) VALUES ('2', 'French');
INSERT INTO `snooker_booking`.`board_type` (`board_type_id`, `board_type_name`) VALUES ('3', 'Semi English');
INSERT INTO `snooker_booking`.`board_type` (`board_type_id`, `board_type_name`) VALUES ('4', 'Pool');
INSERT INTO `snooker_booking`.`board_type` (`board_type_id`, `board_type_name`) VALUES ('5', 'French/Pool');


INSERT INTO `snooker_booking`.`location` (`location_id`, `address_line1`, `address_line2`, `pincode`, `city`, `state`) VALUES ('1', 'Snooker Parlour', 'Address line2', '517004', '1', "Telengana");
INSERT INTO `snooker_booking`.`location` (`location_id`, `address_line1`, `address_line2`, `pincode`, `city`, `state`) VALUES ('2', 'Snooker Parlour', 'Address line2', '517004', '1', "Telengana");
INSERT INTO `snooker_booking`.`location` (`location_id`, `address_line1`, `address_line2`, `pincode`, `city`, `state`) VALUES ('3', 'Snooker Parlour', 'Address line2', '517004', '1', "Telengana");
INSERT INTO `snooker_booking`.`location` (`location_id`, `address_line1`, `address_line2`, `pincode`, `city`, `state`) VALUES ('4', 'Snooker Parlour', 'Address line2', '517004', '2', "Tamilnadu");
INSERT INTO `snooker_booking`.`location` (`location_id`, `address_line1`, `address_line2`, `pincode`, `city`, `state`) VALUES ('5', 'Snooker Parlour', 'Address line2', '517004', '2', "Tamilnadu");
INSERT INTO `snooker_booking`.`location` (`location_id`, `address_line1`, `address_line2`, `pincode`, `city`, `state`) VALUES ('6', 'Snooker Parlour', 'Address line2', '517004', '3', "Karnataka");


INSERT INTO `snooker_booking`.`parlour_owner` (`owner_id`, `email`, `first_name`, `last_name`, `phone_no`) VALUES ('1', 'vignesh.n.s@gmail.com', 'Vignesh', 'Siva', '9032849214');
INSERT INTO `snooker_booking`.`parlour_owner` (`owner_id`, `email`, `first_name`, `last_name`, `phone_no`) VALUES ('2', 'lalith@gmail.com', 'Lalith', 'Punagani', '9182736450');

INSERT INTO `snooker_booking`.`parlour` (`parlour_id`, `description`, `mail_id`, `parlour_name`, `phone_no`, `location`, `owner`) VALUES ('1', 'Parlour asd auar adsfi ads inr an aaf adf ren adfuqr', 'vignesh.siva@gmail.com', 'Sudo Parlout', '9032849214', '1', '1');
INSERT INTO `snooker_booking`.`parlour` (`parlour_id`, `description`, `mail_id`, `parlour_name`, `phone_no`, `location`, `owner`) VALUES ('2', 'parlour asdf reww adsf hnl  iah ygy uanna dhu uahd odlis hofrh auhdf 9hrf .', 'parlour@invalidmail.com', 'Lallu Snookers', '9182736450', '2', '2');
