package eiar;

import java.util.Date;

public class Nadredeni extends Radnik implements Postavi_radnika {

	public Nadredeni(String ime, String prez, Date dat, String g_s, String u_s, String email, int OIB, String tele,
			String obrazovanje, String razina_ovlasti, Date r_v_p, Date r_v_k, int s_d) {
		super(ime, prez, dat, g_s, u_s, email, OIB, tele, obrazovanje, razina_ovlasti, r_v_p, r_v_k, s_d);
		// TODO Auto-generated constructor stub
	}
	
	public void Napisi_izvjesce(String izvjesce, Projekt projekt) {
		//Write report
		projekt.setIzvjesce(izvjesce);
	}
	
	public String Izvjesce(Projekt projekt) {
		//Get report back
		return projekt.getIzvjesce();
	}
	
	public void Zadaj_zadatak(Podredeni radnik, Projekt projekt, String ime_zadatka) {
		//Create task
		Zadaci zadatak = new Zadaci(radnik, projekt, ime_zadatka);
	}

	@Override
	public void postavi_radnika(Radnik radnik_dodjeljen, Zadaci zadatak) {
		//Add worker to a task
		zadatak.dodaj_radnika(radnik_dodjeljen);
		
	}
	
}
