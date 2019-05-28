--INSERCIÓN DE DATOS.

--TABLA administrador

INSERT INTO administrador (id_ad, nombre_ad, apellido_ad, contrasena_ad, correo_ad)
			  VALUES ('1035863564', 'JUAN DAVID', 'MEJIA MOLINA', '3456', 'JUAN_MEJIA93212@ELPOLI.EDU.CO');
INSERT INTO administrador (id_ad, nombre_ad, apellido_ad, contrasena_ad, correo_ad)
			  VALUES ('1038546244', 'MARLON', 'TOBON ARIAS', '1234', 'MARLON_TOBON43532@ELPOLI.EDU.CO');
INSERT INTO administrador (id_ad, nombre_ad, apellido_ad, contrasena_ad, correo_ad)
			  VALUES ('1152201360', 'EDWARD', 'MORENO LOPEZ', '1928', 'EDWARD_MORENO23214@ELPOLI.EDU.CO');

--TABLA deporte

INSERT INTO deporte (id_dep, nombre_dep, tipo_dep, estado_dep)
			  VALUES ('1001', 'FUTBOL', 'GRUPAL', 'OK');
INSERT INTO deporte (id_dep, nombre_dep, tipo_dep, estado_dep)
			  VALUES ('1002', 'FUTBOL', 'INDIVIDUAL', 'OK');
INSERT INTO deporte (id_dep, nombre_dep, tipo_dep, estado_dep)
			  VALUES ('1003', 'NATACION', 'GRUPAL', 'OK');
INSERT INTO deporte (id_dep, nombre_dep, tipo_dep, estado_dep)
			  VALUES ('1004', 'NATACION', 'INDIVIDUAL', 'OK');
INSERT INTO deporte (id_dep, nombre_dep, tipo_dep, estado_dep)
			  VALUES ('1005', 'BALONCESTO', 'GRUPAL', 'OK');
INSERT INTO deporte (id_dep, nombre_dep, tipo_dep, estado_dep)
			  VALUES ('1006', 'BALONCESTO', 'INDIVIDUAL', 'OK');


--TABLA categoria

INSERT INTO categoria (id_cat, tipo_cat, descripcion_cat, deporte_id_dep)
			  VALUES ('2001', 'SUB 10', 'SOLO INGRESARAN EN ESTA CATEGORIA CON LA EDAD DE 10 AÑOS A 9 AÑOS', '1001');
INSERT INTO categoria (id_cat, tipo_cat, descripcion_cat, deporte_id_dep)
			  VALUES ('2002', 'SUB 10', 'SOLO INGRESARAN EN ESTA CATEGORIA CON LA EDAD DE 10 AÑOS', '1002');
INSERT INTO categoria (id_cat, tipo_cat, descripcion_cat, deporte_id_dep)
			  VALUES ('2003', 'SUB 8', 'SOLO INGRESARAN EN ESTA CATEGORIA CON LA EDAD DE 8 AÑOS A 7 AÑOS', '1001');
INSERT INTO categoria (id_cat, tipo_cat, descripcion_cat, deporte_id_dep)
			  VALUES ('2004', 'SUB 7', 'SOLO INGRESARAN EN ESTA CATEGORIA CON LA EDAD DE 7 AÑOS', '1002');
INSERT INTO categoria (id_cat, tipo_cat, descripcion_cat, deporte_id_dep)
			  VALUES ('2005', 'SUB 6', 'SOLO INGRESARAN EN ESTA CATEGORIA CON LA EDAD DE 4 AÑOS A 6 AÑOS', '1001');

INSERT INTO categoria (id_cat, tipo_cat, descripcion_cat, deporte_id_dep)
			  VALUES ('2006', 'SUB 10', 'SOLO INGRESARAN EN ESTA CATEGORIA CON LA EDAD DE 10 AÑOS A 9 AÑOS', '1003');
INSERT INTO categoria (id_cat, tipo_cat, descripcion_cat, deporte_id_dep)
			  VALUES ('2007', 'SUB 10', 'SOLO INGRESARAN EN ESTA CATEGORIA CON LA EDAD DE 10 AÑOS', '1004');
