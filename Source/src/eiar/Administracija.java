package eiar;

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
		// TODO change authority status within database
	}
	
}
