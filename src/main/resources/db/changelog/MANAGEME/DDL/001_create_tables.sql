--liquibase formatted sql
--changeset Antonio Lucian:create-tables

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table if not exists users (
id uuid NOT NULL DEFAULT uuid_generate_v4() PRIMARY KEY,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
phone_number VARCHAR(50) NOT NULL,
email VARCHAR(50) NOT NULL,
password VARCHAR(250) NOT NULL,
birthday DATE NOT NULL,
user_roles VARCHAR(50) NOT NULL,
status VARCHAR(50) NOT NULL,
company_id uuid
);

create table if not exists companies (
id uuid NOT NULL DEFAULT uuid_generate_v4() PRIMARY KEY,
name VARCHAR(50) NOT NULL,
);

-- User table relationships --

alter table
users
add
constraint fk_CompanyUser FOREIGN KEY (company_id) REFERENCES companies(id);