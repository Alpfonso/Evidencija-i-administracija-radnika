package eiar;

public class Zadaci {
	private int id;
	private String ime = new String();
	private Radnik zadano_radniku;
	private Projekt projekt;
	private boolean status;
	private String izvjesce;
	
	public Zadaci(Radnik radnik, Projekt projekt, String ime) {
		this.zadano_radniku = radnik;
		this.projekt = projekt;
		this.ime = ime;
		this.status = false;
		//TODO add data to database and get auto increment id
	}
	public Zadaci(Projekt projekt) {
		this.projekt = projekt;
	}
	public Zadaci(Projekt projekt, String opis) {
		this.projekt = projekt;
		this.ime = opis;
	}
	
	public void dodaj_radnika(Radnik radnik) {
		this.zadano_radniku = radnik;
	}
	public void dodaj_opis(String opis) {
		this.ime = opis;
	}
	public boolean pregled_statusa() {
		
		return status;
	}
	public void zavrsi() {
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
	
	

}
