DROP TABLE articulo;
DROP TABLE usuario;

CREATE TABLE usuario (
	id INT NOT NULL GENERATED ALWAYS 
		AS IDENTITY (START WITH 1, INCREMENT BY 1),
	nombre VARCHAR(20),
	clave VARCHAR(20),
	rol VARCHAR(20),
	PRIMARY KEY (id)
);

INSERT INTO usuario(nombre, clave, rol) 
VALUES('admin', 'admin', 'Administrador');
INSERT INTO usuario(nombre, clave, rol) 
VALUES('usuario', 'usuario', 'Ordinario');

CREATE TABLE articulo (
	id INT NOT NULL GENERATED ALWAYS 
		AS IDENTITY (START WITH 1, INCREMENT BY 1),
	usuario_id INT NOT NULL,
	titulo VARCHAR(100),
	texto VARCHAR(2000),
	PRIMARY KEY (id),
	FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

INSERT INTO articulo(usuario_id, titulo, texto) 
VALUES(1, 'Articulo #1', 'Articulo #1');
INSERT INTO articulo(usuario_id, titulo, texto) 
VALUES(1, 'Articulo #2', 'Articulo #2');
INSERT INTO articulo(usuario_id, titulo, texto) 
VALUES(2, 'Articulo #3', 'Articulo #3');





