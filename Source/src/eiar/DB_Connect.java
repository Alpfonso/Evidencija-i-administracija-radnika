package eiar;

import java.sql.*;
import java.time.LocalDate;

public class DB_Connect {
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:../Database/EIAR_DB.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
	public void Create_User(String ime, String prezime, LocalDate datum_rodenja, String grad_stanovanja, String ulica_i_broj, String email, String OIB, 
			String telefon, String obrazovanje, Time radno_vrijeme_start, Time radno_vrijeme_end, String razina_ovlasti){
	      	Connection con = null;
	      	Statement stmt = null;
	      
	      	try {
	      		Class.forName("org.sqlite.JDBC");
	      		// Establish connection to DB via jdbc driver
	      		con = DriverManager.getConnection("jdbc:sqlite:../Database/EIAR_DB.db");
	      		con.setAutoCommit(false);
	      		System.out.println("Opened database successfully");
	      		
	      		// stmt obj used to execute SQL statements
	      		stmt = con.createStatement();
	      		String sql = "INSERT INTO zaposlenici('ime', 'prezime', 'datum_rodenja', 'grad_stanovanja', 'ulica_i_broj', 'email',"
	      				+ " 'OIB', 'telefon', 'obrazovanje', 'razina_ovlasti', 'radno_vrijeme_start', 'radno_vrijeme_end') VALUES "
	      				+ "('" + ime + "','" + prezime + "','" + datum_rodenja + "','" + grad_stanovanja + "','" + ulica_i_broj + "','" + email
	      				+ "','" + OIB + "','" + telefon + "','" + obrazovanje + "','" + razina_ovlasti + "','" + radno_vrijeme_start + "','" + 
	      				radno_vrijeme_end + "')";
	      		stmt.executeUpdate(sql);
	      		stmt.close();
	            con.commit();
	            con.close();
	      	} catch ( Exception e ) {
	      		System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      		System.exit(0);
	      	}
	      	System.out.println("User record created");
	}
	
	public ResultSet Fetch_Table_Data(String table_name, int data_id){
		String sql = "SELECT * FROM '" + table_name + "' WHERE id = '" + data_id + "'";
		Connection conn = this.connect();
		Statement stmt;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return rs;
	}
}