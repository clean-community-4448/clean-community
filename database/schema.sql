USE cleancommunity;

CREATE TABLE IF NOT EXISTS users (
    username    varchar(20) NOT NULL UNIQUE,
    password    varchar(20) NOT NULL,
    id          int NOT NULL UNIQUE AUTO_INCREMENT,
    firstname   varchar(20) NOT NULL DEFAULT '',
    lastname    varchar(20) NOT NULL DEFAULT '',
    is_admin    boolean NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS postings (
    id          int NOT NULL UNIQUE AUTO_INCREMENT,
    title       varchar(255) NOT NULL,
    description varchar(1000) NOT NULL,
    submitter   varchar(20) NOT NULL,
    location    varchar(20) NOT NULL,
    accepted    boolean NOT NULL DEFAULT 0
);

-- For development purposes
INSERT INTO users(username, password) values("barklin", "missouri");
INSERT INTO users(username, password) values("dooferd", "tekaxes");
INSERT INTO users(username, password, is_admin) values("t2nerb", "password", 1);
