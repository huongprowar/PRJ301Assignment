<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
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
        <table class="list">
            <tr>
                <td>ListID</td>
                <td>Course</td>
                <td>Instructor</td>
                <td>Slot</td>                
                <td>Room</td>
                <td>Menu</td>
            </tr>             
            <c:forEach items="${requestScope.lessionList}" var="lession">
                <tr>                    
                    <td>${lession.lessionID}</td>
                    <td></td>
                    <td>${lession.instructor.ID}</td>
                    <td>${lession.slot}</td>
                    <td>${lession.roomID}</td>
                    <td><form action="groupInformation.jsp"><input type="submit" value="View" /></td>
                </tr>
            </c:forEach>





            <!--
            
                        <tr>
                <td>${requestScope.lessionList[0].roomID}</td>
            </tr>
            
                       <c:forEach items="${requestScope.dummies}" var="d">
                <tr>
                    <td>${d.id}</td>
                    <td>${d.name}</td>
                </tr>   
            </c:forEach>
            
            <c:forEach items="${requestScope.lessionList}" var="l">
                <tr>
                    <td>2</td>
                    <td>${l.lessionID}</td>
                    <td></td>
                    <td>${l.slot}</td>
                    <td>${l.instructor.Name}</td>
                </tr>
            </c:forEach>   -->
        </table>
    </body>
</html>