INSERT INTO categoria (id_cat, tipo_cat, descripcion_cat, deporte_id_dep)
			  VALUES ('2008', 'SUB 8', 'SOLO INGRESARAN EN ESTA CATEGORIA CON LA EDAD DE 8 AÑOS A 7 AÑOS', '1003');
INSERT INTO categoria (id_cat, tipo_cat, descripcion_cat, deporte_id_dep)
			  VALUES ('2009', 'SUB 7', 'SOLO INGRESARAN EN ESTA CATEGORIA CON LA EDAD DE 7 AÑOS', '1004');
INSERT INTO categoria (id_cat, tipo_cat, descripcion_cat, deporte_id_dep)
			  VALUES ('2010', 'SUB 6', 'SOLO INGRESARAN EN ESTA CATEGORIA CON LA EDAD DE 4 AÑOS A 6 AÑOS', '1003');

INSERT INTO categoria (id_cat, tipo_cat, descripcion_cat, deporte_id_dep)
			  VALUES ('2011', 'SUB 10', 'SOLO INGRESARAN EN ESTA CATEGORIA CON LA EDAD DE 10 AÑOS A 9 AÑOS', '1005');
INSERT INTO categoria (id_cat, tipo_cat, descripcion_cat, deporte_id_dep)
			  VALUES ('2012', 'SUB 10', 'SOLO INGRESARAN EN ESTA CATEGORIA CON LA EDAD DE 10 AÑOS', '1006');
INSERT INTO categoria (id_cat, tipo_cat, descripcion_cat, deporte_id_dep)
			  VALUES ('2013', 'SUB 8', 'SOLO INGRESARAN EN ESTA CATEGORIA CON LA EDAD DE 8 AÑOS A 7 AÑOS', '1005');
INSERT INTO categoria (id_cat, tipo_cat, descripcion_cat, deporte_id_dep)
			  VALUES ('2014', 'SUB 7', 'SOLO INGRESARAN EN ESTA CATEGORIA CON LA EDAD DE 7 AÑOS', '1006');
INSERT INTO categoria (id_cat, tipo_cat, descripcion_cat, deporte_id_dep)
			  VALUES ('2015', 'SUB 6', 'SOLO INGRESARAN EN ESTA CATEGORIA CON LA EDAD DE 4 AÑOS A 6 AÑOS', '1005');


--TABLA entrenador


INSERT INTO entrenador (id_ent, nombre_ent , apellido_ent,genero_ent, correo_ent, contrasena_ent)
			  VALUES ('1035863563', 'JUAN JOSE', 'MARIN MOLINA', 'M', 'JUAN_MARIN83212@ELPOLI.EDU.CO', '12345');
INSERT INTO entrenador (id_ent, nombre_ent , apellido_ent,genero_ent, correo_ent, contrasena_ent)
			  VALUES ('1035863566', 'JUAN FERNANDO', 'GARCIA TORO', 'M', 'JUAN_GARCIA28321@ELPOLI.EDU.CO', '23123');
INSERT INTO entrenador (id_ent, nombre_ent , apellido_ent,genero_ent, correo_ent, contrasena_ent)
			  VALUES ('1035863558', 'STEVEN', 'MOLINA RINCON', 'M', 'STEVEN_MOLINA23454@ELPOLI.EDU.CO', '12567');
INSERT INTO entrenador (id_ent, nombre_ent , apellido_ent,genero_ent, correo_ent, contrasena_ent)

--TABLA clase

INSERT INTO clase (id_c, fecha_inicio, fecha_finalizacion, costo, deporte_id_dep, entrenador_id_ent)
			  VALUES ('3001', to_date('10-01-2019','dd-mm-yyyy'), to_date('10-03-2019','dd-mm-yyyy'), '60000', '1001', '1035863563');
INSERT INTO clase (id_c, fecha_inicio, fecha_finalizacion, costo, deporte_id_dep, entrenador_id_ent)
			  VALUES ('3002', to_date('12-01-2019','dd-mm-yyyy'), to_date('12-03-2019','dd-mm-yyyy'), '100000', '1002', '1035863563');
INSERT INTO clase (id_c, fecha_inicio, fecha_finalizacion, costo, deporte_id_dep, entrenador_id_ent)
			  VALUES ('3003', to_date('10-01-2019','dd-mm-yyyy'), to_date('10-03-2019','dd-mm-yyyy'), '60000', '1003', '1035863566');
