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
    
	public void Insert_table_data(String[] atributes, Object[] data, String table_name, int data_id)
	{
		StringBuilder str = new StringBuilder();
		if(atributes.length == data.length) {	// Build INSERTION string
			str.append("'" + table_name + "' (");
			for(int i = 0; i < atributes.length;i++) {	// Building column names into a workable sql
				str.append("'" + atributes[i] + "'");
				if(i<atributes.length-1) {
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
	
	public void Update_table_data(String[] atributes, Object[] data, String table_name, int data_id) {	// Update table entry based on atributes and data
		StringBuilder str = new StringBuilder();
		if(atributes.length == data.length) {	// Build SET part of sql string
			for(int i = 0; i < atributes.length;i++) {
				str.append("'" + atributes[i] + "' = '" + data[i] + "' ");
				if(i<atributes.length-1) {
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