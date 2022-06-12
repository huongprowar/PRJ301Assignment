<%-- 
    Document   : attendancemenu
    Created on : Jun 11, 2022, 12:57:46 AM
    Author     : Nam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Attendance menu</title>
    </head>
    <body>
        <table>
            <c:forEach items="${requestScope.groupList}" var="e">
                <tr>
                    <td>${e.gID}</td>
                    <td>${e.cID}</td>
                    <td>${e.iID}</td>
                </tr>                  
            </c:forEach>              
        </table>
    </body>
</html>
