CREATE TABLE estudio.VENDEDORES
(
IDPERSONA bigint(20) NOT NULL,
FECHA_INGRESO datetime DEFAULT NULL,
LEGAJO varchar(255) DEFAULT NULL,
SUELDO double DEFAULT NULL,
IDCONCESIONARIO bigint(20), 
PRIMARY KEY (IDPERSONA)
);

ALTER TABLE estudio.VENDEDORES
ADD CONSTRAINT FK_PERSONA2 FOREIGN KEY (IDPERSONA)
REFERENCES PERSONAS(IDPERSONA);

ALTER TABLE estudio.VENDEDORES
ADD CONSTRAINT FK_Concesionario FOREIGN KEY (IDCONCESIONARIO) 
REFERENCES CONCESIONARIO (IDCONCESIONARIO)
