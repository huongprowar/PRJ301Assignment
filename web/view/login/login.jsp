<%-- 
    Document   : create
    Created on : Jun 2, 2022, 11:50:41 AM
    Author     : Ngo Tung Son
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Username: <input type="text" name="user"><br/>
        Password: <input type="text" name="pass"><br/>
        <form action="create" method="POST">
            Campus: <select name="cid" required="required">
                <c:forEach items="${requestScope.cList}" var="d">
                    <option 
                        <c:if test="${param.cid eq d.cid}">selected="selected"</c:if>
                        value="${d.cid}">${d.cname}</option>
                </c:forEach>
            </select> <br/>
            <input type="submit" value="Login" />
        </form>
    </body>
</html>
