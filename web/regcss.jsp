<%@page contentType="text/html" pageEncoding="UTF-8" language = "java" %>

<!DOCTYPE html>
<html lang='en'>
    
<head>
    <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Registration Form</title>
  <link rel="stylesheet" href="style.css">

<script>
function validateForm()
{
    
     
    if(document.frm1.email.value==="")
    {
      alert("Email should not be left blank");
      document.frm1.email.focus();
      return false;
    }
    else if(document.frm1.password.value==="")
    {
      alert("Password should not be left blank");
      document.frm1.password.focus();
      return false;
    }
    else if(document.frm1.name.value==="")
    {
      alert("First Name should not be left blank");
      document.frm1.name.focus();
      return false;
    }
    else if(document.frm1.tel.value==="")
    {
      alert("Telephone no. should not be left blank");
      document.frm1.tel.focus();
      return false;
    }
}
function passchk()
{
    var err=document.getElementById('passERR');
    if(document.frm1.password.value!==document.frm1.confirm.value)
    {
        
        err.innerHTML = "Password did not match!";
        document.frm1.password.value="";
        document.frm1.confirm.value="";
        
        
      
    }
    else
    {
        err.innerHTML = "";
    }
        
}
</script>
</head>
<body>
  <div class="container">
    <section class="register">
      <h1>Register on Keystroke Biometrics</h1>
      <form name="frm1" method="post" onsubmit="return validateForm()" action="trainingpass.jsp">
      <div class="reg_section personal_info">
      <h3>Your Personal Information</h3>
      <input type="text" name="name" value="" placeholder="Your Desired Username">
      <input type="email" name="email" value="" placeholder="Your E-mail Address"/><br>
      <input id="tel" name="tel" type="text" placeholder="Your Contact No." value="" />
      </div>
      <div class="reg_section password">
      <h3>Your Password</h3>
      <input type="password" name="password" value="" placeholder="Your Password" onfocus="var err=document.getElementById('passERR');err.innerHTML = '';">
      <input type="password" name="confirm" value="" placeholder="Confirm Password" onchange="passchk()">
      <span id="passERR"></span><br>
      </div>
      <div class="reg_section password">
      <h3>Nationality</h3>
      <select name="nation">
        <option value="India">India</option>  
        <option value="US">US</option>
        <option value="UK">UK</option>
        <option value="Egypt">Egypt</option>
        <option value="Palastine">Palastine</option>
        <option value="Syria">Syria</option>
        <option value="Italy">Italy</option>
      </select>
      
      <select name="sec">
        <option value="">Choose</option>
        <option value="Para">Paragraph Level Security</option>          
      </select>
      
      </div>
      <p class="submit"><input type="submit" name="commit" value="Sign Up"></p>
      </form>
    </section>
  </div>
</body>
</html>