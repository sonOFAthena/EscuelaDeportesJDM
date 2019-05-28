--Indices unique

CREATE UNIQUE INDEX iu_id_estudiante ON estudiante (id_est);

CREATE UNIQUE INDEX iu_id_acudiente ON acudiente ( id_ac, correo_ac);

CREATE UNIQUE INDEX iu_id_clase ON clase ( id_c );

CREATE UNIQUE INDEX iu_id_objetivo ON objetivo ( id_ob);

CREATE UNIQUE INDEX piu_id_pago ON pago ( id_pago);

CREATE UNIQUE INDEX iu_id_entrenador ON entrenador ( id_ent , correo_ent );

CREATE UNIQUE INDEX iu_id_deporte ON deporte ( id_dep );

CREATE UNIQUE INDEX iu_id_categoria ON categoria ( id_cat);

CREATE UNIQUE INDEX iu_id_administrador ON administrador ( id_ad, correo_ad );