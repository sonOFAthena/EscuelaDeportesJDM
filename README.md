# EscuelaDeportesJDM
Software para una escuela de deportes


## ESQUEMA SERVICIO RESTFull

```
GET 	  /device-management/devices : Get all devices
POST 	  /device-management/devices : Create a new device
GET 	  /device-management/devices/{id} : Get the device information identified by "id"
PUT 	  /device-management/devices/{id} : Update the device information identified by "id"
DELETE	/device-management/devices/{id} : Delete device by "id"
```
## ESQUEMA EJEMPLO SERVICIO RESTFull: CATEGORIA
```
GET 	  localhost:port/EscuelaDeportesJDM/rest/categorias :      Get all categorias
        Produces:JSON
        Return: lista de categorias
        ej:
        [
            {
                "deporteIdDep":"1001",
                "descripcionCat":"SOLO INGRESARAN EN ESTA CATEGORIA CON LA EDAD DE 10 AÑOS A 9 AÑOS",
                "idCat":"2001",
                "tipoCat":"SUB 10"
            },
            {
                "deporteIdDep":"1002",
                "descripcionCat":"SOLO INGRESARAN EN ESTA CATEGORIA CON LA EDAD DE 10 AÑOS",
                "idCat":"2002",
                "tipoCat":"SUB 10"
            }
        ]
```        
```        
POST 	 localhost:port/EscuelaDeportesJDM/rest/categorias :      Create a new categoria
        ConsumeS: JSON
        ej:
        {
            "deporteIdDep":"1001",
            "descripcionCat":"SOLO INGRESARAN EN ESTA CATEGORIA CON LA EDAD DE 10 AÑOS A 9 AÑOS",
            "idCat":"2001",
            "tipoCat":"SUB 10"
        }
        Produces:JSON, 
        Return: Objeto creado
        ej:
        {
            "deporteIdDep":"1001",
            "descripcionCat":"SOLO INGRESARAN EN ESTA CATEGORIA CON LA EDAD DE 10 AÑOS A 9 AÑOS",
            "idCat":"2001",
            "tipoCat":"SUB 10"
        }
```        
```        
GET 	 localhost:port/EscuelaDeportesJDM/rest/categorias/{id} : Get the categoria information identified by "id"
        Produces: JSON
        Return: Objeto buscado con la id 
        ej:
        {
            "deporteIdDep":"1001",
            "descripcionCat":"SOLO INGRESARAN EN ESTA CATEGORIA CON LA EDAD DE 10 AÑOS A 9 AÑOS",
            "idCat":"2001",
            "tipoCat":"SUB 10"
        }
```
```
PUT 	 localhost:port/EscuelaDeportesJDM/rest/categorias :      Update the categoria information identified by "id"
        ConsumeS: JSON
        ej:
        {
            "deporteIdDep":"1001",
            "descripcionCat":"SOLO INGRESARAN EN ESTA CATEGORIA CON LA EDAD DE 10 AÑOS A 9 AÑOS",
            "idCat":"2001",
            "tipoCat":"SUB 10"
        }
        Produces:JSON, 
        Return: Objeto actualizado
        ej:
        {
            "deporteIdDep":"1001",
            "descripcionCat":"SOLO INGRESARAN EN ESTA CATEGORIA CON LA EDAD DE 10 AÑOS A 9 AÑOS",
            "idCat":"2001",
            "tipoCat":"SUB 10"
        }
```        
```
DELETE localhost:port/EscuelaDeportesJDM/rest/categorias/{id} : Delete categoria by "id"
        Produces: JSON
        Return: Objeto eliminado con la id 
        ej:
        {
            "deporteIdDep":"1001",
            "descripcionCat":"SOLO INGRESARAN EN ESTA CATEGORIA CON LA EDAD DE 10 AÑOS A 9 AÑOS",
            "idCat":"2001",
            "tipoCat":"SUB 10"
        }
```

## HERRAMIENTAS UTILIZADAS

* **SERVER**: GLASSFISH5
* **IDE**: NetBeans IDE 8.2 (Build 201609300101)
* **DATABASE**: ORACLE 11g
* **MANEJO DE DEPENDENCIAS**: Apache-Maven-3.6.1

## AUTORES

* **Daniel Londoño David** - *Front-End* - [villanuevand](https://github.com/add)
* **Manuela Lopez** - *Base de datos* - [villanuevand](https://github.com/add)
* **Jose Ramirez Giraldo** - *Back-End* - [sonOFAthena](https://github.com/sonOFAthena/)

##  AGRADECIMIENTOS🎁

Gracias a los colaboradores de este proyecto por su dedicación, aun en momento dificiles en la universidad.
