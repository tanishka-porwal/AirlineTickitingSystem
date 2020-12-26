<%-- 
    Document   : addFlights
    Created on : 17-Dec-2020, 6:48:53 PM
    Author     : tanishka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add flight</title>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <script>
            $(document).ready(function () {
                $("#txtFromDate").datepicker({
                    numberOfMonths: 2,
                    minDate: 0,
                    onSelect: function (selected) {
                        $("#txtToDate").datepicker("option", "minDate", selected)
                    }
                });
                $("#txtToDate").datepicker({
                    numberOfMonths: 2,
                    onSelect: function (selected) {
                        $("#txtFromDate").datepicker("option", "maxDate", selected)
                    }
                });
            });
        </script>
        <style>
            input:required:focus {
                border: 1px solid red;
                outline: none;
            }
        </style>
    </head>
    <body>
    <form:form action="addflights.htm" commandName="fd" method="post">
        <table>
            <tr>
                <td>Flight Name</td>
                <td><form:input type="text" path="flight_name" size="30"/><font color="red"><form:errors path="flight_name"/></font></td>
            </tr>
            <tr>
                <td>Airplane Id</td>
                <td><form:input type="text" path="airplane_id" size="30"/><font color="red"><form:errors path="airplane_id"/></font></td>
            </tr>
            <tr>
                <td>From</td>
                <td><form:input type="text" path="from" size="30"/><font color="red"><form:errors path="from"/></font></td>
            </tr>
            <tr>
                <td>Dest</td>
                <td><form:input type="text" path="dest" size="30"/><font color="red"><form:errors path="dest"/></font></td>
            </tr>
            <tr>
                <td>Departure Time</td>
                <td><form:input type="text" path="deptTime" size="30"/><font color="red"><form:errors path="deptTime"/></font></td>
            </tr>
            <tr>
                <td>Arrival Time</td>
                <td><form:input type="text" path="arrivalTime" size="30"/><font color="red"><form:errors path="arrivalTime"/></font></td>
            </tr>
            <tr>
                <td>Travel Class</td>
                <td><form:input type="text" path="travelClass" size="30"/><font color="red"><form:errors path="travelClass"/></font></td>
            </tr>
            <tr>
                <td>Total Seats</td>
                <td><form:input type="text" path="totalSeats" size="30"/><font color="red"><form:errors path="totalSeats"/></font></td>
            </tr>
            <tr>
                <td>Available Seats</td>
                <td><form:input type="text" path="availableSeats" value="${requestScope.flight.availableSeats}" size="30"/><font color="red"><form:errors path="availableSeats"/></font></td>
            </tr>
            <tr>
                <td>Amount</td>
                <td><form:input type="text" path="amount" size="30"/><font color="red"><form:errors path="amount"/></font></td>
            </tr>
            <tr>
                <td>Departure Date</td>
                <td><form:input type="text" path="deptDate" id="txtFromDate" size="30"/><font color="red"><form:errors path="deptDate"/></font></td>
            </tr>
            <tr>
                <td>Arrival Date</td>
                <td><form:input type="text" path="arrDate" id="txtToDate" size="30"/><font color="red"><form:errors path="arrDate"/></font></td>

            </tr>

            <tr>
                <td colspan="2"><input type="submit" value="Add flight to database" /></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
