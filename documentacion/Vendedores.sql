CREATE TABLE estudio.Vendedores 
(
fecha_ingreso datetime DEFAULT NULL,
LEGAJO varchar(255) DEFAULT NULL,
SUELDO double DEFAULT NULL,
id_vendedor bigint(20) NOT NULL,
PRIMARY KEY (id_vendedor),
CONSTRAINT FK_PERSON FOREIGN KEY (id_Persona) REFERENCES persona (id_Persona)
);
