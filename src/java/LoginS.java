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

/**
 *
 * @author gazda
 */
@WebServlet(urlPatterns = {"/LoginS"})
public class LoginS extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Belépés</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <link href=\"css.css\" rel=\"stylesheet\" type=\"text/css\"/>");
                
            out.println("</head>");
            out.println("<body>");
            out.println(fv());
            out.println("</body>");
            out.println("</html>");
        }
    }
String fv(){
    String g=" <form action=\"LoginServlet\" method=\"POST\">     \n" +
"        <div class=\"container\">\n" +
"            <label><b style=\"font-weight: bold\">Felhasználónév:</b></label>\n" +
"    <input type=\"text\" placeholder=\"Írja be a felhasználónevét !\" name=\"felhnev\" required>\n" +
"\n" +
"    <label><b style=\"font-weight: bold\">Jelszó:</b></label>\n" +
"    <input type=\"password\" placeholder=\"Írja be a jelszavát !\" name=\"passwd\" required>\n" +
"\n" +
"    <button type=\"submit\">Belépés</button>\n" +
"    \n" +
"  </div>\n" +
"\n" +
"  \n" +
"</form>";
    return g;
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
        processRequest(request, response);
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
