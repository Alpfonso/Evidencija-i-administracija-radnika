package eiar;

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

	public String Dohvati_izvjesce (Financijska_izvjesca izvjesce, String nastavak) {
		
		return izvjesce.getIzvjesce();
	}
	
}
