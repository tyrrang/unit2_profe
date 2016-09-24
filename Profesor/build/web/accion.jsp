<%-- 
    Document   : accion
    Created on : 23/09/2016, 02:45:51 PM
    Author     : tyrrang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Acciones</title>
    </head>
    <body>
        <form action="AccionController" method="post">
            <fieldset> 
                <legend> Registro de Acciones </legend>
                <div>
                    <label for="idAccion">ID Accion: </label>
                    <input type="text" name="idAccion" placeholder="ID Accion" value="${accion.idAccion}" readonly="readonly">
                </div>
                <div>
                    <label for="nombre">Nombre Accion: </label>
                    <input type="text" name="nombre" placeholder="Nombre de la Accion" value="${accion.nombre}">
                </div>
                <div>
                    <label for="activo">Accion Activa: </label>
                    <input type="text" name="activo" placeholder="Activo" value="${accion.activo}">
                </div>
                <div>
                    <label for="materia">Materia: </label>
                    <input type="text" name="materia" placeholder="Nombre de materia" value="${accion.materia}">
                </div>
                <div>
                    <label for="cuatrimestre">Cuatrimestre: </label>
                    <input type="text" name="cuatrimestre" placeholder="Cuatrimestre" value="${accion.cuatrimestre}">
                </div><div>
                    <label for="maestro">Maestro: </label>
                    <input type="text" name="maestro" placeholder="Nombre del maestro" value="${accion.maestro}">
                </div>
                <div>
                    <input type="submit" values="Guardar">
                </div>
            </fieldset>
        </form>
    </body>
</html>