/**
 * Author:  mariano
 * Created: 04/08/2016
 */
CREATE TABLE estudio.CONCESIONARIO (
	IDCONCESIONARIO BIGINT(20) NOT NULL AUTO_INCREMENT,
	NOMBRE VARCHAR(50) ,
	DIRECCION VARCHAR(50) ,
	PRIMARY KEY (IDCONCESIONARIO)
);

INSERT INTO estudio.CONCESIONARIO (IDCONCESIONARIO, NOMBRE, DIRECCION) VALUES ('1', 'Av Montes de Oca 720', 'Toyota');
INSERT INTO estudio.CONCESIONARIO (IDCONCESIONARIO, NOMBRE, DIRECCION) VALUES ('2', 'Av Rivadavia 6150', 'Fiat');
INSERT INTO estudio.CONCESIONARIO (IDCONCESIONARIO, NOMBRE, DIRECCION) VALUES ('18', 'Moreno 2350', 'Saab');
INSERT INTO estudio.CONCESIONARIO (IDCONCESIONARIO, NOMBRE, DIRECCION) VALUES ('21', 'Moreno 2350', 'Honda');