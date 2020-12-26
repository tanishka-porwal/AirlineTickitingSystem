<%-- 
    Document   : viewCart
    Created on : 17-Dec-2020, 7:36:52 PM
    Author     : tanishka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Cart</title>
    </head>
    <body>
    <c:choose>
        <c:when test="${!empty sessionScope.username}">
            <jsp:include page="menu.jsp"/>
        </c:when>
        <c:otherwise>
            <jsp:include page="menu2.jsp"/>
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${!empty sessionScope.cart}">
            <h3>Your cart contents</h3>
            <table border="1">
                <tr>
                    <th>Flight Number</th>
                    <th>Flight Name</th>
                    <th>Airplane Id</th>
                    <th>Price</th>
                    <th>Departure time</th>
                    <th>Destination arrival time </th>
                </tr>
                <c:forEach var="flight" items="${sessionScope.cart}">
                    <tr>
                        <td>${flight.flight_id}</td>
                        <td>${flight.flight_name}</td>
                        <td>${flight.airplane_id}</td>
                        <td>$${flight.amount}</td>
                        <td>${flight.deptTime}</td>
                        <td>${flight.arrivalTime}</td>
                        <td><a href="removeFromCart.htm?action=remove&id=${flight.flight_id}"> [Remove from cart]</a></td>
                    </tr>   
                </c:forEach>
                <tr><td></td><td></td></tr>
                <tr>
                    <td>Total</td>
                    <td>${sessionScope.total}</td>
                </tr>
            </table>
            <br><br>
            <a href="passenger1.htm"> Proceed to enter details and Payment>></a>
        </c:when>
        <c:otherwise>
            <h3>Oops.. your cart is empty</h3>
            <p><a href="index.htm">Return to main page</a></p>
        </c:otherwise>
    </c:choose>
</body>
</html>
