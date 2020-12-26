<%-- 
    Document   : addAirplane
    Created on : 17-Dec-2020, 6:45:01 PM
    Author     : tanishka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Airplane</title>
        <style>
            input:required:focus {
                border: 1px solid red;
                outline: none;
            }
        </style>
    </head>
    <body>
    <form:form action="addAirplane.htm" commandName="airplane" method="post">
        <pre>
Please enter the details

Airline Name: <form:input type="text" path="airlineName" name="airlineName" size="30" required="required"/>

Owner:        <form:input type="text" path="owner" name="owner" size="30" required="required" />
    
        <input type="submit" value="Add Airplane" />
        </pre>
    </form:form>
</body>
</html>
