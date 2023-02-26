--liquibase formatted sql
--changeset Antonio Lucian:create-tables

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table if not exists ceos (
id uuid NOT NULL DEFAULT uuid_generate_v4() PRIMARY KEY,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
phone_number VARCHAR(50) NOT NULL,
email VARCHAR(50) NOT NULL,
password VARCHAR(250) NOT NULL,
birthday DATE NOT NULL,
company_id uuid,
user_role_id uuid
);

create table if not exists employees (
id uuid NOT NULL DEFAULT uuid_generate_v4() PRIMARY KEY,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
phone_number VARCHAR(50) NOT NULL,
email VARCHAR(50) NOT NULL,
password VARCHAR(250) NOT NULL,
birthday DATE NOT NULL,
status VARCHAR(50) NOT NULL,
company_id uuid,
user_role_id uuid
);

create table if not exists companies (
id uuid NOT NULL DEFAULT uuid_generate_v4() PRIMARY KEY,
name VARCHAR(50) NOT NULL
);

create table if not exists invitationLinks (
id uuid NOT NULL DEFAULT uuid_generate_v4() PRIMARY KEY,
value VARCHAR(50) NOT NULL,
user_roles VARCHAR(50) NOT NULL,
created_at DATE NOT NULL,
company_id uuid
);

create table if not exists user_roles (
id uuid NOT NULL DEFAULT uuid_generate_v4() PRIMARY KEY,
role VARCHAR(50) NOT NULL
);

-- User table relationships --

alter table
ceos
add
constraint fk_CompanyCeos FOREIGN KEY (company_id) REFERENCES companies(id);

alter table
ceos
add
constraint fk_UserRoleCeos FOREIGN KEY (user_role_id) REFERENCES user_roles(id);

alter table
employees
add
constraint fk_CompanyEmployees FOREIGN KEY (company_id) REFERENCES companies(id);

alter table
employees
add
constraint fk_UserRoleEmployees FOREIGN KEY (user_role_id) REFERENCES user_roles(id);

-- Invitation link table relationships --

alter table
invitationLinks
add
constraint fk_CompanyInvitationLinks FOREIGN KEY (company_id) REFERENCES companies(id);