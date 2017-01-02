<%@page contentType="text/html" pageEncoding="UTF-8" language = "java" %>

<!DOCTYPE html>
<html lang='en'>
<head>
    
     <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <%
    if ((session.getAttribute("uname") == null) || (session.getAttribute("uname") == "")) {
        response.sendRedirect("disclaimer.jsp");
    }
%>

  <title>Inbox</title>
  <link rel="stylesheet" href="style.css">    </head>
    <body>
        <%   Class.forName("com.mysql.jdbc.Driver");
    java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/members",
            "root", "123456");
    java.sql.Statement st = con.createStatement();
    java.sql.ResultSet rs;
    rs = st.executeQuery("select * from mailbox where `FROM` =('"+ session.getAttribute("uname") + "')AND subject=('" + request.getParameter("subject") + "')");
    while(rs.next())
    {
        String content = rs.getString(7);
     %>   
     <p style="color: #C4C3C3"><%= content %> </p>
     
    <%
    }  
        %>
    </body>
</html>
