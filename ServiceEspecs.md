# EscuelaDeportesJDM
Software para una escuela de deportes


## SERVICIOS RESTFull


## EJEMPLO SERVICIO listarEst_dep: mostrar el deporte de un estudiante dado el id
```
GET 	http://localhost:9091/EscuelaDeportesJDM/rest/estudiantes/dep/1036722230 :     
        @GET
		@Path("/dep/{id}")
		@Produces(MediaType.APPLICATION_JSON)
        Return: Retorna el deporte al que pertenece el estudiante con el id "1036722230"
        
		ej:
        [
            {
				"apellidoEst":"LONDOÑO ARIAS",
				"idEst":"1036722230",
				"nombreDep":"NOMBRE_DEP",
				"nombreEst":"MAURICIO"
			}
        ]
``` 
       
## EJEMPLO SERVICIO listarTodos_Est_dep: mostrar todos los estudiantes que practican el deporte dado
```
GET 	http://localhost:9091/EscuelaDeportesJDM/rest/estudiantes/dep/todo/natacion :     
        @GET
		@Path("/dep/todo/{depname}")
		@Produces(MediaType.APPLICATION_JSON)
        Return: Retorna el deporte al que pertenece el estudiante con el id "1036722230"
        
		ej:
        [
            {
				"apellidoEst":"AGUDELO ROJAS",
				"idEst":"1136722230",
				"nombreDep":"NOMBRE_DEP",
				"nombreEst":"ANA MARIA"
			},
			{
				"apellidoEst":"LOPEZ ARIAS",
				"idEst":"1022226930",
				"nombreDep":"NOMBRE_DEP",
				"nombreEst":"SERGIO"
			}
        ]
``` 

