/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gazda
 */
@WebServlet(urlPatterns = {"/insertServlet"})
public class insertServlet extends HttpServlet {

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
String fv(){
    String g="";
    g="<div class=\"form-style-3\"><form action='felvitelServlet' method=\"POST\">\n" +
"<fieldset><legend>Adatok felvitele</legend>"+
"<label for=\"nev\"><span>Név <span class=\"required\">*</span></span><input type=\"text\" class=\"input-field\" name=\"nev\" value=\"\" autofocus required title=\"Kérem töltse ki!\" x-moz-errormessage=\"Kérem adja meg a nevét!\" maxlength=\"25\"/></label>\n" +
"<label for=\"emil\"><span>e-mail cím <span class=\"required\">*</span></span><input type=\"text\" class=\"input-field\" name=\"emil\"  value=\"\"   required title=\"Kérem töltse ki!\" x-moz-errormessage=\"Helytelen formátum (hasnzáljon '@'  illetve '.com/hu kiterjesztést' !\" maxlength=\"25\"/></label>\n" +
"<label for=\"ipcim\"><span>IP cim <span class=\"required\">*</span></span><input type=\"text\" required pattern=\"((^|\\.)((25[0-5])|(2[0-4]\\d)|(1\\d\\d)|([1-9]?\\d))){4}$\" class=\"input-field\" name=\"ipcim\" value=\"\" required title=\"Kérem töltse ki!\" x-moz-errormessage=\"Kérem adja meg az IP cimét!!\" maxlength=\"15\"/></label>\n" +
"<label for=\"alapfiz\"><span>Alapfizetés <span class=\"required\">*</span></span><input type=\"text\"  class=\"input-field\" name=\"alapfiz\" value=\"\" required title=\"Kérem töltse ki!\" maxlength=\"30\" x-moz-errormessage=\"Adja meg az alapfizetését!\" /></label>\n" +
"<label for=\"vallalat\"><span>Vállalat neve<span class=\"required\">*</span></span><input type=\"text\" class=\"input-field\" name=\"vallalat\" value=\"\"  required title=\"Kérem töltse ki!\" x-moz-errormessage=\"Adja meg a vállalat nevét!\" maxlength=\"25\"/></label>\n" +
"<label for=\"beosztas\"><span>Beosztas<span class=\"required\">*</span></span><input type=\"text\"  class=\"input-field\" name=\"beosztas\" value=\"\" required title=\"Adja meg a beosztást!\" x-moz-errormessage=\"Kérem töltse ki,csak 0 vagy 1-es értéket adjon!\"/></label>\n" +
"<label for=\"telephely\"><span>Telephely <span class=\"required\">*</span></span><input type=\"text\" class=\"input-field\" name=\"telephely\" value=\"\"  required title=\"Kérem töltse ki!\" x-moz-errormessage=\"Kérem adja meg a telephely cimét !\" maxlength=\"25\"/></label>\n" +
"<label for=\"fiz_szorzo\"><span>Fizetési szorzó<span class=\"required\">*</span></span><input type=\"text\" class=\"input-field\" name=\"fiz_szorzo\" value=\"\"  required title=\"Kérem töltse ki!\" x-moz-errormessage=\"Kérem adja meg a fizetési szorzó értékét!\" maxlength=\"25\"/></label>\n" +            

//"<label for=\"iar\"><span>Irányár<span class=\"required\">*</span></span><input type=\"text\" class=\"input-field\" name=\"iar\" value=\"\"  required title=\"Kérem töltse ki!\" x-moz-errormessage=\"Kérem adjon meg egy irányárat!\" maxlength=\"15\"/></label>\n" +           

            "<label><span>&nbsp;</span><input type='submit' value='Felvitel' /></label>"+

"     </fieldset> </div></form>";
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
