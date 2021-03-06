# Created_by: Hieu_iceTea
# Created_at: 08:45 2021-07-22
# Updated_at: 09:00 2021-07-22

# = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = #
#                                           Create DataBase                                           #
# = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = #

# SET @DATABASE_Name = 'Practice_EAD_Spring';

# Create DataBase >> (Lúc nhập dữ liệu để deploy thì bỏ 2 dòng tạo DB này, nhớ đổi tên DB nữa nhé)
DROP DATABASE IF EXISTS `Practice_EAD_Spring`;
CREATE DATABASE IF NOT EXISTS `Practice_EAD_Spring` CHARACTER SET utf8 COLLATE utf8_unicode_ci;

USE `Practice_EAD_Spring`;

SET time_zone = '+07:00';
ALTER DATABASE `Practice_EAD_Spring` CHARACTER SET utf8 COLLATE utf8_unicode_ci;

# SET SQL_MODE = 'ALLOW_INVALID_DATES';

# = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = #
#                                            Create Tables                                            #
# = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = #

# Create Table users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users`
(
    `id`                  INT AUTO_INCREMENT,

    `restaurant_id`       INT UNSIGNED,

    `username`            VARCHAR(64) UNIQUE           NOT NULL,
    `email`               VARCHAR(64) UNIQUE           NOT NULL,
    `password`            VARCHAR(128)                 NOT NULL,

    `email_verified_at`   DATETIME,
    `verification_code`   VARCHAR(8)     DEFAULT NULL,
    `reset_password_code` VARCHAR(16)    DEFAULT NULL,
    `remember_token`      VARCHAR(128)   DEFAULT NULL,

    `image`               VARCHAR(128),
    `gender`              BOOLEAN,
    `name`                VARCHAR(64),
    `phone`               VARCHAR(16),
    `address`             VARCHAR(128),

    `wage`                DECIMAL(16, 2) DEFAULT 0     NOT NULL,

    `enabled`             BOOLEAN        DEFAULT FALSE NOT NULL,

    `created_by`          NVARCHAR(32)   DEFAULT 'Hieu_iceTea',
    `created_at`          TIMESTAMP      DEFAULT CURRENT_TIMESTAMP,
    `updated_by`          NVARCHAR(32)   DEFAULT NULL,
    `updated_at`          TIMESTAMP      DEFAULT CURRENT_TIMESTAMP,
    `version`             INT            DEFAULT 1,
    `deleted`             BOOLEAN        DEFAULT FALSE,

    PRIMARY KEY (`id`)
) ENGINE InnoDB;


# Create Table authorities
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE IF NOT EXISTS `authorities`
(
    `id`         INT AUTO_INCREMENT,

    `username`   VARCHAR(64)  NOT NULL,
    `authority`  VARCHAR(128) NOT NULL,

    `created_by` NVARCHAR(32) DEFAULT 'Hieu_iceTea',
    `created_at` TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
    `updated_by` NVARCHAR(32) DEFAULT NULL,
    `updated_at` TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
    `version`    INT          DEFAULT 1,
    `deleted`    BOOLEAN      DEFAULT FALSE,

    PRIMARY KEY (`id`)
) ENGINE InnoDB;


# Create Table employees
DROP TABLE IF EXISTS `employees`;
CREATE TABLE IF NOT EXISTS `employees`
(
    `id`                  INT AUTO_INCREMENT,

    `name`                VARCHAR(64),
    `wage`                DECIMAL(16, 2) DEFAULT 0     NOT NULL,

    `created_by`          NVARCHAR(32)   DEFAULT 'Hieu_iceTea',
    `created_at`          TIMESTAMP      DEFAULT CURRENT_TIMESTAMP,
    `updated_by`          NVARCHAR(32)   DEFAULT NULL,
    `updated_at`          TIMESTAMP      DEFAULT CURRENT_TIMESTAMP,
    `version`             INT            DEFAULT 1,
    `deleted`             BOOLEAN        DEFAULT FALSE,

    PRIMARY KEY (`id`)
) ENGINE InnoDB;


# = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = #
#                                             Insert Data                                             #
# = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = #

# Default password: 123456

