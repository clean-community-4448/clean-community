USE cleancommunity;

CREATE TABLE IF NOT EXISTS users (
    id          int NOT NULL UNIQUE AUTO_INCREMENT,
    firstName   varchar(20),
    lastName    varchar(20),
    userName    varchar(20) NOT NULL UNIQUE,
    password    varchar(20) NOT NULL,
    is_admin    boolean NOT NULL DEFAULT 0
)

CREATE TABLE IF NOT EXISTS postings (
    id          int NOT NULL UNIQUE AUTO_INCREMENT,
    title       varchar(255) NOT NULL,
    description varchar(1000) NOT NULL,
    submitter   varchar(20) NOT NULL,
    location    varchar(20) NOT NULL,
    accepted    boolean NOT NULL DEFAULT 0
)
