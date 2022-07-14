<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>Group Information</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <style>
        table{
            width:100%;
        }
        tr:first-child{
            background-color: rgb(66, 212, 245);
        }
        th, td {
            border-bottom:1px solid black;
        }
        h1, groupheader{
            font-family: Arial, Helvetica, sans-serif;
            font-size: 45px;
        }
        h2{
            font-family: Arial, Helvetica, sans-serif;
        }

    </style>
    <body>
        <h1 class="groupheader">Group Information</h1>
        <h2>Group: ${requestScope.slList[0].lession.group.gName}</h2>
        <h2>Course: ${requestScope.slList[0].lession.group.cID}</h2>            
        <form action="submitattendance" method="POST">
            <table>
                <tr>
                    <td>Index</td>
                    <td>Member</td>
                    <td>Code</td>
                    <td>Name</td>
                    <td>Status</td>
                </tr>
                <c:set var="i" value="1"></c:set>
                <c:forEach items="${requestScope.slList}" var="sl">
                    <tr>
                        <td>${i}</td>
                        <td>${sl.student.username}</td>
                        <td>${sl.student.id}</td>
                        <td>${sl.student.name}</td>
                        <td><input type="radio" name="${sl.student.id}" value="1" <c:if test="${sl.status}"> checked="checked"</c:if>>Present
                            <input type="radio" name="${sl.student.id}" value="0" <c:if test="${!sl.status}"> checked="checked"</c:if>>Absent
                            </td>
                        </tr>                
                    <c:set var="i" value="${i+1}"></c:set>
                </c:forEach>               
            </table>
            <input type="hidden" name="lessionID" value="${requestScope.slList[0].lession.lessionID}">
            <input type="submit" value="Save">
        </form>
    </body>
</html>
