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

	public Radnik getPrijavio() {
		return prijavio;
	}

	public void setPrijavio(Radnik prijavio) {
		this.prijavio = prijavio;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Zadaci getZadatak() {
		return zadatak;
	}

	public void setZadatak(Zadaci zadatak) {
		this.zadatak = zadatak;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public boolean isRijesen() {
		return rijesen;
	}

	public void setRijesen(boolean rijesen) {
		this.rijesen = rijesen;
	}

	public Radnik getRijesio() {
		return rijesio;
	}

	public void setRijesio(Radnik rijesio) {
		this.rijesio = rijesio;
	}
	
}
