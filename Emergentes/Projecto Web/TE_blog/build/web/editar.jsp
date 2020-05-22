<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.emergentes.modelo.Entrada"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Entrada entrada = (Entrada) request.getAttribute("entrada");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>JSP Page</title>
    </head>
    <body style="font-family: comic sans ms; font-size: large; background-color: lightblue">
        <center>
        <h1>
            <c:if test="${item.id == 0}">Editar Entrada</c:if>
            <c:if test="${item.id != 0}">Nueva Entrada</c:if>
        </h1>
    
        <form action="EntradaController" method="post">
            <table>
                <input type="hidden" name="id" value="${entrada.id}">
                <tr>
                    <td>Fecha: </td>
                    <td><input type="date" name="fecha" value="${entrada.fecha}"></td>
                </tr>
                
                <tr><h1></h1></tr>
                <tr>
                    <td>Título: </td>
                    <td><input type="text" name="titulo" value="${entrada.titulo}" size="60"></td>
                </tr>
                <h1></h1>
                
                <tr>
                    <td >Contenido: </td>
                    <td><textarea rows = "20" cols = "100" name="contenido" value="${libro.contenido}"></textarea></td>
                </tr>
                <h1></h1>
                
                <tr>
                    <td>Autor: </td>
                    <td><input type="text" name="autor" value="${entrada.autor}"></td>
                </tr>
                <h1></h1>
                
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enviar"></td>
                </tr>
            </table>            
        </form>
    </center>
    </body>
</html>
