/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import keystrokePackage.*;
/**
 *
 * @author mehul
 */
@WebServlet(urlPatterns = {"/StoreRec"})
public class StoreRec extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StoreRec</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StoreRec at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out = response.getWriter();
        String pass1 = request.getParameter("hide1");    
    String pass2 = request.getParameter("hide2");
    String pass3 = request.getParameter("hide3");
    String pass4 = request.getParameter("hide4");
    String pass5 = request.getParameter("hide5");
   
    String name= request.getParameter("hide6");
    String tel=request.getParameter("hide7");
    String email=request.getParameter("hide8");
    String password=request.getParameter("hide9");
    String nation= request.getParameter("hide10");
    
      String keycode= request.getParameter("keycode");
      String diff= request.getParameter("diff");
      String[] keycodesplit =keycode.split(",");
      String[] diffsplit =diff.split(",");
      int[] finkeycode = new int[keycodesplit.length];
      double[] findiff = new double[diffsplit.length];
      for (int i = 0; i < keycodesplit.length; i++) {
    try {
        finkeycode[i] = Integer.parseInt(keycodesplit[i]);
    }catch (NumberFormatException nfe) {}
    }
      
     for (int i = 0; i < diffsplit.length; i++) {
    try {
        findiff[i] = Double.parseDouble(diffsplit[i]);
    }catch (NumberFormatException nfe) {}
    }
     for(int i=0;i<finkeycode.length;i++)                                         //printing finkeycode                                  
         System.out.println(finkeycode[i]);
      
    String[] conv1 =pass1.split(",");
    String[] conv2=pass2.split(",");
    String[] conv3 =pass3.split(",");
    String[] conv4 =pass4.split(",");
    String[] conv5 =pass5.split(",");
    int[] result1 = new int[conv1.length];
    int[] result2 = new int[conv2.length];
    int[] result3 = new int[conv3.length];
    int[] result4 = new int[conv4.length];
    int[] result5 = new int[conv5.length];
    for (int i = 0; i < conv1.length; i++) {
    try {
        result1[i] = Integer.parseInt(conv1[i]);
    }catch (NumberFormatException nfe) {}
    }
    for(int i=0;i<conv1.length; i++)                                            //printing resultarray
        System.out.print("result1"+result1[i]+" ");
    System.out.println("");
    for (int i = 0; i < conv2.length; i++) {
    try {
        result2[i] = Integer.parseInt(conv2[i]);
    }catch (NumberFormatException nfe) {}
    }
    for(int i=0;i<conv2.length; i++)
System.out.print("result2"+result2[i]+" ");
System.out.println("");
      
    for (int i = 0; i < conv3.length; i++) {
    try {
        result3[i] = Integer.parseInt(conv3[i]);
    }catch (NumberFormatException nfe) {}
    }
    for(int i=0;i<conv3.length; i++)
System.out.print("result3"+result3[i]+" ");
System.out.println("");
      
    for (int i = 0; i < conv4.length; i++) {
    try {
        result4[i] = Integer.parseInt(conv4[i]);
    }catch (NumberFormatException nfe) {}
    }
    for(int i=0;i<conv4.length; i++)
System.out.print(result4[i]+" ");
System.out.println("");
      
    for (int i = 0; i < conv5.length; i++) {
    try {
        result5[i] = Integer.parseInt(conv5[i]);
    }catch (NumberFormatException nfe) {}
    }
    for(int i=0;i<conv5.length; i++)
System.out.print(result5[i]+" ");
System.out.println("");
int arr[][]={result1,result2,result3,result4,result5};
KeyRecord r=new KeyRecord(result1.length);
PasswordAlgorithm p;
        p = new PasswordAlgorithm();
r=p.Create(r,arr,5);

      
    
  //  String userid = request.getParameter("uname");    
    //String pwd = request.getParameter("pass");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StoreRec.class.getName()).log(Level.SEVERE, null, ex);
        }
    //java.sql.Connection con = null;
        try {
           java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/members","root", "123456");
           java.sql.Statement st = con.createStatement();
           
           int i = st.executeUpdate("insert into keystroke(username,email,contact,password,nation) values ('" + name + "','" + email + "','" + tel + "','" + password + "','"+nation+"')");
           ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(r);
        oos.flush();
        oos.close();
        bos.close();
        byte[] data = bos.toByteArray();

        UserObject O=new UserObject();
        ComposeAlgorithm a= new ComposeAlgorithm();
        O=a.updatel(findiff, finkeycode, findiff.length, O);
        
        ByteArrayOutputStream bos1 = new ByteArrayOutputStream();
        ObjectOutputStream oos1 = new ObjectOutputStream(bos1);

        oos1.writeObject(O);
        oos1.flush();
        oos1.close();
        bos1.close();

        byte[] data1 = bos1.toByteArray();
        //out.print(data);
        response.sendRedirect("loginpage.jsp");
       /*    java.sql.Blob blob;
           //blob.setBytes(1,bytes);
           blob = con.createBlob(data);
        */


      // String sql="insert into keystroke(username,email,contact,password,nation,key) values (?)";
       
       
         PreparedStatement ps=con.prepareStatement("UPDATE keystroke SET Passkey = ?,Composekey = ? where username='"+name+"'");
       /* ps.setString(1, name);
        ps.setString(2,email);
        ps.setString(3,tel);
        ps.setString(4,password);
        ps.setString(5,nation);*/
        ps.setObject(1,data);
        ps.setObject(2,data1);
        int result = ps.executeUpdate();
        System.out.println("Result : "+result);
     
        } catch (SQLException ex) {
            Logger.getLogger(StoreRec.class.getName()).log(Level.SEVERE, null, ex);
            
        }//"','" + r + 
    //java.sql.Statement st=null;
     /*   try {
    java.sql.Statement st = con.createStatement();
            int i = st.executeUpdate("insert into keystroke(username,email,contact,password,nation,key) values ('" + name + "','" + email + "','" + tel + "','" + password + "','"+nation+"','" + r + "')");
        } catch (SQLException ex) {
            Logger.getLogger(StoreRec.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    //java.sql.ResultSet rs;
    
   
    
    
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    }
}

