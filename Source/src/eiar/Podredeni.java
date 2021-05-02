package eiar;

import java.util.Date;

public class Podredeni extends Radnik {
	
	
	public Podredeni(String ime, String prez, Date dat, String g_s, String u_s, String email, int OIB, String tele,
			String obrazovanje, String razina_ovlasti, Date r_v_p, Date r_v_k, int s_d) {
		super(ime, prez, dat, g_s, u_s, email, OIB, tele, obrazovanje, razina_ovlasti, r_v_p, r_v_k, s_d);
		// TODO Auto-generated constructor stub
	}
	
	public void napisi_izvjesce (String izvjesce, Zadaci zadatak) {
		//Write report
		zadatak.setIzvjesce(izvjesce);
	}
	
	public String pregledaj_izvjesce (String izvjesce, Zadaci zadatak) {
		//Check report
		return zadatak.getIzvjesce();
	}
	
	public void zavrsi_zadatak (Zadaci zadatak) {
		//End task
		zadatak.isStatus();
	}
	
	public int provjera_zadataka() {
		
		//Return worker ID
		
		return this.getId();
	}
	
	

}
