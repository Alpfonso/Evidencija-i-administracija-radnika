package eiar;

import java.util.Date;

public class Ticket {
	private int id;
	private Radnik prijavio;
	private String opis = new String();
	private Zadaci zadatak;
	private Date datum = new Date();
	private boolean rijesen;
	private Radnik rijesio;
	
	public Ticket(Radnik prijavio, String opis, Zadaci zadatak, Date datum) {
		this.prijavio = prijavio;
		this.opis = opis;
		this.zadatak = zadatak;
		this.datum = datum;
		this.rijesen = false;
	}
	
	public boolean Status(){
		return rijesen;
	}
	public void Zatvori_ticket(Radnik zatvorio){
		this.rijesio = zatvorio;
		this.rijesen = true;
	}
	
}
