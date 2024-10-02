INSERT INTO prices (id,start_date, end_date, price_list, product_id, priority, price, currency,brand_id) VALUES (1, '2020-06-14T00:00:00', '2020-12-31T23:59:59', 1, 35455, 0, 35.50, 'EUR', 1);
INSERT INTO prices (id,start_date, end_date, price_list, product_id, priority, price, currency,brand_id) VALUES (2, '2020-06-14T18:00:00', '2020-06-14T18:30:00', 2, 35455, 1, 25.45, 'EUR', 1);
INSERT INTO prices (id,start_date, end_date, price_list, product_id, priority, price, currency,brand_id) VALUES (3, '2020-06-15T00:00:00', '2020-06-15T11:00:00', 3, 35455, 1, 30.50, 'EUR', 1);
INSERT INTO prices (id,start_date, end_date, price_list, product_id, priority, price, currency,brand_id) VALUES (4, '2020-06-15T16:00:00', '2020-12-31T23:59:59', 4, 35455, 1, 38.95, 'EUR', 1);

INSERT INTO prices (id,start_date, end_date, price_list, product_id, priority, price, currency,brand_id) VALUES (5, '2020-06-14T00:00:00', '2020-12-31T23:59:59', 1, 35456, 0, 35.50, 'EUR', 2);
INSERT INTO prices (id,start_date, end_date, price_list, product_id, priority, price, currency,brand_id) VALUES (6, '2020-06-15T18:00:00', '2020-06-16T18:30:00', 2, 35456, 1, 25.45, 'EUR', 2);
INSERT INTO prices (id,start_date, end_date, price_list, product_id, priority, price, currency,brand_id) VALUES (7, '2020-06-15T00:00:00', '2020-06-17T11:00:00', 3, 35456, 1, 30.50, 'EUR', 2);
INSERT INTO prices (id,start_date, end_date, price_list, product_id, priority, price, currency,brand_id) VALUES (8, '2020-06-13T16:00:00', '2020-06-29T23:59:59', 4, 35456, 1, 38.95, 'EUR', 2);

ALTER SEQUENCE PRICES_SEQ RESTART WITH 9;
