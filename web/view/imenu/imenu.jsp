<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>Instructor menu</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <style>
            .headinformation{
                width: 100%;
                text-align: center;
                font-family: Arial, Helvetica, sans-serif;
            }
            .status{
                text-align: center;
                padding-right: 20px;
                background-color: rgb(230, 227, 220);
                height:35px;
            }
            .headerbox h2 {
                font-family: Arial, Helvetica, sans-serif;
                padding-top: 5px;
                height: 34px;
                width: 100%;
                text-align: center;
                color:#fff;
                background-color: orange;
            }
        </style>
        <div class="headinformation">
            <h1>FPT University Academic Portal</h1>
        </div>
        <div class="status">
            <span>Welcome back ${acc.person.id}</span>
        </div>
        <div class="headerbox">
            <h2>Academic Information</h2>
        </div>
        <form action="grouplist" method="GET">            
            <input type="hidden" name="instructorID" value="${acc.person.id}">   
            <input type="submit" value="Attendance Menu"/> 
        </form>
    </body>
</html>
