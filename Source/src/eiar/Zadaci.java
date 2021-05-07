package eiar;
/**
 * Tasks class
 */
public class Zadaci {
	private int id;
	private String ime = new String();
	private Radnik zadano_radniku;
	private Projekt projekt;
	private boolean status;
	private String izvjesce;
	/**
	 * Main constructor sets worker, parent project and name
	 * @param radnik assigned worker name
	 * @param projekt project name who's child is the constructed task
	 * @param ime task name
	 */
	public Zadaci(Radnik radnik, Projekt projekt, String ime) {
		this.zadano_radniku = radnik;
		this.projekt = projekt;
		this.ime = ime;
		this.status = false;
		//TODO add data to database and get auto increment id
	}
	public Zadaci(Projekt projekt) {//constructor that only assigns this task to the given project
		this.projekt = projekt;
	}
	public Zadaci(Projekt projekt, String opis) {//constructor that assigns this task to the project and gives it a description
		this.projekt = projekt;
		this.ime = opis;
	}
	
	public void Dodaj_radnika(Radnik radnik) {
		this.zadano_radniku = radnik;
	}
	public void Dodaj_opis(String opis) {
		this.ime = opis;
	}
	public boolean Pregled_statusa() {
		
		return status;
	}
	public void Zavrsi() {
		this.status = false;
	}

	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public Radnik getZadano_radniku() {
		return zadano_radniku;
	}
	public void setZadano_radniku(Radnik zadano_radniku) {
		this.zadano_radniku = zadano_radniku;
	}
	public Projekt getProjekt() {
		return projekt;
	}
	public void setProjekt(Projekt projekt) {
		this.projekt = projekt;
	}
	public String getIzvjesce() {
		return izvjesce;
	}
	public void setIzvjesce(String izvjesce) {
		this.izvjesce = izvjesce;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	//TODO implement the remaining necessary methods

}
