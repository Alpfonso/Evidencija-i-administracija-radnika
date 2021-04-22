package eiar;

import java.util.Date;

public class Nadredeni extends Radnik {

	public Nadredeni(String ime, String prez, Date dat, String g_s, String u_s, String email, int OIB, String tele,
			String obrazovanje, String razina_ovlasti, Date r_v_p, Date r_v_k, int s_d) {
		super(ime, prez, dat, g_s, u_s, email, OIB, tele, obrazovanje, razina_ovlasti, r_v_p, r_v_k, s_d);
		// TODO Auto-generated constructor stub
	}
	
	public void Napisi_izvjesce(String izvjesce, Projekt projekt) {
		// Napisi izvjesce projekta
		projekt.setIzvjesce(izvjesce);
	}
	
	public String Izvjesce(Projekt projekt) {
		// Metoda za dohvat izvjesca projekta
		return projekt.getIzvjesce();
	}
	
	public void Zadaj_zadatak(Podredeni radnik, Projekt projekt, String ime_zadatka) {
		Zadaci zadatak = new Zadaci(radnik, projekt, ime_zadatka);
	}
	
}