INSERT INTO clase (id_c, fecha_inicio, fecha_finalizacion, costo, deporte_id_dep, entrenador_id_ent)
			  VALUES ('3004', to_date('12-01-2019','dd-mm-yyyy'), to_date('12-03-2019','dd-mm-yyyy'), '100000', '1004', '1035863566');
INSERT INTO clase (id_c, fecha_inicio, fecha_finalizacion, costo, deporte_id_dep, entrenador_id_ent)
			  VALUES ('3005', to_date('10-01-2019','dd-mm-yyyy'), to_date('10-03-2019','dd-mm-yyyy'), '60000', '1005', '1035863558');
INSERT INTO clase (id_c, fecha_inicio, fecha_finalizacion, costo, deporte_id_dep, entrenador_id_ent)
			  VALUES ('3006', to_date('12-01-2019','dd-mm-yyyy'), to_date('12-03-2019','dd-mm-yyyy'), '100000', '1006', '1035863558');

--TABLA objetivo

INSERT INTO objetivo (id_ob, fecha_ob, nombre_ob, descripcion_ob, estado_ob, puntuacion_ob, clase_id_c, entrenador_id_ent)
			  VALUES ('4001', to_date('10-01-2019','dd-mm-yyyy'), 'TIRO LIBRE ', 'APRENDER EL TIRO LIBRE , EL BALON DEBERA ESTAR INMOVIL PARA PODER SER LANZADO.', 'ATRASADO', '2,0', '3001', '1035863563');
INSERT INTO objetivo (id_ob, fecha_ob, nombre_ob, descripcion_ob, estado_ob, puntuacion_ob, clase_id_c, entrenador_id_ent)
			  VALUES ('4002', to_date('10-01-2019','dd-mm-yyyy'), 'TIRO LIBRE ', 'APRENDER EL TIRO LIBRE , EL BALON DEBERA ESTAR INMOVIL PARA PODER SER LANZADO.', 'ADELANTADO', '4,5', '3001', '1035863563');
INSERT INTO objetivo (id_ob, fecha_ob, nombre_ob, descripcion_ob, estado_ob, puntuacion_ob, clase_id_c, entrenador_id_ent)
			  VALUES ('4003', to_date('10-01-2019','dd-mm-yyyy'), 'TIRO LIBRE ', 'APRENDER EL TIRO LIBRE , EL BALON DEBERA ESTAR INMOVIL PARA PODER SER LANZADO.', 'INCAPACITADO', '0', '3001', '1035863563');
INSERT INTO objetivo (id_ob, fecha_ob, nombre_ob, descripcion_ob, estado_ob, puntuacion_ob, clase_id_c, entrenador_id_ent)
			  VALUES ('4004', to_date('10-01-2019','dd-mm-yyyy'), 'TIRO LIBRE ', 'APRENDER EL TIRO LIBRE , EL BALON DEBERA ESTAR INMOVIL PARA PODER SER LANZADO.', 'RETIRADO', '0', '3001', '1035863563');

INSERT INTO objetivo (id_ob, fecha_ob, nombre_ob, descripcion_ob, estado_ob, puntuacion_ob, clase_id_c, entrenador_id_ent)
			  VALUES ('4005', to_date('12-01-2019','dd-mm-yyyy'), 'TIRO LIBRE ', 'APRENDER EL TIRO LIBRE , EL BALON DEBERA ESTAR INMOVIL PARA PODER SER LANZADO.', 'ATRASADO', '2,5', '3002', '1035863563');

INSERT INTO objetivo (id_ob, fecha_ob, nombre_ob, descripcion_ob, estado_ob, puntuacion_ob, clase_id_c, entrenador_id_ent)
			  VALUES ('4006', to_date('10-01-2019','dd-mm-yyyy'), 'BRAZADA ', 'APRENDER LA BRAZADA ESTILO PECHO, LO CUAL EL NADADOR FLOTA BOCA ABAJO, CON LOS BRAZOS APUNTANDO AL FRENTE.', 'ATRASADO', '3,0', '3003', '1035863566');
