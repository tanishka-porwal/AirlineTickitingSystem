<%-- 
    Document   : addedAirplane
    Created on : 17-Dec-2020, 6:48:07 PM
    Author     : tanishka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Airplane Added</title>
        <style>
            input:required:focus {
                border: 1px solid red;
                outline: none;
            }
        </style> 
    </head>
    <body>
        New Airplane added Successfully: ${airplane.airlineName}<br>

        <a href="adminHome.htm">Go Back to Menu Page</a>

    </body>
</html>
