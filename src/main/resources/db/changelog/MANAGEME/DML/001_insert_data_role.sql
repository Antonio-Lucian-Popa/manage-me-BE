--liquibase formatted sql
--changeset Antonio Lucian:inset-role-01

INSERT INTO user_roles(role,id) VALUES ('MANAGER', uuid_generate_v4());
INSERT INTO user_roles(role,id) VALUES ('CEO', uuid_generate_v4());
INSERT INTO user_roles(role,id) VALUES ('TRANSPORTER', uuid_generate_v4());