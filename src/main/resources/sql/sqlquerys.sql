
select * from all_tables;

SELECT * FROM estudio.Concesionario;
SELECT * FROM estudio.Auto;

desc estudio.Auto;

SELECT  *   
FROM estudio.Auto A,
estudio.Concesionario as C
where A.idConcesionario = C.idConcesionario;