INSERT INTO objetivo (id_ob, fecha_ob, nombre_ob, descripcion_ob, estado_ob, puntuacion_ob, clase_id_c, entrenador_id_ent)
			  VALUES ('4007', to_date('10-01-2019','dd-mm-yyyy'), 'BRAZADA ', 'APRENDER LA BRAZADA ESTILO PECHO, LO CUAL EL NADADOR FLOTA BOCA ABAJO, CON LOS BRAZOS APUNTANDO AL FRENTE.', 'ADELANTADO', '5', '3003', '1035863566');
INSERT INTO objetivo (id_ob, fecha_ob, nombre_ob, descripcion_ob, estado_ob, puntuacion_ob, clase_id_c, entrenador_id_ent)
			  VALUES ('4008', to_date('10-01-2019','dd-mm-yyyy'), 'BRAZADA ', 'APRENDER LA BRAZADA ESTILO PECHO, LO CUAL EL NADADOR FLOTA BOCA ABAJO, CON LOS BRAZOS APUNTANDO AL FRENTE.', 'INCAPACITADO', '0', '3003', '1035863566');
INSERT INTO objetivo (id_ob, fecha_ob, nombre_ob, descripcion_ob, estado_ob, puntuacion_ob, clase_id_c, entrenador_id_ent)
			  VALUES ('4009', to_date('10-01-2019','dd-mm-yyyy'), 'BRAZADA ', 'APRENDER LA BRAZADA ESTILO PECHO, LO CUAL EL NADADOR FLOTA BOCA ABAJO, CON LOS BRAZOS APUNTANDO AL FRENTE.', 'RETIRADO', '0', '3003', '1035863566');

INSERT INTO objetivo (id_ob, fecha_ob, nombre_ob, descripcion_ob, estado_ob, puntuacion_ob, clase_id_c, entrenador_id_ent)
			  VALUES ('4010', to_date('12-01-2019','dd-mm-yyyy'), 'BRAZADA ', 'APRENDER LA BRAZADA ESTILO PECHO, LO CUAL EL NADADOR FLOTA BOCA ABAJO, CON LOS BRAZOS APUNTANDO AL FRENTE.', 'ADELANTADO', '5', '3004', '1035863566');

INSERT INTO objetivo (id_ob, fecha_ob, nombre_ob, descripcion_ob, estado_ob, puntuacion_ob, clase_id_c, entrenador_id_ent)
			  VALUES ('4011', to_date('10-01-2019','dd-mm-yyyy'), 'REGLAS ', 'APRENDER LAS REGLAS NECESARIAS DEL BALONCESTO.', 'ATRASADO', '1,5', '3005', '1035863558');
INSERT INTO objetivo (id_ob, fecha_ob, nombre_ob, descripcion_ob, estado_ob, puntuacion_ob, clase_id_c, entrenador_id_ent)
			  VALUES ('4012', to_date('10-01-2019','dd-mm-yyyy'), 'REGLAS ', 'APRENDER LAS REGLAS NECESARIAS DEL BALONCESTO.', 'ADELANTADO', '5', '3005', '1035863558');
INSERT INTO objetivo (id_ob, fecha_ob, nombre_ob, descripcion_ob, estado_ob, puntuacion_ob, clase_id_c, entrenador_id_ent)
			  VALUES ('4013', to_date('10-01-2019','dd-mm-yyyy'), 'REGLAS ', 'APRENDER LAS REGLAS NECESARIAS DEL BALONCESTO.', 'INCAPACITADO', '0', '3005', '1035863558');
INSERT INTO objetivo (id_ob, fecha_ob, nombre_ob, descripcion_ob, estado_ob, puntuacion_ob, clase_id_c, entrenador_id_ent)
			  VALUES ('4014', to_date('10-01-2019','dd-mm-yyyy'), 'REGLAS ', 'APRENDER LAS REGLAS NECESARIAS DEL BALONCESTO.', 'RETIRADO', '0', '3005', '1035863558');
INSERT INTO objetivo (id_ob, fecha_ob, nombre_ob, descripcion_ob, estado_ob, puntuacion_ob, clase_id_c, entrenador_id_ent)
			  VALUES ('4015', to_date('12-01-2019','dd-mm-yyyy'), 'REGLAS ', 'APRENDER LAS REGLAS NECESARIAS DEL BALONCESTO.', 'RETIRADO', '0', '3006', '1035863558');


--TABLA estudiante

--TABLA estudiante

