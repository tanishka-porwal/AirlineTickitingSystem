<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to FlyHigh AirTravel </title>
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

            //AJAX 

            var xmlHttp;
            xmlHttp = GetXmlHttpObject();
            function names1()
            {
                if (xmlHttp === null)
                {
                    alert("Your browser does not support AJAX!");
                    return;
                }
                var destCities = document.getElementById("dest").value;
                var query = "fromCities=" + destCities;


                xmlHttp.onreadystatechange = function stateChanged()
                {
                    if (xmlHttp.readyState === 4)
                    {

                        var dataList = document.getElementById('json-datalist1');
                        var json = JSON.parse(xmlHttp.responseText);
                        for (var i = 0; i < json.list.length; i++)
                        {

                            var option = document.createElement("option");
                            option.value = json.list[i].cityname;
                            option.textContent = name;
                            dataList.appendChild(option);
                        }

                    }
                };

                xmlHttp.open("POST", "fromCitieslist.htm", true);
                xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xmlHttp.send(query);
                return false;
            }

            function names() {
                if (xmlHttp === null)
                {
                    alert("Your browser does not support AJAX!");
                    return;
                }
                var fromCities = document.getElementById("from").value;
                var query = "fromCities=" + fromCities;


                xmlHttp.onreadystatechange = function stateChanged()
                {
                    if (xmlHttp.readyState === 4)
                    {

                        var dataList = document.getElementById('json-datalist');
                        var json = JSON.parse(xmlHttp.responseText);
                        for (var i = 0; i < json.list.length; i++)
                        {

                            var option = document.createElement("option");
                            option.value = json.list[i].cityname;
                            option.textContent = name;
                            dataList.appendChild(option);
                        }

                    }
                };
                xmlHttp.open("POST", "fromCitieslist.htm", true);
                xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xmlHttp.send(query);
                return false;
            }

            function GetXmlHttpObject()
            {
                var xmlHttp = null;
                try
                {
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
        <style>
            input:required:focus {
                border: 1px solid red;
                outline: none;
            }
        </style>
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

    <h1>FlyHigh AirTravel</h1>
    <form:form action="listflights.htm" commandName="flightInformation" method="post">

        From:
        <input type="text" path="from" size="30" id="from" list="json-datalist" onkeyup="return names()" required="required"/> <font color="red"><errors path="from"/></font>
            <datalist id="json-datalist"></datalist>
        <br>
        Destination:
        <input type="text" path="dest" id="dest" list="json-datalist1" onkeyup="return names1()" size="30" required="required"/> <font color="red"><errors path="dest"/></font>
            <datalist id="json-datalist1"></datalist>
        <br/>
        Departure Date:
        <input type="date" path="deptDate" id="txtFromDate" size="30" required="required"/> <font color="red"><errors path="deptDate"/></font>
        <br/>   
        Travel Class:
        <input type="radio" value="Economy" name="travelclass" id= "Economy" checked="checked"/>
        <label for="Economy">Economy</label>
        <input type="radio" value="Business" name="travelclass" id="Business" />
        <label for="Business">Business Class</label> <br/>
        
        
        <input type="submit" value="Search flights" />
    </form:form>
</body>
</html>
