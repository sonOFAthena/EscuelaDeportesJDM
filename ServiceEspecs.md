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
		"nombreDep":"NATACION",
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
        Return: Retorna todos los estudiantes que practican el deporte dado
        
	ej:
        [
            {
		"apellidoEst":"AGUDELO ROJAS",
		"idEst":"1136722230",
		"nombreDep":"NATACION",
		"nombreEst":"ANA MARIA"
	    },
	    {
		"apellidoEst":"LOPEZ ARIAS",
		"idEst":"1022226930",
		"nombreDep":"NATACION",
		"nombreEst":"SERGIO"
	    }
        ]
``` 

## EJEMPLO SERVICIO listarTodas_clases_dep: mostrar todas las clases  del deporte dado
```
GET 	http://localhost:9091/EscuelaDeportesJDM/rest/clases/dep/todo/natacion :     
        @GET
	@Path("/dep/todo/{depname}")
	@Produces(MediaType.APPLICATION_JSON)
        Return: Retorna todas las clases  del deporte dado
        
	ej:
        [
            {
		"costo":60000,
		"deporteIdDep":"1003",
		"entrenadorIdEnt":"1035863566",
		"fechaFinalizacionClass":"2019-03-10 00:00:00",
		"fechaInicioClass":"2019-01-10 00:00:00",
		"idClas":"3003"
		},
		{
		"costo":100000,
		"deporteIdDep":"1004",
		"entrenadorIdEnt":"1035863566",
		"fechaFinalizacionClass":"2019-03-12 00:00:00",
		"fechaInicioClass":"2019-01-12 00:00:00",
		"idClas":"3004"}
        ]
``` 

