<%-- 
    Document   : lista_acciones
    Created on : 23/09/2016, 02:44:24 PM
    Author     : tyrrang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Acciones</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>  ID Accion Remedial</tr>
                <tr>-  Nombre</tr>
                <tr>-  Activo</tr>
                <tr>-  Materia</tr>
                 <tr>-  Cuatrimestre</tr>
                  <tr>-  Maestro</tr>
            </thead>
            <tbody>
                <c:forEach items="${acciones}" var="accion">
                    <tr>
                        <td>${accion.idAccion}</td>
                        <td>${accion.nombre}</td>
                        <td>${accion.activo}</td>
                        <td>${accion.materia}</td>
                        <td>${accion.cuatrimestre}</td>
                        <td>${accion.maestro}</td>
                        <td> 
                            <a href="AccionController?action=cambiar&idAccion=${accion.idAccion}">Cambiar</a> 
                        </td>
                        <td> 
                            <a href="AccionController?action=borrar&idAccion=${accion.idAccion}">Borrar</a> 
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="AccionController?action=agregar">AgregarAccion</a>
        </p>
    </body>
</html>
