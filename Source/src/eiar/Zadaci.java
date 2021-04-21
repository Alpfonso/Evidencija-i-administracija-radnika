package eiar;

public class Zadaci {
	private int id = 0;
	private String ime = new String();
	private Radnik zadano_radniku;
	private Projekt projekt;
	
	public Zadaci(Radnik radnik, Projekt projekt) {
		this.zadano_radniku = radnik;
		this.projekt = projekt;
	} 
}
