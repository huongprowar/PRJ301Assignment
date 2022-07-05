<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>Group menu</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <style>
        .list{
            width: 100%;
        }
        table{
            text-align: center;
        }
        tr:first-child{
            background-color: rgb(66, 212, 245);
        }
        tr,td {
            border-bottom:1px solid black;
        }
    </style>
    <body>
        <form action="view" method="GET">
            <table class="list">
                <tr>
                    <td>ListID</td>
                    <td>Course</td>
                    <td>Instructor</td>
                    <td>Slot</td>                
                    <td>Room</td>
                    <td>Menu</td>
                </tr>            
                <c:forEach items="${requestScope.lessionList}" var="l">
                    <tr>                    
                        <td>${l.lessionID}</td>
                        <td>${l.group.cID}</td>
                        <td>${l.instructor.ID}</td>
                        <td>${l.slot}</td>
                        <td>${l.roomID}</td>
                        <td><a href="view?gid=${l.group.gID}&lessionID=${l.lessionID}">View</a></td>
                    </tr>
                </c:forEach>            
            </table>        
        </form>
    </body>
</html>
