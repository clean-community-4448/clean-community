CREATE DATABASE IF NOT EXISTS cleancommunity;
USE cleancommunity;

CREATE TABLE IF NOT EXISTS users (
    username    varchar(20) NOT NULL UNIQUE,
    password    varchar(20) NOT NULL,
    id          int NOT NULL UNIQUE AUTO_INCREMENT,
    firstname   varchar(20) NOT NULL DEFAULT '',
    lastname    varchar(20) NOT NULL DEFAULT '',
    is_admin    boolean NOT NULL DEFAULT 0,
    inProgress  int,
    completed   int,
    posted      int
);

CREATE TABLE IF NOT EXISTS postings (
    id          int NOT NULL UNIQUE AUTO_INCREMENT,
    title       varchar(255) NOT NULL,
    description varchar(1000) NOT NULL,
    submitter   varchar(20) NOT NULL,
    location    varchar(40) NOT NULL,
    accepted    boolean NOT NULL DEFAULT 0
    completed   boolean NOT NULL DEFAULT 0
    flagged     boolean NOT NULL DEFAULT 0
);

-- For development purposes
-- User samples
INSERT INTO users(username, password) values("barklin", "missouri");
INSERT INTO users(username, password) values("dooferd", "tekaxes");
INSERT INTO users(username, password, is_admin) values("t2nerb", "password", 1);

-- Posting samples
INSERT INTO postings(title, description, submitter, location) values("dookies!", "dookies in da park", "t2nerb", "40.014986,-105.270546");
INSERT INTO postings(title, description, submitter, location) values("mo' dookies!", "dookies in da parks again", "t2nerb", "40.00,-105.270546");
