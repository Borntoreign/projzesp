INSERT INTO CITY("CITY_NAME") VALUES ('Barcelona');
INSERT INTO CITY("CITY_NAME") VALUES ('London');
INSERT INTO CITY("CITY_NAME") VALUES ('Warsaw');
INSERT INTO CITY("CITY_NAME") VALUES ('Lodz');
INSERT INTO CITY("CITY_NAME") VALUES ('Redmond');
INSERT INTO CITY("CITY_NAME") VALUES ('A');
INSERT INTO CITY("CITY_NAME") VALUES ('B');
INSERT INTO CITY("CITY_NAME") VALUES ('C');
INSERT INTO CITY("CITY_NAME") VALUES ('D');

INSERT INTO USERS("EMAIL", "FIRST_NAME", "LAST_NAME", "PHONE_NUMBER", "AVATAR", "CITY_ID") VALUES ('lovciam@localhost', 'mateusz', 'su', '0700100200', 'default_photo.png', 1);
INSERT INTO USERS("EMAIL", "FIRST_NAME", "LAST_NAME", "PHONE_NUMBER", "AVATAR", "CITY_ID") VALUES ('lubieplacuszki@buziaczek.pl', 'adrian', 'sz', '0700300400', 'default_photo.png', 1);
INSERT INTO USERS("EMAIL", "FIRST_NAME", "LAST_NAME", "PHONE_NUMBER", "AVATAR", "CITY_ID") VALUES ('admin@test.com', 'admin', 'admin', '0700300400', 'default_photo.png', 1);

INSERT INTO ACCOUNT("LOGIN", "PASSWORD", "USER_ID") VALUES ('mateusz', 'mateusz', 1);
INSERT INTO ACCOUNT("LOGIN", "PASSWORD", "USER_ID") VALUES ('adrian' , 'adrian' , 2);
INSERT INTO ACCOUNT("LOGIN", "PASSWORD", "USER_ID") VALUES ('admin' , 'admin' , 3);

INSERT INTO ROUTE("START_CITY_ID", "END_CITY_ID") VALUES (1, 2);
INSERT INTO ROUTE("START_CITY_ID", "END_CITY_ID") VALUES (2, 3);
INSERT INTO ROUTE("START_CITY_ID", "END_CITY_ID") VALUES (3, 4);
INSERT INTO ROUTE("START_CITY_ID", "END_CITY_ID") VALUES (4, 5);
INSERT INTO ROUTE("START_CITY_ID", "END_CITY_ID") VALUES (6, 7);
INSERT INTO ROUTE("START_CITY_ID", "END_CITY_ID") VALUES (8, 9);

INSERT INTO TRANSIT("START_DATE", "DRIVER_ID", "ROUTE_ID", "ARCHIVED", "COST") VALUES ('2015-02-09 09:09:00.0', 1, 4, TRUE, 100);
INSERT INTO TRANSIT("START_DATE", "DRIVER_ID", "ROUTE_ID", "ARCHIVED", "COST") VALUES ('2015-02-10 12:10:00.0', 2, 3, FALSE, 200);
INSERT INTO TRANSIT("START_DATE", "DRIVER_ID", "ROUTE_ID", "ARCHIVED", "COST") VALUES ('2015-02-11 07:07:00.0', 2, 3, TRUE, 300);
INSERT INTO TRANSIT("START_DATE", "DRIVER_ID", "ROUTE_ID", "ARCHIVED", "COST") VALUES ('2015-02-11 10:10:00.0', 2, 3, FALSE, 1500);
INSERT INTO TRANSIT("START_DATE", "DRIVER_ID", "ROUTE_ID", "ARCHIVED", "COST") VALUES ('2015-02-11 16:16:00.0', 2, 3, FALSE, 50);
INSERT INTO TRANSIT("START_DATE", "DRIVER_ID", "ROUTE_ID", "ARCHIVED", "COST") VALUES ('2015-02-11 22:22:00.0', 2, 3, FALSE, 230);
INSERT INTO TRANSIT("START_DATE", "DRIVER_ID", "ROUTE_ID", "ARCHIVED", "COST") VALUES ('2015-02-15 15:15:00.0', 2, 2, FALSE, 430);
INSERT INTO TRANSIT("START_DATE", "DRIVER_ID", "ROUTE_ID", "ARCHIVED", "COST") VALUES ('2015-02-21 21:21:00.0', 2, 1, TRUE, 220);
INSERT INTO TRANSIT("START_DATE", "DRIVER_ID", "ROUTE_ID", "ARCHIVED", "COST") VALUES ('2015-02-21 21:21:00.0', 1, 5, TRUE, 340);
INSERT INTO TRANSIT("START_DATE", "DRIVER_ID", "ROUTE_ID", "ARCHIVED", "COST") VALUES ('2015-02-21 21:21:00.0', 2, 6, TRUE, 120);
INSERT INTO TRANSIT("START_DATE", "DRIVER_ID", "ROUTE_ID", "ARCHIVED", "COST") VALUES ('2015-02-10 12:10:00.0', 3, 3, FALSE, 100);
INSERT INTO TRANSIT("START_DATE", "DRIVER_ID", "ROUTE_ID", "ARCHIVED", "COST") VALUES ('2015-02-11 07:07:00.0', 3, 3, TRUE, 200);
INSERT INTO TRANSIT("START_DATE", "DRIVER_ID", "ROUTE_ID", "ARCHIVED", "COST") VALUES ('2015-02-11 10:10:00.0', 3, 3, FALSE, 250);
INSERT INTO TRANSIT("START_DATE", "DRIVER_ID", "ROUTE_ID", "ARCHIVED", "COST") VALUES ('2015-02-11 16:16:00.0', 3, 3, FALSE, 150);
INSERT INTO TRANSIT("START_DATE", "DRIVER_ID", "ROUTE_ID", "ARCHIVED", "COST") VALUES ('2015-02-11 22:22:00.0', 3, 3, FALSE, 230);

