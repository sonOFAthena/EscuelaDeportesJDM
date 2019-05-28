DROP TABLESPACE BD_EscuelaDeportes INCLUDING CONTENTS AND DATAFILES;

CREATE TABLESPACE BD_EscuelaDeportes LOGGING
DATAFILE 'C:\BD_EscuelaDeportes.dbf' size 25M;
extent management local segment space management auto; 
 
DROP USER EscuelaDeportes;

create user EscuelaDeportes profile default 
identified by ADMIN123 
default tablespace BD_EscuelaDeportes
temporary tablespace temp 
account unlock; 

--permisos 

grant connect, resource,dba to EscuelaDeportes;
