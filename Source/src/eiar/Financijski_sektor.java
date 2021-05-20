package eiar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
/**
 * Financial sector
 * <br>Provides financial reports
 */
public class Financijski_sektor extends Radnik {

	public Financijski_sektor(String ime, String prez, Date dat, String g_s, String u_s, String email, int OIB,
			String tele, String obrazovanje, String razina_ovlasti, Date r_v_p, Date r_v_k, int s_d) {
		super(ime, prez, dat, g_s, u_s, email, OIB, tele, obrazovanje, razina_ovlasti, r_v_p, r_v_k, s_d);
		// TODO Auto-generated constructor stub
	}

	//public String Dohvati_izvjesce () {
		
		//TO-DO fetch reports
		
	//}
	
	public String Dohvati_izvjesce_po_datumu (Financijska_izvjesca izvjesce, String nastavak, Date vremenski_period) throws SQLException{
		
		DB_Connect db_object = new DB_Connect();
		ResultSet rs = db_object.Fetch_table_data(""); //TO-DO fetch reports
		
		while (rs.next()) {
			this.setIme(rs.getString("ime") + " " + rs.getString("prezime"));// fetches basic data from db to display
		}
		return this.getIme();
	}
}
