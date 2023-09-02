import java.sql.*;

public class RegistrationForm {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost/yourdatabase";

   static final String USER = "Agent1092";
   static final String PASS = "Pune@3801";

   public static void main(String[] args) {
      Connection conn = null;
      Statement stmt = null;

      try {
         Class.forName(JDBC_DRIVER);

         System.out.println("Connecting to database...");
         conn = DriverManager.getConnection(DB_URL, USER, PASS);

         System.out.println("Creating statement...");
         stmt = conn.createStatement();

         String sql = "INSERT INTO users (first_name, last_name, email) VALUES ('John', 'Doe', 'johndoe@email.com')";
         stmt.executeUpdate(sql);

         System.out.println("Data inserted successfully!");

      } catch(SQLException se) {
         se.printStackTrace();
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if(stmt != null) stmt.close();
         } catch(SQLException se2) {
         }
         try {
            if(conn != null) conn.close();
         } catch(SQLException se) {
            se.printStackTrace();
         }
      }
   }
}