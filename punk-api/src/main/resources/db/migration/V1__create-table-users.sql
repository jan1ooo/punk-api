CREATE TABLE tb_users
(
    id_user  VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    CONSTRAINT pk_tb_users PRIMARY KEY (id_user)
);