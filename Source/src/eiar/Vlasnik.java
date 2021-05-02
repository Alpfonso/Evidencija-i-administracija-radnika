package eiar;

import java.util.Date;
/**
 * Firm owner
 */
public class Vlasnik extends Radnik {
	
	public Vlasnik(String ime, String prez, Date dat, String g_s, String u_s, String email, int OIB, String tele,
            String obrazovanje, String razina_ovlasti, Date r_v_p, Date r_v_k, int s_d) {
        super(ime, prez, dat, g_s, u_s, email, OIB, tele, obrazovanje, razina_ovlasti, r_v_p, r_v_k, s_d);
        // TODO Auto-generated constructor stub
    }
	/**
	 * Grabs project report
	 * @param projekt project name
	 * @return <b>Note: </b> could be an error, should only receive report not return
	 */
	public String Dohvati_izvjesce (Projekt projekt) {
		
		return projekt.getIzvjesce();
	}
	
	

}
