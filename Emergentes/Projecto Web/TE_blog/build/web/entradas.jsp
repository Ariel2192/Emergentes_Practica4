<%@page import="com.emergentes.modelo.Usuario"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Entrada"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<Entrada> lista = (List<Entrada>) request.getAttribute("Lista");
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>JSP Page</title>
    </head>
    
        <body style="background-color: lightblue; font-family: comic sans ms; width: 80%; margin-left: auto; margin-right: auto">
            <p align = "right"> 
            <a href="MainController">Salir</a>
            </p>
            <h1><center>Blog de educación</center></h1>
        
        <a href="EntradaController?op=nuevo">Nueva Entrada</a>
        <br>
        <br>
                    
            <c:forEach var="item" items="${lista}">
                <hr>
            
                <div>
                    <p style="color: blue">${item.fecha}<P>
                    <h2>${item.titulo}</h2>
                    <p align = "right"><a href="EntradaController?op=editar&id=${item.id}">Editar</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="EntradaController?op=eliminar&id=${item.id}" onclick="return(confirm('¿Eliminar la entrada?'))">Eliminar</a></p>
                    <p>${item.contenido}</p>
                    <P>Autor: ${item.autor}</P>
                </div>
            
            
            </c:forEach>
            
        </body>
</html>