INSERT INTO users (id, restaurant_id, username, email, password, email_verified_at, image, gender, name, phone, address, enabled)
VALUES
(13, NULL, 'Hieu_iceTea', 'DinhHieu8896@gmail.com', '{bcrypt}$2y$10$//Od0OmEqRwFepW3wynrYOwslyvaS.snzBbpWwskF1Zrg5fNI.eTe', '1996-08-08', 'Hieu_iceTea.jpg', 1, 'Nguyễn Đình Hiếu', '0868 6633 15', '8, Ton That Thuyet, Ha Noi, Viet Nam', TRUE),
(12, NULL, 'ThiDK', 'ThiDK@fpt.edu.vn ', '{bcrypt}$2y$10$//Od0OmEqRwFepW3wynrYOwslyvaS.snzBbpWwskF1Zrg5fNI.eTe', '2021-08-08', 'ThiDK.jpg', 2, 'Đặng Kim Thi', '0868 6633 15', '8, Ton That Thuyet, Ha Noi, Viet Nam', TRUE),
(11, NULL, 'DinhHieu8896', 'HieuNDTH1908028@fpt.edu.vn', '{bcrypt}$2y$10$//Od0OmEqRwFepW3wynrYOwslyvaS.snzBbpWwskF1Zrg5fNI.eTe', '2021-08-08', 'DinhHieu8896.jpg', 1, 'Nguyễn Đình Hiếu', '0868 6633 15', '8, Ton That Thuyet, Ha Noi, Viet Nam', TRUE),
(10, NULL, 'HungNPMTH1908050', 'HungNPMTH1908050@fpt.edu.vn', '{bcrypt}$2y$10$//Od0OmEqRwFepW3wynrYOwslyvaS.snzBbpWwskF1Zrg5fNI.eTe', '2021-08-08', 'HungNPMTH1908050.jpg', 1, 'Nông Phan Mạnh Hùng', '0868 6633 15', '8, Ton That Thuyet, Ha Noi, Viet Nam', TRUE),
(9, NULL, 'HuyVQTH1909003', 'HuyVQTH1909003@fpt.edu.vn', '{bcrypt}$2y$10$//Od0OmEqRwFepW3wynrYOwslyvaS.snzBbpWwskF1Zrg5fNI.eTe', '2021-08-08', 'HuyVQTH1909003.jpg', 1, 'Vũ Quang Huy', '0868 6633 15', '8, Ton That Thuyet, Ha Noi, Viet Nam', TRUE),
(8, NULL, 'AnhNTTH1908059', 'AnhNTTH1908059@fpt.edu.vn', '{bcrypt}$2y$10$//Od0OmEqRwFepW3wynrYOwslyvaS.snzBbpWwskF1Zrg5fNI.eTe', '2021-08-08', 'AnhNTTH1908059.jpg', 1, 'Nguyễn Trung Anh', '0868 6633 15', '8, Ton That Thuyet, Ha Noi, Viet Nam', TRUE),
(7, NULL, 'Customer', 'codedy.demo@gmail.com', '{bcrypt}$2y$10$//Od0OmEqRwFepW3wynrYOwslyvaS.snzBbpWwskF1Zrg5fNI.eTe', '2021-08-08', 'customer.jpg', 1, 'CODEDY Customer', '0868 6633 15', 'Codedy, Ha Noi, Viet Nam', TRUE),
(6, 3, 'Staff_C', 'staff_c.codedy@gmail.com', '{bcrypt}$2y$10$//Od0OmEqRwFepW3wynrYOwslyvaS.snzBbpWwskF1Zrg5fNI.eTe', '2021-08-08', 'staff_c.jpg', 1, 'CODEDY Staff C', '0868 6633 15', 'Codedy, Ha Noi, Viet Nam', TRUE),
(5, 2, 'Staff_B', 'staff_b.codedy@gmail.com', '{bcrypt}$2y$10$//Od0OmEqRwFepW3wynrYOwslyvaS.snzBbpWwskF1Zrg5fNI.eTe', '2021-08-08', 'staff_b.jpg', 2, 'CODEDY Staff B', '0868 6633 15', 'Codedy, Ha Noi, Viet Nam', TRUE),
(4, 1, 'Staff_A', 'staff_a.codedy@gmail.com', '{bcrypt}$2y$10$//Od0OmEqRwFepW3wynrYOwslyvaS.snzBbpWwskF1Zrg5fNI.eTe', '2021-08-08', 'staff_a.jpg', 1, 'CODEDY Staff A', '0868 6633 15', 'Codedy, Ha Noi, Viet Nam', TRUE),
(3, NULL, 'Admin_ReadOnly', 'admin_readOnly.codedy@gmail.com', '{bcrypt}$2y$10$//Od0OmEqRwFepW3wynrYOwslyvaS.snzBbpWwskF1Zrg5fNI.eTe', '2021-08-08', 'admin_readOnly.jpg', 1, 'CODEDY Admin ReadOnly', '0868 6633 15', 'Codedy, Ha Noi, Viet Nam', FALSE),
(2, NULL, 'Admin', 'admin.codedy@gmail.com', '{bcrypt}$2y$10$//Od0OmEqRwFepW3wynrYOwslyvaS.snzBbpWwskF1Zrg5fNI.eTe', '2021-08-08', 'admin.jpg', 1, 'CODEDY Admin', '0868 6633 15', 'Codedy, Ha Noi, Viet Nam', TRUE),
(1, NULL, 'Host', 'host.codedy@gmail.com', '{bcrypt}$2y$10$//Od0OmEqRwFepW3wynrYOwslyvaS.snzBbpWwskF1Zrg5fNI.eTe', '2021-08-08', 'host.jpg', 1, 'CODEDY Host', '032 87 99 000', 'Codedy, Ha Noi, Viet Nam', TRUE);


INSERT INTO authorities (username, authority)
VALUES
('Host', 'ROLE_HOST'),
('Admin', 'ROLE_ADMIN'),
('Admin_ReadOnly', 'ROLE_ADMIN'),
('Admin_ReadOnly', 'ROLE_ADMIN_ReadOnly'),
('Staff_A', 'ROLE_STAFF'),
('Staff_B', 'ROLE_STAFF'),
('Staff_C', 'ROLE_STAFF'),
('Customer', 'ROLE_CUSTOMER'),
('DinhHieu8896', 'ROLE_CUSTOMER'),
('Hieu_iceTea', 'ROLE_HOST'),
('Hieu_iceTea', 'ROLE_ADMIN'),
('Hieu_iceTea', 'ROLE_STAFF'),
('Hieu_iceTea', 'ROLE_CUSTOMER');


INSERT INTO employees (id, name, wage)
VALUES
(13, 'Nguyễn Đình Hiếu', 12000),
(12, 'Đặng Kim Thi', 12000),
(11, 'Nguyễn Đình Hiếu', 12000),
(10, 'Nông Phan Mạnh Hùng', 12000),
(9, 'Vũ Quang Huy', 12000),
(8, 'Nguyễn Trung Anh', 12000),
(7, 'CODEDY Customer', 12000),
(6, 'CODEDY Staff C', 12000),
(5, 'CODEDY Staff B', 12000),
(4, 'CODEDY Staff A', 12000),
(3, 'CODEDY Admin ReadOnly', 12000),
(2, 'CODEDY Admin', 12000),
(1, 'CODEDY Host', 12000);
