package eiar;

import java.util.Date;

/**
 * Contains a collection of tasks
 */
public class Projekt {
	private int id;
	private String ime;
	private Nadredeni nadredeni_radnik;
	private Date datum_pocetak;
	private Date datum_kraj;
	private boolean status;
	private String izvjesce = new String("Empty");
	
	/**
	 * Constructor
	 * @param ime project name
	 * @param nadredeni_radnik project superior
	 * @param datum_pocetak project start date
	 * @param datum_kraj project end date
	 */
	public Projekt(String ime, Nadredeni nadredeni_radnik, Date datum_pocetak, Date datum_kraj) {
		// konstrukor projekta
		this.ime = ime;
		this.nadredeni_radnik = nadredeni_radnik;
		this.datum_pocetak = datum_pocetak;
		this.datum_kraj = datum_kraj;
	}
	
	/**
	 * 
	 * @return returns project status(bool)
	 */
	public boolean status() {
		return status;
	}
	/**
	 * Close project
	 * @return if the project isn't already clossed returns true and closes it; otherwise returns false
	 */
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
	/**
	 * Check who's the project superior
	 * @return returns project superior
	 */
	public Nadredeni provjeri_nadleznog() {
		//Return superior worker
		if(nadredeni_radnik != null) {
			return nadredeni_radnik;
		}
		return null;
	}
	/**
	 * Changes project dates
	 * @param novi_pocetak new start
	 * @param novi_kraj new end
	 * @return returns true if new date start isn't after new date end
	 */
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
	/**
	 * @return grabs project report
	 */
	public String getIzvjesce() {
		return izvjesce;
	}
	/**
	 * Sets project report to received string
	 * @param izvjesce report string 
	 */
	public void setIzvjesce(String izvjesce) {
		this.izvjesce = izvjesce;
	}

	public int getId() {
		return id;
	}


	
}

	
