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

	public String Dohvati_izvjesce (Financijska_izvjesca izvjesce) {
		
		return izvjesce.toString();
	}
	
	public String Dohvati_izvjesce_po_datumu (Date start, Date end) throws SQLException {
		
		DB_Connect db_object = new DB_Connect();
		ResultSet rs = db_object.Fetch_table_data("financijska_izvjesca", start, "vrijeme_pocetak AND vrijeme_kraj = " + end); //TO-DO fetch reports
		
		String naziv = new String();
		String opis = new String();
		String ime_autora = new String();
		
		int prihodi = 0;
		int rashodi = 0;
		
		ResultSet rs2 = db_object.Fetch_table_data("zaposlenici", rs.getInt("autor"), "id");
		
		while (rs.next()) {
			
			naziv = rs.getString("ime");
			opis = rs.getString("opis");
			ime_autora = rs2.getString("ime ") + rs2.getString("prezime");
			prihodi = rs.getInt("prihodi");
			rashodi = rs.getInt("rashodi");
			
		}
		
		
		Financijska_izvjesca izvjesce = new Financijska_izvjesca(naziv, opis, ime_autora, prihodi, rashodi, start, "format");
		
		return izvjesce.toString();
	}
	
}
