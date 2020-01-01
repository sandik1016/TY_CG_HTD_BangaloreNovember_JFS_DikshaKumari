<%String msg =(String)request.getAttribute("msg"); %>


<html>
<body>
//<h2>${msg}</h2>
<h2 style="color:green;">${msg}</h2>
<h2 style="color:red;"><%=msg %></h2><!-- request attribute -->
</body>
</html>
