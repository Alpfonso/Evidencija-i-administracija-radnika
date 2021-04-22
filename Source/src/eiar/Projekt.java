package eiar;

import java.util.Date;

public class Projekt {
	private int id;
	private String ime;
	private Nadredeni nadredeni_radnik;
	private Date datum_pocetak;
	private Date datum_kraj;
	private boolean status;
	private String izvjesce = new String("Empty");
	
	public Projekt(String ime, Nadredeni nadredeni_radnik, Date datum_pocetak, Date datum_kraj) {
		// konstrukor projekta
		this.ime = ime;
		this.nadredeni_radnik = nadredeni_radnik;
		this.datum_pocetak = datum_pocetak;
		this.datum_kraj = datum_kraj;
	}
	
	public boolean Status() {
		// vraca bool status projekta
		return status;
	}
	
	public boolean Zatvori_projekt() {
		// Zatvaramo projekt ukoliko jos nije zatvoren
		if(status) {
			status = false;
			return true;
		}
		else {
			return false;
		}
	}
	
	public Nadredeni Provjeri_nadleznog() {
		// Vraca nadredenog radnika
		if(nadredeni_radnik != null) {
			return nadredeni_radnik;
		}
		return null;
	}
	
	public boolean Promjeni_datum(Date novi_pocetak, Date novi_kraj) {
		// Promjena datuma pocetka I kraja
		if(novi_pocetak.after(novi_kraj)) {
			return false;
		}
		this.datum_pocetak = novi_pocetak;
		this.datum_kraj = novi_kraj;
		
		return true;
	}
	
	public boolean Promjeni_datum(Date novi_datum, boolean provjera) {
		// Promjena datuma pocetka ILI kraja
		if(provjera) {
			this.datum_kraj = novi_datum;
		}
		else {
			this.datum_pocetak = novi_datum;
		}
		return true;
	}
	
	public String getIzvjesce() {
		return izvjesce;
	}

	public void setIzvjesce(String izvjesce) {
		this.izvjesce = izvjesce;
	}
	
}

	
