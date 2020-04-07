/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 *
 * @author gazda
 */
@WebServlet(urlPatterns = {"/felvitelServlet"})
public class felvitelServlet extends HttpServlet {

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
        
        response.setContentType("text/html;charset=UTF-8");
        String a,b,c,d,e,f,g,h,i,name="";
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
            
        if(!request.getParameter("nev").isEmpty())
        {
            a=request.getParameter("nev").toString();
            b=request.getParameter("emil").toString();
            c=request.getParameter("ipcim").toString();
            d=request.getParameter("alapfiz").toString();
            e=request.getParameter("vallalat").toString();
            f=request.getParameter("beosztas").toString();
            g=request.getParameter("telephely").toString();
            h=request.getParameter("fiz_szorzo").toString();
//            i=request.getParameter("iar").toString();
            
            
            felvisz(a,b,c,d,e,f,g,h);
            
        }
           
            out.println("</body>");
            out.println("</html>");
            
            response.sendRedirect("piroskaS?name="+URLEncoder.encode(name,"UTF-8"));
    }
    String kezdolap(){
        String g="";
        
        return g;
    }
void felvisz(String a, String b, String c, String d, String e, String f, String g, String h) {
        try {
            String s = "";
            String y = "";
            ResultSet rs = null;
            String x = "";
            String id,id1;
            indit in = new indit();
            in.startConnection("");
            //byte[] encoded = Base64.encodeBase64(e.getBytes());
            
            x = "insert into domain values(null,'" + a + "','" + b + "','" + c + "','" + d + "');";
            in.leker(x, 1);
            s = "select last_insert_id();";
            rs = in.leker(s, 0);
            rs.next();
            id = rs.getString(1);
           
            y = "insert into beosztas values(null,'" + e + "','" + f + "','" + g + "','" + h + "','"+ id +"');";
            in.leker(y, 1);
//            s = "select last_insert_id();";
//            rs = in.leker(s, 0);
//            rs.next();
//            id1 = rs.getString(1);
            
            
//            x = "insert into ig values(null,'" + e + "','" + f + "','" + g + "','" + h + "','" + i + "','" + j + "','" + k + "','" + l+ "','" + id + "','" + id1 + "');";
//            in.leker(x, 1);
         
            //rs.next();
            //id = rs.getString(1);
            
            
            
            //rs.next();
            //id = rs.getString(1);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(felvitelServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
