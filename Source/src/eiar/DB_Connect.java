package eiar;

import java.sql.*;
import java.time.LocalDate;
/** Used for handling Database operations
 */
public class DB_Connect {
	/**
	 * Method establishes connection to the DB via jdbc driver
	 * @return returns connection object
	 */
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
    /**
     * Inserts data into database table depending on received parameters
     * <br><b>Note:</b> attributes length must match data length otherwise no data will be inserted due to mismatch
     * @param attributes represents column names found in given table
     * @param data data that needs to be inserted is passed via this variable
     * @param table_name table into which the data will be inserted
     * @param data_id currently unused
     */
	public void Insert_table_data(String[] attributes, Object[] data, String table_name, int data_id)
	{
		StringBuilder str = new StringBuilder();
		if(attributes.length == data.length) {	// Build INSERTION string
			str.append("'" + table_name + "' (");
			for(int i = 0; i < attributes.length;i++) {	// Building column names into a workable sql
				str.append("'" + attributes[i] + "'");
				if(i<attributes.length-1) {
					str.append(", ");
				}
			}
			str.append(") VALUES (");
			for(int i = 0; i < data.length;i++) {	// Building values into a workable sql
				str.append("'" + data[i] + "'");
				if(i<data.length-1) {
					str.append(", ");
				}
			}
			str.append(")");
		}
		else {
			System.out.println("Nesukladne kolicine podataka");	// In case of array size missmatch print error
			return;
		}
		
		String sql = "INSERT INTO " + str.toString();
		System.out.println(sql);
		
		Connection conn = this.connect();
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Fetches data based on given parameters
	 * @param table_name table from which the data will be fetched
	 * @param data_id entity which id we want to grab
	 * @return resultset querry is returned which can then be used to access fetched data
	 */
	public ResultSet Fetch_table_data(String table_name, int data_id){
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
	
	public ResultSet Fetch_table_data(String table_name){
		String sql = "SELECT * FROM '" + table_name;
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
	
	/**
	 * Delete data based on given parameters
	 * @param table_name table from which the data will be deleted
	 * @param data_id entity which id we want to delete
	 * @return resultset querry is returned which can then be used to review deleted data
	 */
	public ResultSet Delete_table_data(String table_name, int data_id){	// Delete entry from table | Send back ResultSet with deleted table info
		String sql_delete = "DELETE FROM '" + table_name + "' WHERE id = '" + data_id + "'";
		String sql_select = "SELECT * FROM '" + table_name + "' WHERE id = '" + data_id + "'";
		Connection conn = this.connect();
		Statement stmt_sel, stmt_del;	// Create 2 separate statements for deletion & selection
		ResultSet rs = null;
		try {
			stmt_sel = conn.createStatement();
			stmt_del = conn.createStatement();
			rs = stmt_sel.executeQuery(sql_select);
			stmt_del.executeUpdate(sql_delete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;	// Return ResultSet data for confirmation
	}

    /**
     * Changes data from database table depending on received parameters
     * <br><b>Note:</b> attributes length must match data length otherwise no data will be inserted due to mismatch
     * @param attributes represents column names which need to be changed
     * @param data data that needs to be updated is passed via this variable
     * @param table_name table from which the data will be updated
     * @param data_id entity id which we want to change
     */
	public void Update_table_data(String[] attributes, Object[] data, String table_name, int data_id) {	// Update table entry based on atributes and data
		StringBuilder str = new StringBuilder();
		if(attributes.length == data.length) {	// Build SET part of sql string
			for(int i = 0; i < attributes.length;i++) {
				str.append("'" + attributes[i] + "' = '" + data[i] + "' ");
				if(i<attributes.length-1) {
					str.append(", ");
				}
			}
			System.out.println(str.toString());
		}
		else {
			System.out.println("Nesukladne kolicine podataka");	// In case of array missmatch print error
		}
		
		String sql = "UPDATE '" + table_name + "' SET " + str.toString() + "WHERE id ='" + data_id + "'";	
		
		Connection conn = this.connect();
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}