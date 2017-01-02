<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language = "java" %>

<!DOCTYPE html>
<html lang='en'>
<head>
    
     <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Sent Box</title>
  <link rel="stylesheet" href="style.css">
<style>
    th {
        color: #C4C3C3;
        text-align: left;
    }
    table {
    border-collapse: separate;
    border-spacing: 8px 8px;
}
</style>    
<%
    if ((session.getAttribute("uname") == null) || (session.getAttribute("uname") == "")) {
        response.sendRedirect("disclaimer.jsp");
    }
%>

</head>
    <body>
        <table>
  <tr>
    <th >Date</th>
    <th> To</th>
    <th > Subject</th>
    
  </tr>
  <%
     Class.forName("com.mysql.jdbc.Driver");
    java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/members",
            "root", "123456");
    java.sql.Statement st = con.createStatement();
    java.sql.ResultSet rs;
    rs = st.executeQuery("select * from mailbox where `FROM`=('" + session.getAttribute("uname") + "')");
   while(rs.next()){
       int mid= rs.getInt(1);
       Date date = rs.getDate(2);
       String to = rs.getString(4);
       String subject = rs.getString(6);
       
       
  %>
  
  
  <tr>
      <td> <%= date %></td>
      <td> <%= to %> </td>
      <td> <a href="maildisplay.jsp"><%= subject %></a></td>
  </tr>
      </table>


  
  <input type="hidden" name="subject" value=<%= subject %>/> 
  <% 
    }
     %>
     

    </body>
</html>
