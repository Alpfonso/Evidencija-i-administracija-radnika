package eiar;

import java.util.Date;
/**
 * Human resources
 * <br>Conducts surveys
 */
public class HR extends Administracija {

	public HR(String ime, String prez, Date dat, String g_s, String u_s, String email, int OIB, String tele,
			String obrazovanje, String razina_ovlasti, Date r_v_p, Date r_v_k, int s_d) {
		super(ime, prez, dat, g_s, u_s, email, OIB, tele, obrazovanje, razina_ovlasti, r_v_p, r_v_k, s_d);
		// TODO Auto-generated constructor stub
	}

	
	public Ankete Napravi_anketu (String naziv, String opis, String ime_autora, String sugestija) {
		
		Ankete anketa = new Ankete(naziv, opis, ime_autora, sugestija);
	
		return anketa;
	}
	

	public String Dohvati_anketu (Ankete anketa) {
		
		return anketa.getNaziv();
	}
}
