package eiar;
import java.sql.*;
import java.time.LocalDate;
/**
 * <b>Currently used mostly for testing</b>
 */
public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws SQLException {
		GUI prozor = new GUI();
		/*
		DB_Connect db_object = new DB_Connect();
		LocalDate birth = LocalDate.of(1999, 4, 14);
		Time start = new Time(8,0,0);
		Time end = new Time(12,0,0);
		//db_object.Create_User("Dzhon", "Cena", birth , "Labin", "Ulica 9", "nesto@nesto.nesto", "988", "0988", "Neplaceni freelancer", start, end, "Vlasnik");
		ResultSet rs = db_object.Fetch_table_data("zaposlenici", 11, "id");
		while (rs.next()) {
		     System.out.println(rs.getInt("id") +  "\t" + 
		                        rs.getString("ime") + " " + rs.getString("prezime") + " " + rs.getString("radno_vrijeme_end"));
		}
		
		String[] str = new String[5];

		str[0] = new String("ime");
		str[1] = new String("prezime");
		str[2] = new String("radno_vrijeme_start");
		str[3] = new String("radno_vrijeme_end");
		str[4] = new String("OIB");
		
		
		Object[] arr = new Object[5];

		arr[0] = new String("Novi");
		arr[1] = new String("Juzer");
		arr[2] = new Time(14,45,22);
		arr[3] = new Time(14,30,59);
		arr[4] = new String("515380085");
		*/
		//db_object.Update_table_data(str, arr, "zaposlenici", 11);
		//db_object.Insert_table_data(str, arr, "zaposlenici", 11);
		
		/*ResultSet rs_del = db_object.Delete_table_data("zaposlenici", 10);
		while (rs_del.next()) {
		     System.out.println("Deleted user: " + rs_del.getInt("id") + " " + rs_del.getString("ime") + " " + rs_del.getString("prezime"));
		}*/
		
	}
}
