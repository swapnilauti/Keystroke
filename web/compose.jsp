

<%@page contentType="text/html" pageEncoding="UTF-8" language = "java" %>

<!DOCTYPE html>
<html lang='en'>
<head>
     <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Compose</title>
  <link rel="stylesheet" href="style.css">
  <style>
      
      </style>
    <script>
        var charCount = 0;
        var times = [];
        var kcode=[];
        var diff=[];
        var i=0;
        var s=new String();
        var e=new String();
        
        function retcode(e)
        {
            var k=e.keyCode;
           
           if(k!==13){
            var currentDate = new Date();
	  times[charCount] = (currentDate.getHours()*60*60*1000)+(currentDate.getMinutes()*60*1000)+(currentDate.getSeconds()*1000)+currentDate.getMilliseconds();
	  charCount++;
                     }
            
            if(k===49||k===50||k===51||k===52||k===53||k===54)
            {
                kcode[i]=1;
                
            }    
           else if(k===55||k===56||k===57||k===48)
            {
                kcode[i]=2;
                
            }
            else if(k===113||k===119||k===101||k===114||k===116)
            {
                kcode[i]=3;
                
            }
            else if(k===121||k===117||k===105||k===111||k===112)
            {
                kcode[i]=4;
                
            }
            else if(k===97||k===115||k===100||k===102||k===103)
            {
                kcode[i]=5;
                
            }
            else if(k===104||k===106||k===107||k===108||k===59)
            {
                kcode[i]=6;
                
            }
            else if(k===122||k===120||k===99||k===118)
            {
                kcode[i]=7;
                
            }
            else if(k===98||k===110||k===109||k===44||k===46)
            {
                kcode[i]=8;
                
            }
            else
            {
                kcode[i]=9;
                
            }
            i++;
        }
        function updatecode()
        {
            s=kcode.join();
            var x=document.getElementById("keycode");
            x.value=s;
            
            e=times.join();
            var m=document.getElementById("diff");
            m.value=e;
            
        }
        
function validateForm()
{
    if(document.comp.mail.value==="")
    {
      alert("No Text in Mail");
      document.comp.mail.focus();
      return false;
    }
    else if(document.comp.to.value==="")
    {
      alert("No recipients");
      document.comp.to.focus();
      return false;
    }
}
function doSubmit()  
{  
location.href="index.jsp"; 
}  
  
  
</script> 
<%
    if ((session.getAttribute("uname") == null) || (session.getAttribute("uname") == "")) {
        response.sendRedirect("disclaimer.jsp");
    }
%>

</head>
  <body>
      <form method="post" action="composeSaveToDB">
          <table style=" text-align: left">
              

<tr> <td>    <label style="color :#C4C3C3" for="to">To: </label>
    <td><input size="50" type="text" name="to" id="to">
  
  <tr> <td>  <label style="color :#C4C3C3" for="cc">Cc: </label>
    <td><input size="50" type="text" name="cc" id="cc">
    
 <tr> <td> <label style="color :#C4C3C3" for="bcc">Bcc: </label>
    <td> <input type="text" size="50" name="bcc" id="bcc">
 <tr> <td>   <label style="color :#C4C3C3" for="subject">Subject: </label>
    <td> <input type="text" size="50" name="subject" id="subject">
  <tr> <td>  <label style="color :#C4C3C3 " for="mail"> Mail:</label>
      <td class="textarea">  <textarea rows="20" cols="100" name="mail"  id="mail" onkeypress="retcode(event)"></textarea>
   </table>             
          
            <br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input type="submit" name="send" id="send" value="send" onclick="updatecode()" >
             <input type="text" name="keycode" id="keycode">
          <input type="text" name="diff" id="diff">
      </form> 
      
</body>
</html>

