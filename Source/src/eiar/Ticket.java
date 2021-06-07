package eiar;

import java.util.Date;
/**
 * Used to report issues, make suggestions etc.
 *
 */
public class Ticket {
	private int id;
	private Radnik prijavio;
	private String opis = new String();
	private Zadaci zadatak;
	private Date datum = new Date();
	private boolean rijesen;
	private Radnik rijesio;
	/**
	 * Ticket constructor
	 * @param prijavio user who created the issue
	 * @param opis description
	 * @param zadatak which task does the issue belong to
	 * @param datum date of creation
	 */
	public Ticket(Radnik prijavio, String opis, Zadaci zadatak, Date datum) {
		this.prijavio = prijavio;
		this.opis = opis;
		this.zadatak = zadatak;
		this.datum = datum;
		this.rijesen = false;
	}
	/**
	 * Issue status check
	 * @return returns true or false depending if the issue is done
	 */
	public boolean Status(){
		return rijesen;
	}
	/**
	 * Used to close the ticket
	 * @param zatvorio name of the user who closed the ticket
	 */
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