INSERT INTO estudiante (id_est, nombre_est, apellido_est, genero_est, fecha_nacimiento_est, estado_est, clase_id_c)
			  VALUES ('1036726870', 'CARLOS MARIO', 'OQUENDO ARIAS', 'M', to_date('12-01-2019','dd-mm-yyyy'), 'OK', '3001');
INSERT INTO estudiante (id_est, nombre_est, apellido_est, genero_est, fecha_nacimiento_est, estado_est, clase_id_c)
			  VALUES ('1036336930', 'MATEO', 'OQUENDO ARIAS', 'M', to_date('12-01-2019','dd-mm-yyyy'), 'OK', '3002');
INSERT INTO estudiante (id_est, nombre_est, apellido_est, genero_est, fecha_nacimiento_est, estado_est, clase_id_c)
			  VALUES ('1022226930', 'SERGIO', 'LOPEZ ARIAS', 'M', to_date('12-01-2019','dd-mm-yyyy'), 'DESERTO', '3003');
INSERT INTO estudiante (id_est, nombre_est, apellido_est, genero_est, fecha_nacimiento_est, estado_est, clase_id_c)
			  VALUES ('1036722230', 'MAURICIO', 'LONDOÑO ARIAS', 'M', to_date('12-01-2019','dd-mm-yyyy'), 'DESERTO', '3004');
INSERT INTO estudiante (id_est, nombre_est, apellido_est, genero_est, fecha_nacimiento_est, estado_est, clase_id_c)
			  VALUES ('1236726930', 'SEBASTIAN', 'MARIN CASTAÑEDA', 'M', to_date('12-01-2019','dd-mm-yyyy'), 'OK', '3005');

INSERT INTO estudiante (id_est, nombre_est, apellido_est, genero_est, fecha_nacimiento_est, estado_est, clase_id_c)
			  VALUES ('1136726870', 'KEVIN', 'QUIROZ RAMIREZ', 'M', to_date('12-01-2019','dd-mm-yyyy'), 'OK', '3006');
INSERT INTO estudiante (id_est, nombre_est, apellido_est, genero_est, fecha_nacimiento_est, estado_est, clase_id_c)
			  VALUES ('1136336930', 'LAURA', 'RAMIREZ LOPEZ', 'F', to_date('12-01-2019','dd-mm-yyyy'), 'OK', '3005');
INSERT INTO estudiante (id_est, nombre_est, apellido_est, genero_est, fecha_nacimiento_est, estado_est, clase_id_c)
			  VALUES ('1122226930', 'YESSICA', 'RIVERA CARDONA', 'F', to_date('12-01-2019','dd-mm-yyyy'), 'DESERTO', '3004');
INSERT INTO estudiante (id_est, nombre_est, apellido_est, genero_est, fecha_nacimiento_est, estado_est, clase_id_c)
			  VALUES ('1136722230', 'ANA MARIA', 'AGUDELO ROJAS', 'F', to_date('12-01-2019','dd-mm-yyyy'), 'DESERTO', '3003');
INSERT INTO estudiante (id_est, nombre_est, apellido_est, genero_est, fecha_nacimiento_est, estado_est, clase_id_c)
			  VALUES ('1136726930', 'JUAN', 'SALDARRIAGA MARIN', 'M', to_date('12-01-2019','dd-mm-yyyy'), 'OK', '3002');

--TABLA pago

INSERT INTO pago (id_pago, pago_total, fecha_factu, fecha_limite, estado_pago)
			  VALUES ('5001', 60000,  to_date('01-01-2019','dd-mm-yyyy'),  to_date('09-01-2019','dd-mm-yyyy'), 'ACEPTADO');
INSERT INTO pago (id_pago, pago_total, fecha_factu, fecha_limite, estado_pago)
			  VALUES ('5002', 100000,  to_date('01-01-2019','dd-mm-yyyy'),  to_date('09-01-2019','dd-mm-yyyy'), 'ACEPTADO');
INSERT INTO pago (id_pago, pago_total, fecha_factu, fecha_limite, estado_pago)
			  VALUES ('5003', 60000,  to_date('01-01-2019','dd-mm-yyyy'),  to_date('09-01-2019','dd-mm-yyyy'), 'RECHAZADO');
