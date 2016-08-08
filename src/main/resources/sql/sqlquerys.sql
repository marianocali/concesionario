SELECT * /*DISTINCT TABLE_NAME*/ 
    FROM INFORMATION_SCHEMA.COLUMNS;
    WHERE TABLE_SCHEMA='estudio';
	AND TABLE_NAME IN ('Auto');
        
SELECT * FROM estudio.CONCESIONARIO;
SELECT * FROM estudio.Auto;
SELECT * FROM estudio.PERSONAS;
SELECT * FROM estudio.CLIENTES;
SELECT * FROM estudio.VENDEDORES;

ALTER TABLE estudio.Concesionario CHANGE idConcesionario IDCONCESIONARIO BIGINT(20);

desc estudio.Auto;

SELECT  *   
FROM estudio.Auto A,
estudio.Concesionario as C
where A.idConcesionario = C.idConcesionario;

-- drop table estudio.Concesionario;
-- drop table estudio.VENDEDORES;

SHOW CREATE TABLE estudio.CONCESIONARIO;
SHOW CREATE TABLE estudio.Auto;
SHOW VARIABLES LIKE '%innodb%';
SHOW TABLE STATUS;
SELECT @@version;		
select @@GLOBAL.sql_mode;
SHOW DATABASES;

-- Creación de la Base de Datos estudio
CREATE DATABASE estudio;
-- Usar la Base de datos estudio
USE estudio;


ALTER TABLE tbl_magazine_issue  DROP FOREIGN KEY FK_tbl_magazine_issue_mst_users;

ALTER TABLE estudio.Auto DROP FOREIGN KEY FK_Concesionario;

SHOW ENGINE INNODB STATUS;
-- constraints de una tabla
select * -- COLUMN_NAME, CONSTRAINT_NAME, REFERENCED_COLUMN_NAME, REFERENCED_TABLE_NAME
from information_schema.KEY_COLUMN_USAGE
-- where TABLE_SCHEMA like 'estudio'
where  TABLE_NAME LIKE 'Concesionario';


-- 
DROP TABLE estudio.Concesionario; 

where idConcesionario > 0;