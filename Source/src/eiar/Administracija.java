package eiar;

import java.sql.ResultSet;
import java.util.Date;

/**
 * WIP - planed responsibility setting up superiors
 * 
 *
 */
public class Administracija extends Radnik {

	public Administracija(String ime, String prez, Date dat, String g_s, String u_s, String email, int OIB, String tele,
			String obrazovanje, String razina_ovlasti, Date r_v_p, Date r_v_k, int s_d) {
		super(ime, prez, dat, g_s, u_s, email, OIB, tele, obrazovanje, razina_ovlasti, r_v_p, r_v_k, s_d);
		// TODO Auto-generated constructor stub
	}

	public void Postavi_nadredenog (Radnik radnik, String razina_ovlasti) {
		
		String[] atributi = new String[1];
		atributi[0] = new String("razina_ovlasti");
		
		Object[] objekt = new Object[1];
		objekt[0] = new String("nadredeni");
		
		DB_Connect db_object = new DB_Connect();
		
		db_object.Update_table_data(atributi, objekt, "zaposlenici", radnik.getId());
	}
	
	public void Dohvati_anketu (int id_ankete) {
		
		DB_Connect db_object = new DB_Connect();
		
		db_object.Fetch_table_data("ankete", id_ankete);
	}
	
	public String Dohvati_izvjesce (Financijska_izvjesca izvjesce, String format) {
		
		return izvjesce.getIzvjesce();
	}
}
