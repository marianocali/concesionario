CREATE TABLE estudio.Clientes 
(
id_cliente bigint(20) NOT NULL,
tipo varchar(255) DEFAULT NULL,
PRIMARY KEY (id_cliente),
CONSTRAINT FK_Persona2 FOREIGN KEY (id_Persona) REFERENCES persona (id_Persona)
);
