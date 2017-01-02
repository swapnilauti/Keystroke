/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import keystrokePackage.ComposeAlgorithm;
import keystrokePackage.KeyRecord;
import keystrokePackage.UserObject;

/**
 *
 * @author mehul
 */
@WebServlet(urlPatterns = {"/composeSaveToDB"})
public class composeSaveToDB extends HttpServlet {

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
            out.println("<title>Servlet composeSaveToDB</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet composeSaveToDB at " + request.getContextPath() + "</h1>");
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
    String t=request.getParameter("to");
    String cc=request.getParameter("cc");
    String subject=request.getParameter("subject");
    String content=request.getParameter("mail");
    String keycode=request.getParameter("keycode");
    String diff=request.getParameter("diff");
    String[] convert =diff.split(",");
    String[] convkcode =keycode.split(",");
       boolean b;
    double[] result = new double[convert.length];
    for (int i = 0; i < convert.length; i++) {
    try {
        result[i] = Double.parseDouble(convert[i]);
        }catch (NumberFormatException nfe) {}
    }
    
    int[] kcode = new int[convkcode.length];
    for (int i = 0; i < convkcode.length; i++) {
    try {
        kcode[i] = Integer.parseInt(convkcode[i]);
    }catch (NumberFormatException nfe) {}
    }
    Date now = new Date();
    String pattern = "yyyy-MM-dd";
    SimpleDateFormat formatter = new SimpleDateFormat(pattern);
    String mysqlDateString = formatter.format(now);
    System.out.println("Java's Default Date Format: " + now);
    System.out.println("Mysql's Default Date Format: " + mysqlDateString);
    HttpSession session = request.getSession(true);
    String temp=new String((String) session.getAttribute("uname"));
    
     try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StoreRec.class.getName()).log(Level.SEVERE, null, ex);
        }
    //java.sql.Connection con = null;

        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/members", "root", "123456");
            java.sql.Statement st = con.createStatement();
            java.sql.ResultSet rs;
            rs = st.executeQuery("select * from keystroke where username=('" + temp + "')");
            if (rs.next()) {
                ByteArrayInputStream bais;
                ObjectInputStream ins;
                try {

                    bais = new ByteArrayInputStream(rs.getBytes(8));
                    ins = new ObjectInputStream(bais);

                    UserObject O = (UserObject) ins.readObject();
                    ComposeAlgorithm c=new ComposeAlgorithm();
                 
                    b = c.Validate(result, kcode, result.length, O);
                    if(b==false)
                    {
                        response.sendRedirect("compose.jsp");
                    }
                    else
                    {
                        int i = st.executeUpdate("insert into mailbox(`date`,`from`,`to`,cc,subject,content,flag) values ('" + mysqlDateString + "','" + session.getAttribute("uname") + "','" + t + "','" + cc + "','"+ subject + "','" + content + "',1)");
    
    if(i>0) {
        response.sendRedirect("home.jsp");
    }
    else
    {
        response.sendRedirect("compose.jsp");
   
    }
                    }
                    /*ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    ObjectOutputStream oos = new ObjectOutputStream(bos);

                    oos.writeObject(O);
                    oos.flush();
                    oos.close();
                    bos.close();
                    byte[] data = bos.toByteArray();

                    PreparedStatement ps=con.prepareStatement("UPDATE keystroke SET Composekey = ? where username='"+temp+"'");
                    ps.setObject(1,data);
        
                    int r = ps.executeUpdate();
                    
                    */
                                        
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                /* String s;
                 s =rs.getString(2);
                 out.println(s);*/
            }
/*            else
            {
                          
                response.sendRedirect("disclaimer.jsp"); 
            }*/

        }
        catch (Exception e) {
                    e.printStackTrace();
                }
        }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */

}

