<%-- 
    Document   : payment
    Created on : 17-Dec-2020, 7:29:26 PM
    Author     : tanishka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Page</title>
        <style>
            input:required:focus {
                border: 1px solid red;
                outline: none;
            }
        </style> 
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <form action="payment.htm" method="post">
            <pre>
	Credit Card Number <input type="text" name="creditCardNumber" value='${cookie.ccn.value}' required />
	Bank Name          <input type="text" name="bankName" required />
	Name as on card    <input type="text" name="fullName" required/>
	Expiration Month   <input type="number" name="expiration_month" required />
	Expiration Year    <input type="number" name="expiration_year" required/> 
	<input type="submit" value="Book Ticket" />
            </pre>
        </form>
    </body>
</html>
