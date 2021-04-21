package eiar;

import java.util.Date;

public class Projekt {
	private int id;
	private String ime;
	private Nadredeni nadredeni_radnik;
	private Date datum_pocetak;
	private Date datum_kraj;
	private boolean status;
	
	public Projekt(String ime, Nadredeni nadredeni_radnik, Date datum_pocetak, Date datum_kraj) {
		// konstrukor projekta
		this.ime = ime;
		this.nadredeni_radnik = nadredeni_radnik;
		this.datum_pocetak = datum_pocetak;
		this.datum_kraj = datum_kraj;
	}
	
	public boolean Status() {
		// vraca status projekta
		return status;
	}
	
	public String Zatvori_projekt() {
		// Zatvaramo projekt ukoliko jos nije zatvoren
		if(status) {
			status = false;
			return "Projekt " + id + " zatvoren!";
		}
		else {
			return "Projekt " + id + " je vec zatvoren!";
		}
	}
	
	public Nadredeni Provjeri_nadleznog() {
		// Vraca nadredenog radnika
		if(nadredeni_radnik != null) {
			return nadredeni_radnik;
		}
		return null;
	}
}
