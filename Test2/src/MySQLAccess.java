//STEP 1. Import required packages
import java.sql.*;

public class MySQLAccess {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/datavisualisatie";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      System.out.println("creating statement...");
      stmt = conn.createStatement();
      
      String sql = "SELECT Omschrijving, Straat, Thv, XCoord, YCoord, Deelgem, Mutdatum FROM datavisualisatie.fietstrommels";
      ResultSet rs = stmt.executeQuery(sql);
      while(rs.next()){
    	  String Omschrijving = rs.getString("Omschrijving");
    	  String Straat = rs.getString("Straat");
    	  int Thv = rs.getInt("Thv");
    	  String XCoord = rs.getString("Xcoord");
    	  String YCoord = rs.getString("Ycoord");
    	  String Deelgem = rs.getString("Deelgem");
    	  String Mutdatum = rs.getString("Mutdatum");
    	  
    	  System.out.print("omschrijving: " + Omschrijving);
    	  System.out.print(", Straat: " + Straat);
    	  System.out.print(", Thv: " + Thv);
    	  System.out.print(", Xcoord: " + XCoord);
    	  System.out.print(", Ycoord: " + YCoord);
    	  System.out.print(", Deelgem: " + Deelgem);
    	  System.out.println(", Mutdatum: " + Mutdatum);
      }
      rs.close();
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample