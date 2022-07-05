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
        <h2>Group: SE1634</h2>
        <h2>Course: PRJ301</h2>            
        <table style="width:100%">
            <tr>
                <td>Index</td>
                <td>Member</td>
                <td>Code</td>
                <td>Name</td>
                <td>Status</td>
            </tr>
            <c:set var="i" value="0"></c:set>
            <c:forEach items="${requestScope.sgList}" var="sg">
                <c:set var="i" value="${i+1}"></c:set>
                    <tr>
                        <td>${i}</td>
                        <td>${sg.student.studentName}</td>
                        <td>${sg.student.studentID}</td>
                        <td>${sg.group.gID}</td>
                        <td><input type="radio" name="status" value="Present">Present
                            <input type="radio" name="status" value="Present">Absent
                        </td>
                    </tr>                
            </c:forEach>


            <!--
            <tr>
                <td>Index</td>
                <td>Member</td>
                <td>Code</td>
                <td>Name</td>
                <td>Status(Present)(Absent)</td>
            </tr>
            
            <tr>
                <td>1</td>
                <td>namnhhe163297</td>
                <td>HE163297</td>
                <td>Ngo Hai Nam</td>
                <td><input type="radio" name="status" value="present">Present<input type="radio" name="status" value="absent">Absent</td>
            </tr>
            <tr>
                <td>2</td>
                <td>huonglmhe160632</td>
                <td>HE160632</td>
                <td>Luu Minh Huong</td>
                <td><input type="radio" name="status" value="present">Present<input type="radio" name="status" value="absent">Absent</td>
            </tr>
            <tr>
                <td>3</td>
                <td>hieunvhe163104</td>
                <td>HE163104</td>
                <td>Nguyen Van Hieu</td>
                <td><input type="radio" name="status" value="present">Present<input type="radio" name="status" value="absent">Absent</td>
            </tr>
            <tr>
                <td>4</td>
                <td>anhpvhe153711</td>
                <td>HE153711</td>
                <td>Phung Viet Anh</td>
                <td><input type="radio" name="status" value="present">Present<input type="radio" name="status" value="absent">Absent</td>
            </tr>
            <tr>
                <td>5</td>
                <td>tungmvhe163714</td>
                <td>HE163714</td>
                <td>Mai Van Tung</td>
                <td><input type="radio" name="status" value="present">Present<input type="radio" name="status" value="absent">Absent</td>
            </tr>
            -->
        </table>
        <form>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
