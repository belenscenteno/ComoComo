
DROP DATABASE IF EXISTS ingS;
CREATE DATABASE ingS;

USE ingS;

DROP TABLE IF EXISTS Clientes;
CREATE TABLE Clientes (
usuario VARCHAR(10) NOT NULL,
contrasena VARCHAR(10) NOT NULL,
email VARCHAR(30) UNIQUE NOT NULL,
nombre VARCHAR(20),
apellidos VARCHAR(40),
tarjeta VARCHAR(16),
PRIMARY KEY (usuario)
);

DROP TABLE IF EXISTS Restaurantes;
CREATE TABLE Restaurantes (
usuario VARCHAR(10) NOT NULL,
contrasena VARCHAR(10) NOT NULL,
email VARCHAR(30) UNIQUE NOT NULL,
nombre VARCHAR(30),
ubicacion VARCHAR(50),
descripcion VARCHAR(100),
PRIMARY KEY (usuario)
);

DROP TABLE IF EXISTS Imagenes;
create table Imagenes(
idImagen VARCHAR(10) not null,
imagen longblob not null,
foreign key (idImagen) references Restaurantes(usuario),
primary key(idImagen)) engine=Innodb;

DROP TABLE IF EXISTS Reservas;
CREATE TABLE Reservas(
restaurante VARCHAR(10) NOT NULL,
cliente VARCHAR(10) NOT NULL,
numComensales INT,
fecha DATETIME NOT NULL,
PRIMARY KEY (restaurante, cliente, fecha),
FOREIGN KEY (restaurante) REFERENCES Restaurantes(usuario),
FOREIGN KEY (cliente) REFERENCES Clientes(usuario)
);


INSERT INTO Clientes VALUES ('Lucia', 'lulamagaz', 'lucialat@gmail.com', 'Lucia', 'Latorre', '0536278');
INSERT INTO Clientes VALUES ('angela', 'ruiz', 'angela@gmail.com', 'Angela', 'Ruiz', '053739882');
INSERT INTO Restaurantes VALUES ('goiko', '1234', 'goikoGrill@gmail.com', 'Goiko Grill', 'Avenida Europa', 'Restaurante americano de hamburguesas');


INSERT INTO Restaurantes VALUES ('pepe', '1234', 'pepe@gmail.com', 'Pepe bar', 'Avenida Lol', 'bar');
INSERT INTO Restaurantes VALUES ('papizza', '1234', 'papizza@gmail.com', 'Papizza', 'holiwi', 'Restaurante americano de hamburguesas');
INSERT INTO Restaurantes VALUES ('poke', '1234', 'poke@gmail.com', 'poke bowl', 'Avenida', 'Restaurante americano de hamburguesas');

SELECT * FROM Clientes;
SELECT * FROM Restaurantes;
select * from imagenes;
SELECT * FROM Reservas;

delete from imagenes where idImagen = 'goiko';

COMMIT;