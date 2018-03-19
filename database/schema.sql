USE cleancommunity;

CREATE TABLE IF NOT EXISTS users (
    id          int NOT NULL UNIQUE AUTO_INCREMENT,
    firstName   varchar(20),
    lastName    varchar(20),
    userName    varchar(20) NOT NULL UNIQUE
)
