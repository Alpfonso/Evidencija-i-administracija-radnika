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
	
	public boolean status() {
		
		return status;
	}
	
	public boolean zatvori_projekt() {
		//End project if it hadn't been ended yet
		if(status) {
			status = false;
			return true;
		}
		else {
			return false;
		}
	}
	
	public Nadredeni provjeri_nadleznog() {
		//Return superior worker
		if(nadredeni_radnik != null) {
			return nadredeni_radnik;
		}
		return null;
	}
	
	public boolean promjeni_datum(Date novi_pocetak, Date novi_kraj) {
		//Change start/end date
		if(novi_pocetak.after(novi_kraj)) {
			return false;
		}
		this.datum_pocetak = novi_pocetak;
		this.datum_kraj = novi_kraj;
		
		return true;
	}
	
	public boolean promjeni_datum(Date novi_datum, boolean provjera) {
		//Change start or end date
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

	
