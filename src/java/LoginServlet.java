/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gazda
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    String felhasznaloka;

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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //request.getRequestDispatcher("index.html").include(request, response);  
        HttpSession session = request.getSession(true);
        String user = request.getParameter("felh_nev");
        String password = request.getParameter("jelszo");
        RequestDispatcher dispatcher;
            
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webshop_db", "root", "");
            PreparedStatement pst = conn.prepareStatement("Select felh_nev,jelszo from felhasznalok where felh_nev=? and jelszo=?");
                pst.setString(1, user);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
        
            if (AuthHelper.isAllowedP(user, password)) {
                session.setAttribute("user", user);
                dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
                
            } 
            else if(rs.next()){
                session.setAttribute("user", user);
                dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
            else {

                request.getRequestDispatcher("index.jsp").include(request, response);
                out.println("Rossz adatokat adott meg!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                out.close();
        }
        

        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
