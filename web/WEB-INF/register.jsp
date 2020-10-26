<%-- 
    Document   : register
    Created on : Oct 25, 2020, 9:30:54 PM
    Author     : 759005
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="post" action="">
            <input type="text" name="username" /><br/>
            <input type="submit" value="Register" />
            <input type="hidden" name="action" value="register" />
        </form>
        <p>${message}</p>
    </body>
</html>
