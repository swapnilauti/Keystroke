<html lang='en'>
<head>
    <meta charset="UTF-8" /> 
    <title>
        HTML Document Structure
    </title>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<%
    if ((session.getAttribute("uname") == null) || (session.getAttribute("uname") == "")) {
        response.sendRedirect("disclaimer.jsp");
    }
%>

<%! int i=0;
%>

   <h3 style="color :#C4C3C3">Welcome <%=session.getAttribute("uname")%></h3>
    <a  href='logout.jsp'><h3>Log out</h3></a>   
<%
    
    for(i=0;i<5;i++)
    {    
%>
<br>
<%
    } 
%>
<a href='compose.jsp'>Compose</a><br>
<a href='inbox.jsp'>Inbox</a><br>
<a href='sentbox.jsp'>Sent Box</a><br>
<a href='draft.jsp'>Draft</a>

</body>
</html>