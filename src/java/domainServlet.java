/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gazda
 */
@WebServlet(urlPatterns = {"/domainServlet"})
public class domainServlet extends HttpServlet {

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
            out.println("<title>Domain adatok lekérdezése</title>");
            String cssLocation = request.getContextPath() + "/css.css";
            String cssTag = "<link rel='stylesheet' type='text/css' href='" + cssLocation + "'>";
            //out.println("<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>first.css'>");

            out.println(cssTag);

//           out.println("hello");
            out.println("</head>");
            out.println("<body>");
//            out.println("<h1>Servlet lekerdez at " + request.getContextPath() + "</h1>");
            out.println(lek());
            out.println("</body>");
            out.println("</html>");
        }
    }

    String beoszt(String z) {
        String g = "";
        if (z.equals("0")) {
            g = "<td>Főnök</td>";
        }
//        else if (!z.equals("1"))g="<td>Beosztott</td>";
//        else if (!z.equals("1")&& !z.equals("1"))"<td>Hibás adat</td>";
//        else if(!z.equals("1") && (!z.equals("0"))) g="<td>Hibás adat</td>";
        return g;
    }

    String lek() {
        String g = "";
        String z = "";
        ResultSet rs;
        indit in = new indit();
        in.startConnection("farkas");
        try {
            rs = in.leker("select nev,ipcim,fiz_szorzo*alapfiz,beosztas from domain inner join beosztas on domain.d_id = beosztas.d_id where beosztas=\"0\"", 0);
//      rs.next();

            g += "<table class=\"blueTable\">\n"
                    + "<thead>\n"
                    + "<tr>\n"
                    + //"<th>ID</th>\n" +
                    "<th>Név</th>\n"
                    + //"<th>emil</th>\n" +
                    "<th>ipcim</th>\n"
                    + "<th>Fizetés</th>\n"
                    + "<th>Beosztas</th>\n"
                    + "</tr>\n"
                    + "</thead><tbody>\n";
//"<table>";
            while (rs.next()) {
                g += "<tr>"
                        + "<td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3) + "</td>" + beoszt(rs.getString(4)) + "</tr>";
            }
//g+="<p>kaja</p>";
            g += "</tbody></table>";

//        z=rs.getString(1)+rs.getString(2)+rs.getString(3);
        } catch (SQLException ex) {
            Logger.getLogger(domainServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
