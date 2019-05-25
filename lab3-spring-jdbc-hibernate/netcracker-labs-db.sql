-- Database: netcracker-labs-db

-- DROP DATABASE "netcracker-labs-db";

CREATE DATABASE "netcracker-labs-db"
WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- Table: public."Customer"

-- DROP TABLE public."Customer";

CREATE TABLE public."Customer"
(
    "last-name" character varying(100)[] COLLATE pg_catalog."default" NOT NULL,
    id integer NOT NULL,
    district character varying(200)[] COLLATE pg_catalog."default",
    sale double precision,
    CONSTRAINT "Customer_pkey" PRIMARY KEY (id)
)
WITH (
         OIDS = FALSE
     )
    TABLESPACE pg_default;

ALTER TABLE public."Customer"
    OWNER to postgres;
