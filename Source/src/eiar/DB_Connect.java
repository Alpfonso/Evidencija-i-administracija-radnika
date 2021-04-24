package eiar;

import java.sql.*;

public class DB_Connect {
  public static void main( String args[] ) {
      Connection con = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         con = DriverManager.getConnection("jdbc:sqlite:../Database/EIAR_DB.db");
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Opened database successfully");
   }
}