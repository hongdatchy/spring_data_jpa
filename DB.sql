CREATE TABLE bangA(
	id int NOT NULL AUTO_INCREMENT,
    name varchar(120) not null,
    primary key (id),
    UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE TABLE conA(
	id int NOT NULL AUTO_INCREMENT,
    bangA_id int not null,
    name varchar(120) not null,
    primary key (id),
    UNIQUE KEY `id_UNIQUE` (`id`),
    CONSTRAINT FOREIGN KEY (`bangA_id`) REFERENCES `bangA` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE TABLE chauA(
	id int NOT NULL AUTO_INCREMENT,
    conA_id int not null,
    name varchar(120) not null,
    primary key (id),
    UNIQUE KEY `id_UNIQUE` (`id`),
    CONSTRAINT FOREIGN KEY (`conA_id`) REFERENCES `conA` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE bangB(
	id int NOT NULL AUTO_INCREMENT,
    name varchar(120) not null,
    primary key (id),
    UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE bangTrungGian(
	id int NOT NULL AUTO_INCREMENT,
    bangA_id int not null,
    bangB_id int not null,
    name varchar(120) not null,
    primary key (id),
    UNIQUE KEY `id_UNIQUE` (`id`),
    CONSTRAINT FOREIGN KEY (`bangA_id`) REFERENCES `bangA` (`id`),
    CONSTRAINT FOREIGN KEY (`bangB_id`) REFERENCES `bangB` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
