<%-- 
    Document   : signup
    Created on : 17-Dec-2020, 7:31:48 PM
    Author     : tanishka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Signup</title>
        <style>
            input:required:focus {
                border: 1px solid red;
                outline: none;
            }
        </style> 
    </head>
    <body>
        <script>
            function clearthefeildSeleciton()
            {
                document.getElementById("duplicateuser").innerHTML = "";
                document.getElementById("error").innerHTML = "";
            }
            function registerUser() {
                var isValid = true;
                var node = document.getElementById("error");

                var txtContent = node.textContent;


                if (txtContent === "Username already exists")
                {
                    isValid = false;
                    document.getElementById("duplicateuser").innerHTML = "";
                    alert("Please enter unique username");
                }
                return isValid;

            }
            //AJAX

            var xmlHttp;
            xmlHttp = GetXmlHttpObject();
            function checkUser() {
                if (xmlHttp === null)
                {
                    alert("Your browser does not support AJAX!");
                    return;
                }
                var username = document.getElementById("username").value;
                var query = "action=ajaxCheck&username=" + username;

                xmlHttp.onreadystatechange = function stateChanged()
                {
                    if (xmlHttp.readyState === 4)
                    {
                        //alert(xmlHttp.responseText);
                        var json = JSON.parse(xmlHttp.responseText);
                        document.getElementById("error").innerHTML = "";
                        document.getElementById("error").innerHTML = json.message;

                    }
                };
                xmlHttp.open("POST", "signup.htm", true);
                xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xmlHttp.send(query);
                return false;
            }

            function GetXmlHttpObject()
            {
                var xmlHttp = null;
                try
                {
                    // Firefox, Opera 8.0+, Safari
                    xmlHttp = new XMLHttpRequest();
                } catch (e)
                {
                    // Internet Explorer
                    try
                    {
                        xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                    } catch (e)
                    {
                        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                    }
                }
                return xmlHttp;
            }

        </script>


        <h1>Sign up</h1>
    <form action="signup.htm?action=signup" onSubmit =" return registerUser()" commandName="users" method="post"/>
        Username: <input type="text" path="username" id="username"  onclick="return clearthefeildSeleciton()" required />
        <div id="error" style="color:red"></div>
        <br/>
        Password: <input type="password" path="password" required/></p>
        <br/>
        <input type="submit" value="Sign Up"/>
        <br/>
        <font color="red"><a href="index.htm"> Go Back to Main Page </a> </font>
    </form>
</body>
</html>

