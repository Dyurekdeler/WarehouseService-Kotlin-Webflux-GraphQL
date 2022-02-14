TRUNCATE TABLE delivery;

INSERT INTO delivery (id, product, supplier, quantity, expected_date, expected_warehouse, is_received) VALUES
(1, 'Bananas', 'JungleInc', 1000000, '2027-01-08T07:17:48.237Z', 'TheMoon', 0),
(2, 'Saiyans', 'Bardock', 9001, '2019-10-10T09:08:11.098Z', 'Namek', 0);