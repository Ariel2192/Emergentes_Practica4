<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body style="font-family: comic sans ms; font-size: large; background-color: lightblue">
        <center>
            
            <br>
            <br>
        <h1>Login</h1>
        <form action="MainController" method="post">
            <table>
                <tr>
                    <td style="font-size: larger">Usuario: </td>
                    <td><input type="text" name="usuario" style="font-size: larger; background-color: cadetblue ;border-style: hidden; color: white"></td>
                    
                </tr>
                <tr><td></td></tr>
                <tr><td></td></tr>
                <tr><td></td></tr>
                <tr><td></td></tr>
                <tr>
                    <td style="font-size: larger">Password:    </td>
                    <td><input type="password" name="password" style="font-size: larger; background-color:cadetblue ;border-style: hidden; color: white"></td>
                    
                </tr>
                <tr><td></td></tr>
                <tr><td></td></tr>
                <tr><td></td></tr>
                <tr><td></td></tr>
                
                <tr>
                    <td><input type="submit" value ="Ingresar" style="font-family: comic sans ms; font-size: larger"></td>
                </tr>
            </table>
        </form>
        </center>
    </body>
    
</html>
