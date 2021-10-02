CREATE DATABASE ClinicaVeterinaria
GO

USE ClinicaVeterinaria
GO

CREATE TABLE Clientes
(
id_cliente INT IDENTITY NOT NULL,
identidad NVARCHAR(13) NOT NULL,
nombre_cliente NVARCHAR(50) NOT NULL,
telefono_cliente NVARCHAR(8) NOT NULL,
correo_cliente NVARCHAR(50),
CONSTRAINT PK_cliente PRIMARY KEY (id_cliente)
)
GO

CREATE TABLE Tipo_Mascota
(
id_tipo_mascota INT IDENTITY NOT NULL,
descripcion_tipo_mascota NVARCHAR(50) NOT NULL,
CONSTRAINT PK_tipo_mascota PRIMARY KEY (id_tipo_mascota)
)
GO

CREATE TABLE Mascota_Expediente
(
id_expediente INT IDENTITY NOT NULL,
id_cliente INT NOT NULL,
nombre_mascota NVARCHAR(50) NOT NULL,
id_tipo_mascota INT NOT NULL,
fecha_nacimiento_mascota DATE NOT NULL
CONSTRAINT PK_mascota PRIMARY KEY(id_expediente),
CONSTRAINT FK_cliente FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente),
CONSTRAINT FK_tipo_mascota FOREIGN KEY (id_tipo_mascota) REFERENCES Tipo_Mascota(id_tipo_mascota)
)
GO

CREATE TABLE Puesto
(
id_puesto INT IDENTITY NOT NULL,
descripcion_puesto NVARCHAR(50) NOT NULL,
CONSTRAINT PK_puesto PRIMARY KEY (id_puesto)
)
GO

CREATE TABLE Detalle_Expedientes_Archivos
(
id_expediente INT NOT NULL,
id_archivo INT NOT NULL IDENTITY,
motivo_visita NVARCHAR(50) NOT NULL,
fecha DATETIME NOT NULL,
descripcion_visita NVARCHAR(300) NOT NULL,
frecuencia_cardiaca INT,
peso DECIMAL,
temperatura DECIMAL,
descripcion_receta NVARCHAR(150),
CONSTRAINT PK_archivo_expediente PRIMARY KEY (id_expediente, id_archivo),
FOREIGN KEY ( id_expediente) REFERENCES Mascota_Expediente (id_expediente)
)
GO

CREATE TABLE Detalle_Control_Vacunas
(
id_expediente INT NOT NULL,
numero_vacuna INT IDENTITY NOT NULL,
nombre_vacuna NVARCHAR(50) NOT NULL,
fecha_aplicacion DATE NOT NULL,
PRIMARY KEY(id_expediente, numero_vacuna),
FOREIGN KEY ( id_expediente) REFERENCES Mascota_Expediente( id_expediente)
)
GO

CREATE TABLE Empleados
(
id_empleado INT IDENTITY NOT NULL,
identidad NVARCHAR(13) NOT NULL,
nombre NVARCHAR(50) NOT NULL,
telefono NVARCHAR(8) NOT NULL,
correo NVARCHAR(50) NOT NULL,
fecha_nacimiento DATE,
usuario NVARCHAR(50) NOT NULL,
contrasenia NVARCHAR(50) NOT NULL,
id_puesto INT NOT NULL,
estado_activo BIT NOT NULL,
PRIMARY KEY (id_empleado),
FOREIGN KEY(id_puesto) REFERENCES Puesto(id_puesto)
)
GO

CREATE TABLE Citas
(
id_cita INT NOT NULL IDENTITY,
id_cliente INT NOT NULL FOREIGN KEY REFERENCES Clientes(id_cliente),
fecha DATE NOT NULL,
hora TIME NOT NULL,
id_empleado INT NOT NULL FOREIGN KEY REFERENCES Empleados (id_empleado),
nombre_mascota NVARCHAR(50) NOT NULL,
hora_final TIME NOT NULL
)
GO


CREATE TABLE Tipo_pago
(
id_tipo_pago INT IDENTITY NOT NULL PRIMARY KEY,
descripcion_tipo_pago NVARCHAR(50) NOT NULL
)
GO

CREATE TABLE Categoria 
(
id_categoria INT NOT NULL IDENTITY PRIMARY KEY,
nombre_categoria NVARCHAR(50) NOT NULL
)
GO

CREATE TABLE Factura
(
id_factura INT NOT NULL IDENTITY PRIMARY KEY,
fecha_factura DATE NOT NULL,
id_cliente INT NOT NULL FOREIGN KEY REFERENCES Clientes(id_cliente),
descuento MONEY NOT NULL ,
id_tipo_pago INT NOT NULL FOREIGN KEY REFERENCES Tipo_pago(id_tipo_pago),
referencia_pago NVARCHAR(5)
)
GO

CREATE TABLE Producto
(
id_producto INT NOT NULL IDENTITY PRIMARY KEY,
nombre_producto NVARCHAR(50) NOT NULL,
descripcion_producto NVARCHAR(100) NOT NULL,
precio_unitario MONEY NOT NULL,
id_categoria INT NOT NULL FOREIGN KEY REFERENCES Categoria(id_categoria),
continuidad BIT NOT NULL,
cantidad_existencia INT NOT NULL
)
GO

CREATE TABLE Detalle_factura
(
id_factura INT NOT NULL,
id_producto INT NOT NULL,
precio_venta MONEY NOT NULL,
cantidad_comprada INT NOT NULL,
PRIMARY KEY (id_factura, id_producto),
FOREIGN KEY (id_factura) REFERENCES Factura(id_factura),
FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
)
GO