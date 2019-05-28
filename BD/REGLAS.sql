--REGLAS DE CLAVE PRIMARIA.

ALTER TABLE estudiante ADD CONSTRAINT estudiante_pk PRIMARY KEY ( id_est );
ALTER TABLE acudiente ADD CONSTRAINT acudiente_pk PRIMARY KEY ( id_ac );
ALTER TABLE administrador ADD CONSTRAINT administrador_pk PRIMARY KEY ( id_ad );
ALTER TABLE pago ADD CONSTRAINT pago_pk PRIMARY KEY ( id_pago );
ALTER TABLE entrenador ADD CONSTRAINT entrenador_pk PRIMARY KEY ( id_ent );
ALTER TABLE deporte ADD CONSTRAINT deporte_pk PRIMARY KEY ( id_dep );
ALTER TABLE categoria ADD CONSTRAINT categoria_pk PRIMARY KEY ( id_cat );
ALTER TABLE clase ADD CONSTRAINT clase_pk PRIMARY KEY ( id_c );
ALTER TABLE objetivo ADD CONSTRAINT objetivo_pk PRIMARY KEY ( id_ob );

--REGLAS DE CLAVE FORANEA.

ALTER TABLE acudiente ADD CONSTRAINT acudiente_pago_fk FOREIGN KEY ( pago_id_pago ) REFERENCES pago ( id_pago );
ALTER TABLE acudiente ADD CONSTRAINT acudiente_estudiante_fk FOREIGN KEY ( estudiante_id_est ) REFERENCES estudiante ( id_est );
ALTER TABLE clase ADD CONSTRAINT clase_entrenador_fk FOREIGN KEY ( entrenador_id_ent ) REFERENCES entrenador ( id_ent );
ALTER TABLE clase ADD CONSTRAINT clase_deporte_fk FOREIGN KEY ( deporte_id_dep ) REFERENCES deporte ( id_dep );
ALTER TABLE objetivo ADD CONSTRAINT objetivo_entrenador_fk FOREIGN KEY ( entrenador_id_ent ) REFERENCES entrenador ( id_ent );
ALTER TABLE objetivo ADD CONSTRAINT objetivo_clase_fk FOREIGN KEY ( clase_id_c ) REFERENCES clase ( id_c );
ALTER TABLE categoria ADD CONSTRAINT categoria_deporte_fk FOREIGN KEY ( deporte_id_dep ) REFERENCES deporte ( id_dep );
ALTER TABLE estudiante ADD CONSTRAINT estudiante_clase_fk FOREIGN KEY ( clase_id_c ) REFERENCES clase ( id_c );

--REGLAS DE OBLIGATORIEDAD.

ALTER TABLE administrador ADD CONSTRAINT nn_nombre_ad CHECK (nombre_ad IS NOT NULL);
ALTER TABLE administrador ADD CONSTRAINT nn_apellido_ad CHECK (apellido_ad IS NOT NULL);
ALTER TABLE administrador ADD CONSTRAINT nn_contrasena_ad CHECK (contrasena_ad IS NOT NULL);
ALTER TABLE administrador ADD CONSTRAINT nn_correo_ad CHECK (correo_ad IS NOT NULL);

--Validar que no contenga numeros

ALTER TABLE administrador ADD CONSTRAINT nl_nombre_ad CHECK (nombre_ad NOT LIKE '%[0-9]%');
ALTER TABLE administrador ADD CONSTRAINT nl_apellido_ad CHECK (apellido_ad NOT LIKE '%[0-9]%');

ALTER TABLE pago ADD CONSTRAINT nn_pago_total CHECK (pago_total IS NOT NULL);
ALTER TABLE pago ADD CONSTRAINT nn_fecha_factu CHECK (fecha_factu IS NOT NULL);
ALTER TABLE pago ADD CONSTRAINT nn_fecha_limite_pago CHECK (fecha_limite IS NOT NULL);
ALTER TABLE pago ADD CONSTRAINT nn_estado_pago CHECK (estado_pago IS NOT NULL);

--Valida pago sea mayor que 0$

ALTER TABLE pago ADD CONSTRAINT nl_pago_total CHECK (pago_total >= 0);

ALTER TABLE entrenador ADD CONSTRAINT nn_nombre_ent CHECK (nombre_ent IS NOT NULL);
ALTER TABLE entrenador ADD CONSTRAINT nn_apellido_ent CHECK (apellido_ent IS NOT NULL);
ALTER TABLE entrenador ADD CONSTRAINT nn_genero_ent CHECK (genero_ent IS NOT NULL);
ALTER TABLE entrenador ADD CONSTRAINT nn_correo_ent CHECK (correo_ent IS NOT NULL);
ALTER TABLE entrenador ADD CONSTRAINT nn_contrasena_ent CHECK (contrasena_ent IS NOT NULL);

--Validar que no contenga numeros

ALTER TABLE entrenador ADD CONSTRAINT nl_nombre_ent CHECK (nombre_ent NOT LIKE '%[0-9]%');
ALTER TABLE entrenador ADD CONSTRAINT nl_apellido_ent CHECK (apellido_ent NOT LIKE '%[0-9]%');

-- Validar genero sea 'm' o 'f'

ALTER TABLE entrenador ADD CONSTRAINT nl_genero_ent CHECK ((genero_ent = 'F') OR (genero_ent = 'M'));

