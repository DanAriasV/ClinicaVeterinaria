USE ClinicaVeterinaria
GO

---------------------------------------------------------------------------------------------------
--Procedimientos WALTER

--Trae listado de expedientes
CREATE PROC listadoExpedientes
AS
BEGIN

SELECT 
ME.id_expediente,
C.nombre_cliente,
C.identidad,
ME.nombre_mascota,
TM.descripcion_tipo_mascota,
ME.fecha_nacimiento_mascota
FROM Mascota_Expediente ME
INNER JOIN Clientes C ON C.id_cliente = ME.id_cliente
INNER JOIN Tipo_Mascota TM ON TM.id_tipo_mascota = ME.id_tipo_mascota

END
GO

--trae listado de archivos
CREATE PROC listadoArchivos
@expediente INT
AS
BEGIN

SELECT 
id_archivo,
Fecha,
motivo_visita
FROM Detalle_Expedientes_Archivos
WHERE id_expediente = @expediente
END
GO
--Procedimiento para llenar el combobox de cliente en nuevoExpediente
CREATE PROC llenarComboboxCliente
AS
BEGIN
SELECT
nombre_cliente,
identidad,
id_cliente
FROM Clientes
END
GO

--llenar combobox de tipo de mascota de nuevo expediente
CREATE PROC llenarComboboxTipoMascota
AS
BEGIN

SELECT
descripcion_tipo_mascota,
id_tipo_mascota
FROM Tipo_Mascota
END
GO

--Insercion de datos a nuevoExpediente
CREATE PROC nuevoExpediente
@cliente INT,
@mascota NVARCHAR(50),
@tipo INT,
@nacimiento DATE
AS
BEGIN

INSERT INTO Mascota_Expediente
VALUES
(
@cliente,
@mascota,
@tipo,
@nacimiento
)

END
GO

--Crea un nuevo archivo
CREATE PROC nuevoArchivo
@exp INT,
@motivo NVARCHAR(50),
@descripcion NVARCHAR(300),
@fc INT,
@peso DECIMAL,
@temp DECIMAL,
@receta NVARCHAR(150)
AS
BEGIN

INSERT INTO Detalle_Expedientes_Archivos
VALUES
(
@exp,
@motivo,
@descripcion,
@fc,
@peso,
@temp,
@receta,
GETDATE()
)

END
GO

--Recupera los datos de los archivos
CREATE PROC recuperarDatosArchivo
@exp INT,
@arch INT
AS
BEGIN

SELECT
motivo_visita,
descripcion_visita,
frecuencia_cardiaca,
peso,
temperatura,
descripcion_receta,
fecha
FROM Detalle_Expedientes_Archivos
WHERE id_expediente = @exp AND id_archivo = @arch

END
GO

--Mantenimiento para control de medicamentos y vacunas
CREATE PROC mantenimientoControlMed
@accion NVARCHAR(20),
@exp INT ,
@vacuna NVARCHAR(50) ,
@fecha DATE ,
@id_vac INT
AS
BEGIN
	IF(@accion = 'insertar')
	BEGIN
		INSERT INTO Detalle_Control_Vacunas
		VALUES
		(
		@exp,
		@vacuna,
		@fecha
		)
	END
	ELSE IF(@accion = 'editar')
	BEGIN
		UPDATE Detalle_Control_Vacunas
		SET fecha_aplicacion = @fecha,
		nombre_vacuna = @vacuna
		WHERE id_expediente = @exp AND numero_vacuna = @id_vac
	END
	ELSE IF(@accion = 'traer')
	BEGIN
		SELECT
		nombre_vacuna,
		fecha_aplicacion,
		numero_vacuna
		FROM Detalle_Control_Vacunas
		WHERE id_expediente = @exp
		ORDER BY fecha_aplicacion ASC
	END
	ELSE IF(@accion = 'eliminar')
	BEGIN
		DELETE FROM Detalle_Control_Vacunas
		WHERE numero_vacuna = @id_vac AND id_expediente = @exp
	END
END
GO

--Filtrar datos de expedientes
CREATE PROC filtroExpedientes
@texto NVARCHAR(50)
AS
BEGIN

DECLARE @table TABLE
(
id_expediente INT,
nombre_cliente NVARCHAR(50),
identidad NVARCHAR(13),
nombre_mascota NVARCHAR(50),
descripcion_tipo_mascota NVARCHAR(30),
fecha_nacimiento_mascota DATE
)

