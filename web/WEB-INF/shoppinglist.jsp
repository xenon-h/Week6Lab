<%-- 
    Document   : shoppingList
    Created on : Oct 25, 2020, 9:31:11 PM
    Author     : 759005
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <h2>Hello ${username}</h2>

        <a href="?action=logout">Logout</a>

        <form method="post" action="">
            <h1>Add Item</h1>
            <input type="text" name="itemname"/>
            <input type="hidden" name="action" value="addItem" />
            <input type="submit" value="Add Item" />
        </form>  

        <form method="post" action="">
            <ul>
                <c:forEach items="${items}" var="item">
                    <c:if test="${item!=null && item!=''}">
                        <li><input type="radio" name="item" value="${item}">${item}</input></li>
                        </c:if>
                    </c:forEach>
            </ul>
            <input type="hidden" name="action" value="deleteItem" />
            <input type="submit" value="Delete Item" />
        </form>
        <p>${message}</p>
    </body>
</html>
