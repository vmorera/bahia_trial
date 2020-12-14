CREATE TABLE IF NOT EXISTS BRAND(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME varchar(255) NOT NULL
);

INSERT INTO BRAND VALUES (1, 'ZARA');

CREATE TABLE IF NOT EXISTS PRICE(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY ,
    BRAND_ID BIGINT NOT NULL ,
    START_DATE TIMESTAMP NOT NULL ,
    END_DATE TIMESTAMP NOT NULL ,
    PRICE_LIST BIGINT NOT NULL ,
    PRODUCT_ID BIGINT NOT NULL ,
    PRIORITY BIGINT NOT NULL ,
    PRICE DECIMAL NOT NULL ,
    CURR VARCHAR(3) NOT NULL ,
    CONSTRAINT fk_brand FOREIGN KEY (BRAND_ID)
        REFERENCES BRAND(ID)
);

INSERT INTO PRICE VALUES (
        1, 1, '2020-06-14 00:00:00.000', '2020-12-31 23:59:59.000', 1, 35455, 0, 35.50, 'EUR');
INSERT INTO PRICE VALUES (
        2, 1, '2020-06-14 15:00:00.000', '2020-06-14 18:30:00.000', 2, 35455, 1, 25.45, 'EUR');
INSERT INTO PRICE VALUES (
        3, 1, '2020-06-15 00:00:00.000', '2020-06-15 11:00:00.000', 3, 35455, 1, 30.50, 'EUR');
INSERT INTO PRICE VALUES (
        4, 1, '2020-06-15 16:00:00.000', '2020-12-31 23:59:59.000', 4, 35455, 1, 38.95, 'EUR');