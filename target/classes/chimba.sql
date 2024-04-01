CREATE TABLE `genero`(
    `id` INT NOT NULL,
    `nombre_genero` VARCHAR(255) NOT NULL,
    `descripcion_genero` VARCHAR(255) NOT NULL,
    PRIMARY KEY(`id`)
);
CREATE TABLE `tipo_contenido`(
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nombre_contenido` VARCHAR(255) NOT NULL
);
CREATE TABLE `lista_audiovisual`(
    `id` INT NOT NULL,
    `nombre` VARCHAR(255) NOT NULL,
    `tipo_contenido_id` INT NOT NULL,
    `estado_visualizacion` VARCHAR(255) NOT NULL,
    `plataforma_id` INT NOT NULL,
    `calificacion` DECIMAL(8, 2) NULL,
    `comentario` VARCHAR(500) NULL,
    PRIMARY KEY(`id`)
);
CREATE TABLE `plataformas`(
    `id` INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nombre` VARCHAR(255) NOT NULL,
    `descripcion` VARCHAR(255) NOT NULL
);

CREATE TABLE `usuario`(
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nombre` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `lista_audiovisual_id` INT NULL
);

CREATE TABLE `genero_x_listaaudiovisual`(
    `genero_id` INT NOT NULL,
    `lista_id` INT NOT NULL,
    PRIMARY KEY(`genero_id`, `lista_id`)
);

ALTER TABLE
    `usuario` ADD UNIQUE `usuario_email_unique`(`email`);
ALTER TABLE
    `lista_audiovisual` ADD CONSTRAINT `listaaudiovisual_tipocontenido_id_foreign` FOREIGN KEY(`tipoContenido_id`) REFERENCES `tipoContenido`(`id`);
ALTER TABLE
    `genero_x_listaaudiovisual` ADD CONSTRAINT `generoxlistaaudiovisual_genero_id_foreign` FOREIGN KEY(`genero_id`) REFERENCES `genero`(`id`);
ALTER TABLE
    `usuario` ADD CONSTRAINT `usuario_listaaudiovisual_id_foreign` FOREIGN KEY(`listaAudiovisual_id`) REFERENCES `listaAudiovisual`(`id`);
ALTER TABLE
    `genero_x_listaaudiovisual` ADD CONSTRAINT `generoxlistaaudiovisual_lista_id_foreign` FOREIGN KEY(`lista_id`) REFERENCES `listaAudiovisual`(`id`);
ALTER TABLE
    `lista_audiovisual` ADD CONSTRAINT `listaaudiovisual_plataforma_id_foreign` FOREIGN KEY(`plataforma_id`) REFERENCES `plataformas`(`id`);
