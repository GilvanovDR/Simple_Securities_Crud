DROP TABLE IF EXISTS "QUOTATIONS";
DROP TABLE IF EXISTS "SECURITIES";

CREATE TABLE SECURITIES
(
    sec_id            VARCHAR(36)             NOT NULL PRIMARY KEY,
    reg_number        VARCHAR(189)            ,
    name             VARCHAR(765)            NOT NULL,
    emitent_title    VARCHAR(765)            NOT NULL
);

CREATE TABLE QUOTATIONS
(
    id          INTEGER                      NOT NULL PRIMARY KEY,
    sec_id       VARCHAR(36)                  NOT NULL,
    trade_date   DATE                         NOT NULL,
    num_trades   double                       NOT NULL,
    open        double                       ,
    close       double                       ,
    FOREIGN KEY (sec_id) REFERENCES securities(sec_id) ON DELETE CASCADE
);



