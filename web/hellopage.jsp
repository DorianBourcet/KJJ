<%-- 
    Document   : hellopage
    Created on : 2016-11-28, 16:50:27
    Author     : soixa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenue !</title>
    </head>
    <body>
        <h1>Hello !</h1>
        Message is: ${message} 
        
        <p>Don't forget: ${thought}</p>
        
        <h2>Adding of a String into the session</h2>
 
<form action="remember" method="post">
<table>
<tr>
<td>To remember:</td>
<td><input type="text" name="thoughtParam" /></td>
</tr>
<tr>
<td><input type="submit" /></td>
<td></td>
</tr>
</table>
</form>
    </body>
</html>
