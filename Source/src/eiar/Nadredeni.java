package eiar;

import java.sql.SQLException;
import java.util.Date;
/**
 * Used to create superiors<br>
 */
public class Nadredeni extends Radnik implements Postavi_radnika {

	public Nadredeni(String ime, String prez, Date dat, String g_s, String u_s, String email, int OIB, String tele,
			String obrazovanje, String razina_ovlasti, Date r_v_p, Date r_v_k, int s_d) {
		super(ime, prez, dat, g_s, u_s, email, OIB, tele, obrazovanje, razina_ovlasti, r_v_p, r_v_k, s_d);
		// TODO Auto-generated constructor stub
	}
	/**
	 * WIP<br>
	 * will be used to write a report about a project
	 * @param izvjesce report
	 * @param projekt name of project for which the report is written
	 */
	public void napisi_izvjesce(String izvjesce, Projekt projekt) {
		//Write report
		projekt.setIzvjesce(izvjesce);
	}
	
	public String izvjesce(Projekt projekt) {
		//Get report back
		return projekt.getIzvjesce();
	}
	/**
	 * Assigns task to a worker
	 * @param radnik worker who gets the task
	 * @param projekt which project is the task part of
	 * @param ime_zadatka task name
	 * @throws SQLException 
	 */
	public void zadaj_zadatak(int radnik, int projekt, String ime_zadatka) throws SQLException {
		//Create task
		Zadaci zadatak = new Zadaci(radnik, projekt, ime_zadatka);
	}
	
	@Override
	/**
	 * Assigns additional workers to a task
	 */
	public void postavi_radnika(int radnik_dodjeljen, Zadaci zadatak) {
		//Add worker to a task
		zadatak.Dodaj_radnika(radnik_dodjeljen);
		
	}
	
}
