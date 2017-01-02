
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    
    <head>
         <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Registration Form-Training</title>
  <link rel="stylesheet" href="style.css">
    
    <script>
         var charCount = 0;
         var chCount = 0;
  var times = [];
  var time2 = [];
  var diff=[];
  var kcode= [];
  var j=0;
  var i=0;
  var xyz=new String();
  var s=new String();
  var e=new String();
        
      function retcode(et)
        {
            var k=et.keyCode;
           
           if(k!==13){
            var currentDate = new Date();
	  time2[chCount] = (currentDate.getHours()*60*60*1000)+(currentDate.getMinutes()*60*1000)+(currentDate.getSeconds()*1000)+currentDate.getMilliseconds();
	  chCount++;
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
    
    
      function keyUp(){
            var currentDate = new Date();
	  times[charCount] = (currentDate.getHours()*60*60*1000)+(currentDate.getMinutes()*60*1000)+(currentDate.getSeconds()*1000)+currentDate.getMilliseconds();
	  charCount++;
       }    
            
      function addvalue1(){
       var b = document.getElementById("nameErr");
       var x=document.getElementById('try1');
       var z=document.getElementById('check');
       if(x.value=== z.value)
       {
           b.innerHTML = "";
       calDiff();
       var ch = document.getElementById('hide1'); 
       ch.value = xyz;
       reset();
       return true;  
       }
       reset();
       x.value="";
       document.passfrm.try1.focus();
       var b = document.getElementById("nameErr");
       b.innerHTML = "Wrong Password";
      return false;
       
      }
      function addvalue2(){
       var b = document.getElementById("nameErr2");
       var x=document.getElementById('try2');
       var z=document.getElementById('check');
       if(x.value===z.value)
       {
            b.innerHTML = "";
            calDiff();
            var ch = document.getElementById('hide2'); 
            ch.value = xyz;
         reset();
            return true;  
       }
       reset();
       x.value="";
       document.passfrm.try2.focus();
       var b = document.getElementById("nameErr2");
       b.innerHTML = "Wrong Password";
       return false;
      }  
      function addvalue3(){
       var b = document.getElementById("nameErr3");
       var x=document.getElementById('try3');
       var z=document.getElementById('check');
       if(x.value=== z.value)
       {
            b.innerHTML = "";
            calDiff();
            var ch = document.getElementById('hide3'); 
            ch.value = xyz;
            //   ch.value=times;
         reset();
            return true;  
       }
       reset();
       x.value="";
       document.passfrm.try3.focus();
       var b = document.getElementById("nameErr3");
       b.innerHTML = "Wrong Password";
       return false;
      }  
      function addvalue4(){
       var b = document.getElementById("nameErr4");
       var x=document.getElementById('try4');
       var z=document.getElementById('check');
       if(x.value=== z.value)
       {
            b.innerHTML = "";
            calDiff();
            var ch = document.getElementById('hide4'); 
            ch.value = xyz;
            // ch.value=times;
           reset();
            return true;  
       }
       reset();
       x.value="";
       document.passfrm.try4.focus();
       var b = document.getElementById("nameErr4");
       b.innerHTML = "Wrong Password";
       return false;
      }  
      function addvalue5(){
       var b = document.getElementById("nameErr5");
       var x=document.getElementById('try5');
       var z=document.getElementById('check');
       if(x.value=== z.value)
       {
            b.innerHTML = "";
            calDiff();
            var ch = document.getElementById('hide5'); 
            ch.value = xyz;
            //ch.value=times;
            reset();
            return true;  
       }
       reset();
       x.value="";
       document.passfrm.try5.focus();
       var b = document.getElementById("nameErr5");
       b.innerHTML = "Wrong Password";
       return false;
      } 

    function reset()
    {
       // for(var i=0;i<charCount;i++)
       
           times=[];
       charCount=0;
    }
    
    function reset1(){
        
           times=[];
       charCount=0;
        
    }
    function calDiff()
    {
      
                
        for(var r=1;r<times.length;r++)
            diff[r-1]=times[r]-times[r-1];
        xyz=diff.join();
        
        
        
    }
    function parasend()
    {
        s=kcode.join();
            var xy=document.getElementById("keycode");
            xy.value=s;
            
            e=time2.join();
            var m=document.getElementById("diff");
            m.value=e;
    }
        /*function buttonPressed(){
      for(var i=1;i<times.length;i++)
      {
          if(i%(len)!=0)
          {
            diff[i-j-1]=times[i]-times[i-1];
              
          }
          else
          {
           j++;
          }
      
      }
     
     k=diff.join();    
var tbox = document.getElementById('a_tbox'); 
                tbox.value = k;
  }*/   
    function formchk()
    {
        if(document.passfrm.try1.value===""||document.passfrm.try2.value===""||document.passfrm.try3.value===""||document.passfrm.try4.value===""||document.passfrm.try5.value==="")
        {
            alert("No field should be left blank!");
            return false;
        }
        return true;         
        
    }
    
    </script>    
    </head>
    <body>
     <div class="container">
    <section class="register">   
        <form name="passfrm" method="post" onsubmit="parasend()" action="StoreRec">
    <p>
    <label>Enter password for 5 times</label>
    </p>
    <p>
    <input type="password" name="try1" id="try1" onkeypress="keyUp()" onkeyup="var vl=event.keyCode;if(vl===8){reset1();try1.value='';document.passfrm.try1.focus();}" onblur="return addvalue1()">
    <span id="nameErr"></span><br>
    </p> 
     <p>
    <input type="password" name="try2" id="try2" onkeypress="keyUp()" onkeyup="var vl=event.keyCode;if(vl===8){reset1();try2.value='';document.passfrm.try2.focus();}" onblur="return addvalue2()">
    <span id="nameErr2"></span><br>
     </p>
     <p>
    <input type="password" name="try3" id="try3" onkeypress="keyUp()" onkeyup="var vl=event.keyCode;if(vl===8){reset1();try3.value='';document.passfrm.try3.focus();}" onblur="return addvalue3()">
    <span id="nameErr3"></span><br>
    </p>
    <p>
    <input type="password" name="try4" id="try4" onkeypress="keyUp()" onkeyup="var vl=event.keyCode;if(vl===8){reset1();try4.value='';document.passfrm.try4.focus();}" onblur="return addvalue4()">
    
    <span id="nameErr4"></span><br>
    </p>
    <p>
    <input type="password" name="try5" id="try5" onkeypress="keyUp()" onkeyup="var vl=event.keyCode;if(vl===8){reset1();try5.value='';document.passfrm.try5.focus();}" onblur="return addvalue5()">
    <span id="nameErr5"></span><br>
    </p>
     <input type="hidden" id="check" name="check" value='<%=request.getParameter("password") %>' />
    <input type="hidden" id="hide1" name="hide1" />
    <input type="hidden" id="hide2" name="hide2" />
    <input type="hidden" id="hide3" name="hide3" />
    <input type="hidden" id="hide4" name="hide4" />
    <input type="hidden" id="hide5" name="hide5" />
    
    <input type="hidden" id="hide6" name="hide6" value="<%=request.getParameter("name")%>" />
    <input type="hidden" id="hide7" name="hide7" value="<%=request.getParameter("tel")%>"/>
    <input type="hidden" id="hide8" name="hide8" value="<%=request.getParameter("email")%>"/>
    <input type="hidden" id="hide9" name="hide9" value="<%=request.getParameter("password")%>"/>
     <input type="hidden" id="hide10" name="hide10" value="<%=request.getParameter("nation")%>"/>
     <%
     
      if(request.getParameter("sec")!="")
      {
      
      
 %>
     Passage:
     Once there was a boy, who listened to a wise old man, and thus began to learn about the present. 
     The old man and the boy had known each other for more than a year, and enjoyed talking together. 
     The boy lived at 104r street.
     
     <textarea name="trainpara" placeholder="Type the above Passage:" onkeypress="retcode(event)" > </textarea>
     <%
      }
     %>
     <input type="text" name="keycode" id="keycode">
          <input type="text" name="diff" id="diff">
     <input type="submit" onclick="return formchk()">
     </form>
    </section>
     </div>
      </body>
</html>
