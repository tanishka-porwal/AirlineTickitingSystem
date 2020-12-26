<%-- 
    Document   : login
    Created on : 16-Dec-2020, 7:15:37 PM
    Author     : tanishka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
            input:required:focus {
                border: 1px solid red;
                outline: none;
            }
        </style> 
    </head>
    <body>
        <h3>Please enter your credentials</h3>
        <form action="login.htm" method="post">

            UserName:
                    <input type="text" name="username" size="30" value = "" required/>
                    <br> <br>
                

            Password:
                    <input type="password" name="password" size="30"  required/>
                     <br><br>
            <input type="submit" value="Login" />
        </form>
<br>
        <font color="red"><a href="index.htm"> Go Back to Main Page </a> </font>

    </body>
</html>
