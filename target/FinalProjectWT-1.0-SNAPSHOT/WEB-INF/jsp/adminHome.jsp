<%-- 
    Document   : adminHome
    Created on : 17-Dec-2020, 6:49:20 PM
    Author     : tanishka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Home Page</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <h3>Admin Page</h3>
        <a href = "addAirplane.htm"> Add Airplane</a><br/><br/>
        <a href = "deleteAirplane.htm">Delete Airplane</a><br/><br/>
        <a href="ListFlights.htm">View and Edit Flights</a><br/><br/>
        <a href="viewpassengers.htm">View Passenger List </a><br/><br/>

    </body>
</html>
