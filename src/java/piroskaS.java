/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = {"/piroskaS"})
public class piroskaS extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            request.setCharacterEncoding("UTF-8");
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Adatok felvitele</title>"); 
           String cssLocation = request.getContextPath() + "/css.css";
           String cssTag = "<link rel='stylesheet' type='text/css' href='" + cssLocation + "'>";
           //out.println("<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>first.css'>");
           out.println(cssTag);
           out.println("</head>");
            out.println("<body>");
            out.print(fv());
            out.println("</body>");
            out.println("</html>");      
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
         response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        request.getRequestDispatcher("index.html").include(request, response);  
          
        HttpSession session=request.getSession(false);  
        
        if(session!=null){ 
            
              String name=(String)session.getAttribute("name");  
            out.print("Hello, "+name+" Welcome to Profile"); 
            }
            else{  
            out.print("Please login first"); 
            session.invalidate();
            //request.getRequestDispatcher("index.jsp").include(request, response);  
              //response.sendRedirect("index.jsp");
            
          
        
        }  
        
       
        out.close();  
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
        processRequest(request, response);
  
    }
    
    String fv(){
        
        String g="";
        
        g="<div class=\"topnav\" id=\"myTopnav\">\n" +
"  <a href=\"index.html\"style=\"float: right\">Kilépés</a>\n" +
"  <a href=\"insertServlet\">Adatok feltöltése</a>\n" +
//"  <a href=\"updateServlet\">Adatok modosítása</a>\n" +
//"  <a href=\"deleteServlet\">Adatok törlése</a>\n" +
//"  <a href=\"ingreg\">Ingatlan felvitele</a>\n" +
//"  <a href=\"fajlfel\">Kép feltöltése</a>\n" +
"  \n" +
"  \n" +
"</div>";
        
        
        return g;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
