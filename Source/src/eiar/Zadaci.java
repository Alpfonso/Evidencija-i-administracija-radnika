package eiar;

public class Zadaci {
	private int id;
	private String ime = new String();
	private Radnik zadano_radniku;
	private Projekt projekt;
	private boolean status;
	
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
}
