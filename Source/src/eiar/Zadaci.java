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
	public boolean pregled_statusa() {
		
		return status;
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
