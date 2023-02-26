--liquibase formatted sql
--changeset Antonio Lucian:inset-role-01

INSERT INTO user_roles (id, role) VALUES (uuid_generate_v4(), 'MANAGER');
INSERT INTO user_roles (id, role) VALUES (uuid_generate_v4(), 'CEO');
INSERT INTO user_roles (id, role) VALUES (uuid_generate_v4(), 'TRANSPORTER');