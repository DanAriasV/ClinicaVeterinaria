
USE ClinicaVeterinaria
GO

--Datos fijos de las categorias
insert into [dbo].[Categoria] values ('Medicamentos')--1insert into [dbo].[Categoria] values ('Alimentos')--2insert into [dbo].[Categoria] values ('Accesorios') --3  insert into [dbo].[Categoria] values ('Consulta')--4--Datos fijos de puestosINSERT INTO [dbo].[Puesto] VALUES ('Medico')INSERT INTO [dbo].[Puesto] VALUES ('Enfermero')--Datos fijos de Tipo MascotaINSERT INTO [dbo].[Tipo_Mascota] VALUES ('Perro')INSERT INTO [dbo].[Tipo_Mascota] VALUES ('Gato')INSERT INTO [dbo].[Tipo_Mascota] VALUES ('Caballo')INSERT INTO [dbo].[Tipo_Mascota] VALUES ('Loro')--Datos fijos de tipo de pagoINSERT INTO [dbo].[Tipo_pago] VALUES('Efectivo')INSERT INTO [dbo].[Tipo_pago] VALUES('Tarjeta')