ALTER TABLE deporte ADD CONSTRAINT nn_nombre_dep CHECK (nombre_dep IS NOT NULL);
ALTER TABLE deporte ADD CONSTRAINT nn_tipo_dep CHECK (tipo_dep IS NOT NULL);
ALTER TABLE deporte ADD CONSTRAINT nn_estado_dep CHECK (estado_dep IS NOT NULL);

--Validar que no contenga numeros

ALTER TABLE deporte ADD CONSTRAINT nl_nombre_dep CHECK (nombre_dep NOT LIKE '%[0-9]%');
ALTER TABLE deporte ADD CONSTRAINT nl_estado_dep CHECK (estado_dep NOT LIKE '%[0-9]%');

ALTER TABLE categoria ADD CONSTRAINT nn_tipo_cat CHECK (tipo_cat IS NOT NULL);
ALTER TABLE categoria ADD CONSTRAINT nn_descripcion_cat CHECK (descripcion_cat IS NOT NULL);

--Validar que no contenga numeros

ALTER TABLE categoria ADD CONSTRAINT nl_tipo_cat CHECK (tipo_cat NOT LIKE '%[0-9]%');

ALTER TABLE clase ADD CONSTRAINT nn_fecha_inicio CHECK (fecha_inicio IS NOT NULL);
ALTER TABLE clase ADD CONSTRAINT nn_fecha_finalizacion CHECK (fecha_finalizacion IS NOT NULL);
ALTER TABLE clase ADD CONSTRAINT nn_costo CHECK (costo IS NOT NULL);
--Costo puede ir de $0
ALTER TABLE clase ADD CONSTRAINT nl_costo CHECK (costo >= 0);

ALTER TABLE objetivo ADD CONSTRAINT nn_fecha_ob CHECK (fecha_ob IS NOT NULL);
ALTER TABLE objetivo ADD CONSTRAINT nn_nombre_ob CHECK (nombre_ob IS NOT NULL);
ALTER TABLE objetivo ADD CONSTRAINT nn_descripcion_ob CHECK (descripcion_ob IS NOT NULL);
ALTER TABLE objetivo ADD CONSTRAINT nn_estado_ob CHECK (estado_ob IS NOT NULL);
ALTER TABLE objetivo ADD CONSTRAINT nn_puntuacion_ob CHECK (puntuacion_ob IS NOT NULL);

--Validar que no contenga numeros

ALTER TABLE objetivo ADD CONSTRAINT nl_nombre_ob CHECK (nombre_ob NOT LIKE '%[0-9]%');
ALTER TABLE objetivo ADD CONSTRAINT nl_estado_ob CHECK (estado_ob NOT LIKE '%[0-9]%');

--Valida la putuacion sea de 0 a 5
ALTER TABLE objetivo ADD CONSTRAINT nl_puntuacion_ob CHECK ((puntuacion_ob >= 0) and (puntuacion_ob <= 5));


ALTER TABLE estudiante ADD CONSTRAINT nn_nombre_est CHECK (nombre_est IS NOT NULL);
ALTER TABLE estudiante ADD CONSTRAINT nn_apellido_est CHECK (apellido_est IS NOT NULL);
ALTER TABLE estudiante ADD CONSTRAINT nn_genero_est CHECK (genero_est IS NOT NULL);
ALTER TABLE estudiante ADD CONSTRAINT nn_fecha_nacimiento_est CHECK (fecha_nacimiento_est IS NOT NULL);
ALTER TABLE estudiante ADD CONSTRAINT nn_estado_est CHECK (estado_est IS NOT NULL); 

--Validar que no contenga numeros

ALTER TABLE estudiante ADD CONSTRAINT nl_nombre_est CHECK (nombre_est NOT LIKE '%[0-9]%');
ALTER TABLE estudiante ADD CONSTRAINT nl_apellido_est CHECK (apellido_est NOT LIKE '%[0-9]%');

-- Validar genero sa 'm' o 'f'
ALTER TABLE estudiante ADD CONSTRAINT nl_genero_est CHECK ((genero_est = 'F') OR (genero_est = 'M'));

ALTER TABLE acudiente ADD CONSTRAINT nn_nombre_ac CHECK (nombre_ac IS NOT NULL);
ALTER TABLE acudiente ADD CONSTRAINT nn_apellido_ac CHECK (apellido_ac IS NOT NULL);
ALTER TABLE acudiente ADD CONSTRAINT nn_genero_ac CHECK (genero_ac IS NOT NULL);
ALTER TABLE acudiente ADD CONSTRAINT nn_rol_ac CHECK (rol_ac IS NOT NULL);
ALTER TABLE acudiente ADD CONSTRAINT nn_correo_ac CHECK (correo_ac IS NOT NULL);
ALTER TABLE acudiente ADD CONSTRAINT nn_contrasena_ac CHECK (contrasena_ac IS NOT NULL);

--Validar que no contenga numeros

ALTER TABLE acudiente ADD CONSTRAINT nl_nombre_ac CHECK (nombre_ac NOT LIKE '%[0-9]%');
ALTER TABLE acudiente ADD CONSTRAINT nl_apellido_ac CHECK (apellido_ac NOT LIKE '%[0-9]%');
ALTER TABLE acudiente ADD CONSTRAINT nl_rol_ac CHECK (rol_ac NOT LIKE '%[0-9]%');

-- Validar genero sea 'm' o 'f'

ALTER TABLE acudiente ADD CONSTRAINT nl_genero_ac CHECK ((genero_ac = 'F') OR (genero_ac = 'M'));