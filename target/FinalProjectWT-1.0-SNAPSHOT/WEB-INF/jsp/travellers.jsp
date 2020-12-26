<%-- 
    Document   : travellers
    Created on : 17-Dec-2020, 7:34:16 PM
    Author     : tanishka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Travellers Information</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <form action="passenger.htm" action="get">
            Number of Travellers : <input type="number" name="noOfTravellers" required />
            <input type="submit" value="Go"/>
        </form>
    </body>
</html>
