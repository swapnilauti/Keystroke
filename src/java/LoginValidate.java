/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import keystrokePackage.KeyRecord;
import keystrokePackage.PasswordAlgorithm;

/**
 *
 * @author mehul
 */
@WebServlet(urlPatterns = {"/LoginValidate"})
public class LoginValidate extends HttpServlet {

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
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
         HttpSession session = request.getSession(true);
        String ptime = request.getParameter("ptime");
        String[] conv1 = ptime.split(",");
        PrintWriter out = response.getWriter();
        double[] result1 = new double[conv1.length];
        for (int i = 0; i < conv1.length; i++) {
            try {
                result1[i] = Double.parseDouble(conv1[i]);
            } catch (NumberFormatException nfe) {
            }
        }
        for (int i = 0; i < conv1.length; i++) {
            out.print(result1[i] + " ");
        }
        out.println("");
        PasswordAlgorithm p = new PasswordAlgorithm();
    //processRequest(request, response);

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
            rs = st.executeQuery("select * from keystroke where username=('" + uname + "') and password=('" + pass + "')");
    // r;

          //
            
            if (rs.next()) {
                ByteArrayInputStream bais;
                ObjectInputStream ins;
                try {

                    bais = new ByteArrayInputStream(rs.getBytes(7));
                    ins = new ObjectInputStream(bais);

                    KeyRecord mc = (KeyRecord) ins.readObject();
                    
                    int x=p.Validate(mc,result1);
                    if(x==0)
                    {
                        response.sendRedirect("loginpage.jsp"); 
                        out.println("fail");
                        
                    }
                    else
                    {
                        session.setAttribute("uname", uname);
                        response.sendRedirect("home.jsp");
                        
                        out.println("success");
                    }
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                /* String s;
                 s =rs.getString(2);
                 out.println(s);*/
            }
            else
            {
                          
                response.sendRedirect("loginpage.jsp"); 
            }

        } catch (SQLException ex) {
            Logger.getLogger(StoreRec.class.getName()).log(Level.SEVERE, null, ex);

        }

            //     if(p.Validate(r,result1))
//    {
//        HttpSession session=request.getSession(true);
//        session.setAttribute("uname",uname);
//    }
//    else
//    {
//        response.sendRedirect("loginpage.jsp");
//    }
    }

}

/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