INSERT INTO @table EXEC listadoExpedientes 
SELECT 
*
FROM @table
WHERE nombre_cliente LIKE '%'+@texto+'%' 
OR identidad LIKE '%'+@texto+'%'
OR nombre_mascota LIKE '%'+@texto+'%'

END
GO

--Ordenar datos de expedientes
CREATE PROC ordenarExpedientes
@orden NVARCHAR(20)
AS
BEGIN

DECLARE @table TABLE
(
id_expediente INT,
nombre_cliente NVARCHAR(50),
identidad NVARCHAR(13),
nombre_mascota NVARCHAR(50),
descripcion_tipo_mascota NVARCHAR(30),
fecha_nacimiento_mascota DATE
)

INSERT INTO @table EXEC listadoExpedientes 

IF(@orden = 'expe')
BEGIN
	SELECT 
	*
	FROM @table
	ORDER BY id_expediente ASC
END
ELSE IF(@orden = 'clie')
BEGIN
	SELECT 
	*
	FROM @table
	ORDER BY nombre_cliente ASC
END
ELSE IF(@orden = 'masc')
BEGIN
	SELECT 
	*
	FROM @table
	ORDER BY nombre_mascota ASC
END
ELSE IF(@orden = 'tipo')
BEGIN
	SELECT 
	*
	FROM @table
	ORDER BY descripcion_tipo_mascota ASC
END

END
GO

---------------------------------------------------------------------------------------------------------
--Procedimientos OSCAR

--agendar la cita
CREATE PROCEDURE AgendarCita
(
	@dni as nvarchar(13),
	@fecha as date,
	@tiempo as time,
	@codempleado as int,
	@nombre as nvarchar(50),
	@tiempofinal as time
)
as

BEGIN
declare @codcliente as int
SELECT @codcliente = (SELECT C.id_cliente FROM Clientes C WHERE C.identidad = @dni)

	INSERT INTO [dbo].[Citas]
	VALUES
	(
		@codcliente,
		@fecha,
		@tiempo,
		@codempleado,
		@nombre,
		@tiempofinal
	)

end

GO


---------------------------------------------------------------------------------------------------
--Procedimientos KENIA

--guardar factura
CREATE PROCEDURE InsertarFactura
@fecha date,
@idC int,
@desc MONEY,
@idPago int, 
@ref nvarchar(50)
AS
BEGIN
	SET NOCOUNT ON;
	insert into Factura values (@fecha, @idC, @desc, @idPago, @ref)
END
GO

--Buscar el cliente en la base de datos
CREATE PROC BuscarCliente
@id nvarchar(13)
AS
BEGIN
	SET NOCOUNT ON;
	select id_cliente from Clientes where identidad = @id
END
GO

--insertar datos al detalle factura
CREATE PROC InsertarDetalle
@fact int, 
@prod int,
@precio MONEY,
@qty int
AS
BEGIN
	SET NOCOUNT ON;
	insert into [dbo].[Detalle_factura] values (@fact, @prod, @precio, @qty)
END
GO

-----------------------------------------------------------------------------------------------------
--Procedimientos DANIEL

--Insertar productos a la base de datos
create proc InsertProductos(@nombre nvarchar(50),@descripcion nvarchar(100),@precio float,@idCategoria nvarchar(50) ,@continuidad nvarchar(50),@cantidad nvarchar(50))
as begin
insert into [dbo].[Producto] values( @nombre,@descripcion,@precio,@idCategoria,@continuidad,@cantidad)
end
GO

--Actualizar los productos de la base de datos
create proc UpdateProductos(@id nvarchar(50),@nombre nvarchar(50),@descripcion nvarchar(100),@precio float,@idCategoria nvarchar(50) ,@continuidad nvarchar(50),@cantidad nvarchar(50))
as begin
update [dbo].[Producto] 
set [nombre_producto]=@nombre,
	[descripcion_producto]=@descripcion,
	[precio_unitario]=@precio,
	[id_categoria]=@idCategoria,
	[continuidad]=@continuidad,
	[cantidad_existencia]=@cantidad
where [id_producto]=@id
end
GO

--Procedimiento para restar cantidad de productos
create proc RestaProductos(@id nvarchar(50),@cantidadPorRestar int)
as begin
update [dbo].[Producto] 
set	[cantidad_existencia]=([cantidad_existencia]-@cantidadPorRestar)
where [id_producto]=@id
end
GO
