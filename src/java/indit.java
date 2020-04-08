
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author szsz
 */

class indit {
    private Connection conn=null;java.sql.Statement stmt = null;
    private boolean connected = false;
    private String error = "";
   public boolean startConnection(String felhasznaloka) {
        
        
       
       String url = "jdbc:mysql://localhost/";
        String dbName = "webshop_db";
        String driver = "com.mysql.jdbc.Driver";
        String user = felhasznaloka;
        String pass = "123456";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/webshop_db", felhasznaloka, pass);

            connected = true;
            return true;

        } catch (Exception e) {
            System.out.println("NO CONNECTION =(" + e + ")");
            System.out.println("Connect.indit.startConnection()");
            error = e.toString();
            connected = false;
            return false;
        }
    }

    public void close() {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Connect.indit.close()");
        }
    }
 public  ResultSet leker(String sql,int a) throws SQLException
 {
     ResultSet rs;
      // create the java statement
         java.sql.Statement st = this.conn.createStatement();
      
      if(a==0){
        rs = st.executeQuery(sql);
        return rs;
      }
      else
         st.executeUpdate(sql);
  return null;
 }
    
}
