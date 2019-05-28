DROP TABLE estudiante;
DROP TABLE acudiente;
DROP TABLE clase;
DROP TABLE objetivo;
DROP TABLE pago;
DROP TABLE entrenador;
DROP TABLE deporte;
DROP TABLE categoria;
DROP TABLE administrador;

--CREACIÓN DE LAS TABLAS.

CREATE TABLE estudiante (
    id_est                 VARCHAR2(15) NOT NULL,
    nombre_est             VARCHAR2(30) NOT NULL,
    apellido_est           VARCHAR2(30) NOT NULL,
    genero_est             VARCHAR2(1) NOT NULL,
    fecha_nacimiento_est   DATE NOT NULL,
    estado_est             VARCHAR2(30) NOT NULL,
    clase_id_c             VARCHAR2(15) NOT NULL
) TABLESPACE BD_EscuelaDeportes;

CREATE TABLE acudiente (
    id_ac               VARCHAR2(15) NOT NULL,
    nombre_ac           VARCHAR2(30) NOT NULL,
    apellido_ac         VARCHAR2(30) NOT NULL,
    genero_ac           VARCHAR2(1) NOT NULL,
    rol_ac              VARCHAR2(30) NOT NULL,
    correo_ac           VARCHAR2(50) NOT NULL,
    contrasena_ac       VARCHAR2(30) NOT NULL,
    pago_id_pago        VARCHAR2(15) NOT NULL,
    estudiante_id_est   VARCHAR2(15) NOT NULL
) TABLESPACE BD_EscuelaDeportes;

CREATE TABLE clase (
    id_c                 VARCHAR2(15) NOT NULL,
    fecha_inicio         DATE NOT NULL,
    fecha_finalizacion   DATE NOT NULL,
    costo                NUMBER NOT NULL,
    deporte_id_dep       VARCHAR2(15) NOT NULL,
    entrenador_id_ent    VARCHAR2(15) NOT NULL
) TABLESPACE BD_EscuelaDeportes;

CREATE TABLE objetivo (
    id_ob               VARCHAR2(15) NOT NULL,
    fecha_ob            DATE NOT NULL,
    nombre_ob           VARCHAR2(30) NOT NULL,
    descripcion_ob      VARCHAR2(200) NOT NULL,
    estado_ob           VARCHAR2(30) NOT NULL,
    puntuacion_ob       NUMBER NOT NULL,
    clase_id_c          VARCHAR2(15) NOT NULL,
    entrenador_id_ent   VARCHAR2(15) NOT NULL
) TABLESPACE BD_EscuelaDeportes;

CREATE TABLE pago (
    id_pago        VARCHAR2(15) NOT NULL,
    pago_total     NUMBER NOT NULL,
    fecha_factu    DATE NOT NULL,
    fecha_limite   DATE NOT NULL,
    estado_pago    VARCHAR2(30) NOT NULL
) TABLESPACE BD_EscuelaDeportes;

CREATE TABLE entrenador (
    id_ent           VARCHAR2(15) NOT NULL,
    nombre_ent       VARCHAR2(30) NOT NULL,
    apellido_ent     VARCHAR2(30) NOT NULL,
    genero_ent       VARCHAR2(1) NOT NULL,
    correo_ent       VARCHAR2(50) NOT NULL,
    contrasena_ent   VARCHAR2(30) NOT NULL
) TABLESPACE BD_EscuelaDeportes;


CREATE TABLE deporte (
    id_dep       VARCHAR2(15) NOT NULL,
    nombre_dep   VARCHAR2(30) NOT NULL,
    tipo_dep     VARCHAR2(200) NOT NULL,
    estado_dep   VARCHAR2(30) NOT NULL
) TABLESPACE BD_EscuelaDeportes;

CREATE TABLE categoria (
    id_cat            VARCHAR2(15) NOT NULL,
    tipo_cat          VARCHAR2(30) NOT NULL,
    descripcion_cat   VARCHAR2(200) NOT NULL,
    deporte_id_dep    VARCHAR2(15) NOT NULL
) TABLESPACE BD_EscuelaDeportes;

CREATE TABLE administrador (
    id_ad           VARCHAR2(15) NOT NULL,
    nombre_ad       VARCHAR2(30) NOT NULL,
    apellido_ad     VARCHAR2(30) NOT NULL,
    contrasena_ad   VARCHAR2(30) NOT NULL,
    correo_ad       VARCHAR2(50) NOT NULL
)TABLESPACE BD_EscuelaDeportes;