package eiar;
import java.sql.*;
import java.time.LocalDate;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws SQLException {
		GUI.basic_display();
		
		DB_Connect db_object = new DB_Connect();
		LocalDate birth = LocalDate.of(1999, 4, 14);
		Time start = new Time(8,0,0);
		Time end = new Time(12,0,0);
		//db_object.Create_User("Dzhon", "Cena", birth , "Labin", "Ulica 9", "nesto@nesto.nesto", "988", "0988", "Neplaceni freelancer", start, end, "Vlasnik");
		ResultSet rs = db_object.Fetch_Table_Data("zaposlenici", 7);
		
		while (rs.next()) {
		     System.out.println(rs.getInt("id") +  "\t" + 
		                        rs.getString("ime") + " " + rs.getString("prezime") + " " + rs.getString("radno_vrijeme_end"));
		}

	}
}
