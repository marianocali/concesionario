CREATE TABLE estudio.Auto
 (
    IDAUTO bigint(20) NOT NULL AUTO_INCREMENT,
    ANIO int(11) DEFAULT NULL,
    FECHA_VENTA date ,
    MARCA varchar(255) ,
    MODELO varchar(255) ,
    PRECIO bigint(20) ,
    IDCONCESIONARIO bigint(20) ,
    PRIMARY KEY (IDAUTO), 
    KEY PKConcesionario (IDAUTO),
    CONSTRAINT FK_Concesionario FOREIGN KEY (idConcesionario) REFERENCES Concesionario (idConcesionario)) 
 )
   AUTO_INCREMENT=16 
