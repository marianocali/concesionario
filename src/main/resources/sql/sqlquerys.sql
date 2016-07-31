SELECT * /*DISTINCT TABLE_NAME*/ 
    FROM INFORMATION_SCHEMA.COLUMNS
    WHERE TABLE_SCHEMA='estudio';
	AND TABLE_NAME IN ('Auto');
        
SELECT * FROM estudio.Concesionario;
SELECT * FROM estudio.Auto;
SELECT * FROM estudio.PERSONAS;
SELECT * FROM estudio.CLIENTES;
SELECT * FROM estudio.VENDEDORES;

desc estudio.Auto;

SELECT  *   
FROM estudio.Auto A,
estudio.Concesionario as C
where A.idConcesionario = C.idConcesionario;

SHOW CREATE TABLE estudio.Clientes;

SHOW CREATE TABLE estudio.Vendedores;
SHOW VARIABLES LIKE '%innodb%';
SHOW TABLE STATUS;
SELECT @@version;		
select @@GLOBAL.sql_mode;


