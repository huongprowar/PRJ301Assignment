<%-- 
    Document   : weeklyTimeTable
    Created on : Jul 18, 2022, 11:45:35 PM
    Author     : Nam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <script>
        window.addEventListener('load', () => {
            const startDate = new Date('2021-04-26').getTime();
            const addWeek = (week) => {
                const date = new Date(startDate + 1000 * 60 * 60 * 24 * 7 * week);
                document.getElementById('date-choices').innerHTML += '<option value="' + date.getTime() + '">' + date.toDateString() + '</option>';
            }

            for (var i = 0; i < 100; i++) {
                addWeek(i);
            }
        });
    </script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="weeklytimetable" method="GET">            
            <select name="milisecond" id="date-choices"></select>            
            <input type="submit" value="Save">
        </form>

        <!-- g.groupName, g.courseID, l.slot, l.roomID, l.recordTime, l.instructorID -->
        <table>

            <tr>
                <td></td>
                <td><input type="hidden" value="${requestScope.dateOfWeek[0]}">Monday</td>
                <td><input type="hidden" value="${requestScope.dateOfWeek[1]}">Tuesday</td>
                <td><input type="hidden" value="${requestScope.dateOfWeek[2]}">Wednesday</td>
                <td><input type="hidden" value="${requestScope.dateOfWeek[3]}">Thursday</td>
                <td><input type="hidden" value="${requestScope.dateOfWeek[4]}">Friday</td>
                <td><input type="hidden" value="${requestScope.dateOfWeek[5]}">Saturday</td>
                <td><input type="hidden" value="${requestScope.dateOfWeek[6]}">Sunday</td>
            </tr>
            <c:forEach var="i" begin="0" end="5">                
                <tr>
                    <td>Slot${i+1}</td>
                    <c:forEach var="j" begin="0" end="6">
                        <td>
                            
                            <c:forEach items="${requestScope.timeTableList}" var="l">
                                <c:if test="${l.slot eq i+1 && l.recordTime lt requestScope.dateOfWeek[j]}">[${l.recordTime}] & [${requestScope.dateOfWeek[j]}]</c:if>
                            </c:forEach>
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
