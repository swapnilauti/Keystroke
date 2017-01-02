<%
session.setAttribute("userid", null);
session.invalidate();
response.sendRedirect("loginpage.jsp");
%>