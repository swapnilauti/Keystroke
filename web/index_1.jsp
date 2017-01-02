<%@page contentType="text/html" pageEncoding="UTF-8" language = "java" %>

<!DOCTYPE html>
<html lang='en'>
<head>
    <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Registration Form</title>
  <link rel="stylesheet" href="css/style.css">
</head>
 <script>
function validateForm()
{
    if(document.frm.email.value=="")
    {
      alert("User Name should not be left blank");
      document.frm.email.focus();
      return false;
    }
    else if(document.frm.password.value=="")
    {
      alert("Password should not be left blank");
      document.frm.password.focus();
      return false;
    }
}
function doSubmit()  
{  
location.href="index.jsp"; 
}  
  

</script>
    <body>
        
        <form name="frm" method="post" onsubmit="return validateForm()" action="login.jsp">
  <h1>Log in</h1>
  <div> 
  <p>
    <label for="email">USER NAME</label>
    <input type="text" name="uname" id="email">
  </p>
  <p>
    <label for="password">PASSWORD</label>
    <input type="password" name="pass" id="password">
  </p>
  
  <p>
    <button id="registerNew" type="submit">LOG IN</button>
  </p>
  <p>Not Yet Registered? <a href="reg.jsp">Register Here</a></p>
</form>
</div>
</body>
</html>