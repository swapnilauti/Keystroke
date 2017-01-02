<%@page contentType="text/html" pageEncoding="UTF-8" language = "java" %>

<!DOCTYPE html>
<html lang='en'>
<head>
     <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Login Page</title>
  <link rel="stylesheet" href="style.css">

     <script>
         var charCount = 0;
  var times = [];
  var diff=[];
  var j=0;
  var k=new String();
  var val = event.keyCode;
  
       function keyUp(){
           var vl=event.keyCode;
           if(vl!==13){
            var currentDate = new Date();
	  times[charCount] = (currentDate.getHours()*60*60*1000)+(currentDate.getMinutes()*60*1000)+(currentDate.getSeconds()*1000)+currentDate.getMilliseconds();
	  charCount++;
                     }
       }  
       function addvalue1()
       {
            
           for(var r=1;r<times.length;r++)
            diff[r-1]=times[r]-times[r-1];
           k=diff.join();
           var b = document.getElementById("ptime");
           b.value=k;
           
       }
       function reset()
        {      alert(' Wrong Password!!Retype Password') ;
           times=[];
           charCount=0;
        }
       
       function reset1()
        {      alert('backspace used!!!!! Retype Password') ;
           times=[];
           charCount=0;
        }
       
function validateForm()
{
    if(document.frm.email.value==="")
    {
      alert("User Name should not be left blank");
      document.frm.email.focus();
      return false;
    }
    else if(document.frm.password.value==="")
    {
      alert("Password should not be left blank");
      document.frm.password.focus();
      return false;
    }
}
  

</script>

</head>
    <body>
        <div class="container">
    <section class="register">
        <form name="frm" method="post" onsubmit="return validateForm()" action="LoginValidate">
  <h1>Log in</h1>
  <p>
    <input type="text" placeholder="Enter Your User Name" name="uname" id="email">
  </p>
  <p>
      <input type="password" placeholder="Enter Your Password" name="pass" id="password" onkeypress="keyUp()" onkeyup="var vl=event.keyCode;if(vl===8){reset1();pass.value='';document.passfrm.pass.focus();} "  onchange="return addvalue1()">
  </p>
  <input type="hidden" id="ptime" name="ptime" value="" />
  <p>
    <input type="submit" name="go" id="go" value="Log in" >
  
  <br>
  
  <p>Not Yet Registered? <a href="regcss.jsp">Register Here</a></p>
</form>
</section>
</div>
</body>
</html>