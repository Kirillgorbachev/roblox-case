TRUNCATE TABLE pet_cards CASCADE ;
INSERT INTO pet_cards (id, pet_id)
VALUES
    (1001, 1001),
    (1002, 1002),
    (1003, 1003),
    (1004, 1004),
    (1005, 1005),
    (1006, 1006),
    (1007, 1007),
    (1008, 1008),
    (1009, 1009),
    (1010, 1010),
    (1011, 1011),
    (1012, 1012),
    (1013, 1013),
    (1014, 1014),
    (1015, 1015),
    (1016, 1016),
    (1017, 1017),
    (1018, 1018),
    (1019, 1019),
    (1020, 1020),
    (1021, 1021),
    (1022, 1022),
    (1023, 1023),
    (1024, 1024),
    (1025, 1025),
    (1026, 1026),
    (1027, 1027),
    (1028, 1028),
    (1029, 1029),
    (1030, 1030);
ALTER SEQUENCE pet_cards_seq RESTART WITH 1031;
INSERT INTO pet_cards_pet_properties (pet_card_id, pet_property_id)
VALUES
    (1001, 1),
    (1002, 1),
    (1003, 1),
    (1004, 1),
    (1005, 1),
    (1006, 1),
    (1007, 1),
    (1008, 1),
    (1009, 1),
    (1010, 1),
    (1011, 2),
    (1012, 2),
    (1013, 2),
    (1014, 2),
    (1015, 2),
    (1016, 1),
    (1017, 2),
    (1018, 2),
    (1019, 2),
    (1020, 1),
    (1021, 2),
    (1022, 2),
    (1023, 2),
    (1024, 2),
    (1025, 2),
    (1026, 1),
    (1027, 1),
    (1028, 2),
    (1029, 2),
    (1030, 1),
    (1021, 3),
    (1022, 3),
    (1023, 3),
    (1024, 3),
    (1025, 3),
    (1026, 3),
    (1027, 3),
    (1028, 3),
    (1029, 3),
    (1030, 3),
    (1025, 4),
    (1026, 4),
    (1027, 4),
    (1028, 4),
    (1029, 4),
    (1030, 4);
