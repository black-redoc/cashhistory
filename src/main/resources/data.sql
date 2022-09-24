CREATE TABLE expense(concept VARCHAR(255) NOT NULL, amount DOUBLE NOT NULL, created_at DATETIME, id INT NOT NULL AUTO_INCREMENT PRIMARY KEY);
INSERT INTO expense(concept, amount, created_at) VALUES('concept1', 1000.0, '2022-09-09 00:00:00');
INSERT INTO expense(concept, amount, created_at) VALUES('concept2', 100.0, '2022-09-10 00:00:00');
INSERT INTO expense(concept, amount, created_at) VALUES('concept3', 350.0, '2022-09-11 00:00:00');
INSERT INTO expense(concept, amount, created_at) VALUES('concept4', 250.0, '2022-09-12 00:00:00');

CREATE TABLE income(concept VARCHAR(255) NOT NULL, amount DOUBLE NOT NULL, created_at DATETIME, id INT NOT NULL AUTO_INCREMENT PRIMARY KEY);
INSERT INTO income(concept, amount, created_at) VALUES('concept1', 2500.0, '2022-09-09 00:00:00');
INSERT INTO income(concept, amount, created_at) VALUES('concept2', 200.0, '2022-09-09 00:00:00');
INSERT INTO income(concept, amount, created_at) VALUES('concept3', 3500.0, '2022-9-11 00:00:00');
INSERT INTO income(concept, amount, created_at) VALUES('concept4', 500.0, '2022-9-12 00:00:00');