INSERT INTO pago (id_pago, pago_total, fecha_factu, fecha_limite, estado_pago)
			  VALUES ('5004', 100000,  to_date('01-01-2019','dd-mm-yyyy'),  to_date('09-01-2019','dd-mm-yyyy'), 'RECHAZADO');


--TABLA acudiente

INSERT INTO acudiente (id_ac, nombre_ac, apellido_ac, genero_ac, rol_ac, correo_ac, contrasena_ac, pago_id_pago, estudiante_id_est)
			  VALUES ( '6001', 'MARIA', 'JIMENEZ SANCHEZ', 'F', 'GRADUADO', 'MARIA_JIMENEZ82123@ELPOLI.EDU.CO', '12345','5001','1136726930');
INSERT INTO acudiente (id_ac, nombre_ac, apellido_ac, genero_ac, rol_ac, correo_ac, contrasena_ac, pago_id_pago, estudiante_id_est)
			  VALUES ( '6002', 'CRISTINA', 'AGUDELO SANCHEZ', 'F', 'PARTICULAR', 'CRISTINAAG@GMAIL.COM', '12345','5001','1036336930');
INSERT INTO acudiente (id_ac, nombre_ac, apellido_ac, genero_ac, rol_ac, correo_ac, contrasena_ac, pago_id_pago, estudiante_id_est)
			  VALUES ( '6003', 'SARA CAMIALA', 'MONTERO SANCHEZ', 'F', 'EMPLEADO', 'SARA_MONTERO@ELPOLI.EDU.CO', '12345','5003','1022226930');
INSERT INTO acudiente (id_ac, nombre_ac, apellido_ac, genero_ac, rol_ac, correo_ac, contrasena_ac, pago_id_pago, estudiante_id_est)
			  VALUES ( '6004', 'MARLON', 'JIMENEZ RIVAS', 'M', 'GRADUADO', 'MARLON_JIMENEZ82123@ELPOLI.EDU.CO', '12345','5003','1036722230');
INSERT INTO acudiente (id_ac, nombre_ac, apellido_ac, genero_ac, rol_ac, correo_ac, contrasena_ac, pago_id_pago, estudiante_id_est)
			  VALUES ( '6005', 'EDUARDO', 'MARIN MARIN', 'M', 'PARTICULAR', 'EDUARDOMARIN@GMAIL.COM', '12345','5002','1236726930');


INSERT INTO acudiente (id_ac, nombre_ac, apellido_ac, genero_ac, rol_ac, correo_ac, contrasena_ac, pago_id_pago, estudiante_id_est)
			  VALUES ( '6006', 'NICOL', 'PEREZ PEREZ', 'F', 'EMPLEADO', 'NICOL_PEREZ@ELPOLI.EDU.CO', '12345','5001','1036726870');
INSERT INTO acudiente (id_ac, nombre_ac, apellido_ac, genero_ac, rol_ac, correo_ac, contrasena_ac, pago_id_pago, estudiante_id_est)
			  VALUES ( '6007', 'BRUNO', 'ALZATE OSSA', 'M', 'GRADUADO', 'BRUNO_ALZATE82123@ELPOLI.EDU.CO', '12345','5001','1036336930');
INSERT INTO acudiente (id_ac, nombre_ac, apellido_ac, genero_ac, rol_ac, correo_ac, contrasena_ac, pago_id_pago, estudiante_id_est)
			  VALUES ( '6008', 'GAEL', 'TAMAYO ', 'M', 'PARTICULAR', 'GTAMAYO@GMAIL.COM', '12345','5003','1022226930');
INSERT INTO acudiente (id_ac, nombre_ac, apellido_ac, genero_ac, rol_ac, correo_ac, contrasena_ac, pago_id_pago, estudiante_id_est)
			  VALUES ( '6009', 'LUCAS', 'RIVERA', 'M', 'EMPLEADO', 'LUCAS_RIVERA@ELPOLI.EDU.CO', '12345','5003','1036722230');
INSERT INTO acudiente (id_ac, nombre_ac, apellido_ac, genero_ac, rol_ac, correo_ac, contrasena_ac, pago_id_pago, estudiante_id_est)
			  VALUES ( '6010', 'LEO', 'JIMENEZ ', 'M', 'GRADUADO', 'LEO_JIMENEZ82123@ELPOLI.EDU.CO', '12345','5002','1236726930');































