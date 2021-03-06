CREATE TABLE VEHICULO(
    IDVEHICULO INTEGER NOT NULL,
    MODELO VARCHAR(30),
    COLOR VARCHAR(30),
    PRIMARY KEY (IDVEHICULO)
);

CREATE TABLE CLIENTE(
    IDCLIENTE INTEGER NOT NULL,
    APELLIDO VARCHAR(30),
    NOMBRE VARCHAR(30),
    DIRECCION VARCHAR(30),
    TELEFONO INTEGER,
    PRIMARY KEY (IDCLIENTE)
);

CREATE TABLE RESERVA(
    IDRESERVA INTEGER NOT NULL,
    ID_CLIENTE INTEGER NOT NULL,
    ID_VEHICULO INTEGER NOT NULL,
    PRIMARY KEY (IDRESERVA),
    FOREIGN KEY (ID_CLIENTE) REFERENCES CLIENTE (IDCLIENTE),
    FOREIGN KEY (ID_VEHICULO) REFERENCES VEHICULO (IDVEHICULO)
);