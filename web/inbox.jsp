<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language = "java" %>

<!DOCTYPE html>
<html lang='en'>
<head>
    
     <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Inbox</title>
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
</head>
    <body>
  <%
    if ((session.getAttribute("uname") == null) || (session.getAttribute("uname") == "")) {
        response.sendRedirect("disclaimer.jsp");
    }
%>

        <table>
  <tr>
    <th >Date</th>
    <th> From</th>
    <th > Subject</th>
    
  </tr>
  <%@page import="java.sql.SQLException" %>
  <%
    Class.forName("com.mysql.jdbc.Driver");
    java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/members","root","123456");
    
    java.sql.Statement st = con.createStatement();
    java.sql.ResultSet rs;
    //
    rs = st.executeQuery("select * from mailbox where `TO`='"+session.getAttribute("uname")+"'" );                      //as TO is a keyword, wrap it in `` (Backtick)
   while(rs.next()){
       int mid= rs.getInt(1);
       Date date = rs.getDate(2);
       String from = rs.getString(3);
       String subject = rs.getString(6);
       
       
  %>
  <tr>
      <td style="color: #C4C3C3"> <%= date %></td>
      <td style="color: #C4C3C3"> <%= from %> </td>
      <td style="color: #C4C3C3"> <a href="maildisplay.jsp" ><%= subject %></a></td>
    </tr>
  <% } %>

  
       </table>
  
    </body>
</html>
