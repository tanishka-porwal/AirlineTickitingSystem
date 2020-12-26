<%-- 
    Document   : deleteAirplane
    Created on : 17-Dec-2020, 6:57:39 PM
    Author     : tanishka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Airplane</title>
        <style>
            input:required:focus {
                border: 1px solid red;
                outline: none;
            }
        </style> 
    </head>
    <body>
        <form action="deleteAirplane.htm" method="post">
            Please enter airplane_id : 
            <input type="number" name="airplane_id" required/>
            <input type="submit" value="Go" />
        </form>
    </body>
</html>
